package net.ukr.dreamsicle.tasksmanagementtracker.exception;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(final String message) {
        super(message);
    }
}