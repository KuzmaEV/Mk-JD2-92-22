package by.mk_jd2_92_22.foodCounter.profile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class ProfileService implements IProfileService{

    private final ProfileRepository dao;

    public ProfileService(ProfileRepository dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public Profile create(ProfileDTO item) {

        UUID user = UUID.randomUUID();//TODO достать из токена

        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

        Profile profile = ProfileBuilder.create().setUuid(UUID.randomUUID())
                .setDtCreate(now)
                .setDtCreate(now)
                .setWeight(item.getWeight())
                .setHeight(item.getHeight())
                .setTarget(item.getTarget())
                .setDtBirthday(item.getDtBirthday())
                .setActivityType(item.getActivityType())
                .setSex(item.getSex())
                .setUser(user)
                .build();

        return dao.save(profile);
    }

    @Override
    public ProfileResponseDTO get(UUID uuid) {

        //TODO restTemplate get from user-service
        UserProfile userProfile = new UserProfile();

        Profile profile = dao.findById(uuid).orElseThrow(() ->
                new IllegalArgumentException("Profile is not found"));

        return new ProfileResponseDTO(profile.getUuid(),
                profile.getDtCreate(),
                profile.getDtUpdate(),
                profile.getHeight(),
                profile.getWeight(),
                profile.getDtBirthday(),
                profile.getTarget(),
                profile.getActivityType(),
                profile.getSex(),
                userProfile);
    }

    @Override
    @Transactional
    public Profile update(UUID uuid, LocalDateTime dtUpdate, ProfileDTO item) {

        Profile profile = dao.findById(uuid).orElseThrow(() ->
                new IllegalArgumentException("Profile is not found"));

        if (!profile.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("wasn't update, try again");
        }


        return dao.save(profile);
    }

    @Override
    @Transactional
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

        Profile profile = dao.findById(uuid).orElseThrow(() ->
                new IllegalArgumentException("Profile is not found"));

        if (!profile.getDtUpdate().isEqual(dtUpdate)){
            throw new IllegalArgumentException("wasn't delete, try again");
        }

        dao.delete(profile);

    }

}
