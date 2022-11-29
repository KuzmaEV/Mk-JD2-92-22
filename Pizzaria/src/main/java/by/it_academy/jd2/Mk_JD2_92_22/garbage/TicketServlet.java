package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.ITicket;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.TicketDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "TicketServlet", urlPatterns = "/ticket")
public class TicketServlet extends HttpServlet {

    private final ITicketService service;
    private final ObjectMapper mapper;

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "application/json";

    public TicketServlet() throws PropertyVetoException {
        service = TicketServiceSingleton.getInstance();
        mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARACTER_ENCODING);

        String idStr = req.getParameter("id");
        if (idStr != null){
            long id = Long.parseLong(idStr);
            ITicket read = service.read(id);
            resp.getWriter().write(mapper.writeValueAsString(read));
        } else {
            List<ITicket> tickets = service.get();
            resp.getWriter().write(mapper.writeValueAsString(tickets));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARACTER_ENCODING);

        TicketDTO ticketDTO = mapper.readValue(req.getInputStream(), TicketDTO.class);

        ITicket ticket = service.create(ticketDTO);

        resp.getWriter().write(mapper.writeValueAsString(ticket));


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARACTER_ENCODING);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);

        String idStr = req.getParameter("id");
        LocalDateTime dtCreate = mapper.readValue(req.getParameter("dtCreate"), LocalDateTime.class);

        try {
            long id = Long.parseLong(idStr);
            service.delete(id, dtCreate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
