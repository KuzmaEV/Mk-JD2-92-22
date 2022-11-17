package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.servlets;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem2;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoSelectedItemServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.SelectedItemServiceSingleton;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.ISelectedItemService;
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
import java.util.List;

@WebServlet(name = "SelectedItemServlet", urlPatterns = "/selected_item")
public class SelectedItemServlet extends HttpServlet {

    private final ISelectedItemService service;
    private final ObjectMapper mapper;

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "application/json";

    public SelectedItemServlet() throws PropertyVetoException {
        this.service = SelectedItemServiceSingleton.getInstance();
        this.mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setContentType(CHARACTER_ENCODING);

        String idStr = req.getParameter("id");

        if (idStr == null || idStr.isBlank()){
            List<ISelectedItem2> list = service.get();
            resp.getWriter().write(mapper.writeValueAsString(list));
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            try {
                long id = Long.parseLong(idStr);
                String selectedItem = mapper.writeValueAsString(service.read(id));
                resp.getWriter().write(selectedItem);
            } catch (NumberFormatException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setContentType(CHARACTER_ENCODING);

        DtoSelectedItemServlet dto = mapper.readValue(req.getInputStream(), DtoSelectedItemServlet.class);

        ISelectedItem2 selectedItem = service.create(dto);

        resp.getWriter().write(mapper.writeValueAsString(selectedItem));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setContentType(CHARACTER_ENCODING);

        long id;

        String idStr = req.getParameter("id");
        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(e.getMessage());
        }

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        DtoSelectedItemServlet dto = mapper.readValue(req.getInputStream(), DtoSelectedItemServlet.class);

        ISelectedItem2 selectedItem = service.update(id, dtUpdate, dto);
        resp.getWriter().write(mapper.writeValueAsString(selectedItem));
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setContentType(CHARACTER_ENCODING);

        long id;

        String idStr = req.getParameter("id");
        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            throw new IllegalStateException(e.getMessage());
        }

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        service.delete(id, dtUpdate);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
