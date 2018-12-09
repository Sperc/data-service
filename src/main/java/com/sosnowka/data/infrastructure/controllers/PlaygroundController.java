package com.sosnowka.data.infrastructure.controllers;

import com.sosnowka.data.application.playground.PlaygroundFacade;
import com.sosnowka.data.application.playground.dto.AddPlaygroundCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/playgrounds")
public class PlaygroundController {
    private final PlaygroundFacade playgroundFacade;

    @PutMapping("/{uuid}")
    public Mono<ResponseEntity> putNewPlayground(@PathVariable("uuid") String uuid, @RequestBody AddPlaygroundCommand command) {
        log.info("Add playground: uuid: {}, {}", uuid, command);
        return playgroundFacade.putNewMerchant(uuid, command)
                               .doOnSuccess(s -> log.info("Succes on add new Playground: {}", uuid))
                               .map(s -> new ResponseEntity(HttpStatus.NO_CONTENT));
    }

}
