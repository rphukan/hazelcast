# Hazelcast Management Center for PCF
Hazelcast Management Center Tile and BOSH Release for PCF Ops Manager

# Overview
This is a PCF tile of Hazelcast Management Center v3.6.4 that runs as an independent CF application. Hazelcast Management Center is a proprietary product that supports 2 Hazelcast server nodes for free, but requires a Hazelcast license key to work for larger cluster.

# Getting Started
Either build the tile with [tile-generator](https://github.com/cf-platform-eng/tile-generator) or download the tile's .pivotal file from [releases](https://github.com/cloudfoundry-community/hazelcast/releases).

## Installation
Upload the **.pivotal** file in your Ops Manager, set the availability zones (if the underlying infrastructure is AWS) and proceed with the installation. A successful installation will return a url where the mancenter app is running. You can also retrieve the app url from CF CLI by querying for running apps: `cf apps`

![hazelcast-pcf-tiles](https://cloud.githubusercontent.com/assets/7980465/17697143/982f277c-63d0-11e6-98ef-f1bef06d3a40.png)

## Using Management Center
Append the app url with `/mancenter`. This is required because of the Jetty engine that is built inside **mancenter war**.
Example: app url returned by your CF deployment: 
http://hazelcast-management-center.apps.your-cloudfoundry-ip.com. 

Append it with `/mancenter`, so the valid Management Center url becomes: 
`http://hazelcast-management-center.apps.your-cloudfoundry-ip.com/mancenter`

![mancenter](https://cloud.githubusercontent.com/assets/7980465/17697144/9832eb78-63d0-11e6-93f7-c7d32e01f342.png)

Check the link for Management Center documentation: http://docs.hazelcast.org/docs/3.6/manual/html-single/index.html#management-center


