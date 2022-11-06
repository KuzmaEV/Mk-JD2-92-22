package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.servlets;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoCreatePizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.PizzaInfoServiceSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IPizzaInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "PizzaInfoServlet", urlPatterns = "/pizzaInfo")
public class PizzaInfoServlet extends HttpServlet {

    private final IPizzaInfoService service;
    private final ObjectMapper mapper;

    public PizzaInfoServlet() {
        this.service = PizzaInfoServiceSingleton.getInstance();
        this.mapper = new ObjectMapper();
    }

    //Read
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String json;

        if (id.isBlank()){
            json = mapper.writeValueAsString(service.get());
        } else {
            json = mapper.writeValueAsString(service.read(Long.parseLong(id)));
        }

        try (PrintWriter writer = resp.getWriter()){
            writer.write(json);
        }



    }

    //Create
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        DtoCreatePizzaInfo dto = mapper.readValue(req.getInputStream(), DtoCreatePizzaInfo.class);
        IPizzaInfo pizzaInfo = new PizzaInfo(0, null, null,
                dto.getName(),
                dto.getDescription(),
                dto.getSize());

        service.create(pizzaInfo);

        resp.setStatus(200);

    }

    //UPDATE
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        DtoCreatePizzaInfo dto = mapper.readValue(req.getInputStream(), DtoCreatePizzaInfo.class);


    }

    //DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
