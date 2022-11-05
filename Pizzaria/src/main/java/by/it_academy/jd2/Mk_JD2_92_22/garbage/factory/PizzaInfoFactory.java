package by.it_academy.jd2.Mk_JD2_92_22.garbage.factory;

import by.it_academy.jd2.Mk_JD2_92_22.garbage.factory.api.IPizzaInfoFactory;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.FilePizzaInfoStorage;
import by.it_academy.jd2.Mk_JD2_92_22.garbage.storages.api.IPizzaInfoStorage;

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
