package org.hazelcast.cloudfoundry.servicebroker.service;

import org.cloudfoundry.community.servicebroker.model.CreateServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.model.DeleteServiceInstanceRequest;
import org.cloudfoundry.community.servicebroker.model.ServiceInstance;
import org.cloudfoundry.community.servicebroker.model.UpdateServiceInstanceRequest;

import java.net.InetAddress;

/**
 * Created by rahul on 28/12/15.
 */
public class HazelcastServiceInstance extends ServiceInstance {

    private String hazelcastIPAddress;
    private InetAddress hazelcastInetAddress;
    private int hazelcastPort;

    public HazelcastServiceInstance(CreateServiceInstanceRequest request) {
        super(request);
    }

    public HazelcastServiceInstance(DeleteServiceInstanceRequest request) {
        super(request);
    }

    public HazelcastServiceInstance(UpdateServiceInstanceRequest request) {
        super(request);
    }

    public void setHazelcastIPAddress(String ipAddress) {
        this.hazelcastIPAddress = ipAddress;
    }

    public String getHazelcastIPAddress() {
        return hazelcastIPAddress;
    }

    public InetAddress getHazelcastInetAddress() {
        return hazelcastInetAddress;
    }

    public void setHazelcastInetAddress(InetAddress hazelcastInetAddress) {
        this.hazelcastInetAddress = hazelcastInetAddress;
    }

    public int getHazelcastPort() {
        return hazelcastPort;
    }

    public void setHazelcastPort(int hazelcastPort) {
        this.hazelcastPort = hazelcastPort;
    }
}
