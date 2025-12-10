package io.github.jinahya.rickandmortyapi.client;

import io.github.jinahya.rickandmortyapi.client.type.CharacterPageResponse;
import io.github.jinahya.rickandmortyapi.client.type.CharacterType;
import jakarta.validation.constraints.NotNull;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class RemoveMe implements ReactiveRickAndMortyApiClient {

    @Override
    public Mono<CharacterPageResponse> getAllCharacters(int page) {
        return null;
    }

    @Override
    public Flux<CharacterType> getAllCharacters() {
        return null;
    }

    @Override
    public Publisher<CharacterType> getCharacters(@NotNull int... ids) {
        return null;
    }

    @Override
    public Mono<CharacterType> getCharacter(int id) {
        return null;
    }
}
