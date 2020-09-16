package net.ukr.dreamsicle.tasksmanagementtracker.validator.taskType;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTaskType implements ConstraintValidator<TaskType, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
