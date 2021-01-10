package org.practice.controllers.customexceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6818858437447456176L;
	public NotFoundException(String message) {
		super("NotFoundException: "+message);
	}
}
