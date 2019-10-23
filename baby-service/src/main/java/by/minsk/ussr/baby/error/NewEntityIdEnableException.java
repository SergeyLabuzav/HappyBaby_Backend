package by.minsk.ussr.baby.error;

public class NewEntityIdEnableException extends RuntimeException {

    public NewEntityIdEnableException() {
        super("A new entity cannot already have an ID");
    }
}
