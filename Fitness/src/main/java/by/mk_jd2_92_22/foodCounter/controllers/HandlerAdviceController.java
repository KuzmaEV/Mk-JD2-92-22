package by.mk_jd2_92_22.foodCounter.controllers;

import by.mk_jd2_92_22.foodCounter.core.exception.ProductNotFoundException;
import by.mk_jd2_92_22.foodCounter.core.exception.handlers.ErrorForMultipleErrorResponse;
import by.mk_jd2_92_22.foodCounter.core.exception.handlers.MultipleErrorResponse;
import by.mk_jd2_92_22.foodCounter.core.exception.handlers.SingleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        public MultipleErrorResponse handleValidationExceptions(
                MethodArgumentNotValidException ex) {

                List<ErrorForMultipleErrorResponse> errors = new ArrayList<>();

                ex.getBindingResult().getAllErrors()
                        .forEach((error) -> {

                        String fieldName = ((FieldError) error).getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.add(new ErrorForMultipleErrorResponse(fieldName, errorMessage));
                });

                return new MultipleErrorResponse("structured_error", errors);
        }
}



