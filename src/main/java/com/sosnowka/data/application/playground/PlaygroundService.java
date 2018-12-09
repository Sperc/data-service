package com.sosnowka.data.application.playground;

import com.sosnowka.data.application.playground.dto.AddPlaygroundCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
class PlaygroundService {
    private final PlaygroundRepository playgroundRepository;

    Playground putNewPlayground(String uuid, AddPlaygroundCommand addPlaygroundCommand) {
        Playground pl = playgroundRepository.findByUuid(uuid)
                                            .orElse(new Playground());
        pl.updatePlayground(addPlaygroundCommand);
        log.info("Add new playground with uuid: {}", uuid);
        return playgroundRepository.save(pl);
    }

}
