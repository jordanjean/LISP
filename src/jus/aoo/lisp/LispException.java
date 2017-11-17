package jus.aoo.lisp;

/**
 * Exceptions levées pendant l'exécution de la machine virtuelle.
 * Cette classe hérite de RTE.
 */
public class LispException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LispException() {
		// TODO Auto-generated constructor stub
	}

	public LispException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LispException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public LispException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LispException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
