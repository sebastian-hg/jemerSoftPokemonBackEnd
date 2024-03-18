package com.jemersoft.pokemon.model.dto.response;

import com.jemersoft.pokemon.model.dto.request.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InformationPokemonOutputDTO {
    private Long id;
    private GenericInformationDTO results;
    private Integer weight;
    private Integer height;
    private List<AbilityPokemonDTO> abilities;
    private List<PokemonTypeDTO> types;
    private List<PokemonMoveDTO> moves;
    private List<DescriptionDTO> descriptions;

}
