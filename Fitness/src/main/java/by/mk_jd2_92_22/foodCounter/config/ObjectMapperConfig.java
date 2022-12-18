package by.mk_jd2_92_22.foodCounter.config;

import by.mk_jd2_92_22.foodCounter.controllers.utils.mapper.ObjectMapperSingleton;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ObjectMapperConfig {

    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        return ObjectMapperSingleton.getInstance();
    }
}
