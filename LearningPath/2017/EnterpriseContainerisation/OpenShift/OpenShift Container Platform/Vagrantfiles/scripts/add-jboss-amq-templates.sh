#!/usr/bin/env bash

set -e

oc login localhost:8443 -u admin -p admin --insecure-skip-tls-verify > /dev/null

oc project openshift

# From https://github.com/openshift/openshift-ansible/tree/master/roles/openshift_examples/files/examples/v1.4/xpaas-templates
oc create -f /home/vagrant/amq62-basic.json
oc create -f /home/vagrant/amq62-persistent.json
oc create -f /home/vagrant/amq62-persistent-ssl.json
oc create -f /home/vagrant/amq62-ssl.json

oc logout > /dev/null
