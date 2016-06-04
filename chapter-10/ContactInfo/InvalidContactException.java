/**
 * Created by frank on 6/4/16.
 */
public class InvalidContactException extends Exception {
    public InvalidContactException() {
        super("Invalid contact data!");
    }

    public InvalidContactException(String message) {
        super(message);
    }
}
