package by.it_academy.jd2.Mk_JD2_92_22.garbage.storages;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.api.IMenuRowStorage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.MenuRow;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MenuRowStorage implements IMenuRowStorage {

    private final String pathToFile;
    private final ObjectMapper mapper;
    private final AtomicLong counter = new AtomicLong(0);

    public MenuRowStorage() {
        mapper =new ObjectMapper();
        String env = "CATALINA_HOME";
        String home = System.getenv(env) ;
        if (home == null|| home.isBlank()){
            throw new IllegalStateException("Environment " + env + " absent!");
        }

        this.pathToFile = home + File.separator + "conf" + File.separator + "MenuRowList.txt";
    }

    @Override
    public List<IMenuRow> get() {

        List<IMenuRow> listMenuRow = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(this.pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null){
                IMenuRow menuRow = this.mapper.readValue(line, MenuRow.class);
                listMenuRow.add(menuRow);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listMenuRow;
    }

    @Override
    public IMenuRow get(String name) {

//        if (Files.notExists(Paths.get(this.pathToFile))){
//            try {
//                new File(this.pathToFile).createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        try(BufferedReader reader = new BufferedReader(new FileReader(this.pathToFile))) {
//            String line;
//            while ((line = reader.readLine()) != null){
//                MenuRow menuRow = this.mapper.readValue(line, MenuRow.class);
//                if (name.equals(menuRow.getId())){
//                    return menuRow;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public void save(IMenuRow item) {


      //  item.setId(counter.toString());

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(this.pathToFile, true))) {
            writer.write(this.mapper.writeValueAsString(item));
            writer.newLine();

        } catch (IOException e) {
           throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(String name) {

        List<IMenuRow> menuRowList = this.get();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.pathToFile))){
            StringBuilder builder = new StringBuilder();
            for (IMenuRow menuRow : menuRowList) {
              //  if (!menuRow.getId().equals(name)){
                    builder.append(this.mapper.writeValueAsString(menuRow)).append('\n');
               // }
            }
            writer.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
