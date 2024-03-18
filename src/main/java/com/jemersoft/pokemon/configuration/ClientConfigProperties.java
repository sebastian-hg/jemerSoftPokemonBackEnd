package com.jemersoft.pokemon.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties(prefix = "client")
public class ClientConfigProperties {
    private String allPokemonUrl;
    private String getDescription;
}
