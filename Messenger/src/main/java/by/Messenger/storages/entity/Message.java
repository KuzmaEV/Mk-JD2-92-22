package by.Messenger.storages.entity;

import java.util.Date;

public class Message {
    private Date date;
    private User from;
    private User forWhom;
    private String text;

    private Message(){}

    public Message(Date date, User from, User forWhom, String text) {
        this.date = date;
        this.from = from;
        this.forWhom = forWhom;
        this.text = text;
    }

    public Date getDate() {
        return date;
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

    @Override
    public String toString() {
        return "Message{" +
                "date: " + date + '\n' +
                " from: " + from.getName() + '\n' +
                " message: " + text +
                '}';
    }
}
