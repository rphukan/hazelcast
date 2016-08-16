# hazelcast
**Hazelcast Service Brokers, Bosh Releases and Tiles for Cloud Foundry**

The latest Cloud Foundry integration enables Hazelcast to be used on Cloud Foundry platform in multiple ways. This provides an end user the flexibility to use Hazelcast on Cloud Foundry in most suitable manner. The three approaches by which Hazelcast can be deployed on PCF are:

## Unmanaged or User Managed Service
A basic form of integration where Hazelcast servers run as a service that is hosted in an environment outside of CF platform. This service is then bound to the applications pushed to CF using User Provided Services framework.

## Hazelcast Service Broker 
Hazelcast runs as a native Cloud Foundry service that is provisioned and maintained by the platform itself using Hazelcast Service Broker implementation. Service broker allows you to create and push a service into Cloud Foundry platform and made available in the CF Catalog. A user can then select Hazelcast service from the catalog, number of service instances (number of Hazelcast servers) and binds their application to the service.
See links for more details: 
http://blog.hazelcast.com/cloud-foundry/

https://github.com/cloudfoundry-community/hazelcast/tree/master/service-broker/


## Hazelcast as PCF Tile 
PCF tile to install Hazelcast Service Broker that creates Hazelcast server instances in the form of CF service. Tiles are clickable and easiest way to deploy a open source Hazelcast cluster on Cloud Foundry.
See link for more details: 
https://github.com/cloudfoundry-community/hazelcast/tree/master/hazelcast-for-pcf

https://github.com/cloudfoundry-community/hazelcast/tree/master/hazelcast-enterprise-for-pcf

![hazelcast-pcf-tiles](https://cloud.githubusercontent.com/assets/7980465/17696525/8e2c50fa-63cc-11e6-956d-7bc7c29d1b9b.png)

**NOTE**: Check each sub-repository for its respective documentation.
