package org.hazelcast.cloudfoundry.servicebroker.config;

import org.cloudfoundry.community.servicebroker.model.Catalog;
import org.cloudfoundry.community.servicebroker.model.Plan;
import org.cloudfoundry.community.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rahul on 22/12/15.
 */
@Configuration
public class CatalogConfig {

    @Bean
    public Catalog catalog() {
        return new Catalog( Arrays.asList(
                new ServiceDefinition(
                        "Hazelcast",
                        "Hazelcast",
                        "A simple Hazelcast implementation",
                        true,
                        false,
                        Arrays.asList(
                                new Plan("hazelcast-plan",
                                        "default",
                                        "This is a default Hazelcast plan.  All services are created equally.",
                                        getPlanMetadata())),
                        Arrays.asList("hazelcast", "document"),
                        getServiceDefinitionMetadata(),
                        null,
                        null)));
    }

/* Used by Pivotal CF console */

    private Map<String,Object> getServiceDefinitionMetadata() {
        Map<String,Object> sdMetadata = new HashMap<String,Object>();
        sdMetadata.put("displayName", "Hazelcast");
        sdMetadata.put("longDescription","Hazelcast Service");
        sdMetadata.put("providerDisplayName","Pivotal");
        sdMetadata.put("documentationUrl","http://www.hazelcast.org");
        sdMetadata.put("supportUrl","http://www.hazelcast.org");
        return sdMetadata;
    }

    private Map<String,Object> getPlanMetadata() {
        Map<String,Object> planMetadata = new HashMap<String,Object>();
        planMetadata.put("costs", getCosts());
        planMetadata.put("bullets", getBullets());
        return planMetadata;
    }

    private List<Map<String,Object>> getCosts() {
        Map<String,Object> costsMap = new HashMap<String,Object>();

        Map<String,Object> amount = new HashMap<String,Object>();
        amount.put("usd", new Double(0.0));

        costsMap.put("amount", amount);
        costsMap.put("unit", "MONTHLY");

        return Arrays.asList(costsMap);
    }

    private List<String> getBullets() {
        return Arrays.asList("Shared Hazelcast cluster",
                "100 MB Storage (not enforced)",
                "40 concurrent connections (not enforced)");
    }
}
