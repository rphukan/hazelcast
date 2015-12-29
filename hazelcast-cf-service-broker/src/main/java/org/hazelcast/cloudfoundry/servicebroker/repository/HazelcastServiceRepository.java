package org.hazelcast.cloudfoundry.servicebroker.repository;

import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul on 23/12/15.
 */

public class HazelcastServiceRepository {

    private Map<String, ServiceInstance> serviceInstanceRepository;
    private Map<String, ServiceInstanceBinding> serviceInstanceBindingRepository;

    private static final HazelcastServiceRepository instance = new HazelcastServiceRepository();

    private HazelcastServiceRepository() {
        serviceInstanceRepository = new HashMap<String, ServiceInstance>();
        serviceInstanceBindingRepository = new HashMap<String, ServiceInstanceBinding>();
    }

    public static HazelcastServiceRepository getInstance() {
        return instance;
    }

    public ServiceInstance findServiceInstance(String id) {
        return serviceInstanceRepository.get(id);
    }

    public void saveServiceInstance(ServiceInstance serviceInstance) {
        serviceInstanceRepository.put(serviceInstance.getServiceInstanceId(), serviceInstance);
    }

    public void deleteServiceInstance(ServiceInstance serviceInstance) {
        serviceInstanceRepository.remove(serviceInstance.getServiceInstanceId());
    }

    public ServiceInstanceBinding findServiceInstanceBinding(String id) {
        return serviceInstanceBindingRepository.get(id);
    }

    public void saveServiceInstanceBinding(ServiceInstanceBinding serviceInstanceBinding) {
        serviceInstanceBindingRepository.put(serviceInstanceBinding.getId(), serviceInstanceBinding);
    }

    public void deleteServiceInstanceBinding(ServiceInstanceBinding serviceInstanceBinding) {
        serviceInstanceBindingRepository.remove(serviceInstanceBinding.getId());
    }

}
