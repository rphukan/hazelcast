package org.hazelcast.cloudfoundry.servicebroker.service;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.cloudfoundry.community.servicebroker.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 21/12/15.
 */
@Service
public class HazelcastCatalogService implements CatalogService {

    @Override
    public Catalog getCatalog() {
        ServiceDefinition serviceDefinition = new ServiceDefinition();
        List<ServiceDefinition> serviceDefinitions = new ArrayList<ServiceDefinition>();
        serviceDefinitions.add(serviceDefinition);

        Catalog catalog = new Catalog(serviceDefinitions);
        return catalog;
    }

    @Override
    public ServiceDefinition getServiceDefinition(String s) {
        return null;
    }
}
