package org.sreesoft.graphql.exception;

public class SreesoftCustomException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Handles Custom exceptions in Graphql services.
     * @param errorMessage
     */
    public SreesoftCustomException(String errorMessage) {
        super(errorMessage);
    }
}

