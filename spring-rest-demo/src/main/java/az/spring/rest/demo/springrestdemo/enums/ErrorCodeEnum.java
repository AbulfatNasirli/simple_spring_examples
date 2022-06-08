package az.spring.rest.demo.springrestdemo.enums;

public enum ErrorCodeEnum {
    EMPLOYEE_NOT_FOUND(1001, "Can not find employee with given id !!!"),
    VALIDATION_ERROR(1002, "  is not valid !!!"),
    UNKNOWN_ERROR(500, "UNKNOWN ERROR !!!"),
    ACCESS_DENIED(1005, " ACCESS IS DENIED !!!");


    private final String message;
    private final int code;

    ErrorCodeEnum(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

}
