package by.it_academy.jd2.Mk_JD2_92_22.pizza.services;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.api.ISelectedItem;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoSelectedItemService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.core.dto.DtoSelectedItemServlet;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.api.ISelectedItemDao;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.api.ISelectedItemService;

import java.time.LocalDateTime;
import java.util.List;

public class SelectedItemService implements ISelectedItemService {

    private final ISelectedItemDao dao;

    public SelectedItemService(ISelectedItemDao dao) {
        this.dao = dao;
    }

    @Override
    public ISelectedItem read(long id) {
        return dao.read(id);
    }

    @Override
    public List<ISelectedItem> get() {

        return dao.get();
    }

    @Override
    public ISelectedItem create(DtoSelectedItemServlet item) {

        return dao.create(new DtoSelectedItemService(LocalDateTime.now(),
                item.getMenuRow(),
                item.getCount()));
    }

    @Override
    public ISelectedItem update(long id, LocalDateTime dtUpdate, DtoSelectedItemServlet item) {
        return dao.update(id, dtUpdate, new DtoSelectedItemService(
                LocalDateTime.now(),
                item.getMenuRow(),
                item.getCount()
        ));
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        dao.delete(id, dtUpdate);

    }
}
