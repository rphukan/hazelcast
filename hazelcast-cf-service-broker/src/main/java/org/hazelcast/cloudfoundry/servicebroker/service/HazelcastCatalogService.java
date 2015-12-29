package org.hazelcast.cloudfoundry.servicebroker.service;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 21/12/15.
 */

public class HazelcastCatalogService { //implements CatalogService {


    public Catalog getCatalog() {
        ServiceDefinition serviceDefinition = new ServiceDefinition();
        List<ServiceDefinition> serviceDefinitions = new ArrayList<ServiceDefinition>();
        serviceDefinitions.add(serviceDefinition);

        Catalog catalog = new Catalog(serviceDefinitions);
        return catalog;
    }


    public ServiceDefinition getServiceDefinition(String s) {
        return null;
    }
}
