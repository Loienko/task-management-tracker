package net.ukr.dreamsicle.tasksmanagementtracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ukr.dreamsicle.tasksmanagementtracker.validator.taskStatus.TaskStatus;
import net.ukr.dreamsicle.tasksmanagementtracker.validator.taskType.TaskType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static net.ukr.dreamsicle.tasksmanagementtracker.dto.Constants.*;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TaskDTO {

    private String id;

    @NotBlank(message = FILL_THE_USERNAME)
    @Pattern(regexp = INPUT_STRING_VALUE_REGEX, message = INPUT_VALID_DATA_FOR_NAME)
    private String name;

    @NotBlank(message = FILL_THE_DESCRIPTION)
    @Pattern(regexp = DESCRIPTION_REGEX, message = INPUT_VALID_DATA_FOR_DESCRIPTION)
    private String description;

    @NotBlank(message = FILL_THE_TASK_OWNER)
    @Pattern(regexp = INPUT_STRING_VALUE_REGEX, message = INPUT_VALID_DATA_FOR_TASK_OWNER)
    private String taskOwner;

    @Pattern(regexp = INPUT_STRING_VALUE_REGEX, message = INPUT_VALID_DATA_FOR_TASK_AUTHOR)
    private String taskAuthor;

    @TaskType(message = INPUT_VALID_DATA_FOR_TASK_TYPE)
    private String type;

    @TaskStatus(message = INPUT_VALID_DATA_FOR_TASK_STATUS)
    private String status;
}
