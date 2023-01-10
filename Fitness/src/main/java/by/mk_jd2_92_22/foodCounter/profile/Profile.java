package by.mk_jd2_92_22.foodCounter.profile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
public class Profile {

    @Id
    private UUID uuid;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;

    private int height;
    private double weight;
    @Column(name = "dt_birthday")
    private Date dtBirthday;
    private double target;

    @Column(name = "activity_type")
    @Enumerated(value = EnumType.STRING)
    private ActivityType activityType;
    @Column(name = "sex")
    @Enumerated(value = EnumType.STRING)
    private ProfileSex sex;

    private UUID user;

    public Profile() {
    }

    public Profile(UUID uuid,
                   LocalDateTime dtCreate, LocalDateTime dtUpdate,
                   int height, double weight, Date dtBirthday, double target,
                   ActivityType activityType, ProfileSex sex,
                   UUID user) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.height = height;
        this.weight = weight;
        this.dtBirthday = dtBirthday;
        this.target = target;
        this.activityType = activityType;
        this.sex = sex;
        this.user = user;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public Date getDtBirthday() {
        return dtBirthday;
    }

    public double getTarget() {
        return target;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public ProfileSex getSex() {
        return sex;
    }

    public UUID getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "uuid=" + uuid +
                ", dtCreate=" + dtCreate +
                ", dtUpdate=" + dtUpdate +
                ", height=" + height +
                ", weight=" + weight +
                ", dtBirthday=" + dtBirthday +
                ", target=" + target +
                ", activityType=" + activityType +
                ", sex=" + sex +
                ", user=" + user +
                '}';
    }
}
