package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.servlets;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuRowServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton.MenuRowServiceSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuRowService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "MenuRowServlet", urlPatterns = "/menuRow")
public class MenuRowServlet extends HttpServlet {

    private final IMenuRowService service;
    private final ObjectMapper mapper;


    public MenuRowServlet() throws PropertyVetoException {
        this.service = MenuRowServiceSingleton.getInstance();
        this.mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idString = req.getParameter("id");
        PrintWriter writer = resp.getWriter();
        if (idString == null || idString.isBlank()){
            writer.write(mapper.writeValueAsString(service.get()));
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            try {
                long id = Long.parseLong(idString.trim());
                writer.write(mapper.writeValueAsString(service.read(id)));
                resp.setStatus(HttpServletResponse.SC_OK);
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                throw new IllegalArgumentException("Некоректные данные");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        DtoMenuRowServlet dto = mapper.readValue(req.getInputStream(), DtoMenuRowServlet.class);

        if (dto.getPrice() == 0){
            throw new IllegalStateException("Не указана цена!");
        }
        if (dto.getInfo() == 0){
            throw new IllegalStateException("Не указана pizzaInfo!");
        }
        if (dto.getMenu() == 0){
            throw new IllegalStateException("Не указано Меню!");
        }

        IMenuRow menuRow = service.create(dto);

        resp.getWriter().write(mapper.writeValueAsString(menuRow));
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idStr = req.getParameter("id");
        long id = Long.parseLong(idStr.trim());

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        DtoMenuRowServlet dto = mapper.readValue(req.getInputStream(), DtoMenuRowServlet.class);

        IMenuRow update = service.update(id, dtUpdate, dto);

        resp.getWriter().write(mapper.writeValueAsString(update));
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idStr = req.getParameter("id");
        long id = Long.parseLong(idStr);

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        service.delete(id, dtUpdate);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
