public class BoardSpaceException extends Exception {
	public BoardSpaceException() {
		super("Invalid space!");
	}
	
	public BoardSpaceException(String message) {
		super(message);
	}
}
