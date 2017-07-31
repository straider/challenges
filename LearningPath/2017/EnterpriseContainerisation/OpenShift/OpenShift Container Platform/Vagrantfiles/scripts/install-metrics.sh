#!/usr/bin/env bash

set -e

SUBDOMAIN=$( grep subdomain /var/lib/openshift/openshift.local.config/master/master-config.yaml | awk '{ print $2 }' )

oc login localhost:8443 -u admin -p admin --insecure-skip-tls-verify > /dev/null

oc project openshift-infra

oc create --filename /home/vagrant/metrics-service-account.yaml
oc secrets new metrics-deployer nothing=/dev/null

oc adm policy add-role-to-user         view           system:serviceaccount:openshift-infra:hawkular
oc adm policy add-role-to-user         edit           system:serviceaccount:openshift-infra:metrics-deployer
oc adm policy add-cluster-role-to-user cluster-reader system:serviceaccount:openshift-infra:heapster

oc new-app                                                          \
    --as=system:serviceaccount:openshift-infra:metrics-deployer     \
    --file /home/vagrant/metrics-deployer.yaml                      \
    --param HAWKULAR_METRICS_HOSTNAME=hawkular-metrics.${SUBDOMAIN} \
    --param USE_PERSISTENT_STORAGE=false

oc logout > /dev/null

sudo sed -i "s|metricsPublicURL: \"\"|metricsPublicURL: \"https://hawkular-metrics.${SUBDOMAIN}/hawkular/metrics\"|" /var/lib/openshift/openshift.local.config/master/master-config.yaml
sudo systemctl restart openshift
