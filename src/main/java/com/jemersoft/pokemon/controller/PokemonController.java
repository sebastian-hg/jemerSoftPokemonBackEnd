package com.jemersoft.pokemon.controller;

import com.jemersoft.pokemon.model.dto.request.ApiAllPokemonDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDescriptionInputDTO;
import com.jemersoft.pokemon.model.dto.request.PokemonDetailInputDTO;
import com.jemersoft.pokemon.model.dto.response.InformationPokemonOutputDTO;
import com.jemersoft.pokemon.service.GetInformationPokemonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/v1")
@RestController()
public class PokemonController {
    private final GetInformationPokemonService service;
    @CrossOrigin
    @GetMapping("/all-pokemons")
    public Mono<ApiAllPokemonDTO> getAllPokemons() {
        return service.getAllPokemon();
    }

    @CrossOrigin
    @GetMapping("/get-pokemon-by-name")
    public Mono<PokemonDetailInputDTO> getPokemon(@RequestParam("name") String name) {
        return service.getPokemon(name);
    }

    @CrossOrigin
    @GetMapping("/get-description-by-id")
    public Mono<PokemonDescriptionInputDTO> getDescription(@RequestParam("id") String id) {
        return service.getDescription(id);
    }

    @CrossOrigin
    @GetMapping("/get-details-pokemon")
    public Mono<List<InformationPokemonOutputDTO>> getDetailsPokemon() {
        return service.getAllInformation();
    }
}
