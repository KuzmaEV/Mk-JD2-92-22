package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.servlets;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoMenuServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton.MenuServiceSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "MenuServlet", urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {

    private final IMenuService service;
    private final ObjectMapper mapper;


    public MenuServlet() throws PropertyVetoException {
        service = MenuServiceSingleton.getInstance();
        mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idString = req.getParameter("id");

        if (idString == null || idString.isBlank()){
            resp.getWriter().write(mapper.writeValueAsString(service.get()));
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            long id;
            try {
                id = Long.parseLong(idString.trim());
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                throw new IllegalArgumentException(e.getMessage());
            }
            resp.getWriter().write(mapper.writeValueAsString(service.read(id)));
            resp.setStatus(HttpServletResponse.SC_OK);
            }
        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        DtoMenuServlet dto = mapper.readValue(req.getInputStream(), DtoMenuServlet.class);

        if (dto.getName() == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalStateException("Не указано название");
        }
        IMenu menu = service.create(dto);

        resp.getWriter().write(mapper.writeValueAsString(menu));
        resp.setStatus(HttpServletResponse.SC_CREATED);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long id;

        String idString = req.getParameter("id");
        if (idString == null || idString.isBlank()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalArgumentException("Не указано id");
        }

        try{
            id = Long.parseLong(idString.trim());
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalArgumentException(e.getMessage());
        }

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        if (dtUpdate == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalArgumentException("Не указано dtUpdate");
        }

        DtoMenuServlet dto = mapper.readValue(req.getInputStream(), DtoMenuServlet.class);

        IMenu updateMenu = service.update(id, dtUpdate, dto);

        resp.getWriter().write(mapper.writeValueAsString(updateMenu));
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long id;

        String idString = req.getParameter("id");
        if (idString == null || idString.isBlank()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalArgumentException("Не указано id");
        }

        try{
            id = Long.parseLong(idString.trim());
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalArgumentException(e.getMessage());
        }

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        if (dtUpdate == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalArgumentException("Не указано dtUpdate");
        }

        try {
            service.delete(id, dtUpdate);
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
}
