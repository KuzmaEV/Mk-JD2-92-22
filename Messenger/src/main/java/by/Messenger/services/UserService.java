package by.Messenger.services;

import by.Messenger.core.dto.RegistrationDto;
import by.Messenger.storages.entity.Role;
import by.Messenger.storages.entity.User;
import by.Messenger.core.builders.UserBuild;
import by.Messenger.services.api.IUserService;
import by.Messenger.storages.UserStorage;
import by.Messenger.storages.api.IUserStorage;

import java.util.Date;
import java.util.List;

public class UserService implements IUserService {

    private static final UserService instance = new UserService();
    private final IUserStorage storage = UserStorage.getInstance();

    private UserService() {
    }

    @Override
    public void validation(User item) { ///NOT USED!!!

    }

    @Override
    public List<User> get() {
        return this.storage.get();
    }

    @Override
    public User get(String login) {
        return this.storage.get(login);
    }

    @Override
    public void addUser(RegistrationDto dto) {
        this.storage.save(UserBuild.create()
                .setLogin(dto.getLogin())
                .setPassword(dto.getPassword())
                .setName(dto.getName())
                .setDateOfBirth(dto.getDateOfBirth())
                .setRole(Role.USER)
                .setDateOfRegistration(new Date())
                .build());
    }

    @Override
    public User validation(String login, String password) {
        User user = this.storage.get(login);
        if (user != null){
            if (user.getPassword().equals(password)){
                return user;
            } else throw new IllegalArgumentException("Invalid password!");
        } else throw new IllegalArgumentException("There is no user with this username!");
    }

    public static UserService getInstance(){ return instance;}
}
