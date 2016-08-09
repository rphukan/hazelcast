# Hazelcast for PCF
Hazelcast Tile and BOSH Release for PCF Ops Manager

# Overview
This is a PCF tile to install Hazelcast {community edition v3.6.4} Service Broker that creates Hazelcast server instances in the form of CF service i.e. every successful completion of **cf create-service** command results in one Hazelcast server node. This implementation creates a default service plan that allows to create unlimited number of cluster instances with memory limits defined by the CF deployment only.

# Getting Started
Clone the repo and either build the tile with [tile-generator](https://github.com/cf-platform-eng/tile-generator) or download the tile's .pivotal file from [releases](https://github.com/cloudfoundry-community/hazelcast/releases).

## Installation
Upload the **.pivotal** file in your Ops Manager, set the availability zones (if the underlying infrastructure is AWS), enter the valid Management Center URL (as documented in **hazelcast-mancenter-for-pcf**) and proceed with the installation. A successful installation will create a service broker and enable service-access to view all service plans in CF Marketplace.

![screen shot 2016-08-09 at 4 39 04 pm](https://cloud.githubusercontent.com/assets/7980465/17523207/6d733810-5e77-11e6-9bdf-e6c2b7f5db39.png)

## Using Service Broker
New services can be created using [Pivotal Apps Manager](https://docs.pivotal.io/pivotalcf/1-7/console/dev-console.html) or through CF CLI that is targetted at the Ops Manager Director.

![screen shot 2016-08-09 at 4 37 44 pm](https://cloud.githubusercontent.com/assets/7980465/17523426/2a450112-5e78-11e6-9def-36c38a8a9174.png)

Create Services from Apps Manager:
![screen shot 2016-08-09 at 4 36 06 pm](https://cloud.githubusercontent.com/assets/7980465/17523464/49169c4a-5e78-11e6-99e8-13ce25a9957e.png)

You can validate the formation of Hazelcast cluster either by checking service broker logs:
`cf logs <HAZELCAST-SERVICE-BROKER-APP-NAME> --recent`

Or you can view the cluster in Hazelcast Management Center. See the link for Management Center documentation:
http://docs.hazelcast.org/docs/3.6/manual/html-single/index.html#management-center


21=
