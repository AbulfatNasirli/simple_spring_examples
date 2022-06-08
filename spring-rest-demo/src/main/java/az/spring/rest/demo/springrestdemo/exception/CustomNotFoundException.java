package az.spring.rest.demo.springrestdemo.exception;

import az.spring.rest.demo.springrestdemo.enums.ErrorCodeEnum;

public class CustomNotFoundException extends RuntimeException {

    private final int code;
    private final String message;

    public CustomNotFoundException(ErrorCodeEnum message) {
        super(message.getMessage());
        this.message = ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getMessage();
        this.code = ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getCode();
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }
}
