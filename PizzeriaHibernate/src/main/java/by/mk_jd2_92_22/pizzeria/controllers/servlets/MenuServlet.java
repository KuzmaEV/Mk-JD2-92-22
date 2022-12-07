package by.mk_jd2_92_22.pizzeria.controllers.servlets;

import by.mk_jd2_92_22.pizzeria.controllers.utils.mapper.ObjectMapperSingleton;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IMenu;
import by.mk_jd2_92_22.pizzeria.services.dto.MenuDTO;
import by.mk_jd2_92_22.pizzeria.services.api.IMenuService;
import by.mk_jd2_92_22.pizzeria.services.singleton.MenuServiceSingleton;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "MenuServlet", urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {

    private final IMenuService service;
    private final ObjectMapper mapper;


    public MenuServlet(){
        service = MenuServiceSingleton.getInstance();
        mapper = ObjectMapperSingleton.getInstance();
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

        MenuDTO dto = mapper.readValue(req.getInputStream(), MenuDTO.class);

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
            throw new IllegalStateException(e.getMessage());
        }

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        if (dtUpdate == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalStateException("Не указано dtUpdate");
        }

        MenuDTO dto = mapper.readValue(req.getInputStream(), MenuDTO.class);

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
            throw new IllegalStateException("Не указано id");
        }

        try{
            id = Long.parseLong(idString.trim());
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalStateException(e.getMessage());
        }

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        if (dtUpdate == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            throw new IllegalArgumentException("Не указано dtUpdate");
        }

            service.delete(id, dtUpdate);
            resp.setStatus(HttpServletResponse.SC_OK);

    }
}