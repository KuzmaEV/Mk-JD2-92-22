package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.IMenuService;

import java.util.List;

public class MenuService implements IMenuService {

    private static final MenuService instance = new MenuService();

    private MenuService() {
    }

    @Override
    public List get() {
        return null;
    }

    @Override
    public Object get(String name) {
        return null;
    }

    @Override
    public void validate(Object item) {

    }

    public static MenuService getInstance(){
        return instance;
    }
}
