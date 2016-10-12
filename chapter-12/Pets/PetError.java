public class PetError extends Exception {
    public PetError() {
        super("Pet error!");
    }

    public PetError(String message) {
        super("Pet Error: " + message);
    }
}
