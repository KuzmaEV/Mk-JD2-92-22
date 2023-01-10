package by.mk_jd2_92_22.foodCounter.profile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.util.Date;

public class ProfileDTO {

    @Positive
    private int height;
    @Positive
    private double weight;
    @Past @NotNull
    private Date dtBirthday;
    @Positive
    private double target;
    @NotBlank
    private ActivityType activityType;
    @NotBlank
    private ProfileSex sex;

    public ProfileDTO() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getDtBirthday() {
        return dtBirthday;
    }

    public void setDtBirthday(Date dtBirthday) {
        this.dtBirthday = dtBirthday;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ProfileSex getSex() {
        return sex;
    }

    public void setSex(ProfileSex sex) {
        this.sex = sex;
    }
}
