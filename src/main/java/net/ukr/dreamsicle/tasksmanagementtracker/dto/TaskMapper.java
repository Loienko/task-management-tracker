package net.ukr.dreamsicle.tasksmanagementtracker.dto;

import net.ukr.dreamsicle.tasksmanagementtracker.model.Task;
import net.ukr.dreamsicle.tasksmanagementtracker.model.TaskStatus;
import net.ukr.dreamsicle.tasksmanagementtracker.model.TaskType;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TaskMapper {

    public TaskDTO toTaskDTO(Task task) {
        if (task == null) {
            return null;
        }
        return TaskDTO.builder()
                .id(task.getId().toHexString())
                .name(task.getName())
                .description(task.getDescription())
                .taskOwner(task.getTaskOwner())
                .taskAuthor(task.getTaskAuthor())
                .type(task.getType().getName())
                .status(task.getStatus().getName())
                .build();
    }

    public Task fromTaskDTO(TaskDTO taskDTO) {

        return Task.builder()
                .name(taskDTO.getName())
                .description(taskDTO.getDescription())
                .taskOwner(taskDTO.getTaskOwner())
                .taskAuthor(taskDTO.getTaskAuthor())
                .type(TaskType.getEnumFromString(taskDTO.getType()))
                .status(TaskStatus.getEnumFromString(taskDTO.getStatus()))
                .build();
    }

    public Page<TaskDTO> toPageTaskDTO(Page<Task> tasks) {
        return tasks.map(this::toTaskDTO);
    }

    public Task toPartialUpdate(Task task, TaskDTO taskDTO) {
        if (task == null) {
            return null;
        }

//        if (task.getName() != null) {
//            task.setName(taskDTO.getName());
//        }
//
//        if (task.getDescription() != null) {
//            task.setDescription(taskDTO.getDescription());
//        }
//
//        if (task.getTaskOwner() != null) {
//            task.setTaskOwner(taskDTO.getTaskOwner());
//        }
//
//        if (task.getTaskAuthor() != null) {
//            task.setTaskAuthor(taskDTO.getTaskAuthor());
//        }
//
//        if (task.getType() != null) {
//            task.setType(TaskType.getEnumFromString(taskDTO.getType()));
//        }
//
//        if (task.getStatus() != null) {
//            task.setStatus(TaskStatus.getEnumFromString(taskDTO.getStatus()));
//        }

        Optional.ofNullable(task.getName()).ifPresent(var -> task.setName(taskDTO.getName()));
        Optional.ofNullable(task.getDescription()).ifPresent(var -> task.setDescription(taskDTO.getDescription()));
        Optional.ofNullable(task.getTaskOwner()).ifPresent(var -> task.setTaskOwner(taskDTO.getTaskOwner()));
        Optional.ofNullable(task.getTaskAuthor()).ifPresent(var -> task.setTaskOwner(taskDTO.getTaskAuthor()));
        Optional.ofNullable(task.getType()).ifPresent(var -> task.setType(TaskType.getEnumFromString(taskDTO.getType())));
        Optional.ofNullable(task.getStatus()).ifPresent(var -> task.setStatus(TaskStatus.getEnumFromString(taskDTO.getStatus())));

        return task;
    }
}
