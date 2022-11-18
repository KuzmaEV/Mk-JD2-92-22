package by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.MapperDao;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenu;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IMenuRow;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IOrder;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.x.ITicket;

import java.sql.ResultSet;

public interface IMapperDao {

    IPizzaInfo getPizzaInfo(ResultSet rs);
    IMenuRow getMenuRow(ResultSet rs);
    IMenu getMenu(ResultSet rs);
    IOrder getOrder(ResultSet rs);
    ITicket getTicket(ResultSet rs);
    void get(ResultSet rs);



}
