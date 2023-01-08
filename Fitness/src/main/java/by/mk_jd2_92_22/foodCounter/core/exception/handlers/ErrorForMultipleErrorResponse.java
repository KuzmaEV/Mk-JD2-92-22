package by.mk_jd2_92_22.foodCounter.core.exception.handlers;

public class ErrorForMultipleErrorResponse {

    private String field;
    private String message;

    public ErrorForMultipleErrorResponse() {
    }

    public ErrorForMultipleErrorResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
