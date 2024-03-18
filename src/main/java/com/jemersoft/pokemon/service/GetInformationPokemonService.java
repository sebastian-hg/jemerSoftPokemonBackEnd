package com.jemersoft.pokemon.service;

import com.jemersoft.pokemon.model.dto.request.ApiAllPokemonDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDetailInputDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDescriptionInputDTO;
import com.jemersoft.pokemon.model.dto.response.InformationPokemonOutputDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GetInformationPokemonService {
    Mono<ApiAllPokemonDTO> getAllPokemon();
    Mono<PokemonDetailInputDTO> getPokemon(String name);
    Mono<PokemonDescriptionInputDTO> getDescription(String id);
    Mono<List<InformationPokemonOutputDTO>> getAllInformation();

}
