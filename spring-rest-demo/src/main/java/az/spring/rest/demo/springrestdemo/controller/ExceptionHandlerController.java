package az.spring.rest.demo.springrestdemo.controller;
   import az.spring.rest.demo.springrestdemo.enums.ErrorCodeEnum;
import az.spring.rest.demo.springrestdemo.exception.CustomNotFoundException;
import az.spring.rest.demo.springrestdemo.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
   import org.springframework.security.access.AccessDeniedException;
   import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomException(CustomNotFoundException exception) {
        return ErrorResponse.builder().
                code(exception.getCode()).
                message(exception.getMessage()).
                build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInputParam(MethodArgumentTypeMismatchException mismatchException) {

        String parameterName = mismatchException.getParameter().getParameter().getName();
        return ErrorResponse.builder().
                code(ErrorCodeEnum.VALIDATION_ERROR.getCode()).
                message(parameterName + ErrorCodeEnum.VALIDATION_ERROR.getMessage()).
                build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidation(MethodArgumentNotValidException argumentNotValidException) {
        String fieldName = argumentNotValidException.getBindingResult().getFieldError().getField();

        return ErrorResponse.builder().
                code(ErrorCodeEnum.VALIDATION_ERROR.getCode()).
                message(fieldName + ErrorCodeEnum.VALIDATION_ERROR.getMessage()).
                build();

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnknown(Exception exception) {
        exception.printStackTrace();
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.UNKNOWN_ERROR.getCode()).
                        message(ErrorCodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleAccess(AccessDeniedException deniedException) {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.ACCESS_DENIED.getCode()).
                        message(ErrorCodeEnum.ACCESS_DENIED.getMessage())
                .build();
    }
}
