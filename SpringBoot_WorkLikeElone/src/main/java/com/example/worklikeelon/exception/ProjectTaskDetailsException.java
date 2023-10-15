package com.example.worklikeelon.exception;

public class ProjectTaskDetailsException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ProjectTaskDetailsException() {
    }

    public ProjectTaskDetailsException(final String message) {
        super(message);
    }

    public ProjectTaskDetailsException(Throwable cause) {
        super(cause);
    }

    public ProjectTaskDetailsException(final String message, Throwable cause) {
        super(message, cause);
    }
}
