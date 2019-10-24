package com.sosnowka.data.application.events;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface EventProducer {
    String ADD_USER = "add-user";

    @Output(EventProducer.ADD_USER)
    SubscribableChannel addUserEvent();
}
