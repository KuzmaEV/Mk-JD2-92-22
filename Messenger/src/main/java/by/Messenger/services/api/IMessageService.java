package by.Messenger.services.api;

import by.Messenger.storages.entity.Message;
import by.Messenger.storages.entity.User;

import java.util.List;

public interface IMessageService extends IEssenceService<Message> {

    List<Message> get(User user);

    @Override
    void validation(Message message);
}
