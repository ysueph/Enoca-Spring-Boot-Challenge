package com.example.adaad.Config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
@Bean
        public ModelMapper getModelMapper(){
    ModelMapper mapperConfig= new ModelMapper();
    mapperConfig.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return mapperConfig;
}
}
