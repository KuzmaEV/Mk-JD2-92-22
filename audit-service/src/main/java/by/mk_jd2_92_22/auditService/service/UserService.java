package by.mk_jd2_92_22.auditService.service;

import by.mk_jd2_92_22.auditService.model.UserAudit;
import by.mk_jd2_92_22.auditService.repository.UserRepository;
import by.mk_jd2_92_22.auditService.service.api.IUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class UserService implements IUserService {

    private final UserRepository dao;

    public UserService(UserRepository dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public UserAudit create(UUID uuid) {

        RestTemplate restTemplate = new RestTemplate();
        UserAudit user = restTemplate
                .getForEntity("http://user-service:8080/api/v1/users/" + uuid, UserAudit.class)
                .getBody();

        if (user == null){
            throw new IllegalArgumentException("Не удалось получить пользователя для аудита");
        }

        return dao.save(user);
    }
}
