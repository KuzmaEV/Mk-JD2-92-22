package by.Messenger.storages;

import by.Messenger.storages.entity.Role;
import by.Messenger.storages.entity.User;
import by.Messenger.core.builders.UserBuild;
import by.Messenger.storages.api.IUserStorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserStorage implements IUserStorage {

    private List<User> data = new ArrayList<>();
    private static final UserStorage instance = new UserStorage();

    private UserStorage() {
        this.data.add(UserBuild.create()
                .setLogin("java2022")
                .setPassword("123321java")
                .setName("Yauheni")
                .setDateOfBirth("08-08-2008")
                .setDateOfRegistration(new Date())
                .setRole(Role.ADMIN)
                .build());
    }

    @Override
    public List<User> get() {
        return this.data;
    }

    @Override
    public User get(String login) {
        return this.data.stream().filter(a->a.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User item) {
        this.data.add(item);
    }

    public static UserStorage getInstance(){ return instance; }
}
