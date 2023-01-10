package by.mk_jd2_92_22.auditService.service;

import by.mk_jd2_92_22.auditService.model.UserAudit;
import by.mk_jd2_92_22.auditService.repository.UserRepository;
import by.mk_jd2_92_22.auditService.service.api.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class UserService implements IUserService {

    private final UserRepository dao;
    private final ObjectMapper mapper;
    private final RestTemplate restTemplate;

    public UserService(UserRepository dao, ObjectMapper mapper, RestTemplate restTemplate) {
        this.dao = dao;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public UserAudit create(UUID uuid) {

        String userResourceUrl = "http://user-service:8080/api/v1/users/";

        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity(userResourceUrl + uuid, String.class);

        String userJson = responseEntity.getBody();

        if (responseEntity.getStatusCode().equals(HttpStatus.OK)){

            try {
                UserAudit userAudit = mapper.readValue(userJson, UserAudit.class);
                return dao.save(userAudit);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("Не удалось получить пользователя для аудита: " + e);
            }

        }else {
            throw new IllegalArgumentException("Не удалось получить пользователя для аудита: " + userJson);
        }


    }
}
