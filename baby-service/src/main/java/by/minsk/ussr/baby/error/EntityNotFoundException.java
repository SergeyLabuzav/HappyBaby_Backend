package by.minsk.ussr.baby.error;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super("Entity with this ID not found");
    }
}
