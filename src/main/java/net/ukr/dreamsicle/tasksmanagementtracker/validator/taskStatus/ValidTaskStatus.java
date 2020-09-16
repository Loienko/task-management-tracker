package net.ukr.dreamsicle.tasksmanagementtracker.validator.taskStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTaskStatus implements ConstraintValidator<TaskStatus, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
