#!/usr/bin/env bash

set -e

sudo rpm -v --install --hash /home/vagrant/corkscrew-2.0-20.fc26.x86_64.rpm

echo | sudo tee --append /etc/ssh/ssh_config << END_OF_SCRIPT
Host *
    ProxyCommand corkscrew 10.1.2.1 3128 %h %p
END_OF_SCRIPT
