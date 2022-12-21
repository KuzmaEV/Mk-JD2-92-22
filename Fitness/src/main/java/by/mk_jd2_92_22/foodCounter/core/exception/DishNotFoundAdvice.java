package by.mk_jd2_92_22.foodCounter.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class DishNotFoundAdvice {

    @ResponseBody

    @ExceptionHandler(DishNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dishNotFoundHandler(DishNotFoundException e){ return e.getMessage();}

}
