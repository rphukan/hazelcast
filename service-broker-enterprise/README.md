hazelcast-cloudfoundry
=============================

Hazelcast CloudFoundry project for creating Cloud Foundry service broker and services on Hazelcast Enterprise.

## Overview
The goal is to provide a service broker that creates Hazelcast {enterprise edition} server instances in the form of CF service i.e. every successful completion of `cf create-service` command results in one Hazelcast server node. 

**NOTE**: This broker requires a Hazelcast Enterprise or Enterprise HD license key to be able to successfully create service instances. Go to [Hazelcast website](https://hazelcast.com/) to obtain a license.

This implementation creates a default service plan that allows creating licensed number of cluster instances  with memory limits defined by the CF deployment only. 

## Getting Started
Download the latest Hazelcast service broker app from here : https://github.com/hazelcast/hazelcast-cloudfoundry/releases

In the `manifest.yml`, you need to define an environement variable `LICENSE_KEY` to configure Hazelcast license key. Here is a sample manifest yml: 

```
applications:
- name: hazelcast-service-broker
  memory: 4096M
  instances: 1
  path: <path to your hazelcast-cf-service-broker.war>
  buildpack: https://github.com/hazelcast/java-buildpack.git
  stack: cflinuxfs2
  env:
   LICENSE_KEY: <YOUR-HAZELCAST-LICENSE-KEY>
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
