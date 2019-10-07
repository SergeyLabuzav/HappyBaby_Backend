package by.minsk.ussr.auth.web.error.handler;

import by.minsk.ussr.auth.web.error.model.ApiError;
import by.minsk.ussr.auth.web.error.BadRequestAlertException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BadRequestAlertException.class})
    public ResponseEntity<ApiError> handleConstraintViolation(BadRequestAlertException ex) {
        return new ResponseEntity<>(new ApiError(ex), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
