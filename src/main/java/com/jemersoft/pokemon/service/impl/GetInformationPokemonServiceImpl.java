package com.jemersoft.pokemon.service.impl;

import com.jemersoft.pokemon.client.PokemonClient;
import com.jemersoft.pokemon.exception.BusinessException;
import com.jemersoft.pokemon.model.dto.request.ApiAllPokemonDTO;
import com.jemersoft.pokemon.model.dto.request.GenericInformationDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDescriptionInputDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDetailInputDTO;
import com.jemersoft.pokemon.model.dto.response.InformationPokemonOutputDTO;
import com.jemersoft.pokemon.service.GetInformationPokemonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@Log4j2
@Service
public class GetInformationPokemonServiceImpl implements GetInformationPokemonService {

    private final PokemonClient client;
    @Override
    public Mono<ApiAllPokemonDTO> getAllPokemon() {
        log.info("[GetInformationPokemonServiceImpl] service getAllPokemon has been called");
        return client.getAllPokemons();
    }

    @Override
    public Mono<PokemonDetailInputDTO> getPokemon(String name) {
        log.info("[GetInformationPokemonServiceImpl] service getPokemon has been called with name: {}", name);
        return client.getPokemonByName(name);
    }

    @Override
    public Mono<PokemonDescriptionInputDTO> getDescription(String id) {
        log.info("[GetInformationPokemonServiceImpl] service getDescription has been called with id: {}", id);
        return client.getDescription(id);
    }

    @Override
    public Mono<List<InformationPokemonOutputDTO>> getAllInformation() {
        log.info("[GetInformationPokemonServiceImpl] service getAllInformation has been called");

        return client.getAllPokemons()
                .map(ApiAllPokemonDTO::getResults)
                .flatMapMany(Flux::fromIterable)
                .take(3)
                .flatMap(this::addPokemon)
                .collectList()
                .switchIfEmpty(Mono.error(new BusinessException("service has failed")));
    }

    private Mono<InformationPokemonOutputDTO> addPokemon(GenericInformationDTO genericInformationDTO) {

        return client.getPokemonByName(genericInformationDTO.getName())
                .flatMap(pokemonDetailDTO -> {
                    InformationPokemonOutputDTO informationPokemonResponseDTO = new InformationPokemonOutputDTO();
                    informationPokemonResponseDTO.setId(pokemonDetailDTO.getId());
                    informationPokemonResponseDTO.setResults(genericInformationDTO);
                    informationPokemonResponseDTO.setAbilities(pokemonDetailDTO.getAbilities());
                    informationPokemonResponseDTO.setTypes(pokemonDetailDTO.getTypes());
                    informationPokemonResponseDTO.setMoves(pokemonDetailDTO.getMoves());
                    informationPokemonResponseDTO.setWeight(pokemonDetailDTO.getWeight());
                    informationPokemonResponseDTO.setHeight(pokemonDetailDTO.getHeight());
                    return Mono.just(informationPokemonResponseDTO).zipWith(client.getDescription(pokemonDetailDTO.getId()));
                }).map(tuple -> {
                    tuple.getT1().setDescriptions(tuple.getT2().getDescriptions());
                    return tuple.getT1();
                });
    }
}