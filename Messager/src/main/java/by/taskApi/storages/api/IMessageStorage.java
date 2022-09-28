package by.taskApi.storages.api;

import by.taskApi.core.entity.Message;
import by.taskApi.core.entity.User;

import java.util.List;

public interface IMessageStorage extends IEssenceStorage<Message>{

    List<Message> get(User usr);

    @Override
    default void save(Message message) {

    }
}
