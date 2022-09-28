package by.taskApi.services.api;

import by.taskApi.core.entity.Message;
import by.taskApi.core.entity.User;

import java.util.List;

public interface IMessageService extends IEssenceService<Message> {

    List<Message> get(User user);

    @Override
    void validation(Message message);
}
