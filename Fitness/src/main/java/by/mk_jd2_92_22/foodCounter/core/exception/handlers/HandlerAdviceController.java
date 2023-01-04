package by.mk_jd2_92_22.foodCounter.core.exception.handlers;

import by.mk_jd2_92_22.foodCounter.core.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class HandlerAdviceController {

        @ExceptionHandler
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public SingleErrorResponse productNotFoundHandler(ProductNotFoundException e) {
                return new SingleErrorResponse(
                        "error",
                        e.getMessage());
        }

        @ExceptionHandler/*({ProductNotFoundException.class})*/
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public SingleErrorResponse updateException(IllegalArgumentException e) {
                return new SingleErrorResponse(
                        "error",
                        e.getMessage());
        }

        @ExceptionHandler
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public MultipleErrorResponse multipleError(IllegalStateException e) {
                return new MultipleErrorResponse(
                        "structured_error",
                        "field",//TODO Вставить название поля
                        e.getMessage());
        }
}



