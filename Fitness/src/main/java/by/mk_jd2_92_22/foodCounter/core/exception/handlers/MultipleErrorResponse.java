package by.mk_jd2_92_22.foodCounter.core.exception.handlers;

import java.util.List;

public class MultipleErrorResponse {

    private final String logref;
    private final List<Error> errors;

    public MultipleErrorResponse(String logref, String field, String message) {
        this.logref = logref;
        this.errors = List.of(new Error(field, message));
    }

    private static class Error{
        private  final String field;
        private  final String message;

        public Error(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }
}


