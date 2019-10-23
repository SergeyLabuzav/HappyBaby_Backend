package by.minsk.ussr.baby.error;

public class IdMustNotBeNullException extends RuntimeException {
    public IdMustNotBeNullException() {
        super("Id must not be NULL");
    }
}
