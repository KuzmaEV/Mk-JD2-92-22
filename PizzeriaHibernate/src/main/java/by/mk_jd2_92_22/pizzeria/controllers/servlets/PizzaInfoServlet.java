package by.mk_jd2_92_22.pizzeria.controllers.servlets;

import by.mk_jd2_92_22.pizzeria.controllers.utils.mapper.ObjectMapperSingleton;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IPizzaInfo;
import by.mk_jd2_92_22.pizzeria.services.api.IPizzaInfoService;
import by.mk_jd2_92_22.pizzeria.services.dto.PizzaInfoDTO;
import by.mk_jd2_92_22.pizzeria.services.singleton.PizzaInfoServiceSingleton;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "PizzaInfoServlet", urlPatterns = "/pizzaInfo")
public class PizzaInfoServlet extends HttpServlet {

    private final IPizzaInfoService service;
    private final ObjectMapper mapper;


    public PizzaInfoServlet() {
        this.service = PizzaInfoServiceSingleton.getInstance();
        this.mapper = ObjectMapperSingleton.getInstance();
    }

    //Read
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String stringId = req.getParameter("id");
        String json;


        if (stringId == null || stringId.isBlank()){
            json = mapper.writeValueAsString(service.get());
            resp.getWriter().write(json);
        } else {
            long id;
            try {
                id = Long.parseLong(stringId.trim());
            } catch (NumberFormatException e){

                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

                return;//завершает работу метода, сервлета
            }
            if (service.read(id) == null){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                json = mapper.writeValueAsString(service.read(id));
                resp.getWriter().write(json);
            }
        }
        }


    //Create
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PizzaInfoDTO dto = mapper.readValue(req.getInputStream(), PizzaInfoDTO.class);
        if (dto.getName() == null){
            throw new IllegalStateException("При создании пиццы, нужно ввести Имя");
        }
        if (dto.getDescription() == null){
            throw new IllegalStateException("При создании пиццы, нужно ввести Описание");
        }
        if (dto.getSize() == 0){
            throw new IllegalStateException("При создании пиццы, нужно ввести Размер");
        }


        String pizzaInfoCreate = mapper.writeValueAsString(service.create(dto));
        resp.getWriter().write(pizzaInfoCreate);

        resp.setStatus(HttpServletResponse.SC_CREATED);

    }

    //UPDATE
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idString = req.getParameter("id");
        long id = Long.parseLong(idString.trim());

//         IPizzaInfo read = service.read(id);

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        PizzaInfoDTO dto = mapper.readValue(req.getInputStream(), PizzaInfoDTO.class);



        IPizzaInfo update = service.update(id, dtUpdate, dto);
        resp.getWriter().write(mapper.writeValueAsString(update));

        resp.setStatus(HttpServletResponse.SC_OK);

    }

    //DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long id = Long.parseLong(req.getParameter("id"));
        String dtUpdateString = req.getParameter("dtUpdate");

        LocalDateTime dtUpdate = mapper.readValue(dtUpdateString, LocalDateTime.class);


        service.delete(id, dtUpdate);

        resp.setStatus(HttpServletResponse.SC_OK);

    }
}
