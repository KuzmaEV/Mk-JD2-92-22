package by.mk_jd2_92_22.pizzeria.controllers.servlets;

import by.mk_jd2_92_22.pizzeria.controllers.utils.mapper.ObjectMapperSingleton;
import by.mk_jd2_92_22.pizzeria.dao.entity.api.IOrder;
import by.mk_jd2_92_22.pizzeria.services.api.IOrderService;
import by.mk_jd2_92_22.pizzeria.services.dto.OrderDTO;
import by.mk_jd2_92_22.pizzeria.services.singleton.OrderServiceSingleton;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "OrderService", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final IOrderService service;


    public OrderServlet() throws PropertyVetoException {
        this.mapper = ObjectMapperSingleton.getInstance();
        this.service = OrderServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();

        String idStr = req.getParameter("id");

        if (idStr != null){
            long id = Long.parseLong(idStr);
            IOrder order = service.read(id);
            String ticketStr = mapper.writeValueAsString(order);
            writer.write(ticketStr);
        } else {
            List<IOrder> tickets = service.get();
            writer.write(mapper.writeValueAsString(tickets));
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        OrderDTO dto = mapper.readValue(req.getInputStream(), OrderDTO.class);

        IOrder order = service.create(dto);

        resp.getWriter().write(mapper.writeValueAsString(order));

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idStr = req.getParameter("id");
        long id = Long.parseLong(idStr);

        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);

        OrderDTO orderDTO = mapper.readValue(req.getInputStream(), OrderDTO.class);

        IOrder order = service.update(id, dtUpdate, orderDTO);

        resp.getWriter().write(mapper.writeValueAsString(order));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idStr = req.getParameter("id");
        long id = Long.parseLong(idStr);
        LocalDateTime dtUpdate = mapper.readValue(req.getParameter("dtUpdate"), LocalDateTime.class);


        service.delete(id, dtUpdate);
    }
}
