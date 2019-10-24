package com.sosnowka.data.application.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventSender {
    private final EventProducer eventProducer;

    public void sendAddUserEvent(AddUserEvent event) {
        Message<AddUserEvent> message = MessageBuilder.withPayload(event)
                                                      .build();
        log.info("Event AddUserEvent send");
        eventProducer.addUserEvent()
                     .send(message);
        log.info("Event send:{}", event);
    }
}
