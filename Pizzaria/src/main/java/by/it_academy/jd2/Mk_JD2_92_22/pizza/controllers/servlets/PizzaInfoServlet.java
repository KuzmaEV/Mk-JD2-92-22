package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.servlets;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoPizzaInfoServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.PizzaInfoServiceSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IPizzaInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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


    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "application/json";

    public PizzaInfoServlet() {
        this.service = PizzaInfoServiceSingleton.getInstance();
        this.mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
    }

    //Read
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        req.setCharacterEncoding(ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(ENCODING);

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

        req.setCharacterEncoding(ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(ENCODING);

        DtoPizzaInfoServlet dto = mapper.readValue(req.getInputStream(), DtoPizzaInfoServlet.class);
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


        req.setCharacterEncoding(ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(ENCODING);

        String idString = req.getParameter("id");
        long id = Long.parseLong(idString.trim());

         IPizzaInfo read = service.read(id);

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        DtoPizzaInfoServlet dto = mapper.readValue(req.getInputStream(), DtoPizzaInfoServlet.class);

        if (dto.getName() == null){
            dto.setName(read.getName());
        }
        if (dto.getDescription() == null){
            dto.setDescription(read.getDescription());
        }
        if (dto.getSize() == 0){
            dto.setSize(read.getSize());
        }

        String pizzaInfoUpdate = mapper.writeValueAsString(service.update(id, dtUpdate, dto));
        resp.getWriter().write(pizzaInfoUpdate);

        resp.setStatus(HttpServletResponse.SC_OK);

    }

    //DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        req.setCharacterEncoding(ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(ENCODING);

        long id = Long.parseLong(req.getParameter("id"));
        String dtUpdateString = req.getParameter("dtUpdate");

        LocalDateTime dtUpdate = mapper.readValue(dtUpdateString, LocalDateTime.class);


        service.delete(id, dtUpdate);

        resp.setStatus(HttpServletResponse.SC_OK);

    }
}
