package com.jemersoft.pokemon.model.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VersionGroupDetailDTO {
    private Integer levelLearnedAt;
    private GenericInformationDTO moveLearnMethod;
    private GenericInformationDTO versionGroup;
}
