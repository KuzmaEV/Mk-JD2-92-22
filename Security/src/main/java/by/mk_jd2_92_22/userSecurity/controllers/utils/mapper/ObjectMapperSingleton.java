package by.mk_jd2_92_22.userSecurity.controllers.utils.mapper;

import by.mk_jd2_92_22.userSecurity.controllers.utils.mapper.serializer.LocalDateTimeDeserializer;
import by.mk_jd2_92_22.userSecurity.controllers.utils.mapper.serializer.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;


public class ObjectMapperSingleton {

    private static ObjectMapperSingleton instance;
    private final ObjectMapper mapper;

    public ObjectMapperSingleton() {
        mapper = new ObjectMapper();

        SimpleModule customModule = new SimpleModule();
        customModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        customModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(customModule);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    }

    public static ObjectMapper getInstance(){
        if (instance == null){
            synchronized (ObjectMapperSingleton.class){
                    instance = new ObjectMapperSingleton();

            }
        }
        return instance.mapper;
    }
}
