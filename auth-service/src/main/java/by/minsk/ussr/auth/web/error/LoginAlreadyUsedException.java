package by.minsk.ussr.auth.web.error;

public class LoginAlreadyUsedException extends BadRequestAlertException {

    public LoginAlreadyUsedException() {
        this("");
    }

    public LoginAlreadyUsedException(String path) {
        super(path, "login-already-used", "Login name already used!", 400);
    }
}
