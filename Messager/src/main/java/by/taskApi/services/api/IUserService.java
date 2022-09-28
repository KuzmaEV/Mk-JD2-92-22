package by.taskApi.services.api;

import by.taskApi.core.dto.RegistrationDto;
import by.taskApi.core.entity.User;

public interface IUserService extends IEssenceService<User>{

    User validation(String login, String password);

    void addUser(RegistrationDto dto);
}
