package exame_modelo.exercicio3e4.exceptions;

public class MyException extends Exception {

	private static final long serialVersionUID = -2151515147355511072L;
	private String message = null;

	public MyException() {
		super();
	}

	public MyException(String message) {
		super(message);
		this.message = message;
	}

	public MyException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
