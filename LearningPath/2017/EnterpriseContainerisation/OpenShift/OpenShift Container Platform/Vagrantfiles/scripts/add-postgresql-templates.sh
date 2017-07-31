#!/usr/bin/env bash

set -e

oc login localhost:8443 -u admin -p admin --insecure-skip-tls-verify > /dev/null

oc project openshift

# From https://github.com/openshift/openshift-ansible/tree/master/roles/openshift_examples/files/examples/v1.4/db-templates
oc create --filename /home/vagrant/postgresql-ephemeral-template.json
oc create --filename /home/vagrant/postgresql-persistent-template.json

oc logout > /dev/null
