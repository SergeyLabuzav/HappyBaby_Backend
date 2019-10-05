package by.minsk.ussr.baby.error;

/**
 * Exception indicates that no user is currently logged in.
 *
 * @author Sergey Labuzov
 */
public class NoUserLoggedInException extends RuntimeException {

    public NoUserLoggedInException() {
        super("No user is logged in");
    }
}
