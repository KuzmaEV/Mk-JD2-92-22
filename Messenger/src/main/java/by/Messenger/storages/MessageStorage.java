package by.Messenger.storages;

import by.Messenger.storages.entity.Message;
import by.Messenger.storages.entity.User;
import by.Messenger.storages.api.IMessageStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageStorage implements IMessageStorage {

    private final List<Message> data = new ArrayList<>();

    private static final MessageStorage instance = new MessageStorage();


    private MessageStorage() {
    }

    @Override
    public List<Message> get() {
        return this.data;
    } // get all messages! NOT USED!!!

    @Override
    public Message get(String id) { // NOT USED!!!
        return null;
    }

    @Override
    public List<Message> get(User user) {
        return this.data.stream().filter(a->a.getFrom().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Message message) {
        this.data.add(message);
    }

    public static MessageStorage getInstance(){ return instance; }
}
