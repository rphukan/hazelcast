package org.hazelcast.cloudfoundry.servicebroker.repository;

import org.cloudfoundry.community.servicebroker.model.ServiceInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul on 23/12/15.
 */
public class HazelcastServiceInstanceRepository { //extends CrudRepository <ServiceInstance, String> {

    private Map<String, ServiceInstance> repository;

    public HazelcastServiceInstanceRepository() {
        repository = new HashMap<String, ServiceInstance>();
    }

    public ServiceInstance findOne(String id) {
        return repository.get(id);
    }

    public void save(ServiceInstance serviceInstance) {
        repository.put(serviceInstance.getServiceInstanceId(), serviceInstance);
    }

    public void delete(ServiceInstance serviceInstance) {
        repository.remove(serviceInstance.getServiceInstanceId());
    }

}
