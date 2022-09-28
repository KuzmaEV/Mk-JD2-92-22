package by.taskApi.services;

import by.taskApi.core.entity.Message;
import by.taskApi.core.entity.User;
import by.taskApi.services.api.IMessageService;
import by.taskApi.storages.MessageStorage;
import by.taskApi.storages.api.IMessageStorage;

import java.util.List;

public class MessageService implements IMessageService {

    private static final MessageService instance = new MessageService();
    private final IMessageStorage storage = MessageStorage.getInstance();

    private MessageService() {
    }

//    @Override
//    public void addUser(RegistrationDto dto) {
//         this.storage.save(UserBuild.create()
//                .setLogin(dto.getLogin())
//                .setPassword(dto.getPassword())
//                .setName(dto.getName())
//                .setDateOfBirth(dto.getDateOfBirth())
//                .setRole(Role.USER)
//                .setDateOfRegistration(new Date())
//                .build());
//    }

//    @Override
//    public List get() {
//        return this.storage.get();
//    }

    @Override
    public List<Message> get(User user) {
        return this.storage.get(user);
    }

    @Override
    public List<Message> get() {
        return null;
    }

    @Override
    public Message get(String login) {
        return null;
    }

    @Override
    public void validation(Message message) {
        this.storage.save(message);
    }

    public static MessageService getInstance(){ return instance;}
}
