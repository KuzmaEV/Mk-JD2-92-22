package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.web.servlets;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.MenuService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MenuServlet", urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {

    private final IMenuService service;
    private final ObjectMapper mapper;

    public MenuServlet() {

        this.service = MenuService.getInstance();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        List<IMenuRow> menuRowList = this.service.get();
        PrintWriter writer =resp.getWriter();
        writer.write(mapper.writeValueAsString(menuRowList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
    }
}
