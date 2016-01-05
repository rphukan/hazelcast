package org.hazelcast.cloudfoundry.servicebroker.service;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.hazelcast.cloudfoundry.servicebroker.repository.HazelcastServiceRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HazelcastAdmin {

    private static HazelcastServiceRepository repository = HazelcastServiceRepository.getInstance();
    private Map<String, HazelcastInstance> hazelcastInstances;


    public HazelcastAdmin() {
        hazelcastInstances = new HashMap<String, HazelcastInstance>();
    }

    public HazelcastInstance createHazelcastInstance(String instanceId) {
        Config config = getHazelcastInstanceConfig(instanceId);
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        hazelcastInstances.put(instanceId, instance);
        return instance;
    }

    private String getClusterMembersConfig() {
        StringBuilder clusterMembersConfigBuilder = null;

        if(repository.getAllServiceInstances().size() > 0) {
            clusterMembersConfigBuilder = new StringBuilder();
            for (ServiceInstance serviceInstance : repository.getAllServiceInstances()) {
                clusterMembersConfigBuilder.append(((HazelcastServiceInstance) serviceInstance).getHazelcastIPAddress());
                clusterMembersConfigBuilder.append(",");
            }
            clusterMembersConfigBuilder.deleteCharAt(clusterMembersConfigBuilder.length() - 1);
        }

        return clusterMembersConfigBuilder == null ? null : clusterMembersConfigBuilder.toString();
    }

    private Config getHazelcastInstanceConfig(String serviceInstanceId) {
        Config config = new Config();
        config.setInstanceName(serviceInstanceId);
        NetworkConfig network = config.getNetworkConfig();
        JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled(false);
        join.getTcpIpConfig().setEnabled(true);
        String clusterMembers = getClusterMembersConfig();
        if(clusterMembers != null)
            join.getTcpIpConfig().addMember(clusterMembers);
        network.getInterfaces().setEnabled(true).addInterface("10.*.*.*");

        return config;
    }

    public void deleteHazelcastInstance(String serviceInstanceId) {
        HazelcastInstance instance = hazelcastInstances.remove(serviceInstanceId);
        instance.getLifecycleService().shutdown();
    }
}
