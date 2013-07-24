package com.redant.project;

/**
 * custom Exception that is thrown when a message is invalid
 * @author chris economou
 *
 */
class InvalidMessageException extends Exception {

	InvalidMessageException() {

	}

	InvalidMessageException(String message) {
		super(message);
	}

	InvalidMessageException(String message, Throwable cause) {
		super(message, cause);
	}

}
