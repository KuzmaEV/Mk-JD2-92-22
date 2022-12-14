package by.example.demo.pizzeria.services;

import by.example.demo.pizzeria.dao.api.IOrderStatusDao;
import by.example.demo.pizzeria.dao.entity.OrderStatus;
import by.example.demo.pizzeria.dao.entity.Stage;
import by.example.demo.pizzeria.services.api.IOrderStatusService;
import by.example.demo.pizzeria.services.api.IStageService;
import by.example.demo.pizzeria.services.dto.OrderStatusDTO;
import by.example.demo.pizzeria.services.dto.StageDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderStatusService implements IOrderStatusService {

    private final IOrderStatusDao dao;
    private final IStageService stageService;

    public OrderStatusService(IOrderStatusDao dao, IStageService stageService) {
        this.dao = dao;
        this.stageService = stageService;
    }

    @Override
    public OrderStatus read(long id) {
        return dao.findById(id).orElseThrow();
    }

    @Override
    public OrderStatus get(long ticket) {
        return dao.findByTicket(ticket);
    }

    @Override
    public List<OrderStatus> get() {

        return dao.findAll();
    }

    @Override
    @Transactional
    public OrderStatus create(OrderStatusDTO item) {

        LocalDateTime nowTime = LocalDateTime.now();
        List<Stage> history = new ArrayList<>();

        OrderStatus orderStatus = new OrderStatus(
                nowTime,
                nowTime,
                history,
                item.getTicket(),
                item.isDone()
        );

        OrderStatus saveOrderStatus = dao.save(orderStatus);

        stageService.create(new StageDTO(item.getStageDescription(), saveOrderStatus.getId()));



        return saveOrderStatus;
    }

    @Override
    @Transactional
    public OrderStatus update(long id, LocalDateTime dtUpdate, OrderStatusDTO item) {

        OrderStatus orderStatus = dao.findById(id).orElseThrow();

//        if (orderStatus == null){
//            throw new IllegalArgumentException("orderStatus не найден!");
//        }
        if (!orderStatus.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось обнавить данные, кто-то отредактировал раньше!");
        }

        orderStatus.setDtUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS));

        orderStatus.setDone(item.isDone());

        return dao.save(orderStatus);
    }

    @Override
    @Transactional
    public void delete(long id, LocalDateTime dtUpdate) {

        OrderStatus orderStatus = dao.findById(id).orElseThrow();

//        if (menu == null){
//            throw new IllegalArgumentException("Меню не найдено!");
//        }
        if (!orderStatus.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("Не удалось удалить данные, кто-то отредактировал раньше!");
        }
        dao.deleteStageFromOrderStatus(id);
        dao.deleteById(id);
    }
}
