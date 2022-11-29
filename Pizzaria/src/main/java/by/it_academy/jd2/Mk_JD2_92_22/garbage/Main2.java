package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton.PizzaInfoServiceSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IPizzaInfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

public class Main2 {
    public static void main(String[] args) {

        ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();




//        try {
//            json = mapper.writeValueAsString(time1);
//            System.out.println("Java -> JSON: " + json);
//        } catch (JsonProcessingException e) {
//            System.out.println("Error Java -> JSON");
//        }
//
//        try {
//            LocalDateTime timeJson = mapper.readValue(json, LocalDateTime.class);
//            System.out.println("JSON -> Java: " + timeJson);
//        } catch (JsonProcessingException e) {
//            System.out.println("Error JSON -> Java");
//        }


        LocalDateTime time;
        final IPizzaInfoService ser = PizzaInfoServiceSingleton.getInstance();

        long id = 218;
//        String forDelete = "[2022,11,8,17,25,55,994000000]";
//
//        try {
//            time = mapper.readValue(forDelete, LocalDateTime.class);
//            System.out.println("date: " + time);
//            ser.delete(id, time);
//        } catch (JsonProcessingException e) {
//            System.out.println("Error JSON -> Java");
//        }


        final IPizzaInfo read = ser.read(id);

        final LocalDateTime dtUpdate = read.getDtUpdate();
        System.out.println("dtUpdate: " + dtUpdate);

        try {
            final String jsonDate = mapper.writeValueAsString(dtUpdate);
            System.out.println("jsonDate: " + jsonDate);
        } catch (JsonProcessingException e) {
            System.out.println("error data -> json");
        }

//{"name":"PizzaDelete","description":"For DELETE ","size":33}

    }
}
