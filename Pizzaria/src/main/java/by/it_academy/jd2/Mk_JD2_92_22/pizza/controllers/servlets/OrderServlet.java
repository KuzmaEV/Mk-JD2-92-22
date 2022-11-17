package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.servlets;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.OrderDTO;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IOrderService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.singleton.OrderServiceSingleton;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OrderService", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final IOrderService service;

    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "application/json";

    public OrderServlet() throws PropertyVetoException {
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        this.service = OrderServiceSingleton.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARACTER_ENCODING);
        PrintWriter writer = resp.getWriter();

        String idStr = req.getParameter("id");

        if (idStr != null){
            long id = Long.parseLong(idStr);
            IOrder order = service.read(id);
            String orderStr = mapper.writeValueAsString(order);
            writer.write(orderStr);
        } else {
            List<IOrder> orders = service.get();
            writer.write(mapper.writeValueAsString(orders));
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding(CHARACTER_ENCODING);
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARACTER_ENCODING);

        OrderDTO orderDTO = mapper.readValue(req.getInputStream(), OrderDTO.class);

        IOrder order = service.create(orderDTO);

        resp.getWriter().write(mapper.writeValueAsString(order));

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
        resp.setContentType(CONTENT_TYPE);
        resp.setCharacterEncoding(CHARACTER_ENCODING);
    }
}
