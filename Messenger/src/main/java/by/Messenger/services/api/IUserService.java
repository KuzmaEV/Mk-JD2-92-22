package by.Messenger.services.api;

import by.Messenger.core.dto.RegistrationDto;
import by.Messenger.storages.entity.User;

public interface IUserService extends IEssenceService<User>{

    User validation(String login, String password);

    void addUser(RegistrationDto dto);
}
