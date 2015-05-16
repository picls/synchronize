package com.web.exception;

public class DuplicateDataException extends Exception {
	
	//private static final long serialVersionUID = -0l;

	public DuplicateDataException() {
		super();
	}

	public DuplicateDataException(String message) {
		super(message);
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

}
