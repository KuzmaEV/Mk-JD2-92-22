package by.Messenger.services.api;

import java.util.List;

public interface IEssenceService<T> {

    List<T> get();
    T get(String login);
    void validation(T item);
}
