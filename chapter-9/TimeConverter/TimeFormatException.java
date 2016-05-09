public class TimeFormatException extends Exception {
	public TimeFormatException() {
		super("Invalid time!");
	}
	
	public TimeFormatException(String message) {
		super(message);
	}
}
