# hazelcast-cloudfoundry
Hazelcast CloudFoundry Integration

Here are step-by-step instructions to deploy and use Hazelcast Service Broker:

Download the cloudfoundry war file from here : https://github.com/hazelcast/hazelcast-cloudfoundry/releases

Here is a sample manifest yml file for deployment : 

```
applications:
- name: hazelcast-service-broker
  memory: 4096M
  instances: 1
  path: <path to your hazelcast-cf-service-broker.war>
  buildpack: https://github.com/wildnez/java-buildpack.git
  stack: cflinuxfs2
```
Just a simple `cf push` will deploy service broker app to cloudfoundry with your mainfest file.
 
A successful push would show the service broker running as one of the CF apps:

When a Service Broker is pushed into CF, default user credentials are created.
 
Next step is to create a Service Broker. Run the following command using same credentials retrieved above:
 
`cf create-service-broker my-hz-broker user <security-password> <your-service-borker-app- url>`
 
Run `cf marketplace` and it will not show your service broker yet. That is because the service plan must be enabled to accommodate public consumption. 
Make your service plan public by doing the following:
`cf service-access`
`cf enable-service-access Hazelcast`

Finally run `cf marketplace` to validate Hazelcast Service Broker is successfully deployed.
