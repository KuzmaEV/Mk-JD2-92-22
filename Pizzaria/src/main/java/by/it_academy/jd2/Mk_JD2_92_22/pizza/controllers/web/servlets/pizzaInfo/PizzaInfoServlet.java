package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.web.servlets.pizzaInfo;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.menu.PizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.PizzaInfoService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IPizzaInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PizzaInfoServlet", urlPatterns = "/pizzaInfo")
public class PizzaInfoServlet extends HttpServlet {

    private final IPizzaInfoService service;
    private final ObjectMapper mapper;

    public PizzaInfoServlet() {

        this.service = PizzaInfoService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<IPizzaInfo> pizzaInfoList = this.service.get();
        PrintWriter writer = resp.getWriter();
        writer.write(mapper.writeValueAsString(pizzaInfoList));
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