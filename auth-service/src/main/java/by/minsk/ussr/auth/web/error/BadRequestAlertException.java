package by.minsk.ussr.auth.web.error;

import lombok.Getter;

@Getter
public abstract class BadRequestAlertException extends RuntimeException {
    private final String error;
    private final String message;
    private final Integer status;
    private final String path;

    BadRequestAlertException(String path, String error, String message, Integer status) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.path = path;
    }
}
