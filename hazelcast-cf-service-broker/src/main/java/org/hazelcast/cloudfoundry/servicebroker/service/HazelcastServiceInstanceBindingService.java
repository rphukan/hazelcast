package org.hazelcast.cloudfoundry.servicebroker.service;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;
import org.cloudfoundry.community.servicebroker.exception.ServiceInstanceBindingExistsException;
import org.cloudfoundry.community.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.cloudfoundry.community.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;
import org.cloudfoundry.community.servicebroker.service.ServiceInstanceBindingService;
import org.hazelcast.cloudfoundry.servicebroker.repository.HazelcastServiceRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul on 21/12/15.
 */

@Service
public class HazelcastServiceInstanceBindingService implements ServiceInstanceBindingService {

    private HazelcastServiceRepository repository;

    //@Autowired
    public HazelcastServiceInstanceBindingService() {
        //repository = new HazelcastServiceBindingRepository();
        repository = HazelcastServiceRepository.getInstance();
    }

    @Override
    public ServiceInstanceBinding createServiceInstanceBinding(CreateServiceInstanceBindingRequest createServiceInstanceBindingRequest) throws ServiceInstanceBindingExistsException, ServiceBrokerException {
        String id = createServiceInstanceBindingRequest.getBindingId();

        ServiceInstanceBinding instanceBinding = repository.findServiceInstanceBinding(id);
        if(instanceBinding != null) {
            throw new ServiceInstanceBindingExistsException(instanceBinding);
        }

        String serviceInstanceId = createServiceInstanceBindingRequest.getServiceInstanceId();
        HazelcastServiceInstance serviceInstance = (HazelcastServiceInstance) repository.findServiceInstance(serviceInstanceId);

        Map<String, Object> credentials = new HashMap();
        credentials.put("host", serviceInstance.getHazelcastIPAddress());
        credentials.put("InetAddress", serviceInstance.getHazelcastInetAddress());
        credentials.put("Port", serviceInstance.getHazelcastPort());

        String appGuid = createServiceInstanceBindingRequest.getAppGuid();

        instanceBinding = new ServiceInstanceBinding(id, serviceInstanceId, credentials, null, appGuid);
        repository.saveServiceInstanceBinding(instanceBinding);
        return instanceBinding;
    }

    @Override
    public ServiceInstanceBinding deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest deleteServiceInstanceBindingRequest) throws ServiceBrokerException {
        String id = deleteServiceInstanceBindingRequest.getBindingId();

        ServiceInstanceBinding instanceBinding = repository.findServiceInstanceBinding(id);
        if(instanceBinding != null) {
            repository.deleteServiceInstanceBinding(instanceBinding);
        }

        return instanceBinding;
    }
}
