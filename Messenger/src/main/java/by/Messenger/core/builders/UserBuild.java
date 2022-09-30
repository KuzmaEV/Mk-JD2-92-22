package by.Messenger.core.builders;

import by.Messenger.storages.entity.Role;
import by.Messenger.storages.entity.User;

import java.util.Date;

public class UserBuild {

    private String login;
    private String password;
    private String name;
    private String dateOfBirth;
    private Date dateOfRegistration;
    private Role role;

    private UserBuild() {
    }

    public static UserBuild create(){ return new UserBuild();}

    public UserBuild setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuild setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuild setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuild setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public UserBuild setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        return this;
    }

    public UserBuild setRole(Role role) {
        this.role = role;
        return this;
    }

    public User build(){
        return new User(this.login, this.password, this.name,
                this.dateOfBirth, this.dateOfRegistration, this.role);
    }
}
