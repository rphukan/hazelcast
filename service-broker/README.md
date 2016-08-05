hazelcast-cloudfoundry
=============================

Hazelcast CloudFoundry project for creating Cloud Foundry service broker and services. 

## Overview
The goal is to provide a service broker that creates Hazelcast {community edition} server instances in the form of CF service i.e. every successful completion of `cf create-service` command results in one Hazelcast server node. This implementation creates a default service plan that provides unlimited number of cluster instances with memory limits defined by the CF deployment only. 

## Getting Started
Download the latest Hazelcast service broker app from here : https://github.com/hazelcast/hazelcast-cloudfoundry/releases

Here is a sample manifest yml file for deployment : 

```
applications:
- name: hazelcast-service-broker
  memory: 4096M
  instances: 1
  path: <path to your hazelcast-cf-service-broker.war>
  buildpack: https://github.com/hazelcast/java-buildpack.git
  stack: cflinuxfs2
```
Just a simple `cf push` will deploy service broker app to cloudfoundry with your mainfest file. A successful push would show the service broker running as one of the CF apps and will also provide a url where the app is hosted, save this url somewhere.

### Service Broker and Services
Next step is to create a Service Broker. Retrieve the password from app logs and run the following command:
 
`cf create-service-broker <service-broker-name> user <security-password> <your-service-borker-app-url>`
 
Run `cf marketplace` and it will not show your service broker yet. That is because the service plan must be enabled to accommodate public consumption. 
Make your service plan public by doing the following:
`cf service-access`
`cf enable-service-access Hazelcast`

Finally run `cf marketplace` to validate Hazelcast Service Broker is successfully deployed.
