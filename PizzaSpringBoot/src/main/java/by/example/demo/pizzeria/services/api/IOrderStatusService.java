package by.example.demo.pizzeria.services.api;

import by.example.demo.pizzeria.dao.entity.OrderStatus;
import by.example.demo.pizzeria.services.dto.OrderStatusDTO;

public interface IOrderStatusService extends IService<OrderStatus, OrderStatusDTO> {

    OrderStatus get(long ticket);
}
