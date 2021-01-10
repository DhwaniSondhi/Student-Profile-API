package org.practice.services.customexceptions;

public class DuplicateKeyException extends RuntimeException {

	private static final long serialVersionUID = 4129053613976597051L;
	public DuplicateKeyException(String message) {
		super("DuplicateKeyException: "+message);
	}
}
