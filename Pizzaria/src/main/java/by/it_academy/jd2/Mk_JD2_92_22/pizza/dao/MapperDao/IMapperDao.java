package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.MapperDao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.ITicket;

import java.sql.ResultSet;

public interface IMapperDao {

    IPizzaInfo getPizzaInfo(ResultSet rs);
    IMenuRow getMenuRow(ResultSet rs);
    IMenu getMenu(ResultSet rs);
    IOrder getOrder(ResultSet rs);
    ITicket getTicket(ResultSet rs);
    void get(ResultSet rs);



}
