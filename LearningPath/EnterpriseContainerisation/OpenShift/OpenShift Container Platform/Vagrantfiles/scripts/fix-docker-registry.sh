#!/usr/bin/env bash

set -e

oc login localhost:8443 -u admin -p admin --insecure-skip-tls-verify > /dev/null
docker_registry_ip_address=$( oc get svc docker-registry --namespace default --output jsonpath='{.spec.clusterIP}' )
oc logout

sudo mv /etc/sysconfig/docker /etc/sysconfig/docker.orig
grep -vi proxy /etc/sysconfig/docker.orig | sudo tee /etc/sysconfig/docker > /dev/null
echo "HTTP_PROXY=http://10.1.2.1:3128"        | sudo tee -a /etc/sysconfig/docker
echo "HTTPS_PROXY=http://10.1.2.1:3128"       | sudo tee -a /etc/sysconfig/docker
echo "NO_PROXY=${docker_registry_ip_address}" | sudo tee -a /etc/sysconfig/docker
# echo "http_proxy=http://10.1.2.1:3128"        | sudo tee -a /etc/sysconfig/docker
# echo "https_proxy=http://10.1.2.1:3128"       | sudo tee -a /etc/sysconfig/docker
# echo "no_proxy=${docker_registry_ip_address}" | sudo tee -a /etc/sysconfig/docker

sudo systemctl daemon-reload
sudo systemctl restart docker
