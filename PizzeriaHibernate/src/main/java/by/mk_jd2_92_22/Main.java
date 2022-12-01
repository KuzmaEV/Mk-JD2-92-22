package by.mk_jd2_92_22;



import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now();

        System.out.println("Time with nano" + time);
        System.out.println("Time without nano" + time.truncatedTo(ChronoUnit.MILLIS));
    }
}
