package by.Messenger.core.dto;

import by.Messenger.storages.entity.User;


public class MessageDto {

    private User from;
    private User forWhom;
    private String text;


    public MessageDto(User from, User forWhom, String text) {
        this.from = from;
        this.forWhom = forWhom;
        this.text = text;

    }

    public User getFrom() {
        return from;
    }

    public User getForWhom() {
        return forWhom;
    }

    public String getText() {
        return text;
    }


}
