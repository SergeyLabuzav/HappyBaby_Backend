package by.minsk.ussr.auth.web.error;

import java.net.URI;

public class BadRequestAlertException extends RuntimeException {
    private final String defaultMessage;
    private final String entityName;
    private final String errorKey;
    private final URI type;

    public BadRequestAlertException(URI type, String defaultMessage, String entityName, String errorKey) {
        this.defaultMessage = defaultMessage;
        this.entityName = entityName;
        this.errorKey = errorKey;
        this.type = type;
    }
}
