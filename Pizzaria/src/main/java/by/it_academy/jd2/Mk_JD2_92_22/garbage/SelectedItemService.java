package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import by.it_academy.jd2.Mk_JD2_92_22.pizza.dao.entity.api.ISelectedItem2;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.DtoSelectedItemService;
import by.it_academy.jd2.Mk_JD2_92_22.pizza.services.dto.DtoSelectedItemServlet;

import java.time.LocalDateTime;
import java.util.List;

public class SelectedItemService implements ISelectedItemService {

    private final ISelectedItemDao dao;

    public SelectedItemService(ISelectedItemDao dao) {
        this.dao = dao;
    }

    @Override
    public ISelectedItem2 read(long id) {
        return dao.read(id);
    }

    @Override
    public List<ISelectedItem2> get() {

        return dao.get();
    }

    @Override
    public ISelectedItem2 create(DtoSelectedItemServlet item) {

        return dao.create(new DtoSelectedItemService(LocalDateTime.now(),
                item.getRow(),
                item.getCount()));
    }

    @Override
    public ISelectedItem2 update(long id, LocalDateTime dtUpdate, DtoSelectedItemServlet item) {
        return dao.update(id, dtUpdate, new DtoSelectedItemService(
                LocalDateTime.now(),
                item.getRow(),
                item.getCount()
        ));
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

        dao.delete(id, dtUpdate);

    }
}
