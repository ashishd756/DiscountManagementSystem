package com.adshopping.core.exception;

public class BadResponseException extends Exception {

	private static final long serialVersionUID = 7405342427844253562L;

	public BadResponseException() {
		super();
	}

	public BadResponseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BadResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadResponseException(String message) {
		super(message);
	}

	public BadResponseException(Throwable cause) {
		super(cause);
	}

}
