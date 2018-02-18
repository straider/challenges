# -*- mode: ruby -*-
# vi: set ft=ruby :

BOX_NAME = 'cdk-2.2'

# The private network IP of the VM. You will use this IP to connect to OpenShift.
# This variable is ignored for Hyper-V provider.
PUBLIC_ADDRESS="10.1.2.2"

# Number of virtualized CPUs
VM_CPU = ENV['VM_CPU'] || 2

# Amount of available RAM
VM_MEMORY = ENV['VM_MEMORY'] || 3072

# Validate required plugins
REQUIRED_PLUGINS = %w(vagrant-service-manager vagrant-registration vagrant-sshfs)
errors = []

def message(name)
  "#{name} plugin is not installed, run `vagrant plugin install #{name}` to install it."
end
# Validate and collect error message if plugin is not installed
REQUIRED_PLUGINS.each { |plugin| errors << message(plugin) unless Vagrant.has_plugin?(plugin) }
unless errors.empty?
  msg = errors.size > 1 ? "Errors: \n* #{errors.join("\n* ")}" : "Error: #{errors.first}"
  fail Vagrant::Errors::VagrantError.new, msg
end


Vagrant.configure(2) do |config|
  if Vagrant.has_plugin?( 'vagrant-proxyconf' ) and ENV.key?( 'PROXY' )
    config.proxy.enabled = { docker: false }
    config.proxy.http  = "http://#{ ENV[ 'PROXY' ] }"
    config.proxy.https = "http://#{ ENV[ 'PROXY' ] }"

    config.proxy.no_proxy = 'rhel-cdk,10.0.2.15,10.1.2.2,10.0.2.0/24,10.1.2.0/24,172.17.0.0/16,172.30.0.0/24,192.168.99.0/24'
  end

  config.vm.box = BOX_NAME

  config.vm.provider 'virtualbox' do | v, override |
    v.name   = BOX_NAME
    v.memory = VM_MEMORY
    v.cpus   = VM_CPU
    v.customize [ 'modifyvm', :id, '--ioapic'             , 'on' ]
    v.customize [ 'modifyvm', :id, '--natdnshostresolver1', 'on' ]
  end

  config.vm.provider "libvirt" do |v, override|
    v.memory = VM_MEMORY
    v.cpus   = VM_CPU
    v.driver = "kvm"
    v.suspend_mode = "managedsave"
  end

  config.vm.network "private_network", ip: "#{PUBLIC_ADDRESS}"

  # vagrant-registration
  if ENV.has_key?('SUB_USERNAME') && ENV.has_key?('SUB_PASSWORD')
    config.registration.username = ENV['SUB_USERNAME']
    config.registration.password = ENV['SUB_PASSWORD']
  end

  # Proxy Information from environment
  config.registration.proxy = PROXY = (ENV['PROXY'] || '')
  config.registration.proxyUser = PROXY_USER = (ENV['PROXY_USER'] || '')
  config.registration.proxyPassword = PROXY_PASSWORD = (ENV['PROXY_PASSWORD'] || '')

  # vagrant-sshfs
  config.vm.synced_folder '.', '/vagrant', disabled: true
  if Vagrant::Util::Platform.windows?
    target_path = ENV['USERPROFILE'].gsub(/\\/,'/').gsub(/[[:alpha:]]{1}:/){|s|'/' + s.downcase.sub(':', '')}
    config.vm.synced_folder ENV['USERPROFILE'], target_path, type: 'sshfs', sshfs_opts_append: '-o umask=000 -o uid=1000 -o gid=1000'
  else
    config.vm.synced_folder ENV['HOME'], ENV['HOME'], type: 'sshfs', sshfs_opts_append: '-o umask=000 -o uid=1000 -o gid=1000'
  end
  config.vm.provision "shell", inline: <<-SHELL
    sudo setsebool -P virt_sandbox_use_fusefs 1
  SHELL

  # prevent the automatic start of openshift via service-manager by just enabling Docker
  config.servicemanager.services = "docker"

  # explicitly enable and start OpenShift
  config.vm.provision "shell", run: "always", inline: <<-SHELL
    PROXY=#{PROXY} PROXY_USER=#{PROXY_USER} PROXY_PASSWORD=#{PROXY_PASSWORD} /usr/bin/sccli openshift
  SHELL

  if Vagrant.has_plugin?( 'vagrant-proxyconf' ) and ENV.key?( 'PROXY' )
    config.vm.provision "shell", run: "always", inline: <<-SHELL
      oc login localhost:8443 -u admin -p admin --insecure-skip-tls-verify
      docker_registry_ip_address=$( oc get svc docker-registry --namespace default --output jsonpath='{.spec.clusterIP}' )
      oc logout

      sudo mv /etc/sysconfig/docker /etc/sysconfig/docker.orig
      grep -vi proxy /etc/sysconfig/docker.orig | sudo tee /etc/sysconfig/docker > /dev/null
      echo "HTTP_PROXY=http://#{ ENV[ 'PROXY' ] }"  | sudo tee -a /etc/sysconfig/docker
      echo "HTTPS_PROXY=http://#{ ENV[ 'PROXY' ] }" | sudo tee -a /etc/sysconfig/docker
      echo "NO_PROXY=${docker_registry_ip_address}" | sudo tee -a /etc/sysconfig/docker

      sudo systemctl daemon-reload
      sudo systemctl restart docker
    SHELL
  end

  config.vm.provision "shell", run: "always", inline: <<-SHELL
    #Get the routable IP address of OpenShift
    OSIP=`/opt/adb/openshift/get_ip_address`
    echo
    echo "Successfully started and provisioned VM with #{VM_CPU} cores and #{VM_MEMORY} MB of memory."
    echo "To modify the number of cores and/or available memory set the environment variables"
    echo "VM_CPU respectively VM_MEMORY."
    echo
    echo "You can now access the OpenShift console on: https://${OSIP}:8443/console"
    echo
    echo "To use OpenShift CLI, run:"
    echo "$ vagrant ssh"
    echo "$ oc login"
    echo
    echo "Configured users are (<username>/<password>):"
    echo "openshift-dev/devel"
    echo "admin/admin"
    echo
    echo "If you have the oc client library on your host, you can also login from your host."
    echo
  SHELL
end
