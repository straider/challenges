#!/usr/bin/env bash

set -e

oc login 10.1.2.2:8443 -u admin -p admin --insecure-skip-tls-verify > /dev/null

for pv in $( find . -type d -name "/nfsvolumes/pv0?" ); do
    oc delete pv $pv
    sudo rm -Rf /nfsvolumes/$pv
done

openshift_ip_address=$( /opt/adb/openshift/get_ip_address )

for size in 512; do
    for index in $( seq 1 15 ); do
        folder=/nfsvolumes/$( printf "pv%03d-%02d" $size $index )
        if [ ! -d $folder ]; then
            sudo mkdir -p $folder
            sudo chmod 777 $folder

            if [ "$( oc get pv | grep $folder | wc -l )" -ne "0" ]; then
                oc delete pv $( printf "pv%03d-%02d" $size $index )
            fi
            oc create -f - <<-EOF!
                apiVersion: v1
                kind: PersistentVolume
                metadata:
                    name: $( printf "pv%03d-%02d" $size $index )
                spec:
                    capacity:
                        storage: ${size}Mi
                    accessModes:
                        - ReadWriteOnce
                        - ReadWriteMany
                    persistentVolumeReclaimPolicy: Recycle
                    nfs:
                        path: $folder
                        server: $openshift_ip_address
EOF!
        fi
    done
done

for size in 1 2 5; do
    for index in $( seq 1 9 ); do
        folder=/nfsvolumes/$( printf "pv%03d-%02d" $size $index )
        if [ ! -d $folder ]; then
            sudo mkdir -p $folder
            sudo chmod 777 $folder

            if [ "$( oc get pv | grep $folder | wc -l )" -ne "0" ]; then
                oc delete pv $( printf "pv%03d-%02d" $size $index )
            fi
            oc create -f - <<-EOF!
                apiVersion: v1
                kind: PersistentVolume
                metadata:
                    name: $( printf "pv%03d-%02d" $size $index )
                spec:
                    capacity:
                        storage: ${size}Gi
                    accessModes:
                        - ReadWriteOnce
                        - ReadWriteMany
                    persistentVolumeReclaimPolicy: Recycle
                    nfs:
                        path: $folder
                        server: $openshift_ip_address
EOF!
        fi
    done
done

oc logout

sudo chown nfsnobody:nfsnobody -R /nfsvolumes
echo '/nfsvolumes/ *(rw,root_squash)' | sudo tee /etc/exports > /dev/null
exportfs -r
