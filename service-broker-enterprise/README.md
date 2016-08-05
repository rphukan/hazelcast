hazelcast-cloudfoundry
=============================

Hazelcast CloudFoundry project for creating Cloud Foundry service broker and services. 

## Overview
The goal is to provide a service broker that creates Hazelcast Enterprise server instances in the form of CF service i.e. every successful completion of `cf create-service` command results in one Hazelcast server node. This implementation creates a default service plan that provides unlimited number of cluster instances with memory limits defined by the CF deployment only. 

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

### Service Broker
Next step is to create a Service Broker. Retrieve the password from app logs and run the following command:
`cf create-service-broker <service-broker-name> user <security-password> <your-service-borker-app-url>`
 
### Service Plans and Marketplace
To know the service plans that this service broker has created, run the following command:
`cf service-access`

This will show all service plans and whether they are enabled. Activate service broker's service plans by running the following:
`cf enable-service-access <name-of-service-plan>`

Run `cf marketplace` to validate if the service plans have been successfully enabled and are available to use.

### Services
Create service instances using the service plan you have created above. Run the following command:
`cf create-service <service-plan-name> <service-plan-type> <service-name>`

Verify the state of Hazelcast member node by checking Hazelcast logs that are dumped in the application log i.e. 

`cf logs hazelcast-service-broker --recent`
