package org.hazelcast.cloudfoundry.servicebroker.service;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceDoesNotExistException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceExistsException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceUpdateNotSupportedException;
import org.cloudfoundry.community.servicebroker.model.CreateServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.model.DeleteServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.UpdateServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceService;
import org.hazelcast.cloudfoundry.servicebroker.Exception.HazelcastServiceException;
import org.springframework.stereotype.Service;

/**
 * Created by rahul on 21/12/15.
 */
@Service
public class HazelcastServiceInstanceService implements ServiceInstanceService {

    @Override
    public ServiceInstance createServiceInstance(CreateServiceInstanceRequest createServiceInstanceRequest) throws ServiceInstanceExistsException, ServiceBrokerException {

        ServiceInstance serviceInstance = new ServiceInstance(createServiceInstanceRequest);

        Config config = new Config();
        config.setInstanceName(createServiceInstanceRequest.getServiceInstanceId());
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        if(hazelcastInstance == null) {
            throw new HazelcastServiceException("Failed to create new Hazelcast member hazelcastInstance: "+createServiceInstanceRequest.getServiceInstanceId());
        }

        return serviceInstance;
    }

    @Override
    public ServiceInstance getServiceInstance(String s) {
        return null;
    }

    @Override
    public ServiceInstance deleteServiceInstance(DeleteServiceInstanceRequest deleteServiceInstanceRequest) throws ServiceBrokerException {
        return null;
    }

    @Override
    public ServiceInstance updateServiceInstance(UpdateServiceInstanceRequest updateServiceInstanceRequest) throws ServiceInstanceUpdateNotSupportedException, ServiceBrokerException, ServiceInstanceDoesNotExistException {
        return null;
    }
}
