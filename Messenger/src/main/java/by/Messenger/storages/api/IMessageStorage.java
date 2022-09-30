package by.Messenger.storages.api;

import by.Messenger.storages.entity.Message;
import by.Messenger.storages.entity.User;

import java.util.List;

public interface IMessageStorage extends IEssenceStorage<Message>{

    List<Message> get(User usr);

    @Override
    default void save(Message message) {

    }
}
