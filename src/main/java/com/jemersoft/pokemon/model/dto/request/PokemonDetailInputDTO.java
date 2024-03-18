package com.jemersoft.pokemon.model.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PokemonDetailInputDTO {
    private Long id;
    private Integer height;
    private Integer weight;
    private List<AbilityPokemonDTO> abilities;
    private List<PokemonTypeDTO> types;
    private List<PokemonMoveDTO> moves;
}
