package es.cic.bootcamp.ejercicio005;

public class NoImplementadoException extends RuntimeException {

	public NoImplementadoException() {
		super();
	}

	public NoImplementadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoImplementadoException(String message) {
		super(message);
	}
}
