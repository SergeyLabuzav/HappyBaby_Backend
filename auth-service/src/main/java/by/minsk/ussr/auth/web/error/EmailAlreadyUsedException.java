package by.minsk.ussr.auth.web.error;

public class EmailAlreadyUsedException extends BadRequestAlertException {

    public EmailAlreadyUsedException() {
        this("");
    }

    public EmailAlreadyUsedException(String path) {
        super(path, "email-already-used", "Email is already in use!", 400);
    }
}
