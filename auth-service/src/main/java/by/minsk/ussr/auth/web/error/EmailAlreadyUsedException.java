package by.minsk.ussr.auth.web.error;

public class EmailAlreadyUsedException extends BadRequestAlertException {

    public EmailAlreadyUsedException() {
        super(ErrorConstants.EMAIL_ALREADY_USED_TYPE, "Email is already in use!", "userManagement", "emailexists");
    }
}
