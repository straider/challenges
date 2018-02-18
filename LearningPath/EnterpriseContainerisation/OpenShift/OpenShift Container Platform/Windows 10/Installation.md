OpenShift Container Platform on Windows 10
==========================================

# Overview

# Options

- [How to install Red Hat Container Development Kit (CDK) in minutes](http://www.schabell.org/2016/02/howto-install-redhat-cdk-in-minutes.html)
- [Red Hat Container Development Kit](CDK.md)
- [Docker Machine](Docker Machine.md)

# Validation

# Well Known Errors

## Subscription

If the step "Registering box with vagrant-registration" asks for an username and password it's because the environment variables SUB_USERNAME and SUB_PASSWORD have not be set up previously before running ```vagrant up```. Either exit and set them up before running the command or input the Red Hat Portal credentials.

```bash
export SUB_USERNAME=<your-subscription-username> #  Account at Red Hat Customer Portal - developers.redhat.com
export SUB_PASSWORD=<your-subscription-password>
```

## Proxy

The step "Registering box with vagrant-registration" failed with the following error:

```
Network error, unable to connect to server. Please see /var/log/rhsm/rhsm.log for more information.
Registering to: subscription.rhn.redhat.com:443/subscription
```

It seems to be a PROXY problem. To configure the proxy issue the following commands before issueing ```vagrant up```:

```bash
export PROXY=[HOSTNAME:PORT]
export PROXY_USER=[USERNAME]
export PROXY_PASSWORD=[PASSWORD]
```
