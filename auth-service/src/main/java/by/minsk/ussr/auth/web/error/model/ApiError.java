package by.minsk.ussr.auth.web.error.model;

import by.minsk.ussr.auth.web.error.BadRequestAlertException;
import java.time.Instant;
import lombok.Getter;

@Getter
public class ApiError {

    private String error;
    private String message;
    private String path;
    private Integer status;
    private Instant timestamp;

    private ApiError(String error, String message, String path, Integer status) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
        this.timestamp = Instant.now();
    }

    public ApiError(BadRequestAlertException ex) {
        this(ex.getError(), ex.getMessage(), ex.getPath(), ex.getStatus());
    }
}
