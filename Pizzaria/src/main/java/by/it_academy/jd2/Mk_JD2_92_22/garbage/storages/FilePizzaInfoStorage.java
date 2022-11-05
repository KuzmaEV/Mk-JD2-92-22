package by.it_academy.jd2.Mk_JD2_92_22.garbage.storages;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.api.IPizzaInfoStorage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePizzaInfoStorage implements IPizzaInfoStorage {

    private final String pathToFile;
    private final ObjectMapper mapper = new ObjectMapper();

    public FilePizzaInfoStorage() {
        String home = System.getenv("CATALINA_HOME");
        if (home == null || home.isBlank()){
            throw new IllegalStateException("Env not found");
        }
        this.pathToFile = home + File.separator + "conf" + File.separator + "PizzaInfoList.txt";
    }

    @Override
    public List<IPizzaInfo> get() {
        List<IPizzaInfo> pizzaInfoList = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(
                new FileReader(this.pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null){
                pizzaInfoList.add(mapper.readValue(line, PizzaInfo.class));
            }
            return pizzaInfoList;

        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

    @Override
    public IPizzaInfo get(String name) {
        try(BufferedReader reader = new BufferedReader(
                new FileReader(this.pathToFile))) {

            String line;
            while ((line = reader.readLine()) != null){
                IPizzaInfo pizzaInfo = mapper.readValue(line, PizzaInfo.class);
                if (pizzaInfo.getName().equals(name)){
                    return pizzaInfo;
                }
            }
            return  null;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(IPizzaInfo item) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.pathToFile, true))){
            writer.write(mapper.writeValueAsString(item));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String name) {


        List<IPizzaInfo> pizzaInfoList = this.get();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.pathToFile))) {

            StringBuilder str = new StringBuilder();
            for (IPizzaInfo pizzaInfo : pizzaInfoList) {
                if (!pizzaInfo.getName().equals(name)){
                    str.append(this.mapper.writeValueAsString(pizzaInfo)).append('\n');
                }
            }
            writer.write(str.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
