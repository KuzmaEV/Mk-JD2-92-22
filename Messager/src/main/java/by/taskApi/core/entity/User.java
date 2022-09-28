package by.taskApi.core.entity;

import java.util.Date;

public class User {
    private String login;
    private String password;
    private String name;
    private String dateOfBirth;
    private Date dateOfRegistration;
    private Role role;



    private User() {
    }

    public User(String login, String password, String name,
                String dateOfBirth, Date dateOfRegistration, Role role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
        this.role = role;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User" + login + '{' +
                " name: " + name + '\n' +
                " date of Birth: " + dateOfBirth + '\n' +
                " date of registration: " + dateOfRegistration + '\n' +
                " role: " + role +
                '}';
    }
}
