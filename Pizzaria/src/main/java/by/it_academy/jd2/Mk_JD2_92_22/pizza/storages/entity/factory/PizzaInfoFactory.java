package by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.entity.factory;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.IPizzaInfo;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.FilePizzaInfoStorage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.api.IPizzaInfoStorage;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.storages.entity.factory.api.IPizzaInfoFactory;

public class PizzaInfoFactory implements IPizzaInfoFactory {

    private static final PizzaInfoFactory instance = new PizzaInfoFactory();

    private final IPizzaInfoStorage pizzaInfo;

    public PizzaInfoFactory() {
        this.pizzaInfo = new FilePizzaInfoStorage();
    }

    @Override
    public IPizzaInfoStorage getPizzaInfoStorage() {
        return this.pizzaInfo;
    }

    public static PizzaInfoFactory getInstance(){
        return instance;
    }
}
