package be.johan40.exceptions;

public class NotLastTimeSliceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotLastTimeSliceException() {
		super();
	}

	public NotLastTimeSliceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotLastTimeSliceException(String message) {
		super(message);
	}

	public NotLastTimeSliceException(Throwable cause) {
		super(cause);
	}

}
