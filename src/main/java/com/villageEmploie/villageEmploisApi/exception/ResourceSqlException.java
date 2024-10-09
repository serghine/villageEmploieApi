package com.villageEmploie.villageEmploisApi.exception;

/**
 * Represent sql exception information
 */
public class ResourceSqlException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param message msg
     */
    public ResourceSqlException(String message) {
        super(message);
    }
}
