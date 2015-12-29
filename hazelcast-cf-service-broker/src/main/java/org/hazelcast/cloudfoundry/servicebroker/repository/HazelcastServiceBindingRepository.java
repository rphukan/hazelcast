package org.hazelcast.cloudfoundry.servicebroker.repository;

import org.cloudfoundry.community.servicebroker.model.ServiceInstanceBinding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul on 23/12/15.
 */
public class HazelcastServiceBindingRepository { //extends CrudRepository <ServiceInstanceBinding, String>{

    private Map<String, ServiceInstanceBinding> repository;

    public HazelcastServiceBindingRepository() {
        repository = new HashMap<String, ServiceInstanceBinding>();
    }

    public ServiceInstanceBinding findOne(String id) {
        return repository.get(id);
    }

    public void save(ServiceInstanceBinding instanceBinding) {
        repository.put(instanceBinding.getId(), instanceBinding);
    }

    public void delete(ServiceInstanceBinding instanceBinding) {
        repository.remove(instanceBinding.getId());
    }

}
