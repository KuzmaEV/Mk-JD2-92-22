package by.it_academy.jd2.Mk_JD2_92_22.garbage.web.servlets.pizzaInfo;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.services.PizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.services.api.IPizzaInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet(name = "AddPizzaInfoServlet", urlPatterns = "/pizzaInfoNo/addNo")
public class AddPizzaInfoServlet extends HttpServlet {

    private final IPizzaInfoService service;
    private final ObjectMapper mapper;

    public AddPizzaInfoServlet() {

        this.service = PizzaInfoService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<IPizzaInfo> pizzaInfoList = this.service.get();
        PrintWriter writer = resp.getWriter();
        writer.write("add a new PizzaInfo");
        writer.write(mapper.writeValueAsString(pizzaInfoList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        IPizzaInfo pizzaInfo = this.mapper.readValue(req.getInputStream(), PizzaInfo.class);

        this.service.validate(pizzaInfo);

        resp.setStatus(201);
    }
}
