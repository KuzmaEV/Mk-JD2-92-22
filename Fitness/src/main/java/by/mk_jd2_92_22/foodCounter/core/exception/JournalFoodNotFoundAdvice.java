package by.mk_jd2_92_22.foodCounter.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JournalFoodNotFoundAdvice {

    @ResponseBody

    @ExceptionHandler(JournalFoodNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String foodDiaryNotFoundHandler(JournalFoodNotFoundException e){ return e.getMessage();}

}
