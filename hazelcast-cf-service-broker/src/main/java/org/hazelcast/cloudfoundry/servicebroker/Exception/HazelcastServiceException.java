package org.hazelcast.cloudfoundry.servicebroker.exception;

import org.cloudfoundry.community.servicebroker.exception.ServiceBrokerException;

/**
 * Created by rahul on 21/12/15.
 */
public class HazelcastServiceException extends ServiceBrokerException {

    public HazelcastServiceException(String message) {
        super(message);
    }

}
