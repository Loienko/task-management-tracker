package net.ukr.dreamsicle.tasksmanagementtracker.dto;

public interface Constants {

    String FILL_THE_USERNAME =                  "Please fill in the username";
    String FILL_THE_DESCRIPTION =               "Please fill in the description";
    String FILL_THE_TASK_OWNER =                "Please fill in the task owner";

    // Valid data message
    String INPUT_VALID_DATA_FOR_NAME =          "Please input valid data in the name";
    String INPUT_VALID_DATA_FOR_TASK_TYPE =     "Please input valid data in the task type";
    String INPUT_VALID_DATA_FOR_TASK_STATUS =   "Please input valid data in the task status";
    String INPUT_VALID_DATA_FOR_DESCRIPTION =   "Please input valid data in the description";
    String INPUT_VALID_DATA_FOR_TASK_OWNER =    "Please input valid data in the task owner";
    String INPUT_VALID_DATA_FOR_TASK_AUTHOR =   "Please input valid data in the task author";

    // Regex
    String INPUT_STRING_VALUE_REGEX =           "^[a-zA-Z]+(([',.\\-][a-zA-Z ])?[a-zA-Z]*)*$";
    String DESCRIPTION_REGEX =                  "^[\\w_\\-' ]+$";
}
