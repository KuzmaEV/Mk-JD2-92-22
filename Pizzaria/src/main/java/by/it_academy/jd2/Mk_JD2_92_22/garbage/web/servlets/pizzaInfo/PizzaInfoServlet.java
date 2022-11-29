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

//@WebServlet(name = "PizzaInfoServlet", urlPatterns = "/pizzaInfo")
public class PizzaInfoServlet extends HttpServlet {

    private final IPizzaInfoService service;
    private final ObjectMapper mapper;

    public PizzaInfoServlet() {

        this.service = PizzaInfoService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json");

//        List<IPizzaInfo> pizzaInfoList = this.service.get();
//        PrintWriter writer = resp.getWriter();
//        writer.write(mapper.writeValueAsString(pizzaInfoList));

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write("hello");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        IPizzaInfo pizzaInfo = this.mapper.readValue(req.getInputStream(), PizzaInfo.class);

        String name = pizzaInfo.getName();

        IPizzaInfo getPizzaInfo = this.service.get(name);
        PrintWriter writer =resp.getWriter();
        writer.write(this.mapper.writeValueAsString(getPizzaInfo));

        resp.setStatus(201);
    }
}
