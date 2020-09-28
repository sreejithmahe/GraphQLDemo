package org.sreesoft.graphql.exception;

/**
 * @author k_sre
 *
 */
public class SreesoftCustomException extends RuntimeException {
    /**
 *
 */
private static final long serialVersionUID = 1L;

/**
     * Handles Custom exceptions in Graphql services.
     * @param errorMessage errorMessage
     */
    public SreesoftCustomException(final String errorMessage) {
        super(errorMessage);
    }
}

