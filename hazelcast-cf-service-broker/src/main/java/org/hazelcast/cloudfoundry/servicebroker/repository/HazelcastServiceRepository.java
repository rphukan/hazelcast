package org.hazelcast.cloudfoundry.servicebroker.repository;

import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public boolean exists(ServiceInstance serviceInstance) {
        return serviceInstanceRepository.containsKey(serviceInstance.getServiceInstanceId());
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
        if(serviceInstanceBinding != null)
            serviceInstanceBindingRepository.remove(serviceInstanceBinding.getId());
    }

    public Collection<ServiceInstance> getAllServiceInstances() {
        return serviceInstanceRepository.values();
    }

}
