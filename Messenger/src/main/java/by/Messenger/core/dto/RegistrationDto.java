package by.Messenger.core.dto;

public class RegistrationDto {

    private String login;
    private String password;
    private String name;
    private String dateOfBirth;

    public RegistrationDto(String login, String password, String name, String dateOfBirth) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
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
}
