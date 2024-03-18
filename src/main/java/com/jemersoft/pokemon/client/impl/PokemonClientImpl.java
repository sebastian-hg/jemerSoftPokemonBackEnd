package com.jemersoft.pokemon.client.impl;

import com.jemersoft.pokemon.client.PokemonClient;
import com.jemersoft.pokemon.configuration.ClientConfigProperties;
import com.jemersoft.pokemon.exception.ErrorInCallToApiException;
import com.jemersoft.pokemon.model.dto.request.ApiAllPokemonDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDetailInputDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDescriptionInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Component
@AllArgsConstructor
public class PokemonClientImpl implements PokemonClient {

    private final ClientConfigProperties properties;
    @Override
    public Mono<ApiAllPokemonDTO> getAllPokemons() {
        return WebClient.create()
                .get()
                .uri(properties.getAllPokemonUrl())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ApiAllPokemonDTO.class)
                .onErrorMap(e -> new ErrorInCallToApiException("Error during call in API" + e.getMessage()));
    }

    @Override
    public Mono<PokemonDetailInputDTO> getPokemonByName(String name) {
        return WebClient.create()
                .get()
                .uri(properties.getAllPokemonUrl() + name)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(PokemonDetailInputDTO.class)
                .onErrorMap(e -> new ErrorInCallToApiException("Error during call in API" + e.getMessage()));
    }

    @Override
    public Mono<PokemonDescriptionInputDTO> getDescription(Object id) {
        var uri = properties.getGetDescription() + id;
        return WebClient.create()
                .get()
                .uri(uri)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(PokemonDescriptionInputDTO.class)
                .onErrorMap(e -> new ErrorInCallToApiException("Error during call in API" + e.getMessage()));
    }
}
