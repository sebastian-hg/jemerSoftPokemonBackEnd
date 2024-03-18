package com.jemersoft.pokemon.client;

import com.jemersoft.pokemon.model.dto.request.ApiAllPokemonDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDetailInputDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDescriptionInputDTO;
import reactor.core.publisher.Mono;

public interface PokemonClient {
    Mono<ApiAllPokemonDTO> getAllPokemons();
    Mono<PokemonDetailInputDTO> getPokemonByName(String name);
    Mono<PokemonDescriptionInputDTO> getDescription(Object id);
}
