package com.sosnowka.data.application.playground;

import com.sosnowka.data.application.playground.dto.AddPlaygroundCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class PlaygroundFacade {
    private final PlaygroundService playgroundService;

    public Mono<String> putNewMerchant(String uuid, AddPlaygroundCommand addPlaygroundCommand) {
        return Mono.fromCallable(() -> playgroundService.putNewPlayground(uuid, addPlaygroundCommand).getUuid());
    }
}
