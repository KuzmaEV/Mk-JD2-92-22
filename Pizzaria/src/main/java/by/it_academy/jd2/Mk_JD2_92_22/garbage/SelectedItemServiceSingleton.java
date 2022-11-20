package by.it_academy.jd2.Mk_JD2_92_22.garbage;

import java.beans.PropertyVetoException;

public class SelectedItemServiceSingleton {
    private static SelectedItemServiceSingleton instance;
    private final ISelectedItemService service;

    public SelectedItemServiceSingleton() throws PropertyVetoException {
        service = new SelectedItemService(SelectedItemDaoSingleton.getInstance());
    }

    public static ISelectedItemService getInstance() throws PropertyVetoException {
        if (instance == null){
            synchronized (SelectedItemServiceSingleton.class){
                instance = new SelectedItemServiceSingleton();
            }
        }
        return instance.service;
    }
}
