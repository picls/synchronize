package com.web.exception;

public class NullDataException extends Exception {
	
	//private static final long serialVersionUID = -0l;
	
	public NullDataException() {
		super();
	}
	
	public NullDataException(String message) {
		super(message);
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
	

}
