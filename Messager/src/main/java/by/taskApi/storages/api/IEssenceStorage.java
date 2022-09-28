package by.taskApi.storages.api;

import java.util.List;

public interface IEssenceStorage <T> {
    List<T> get();
    T get(String id);
    void save(T item);
}
