package net.ukr.dreamsicle.tasksmanagementtracker.controller;

import lombok.AllArgsConstructor;
import net.ukr.dreamsicle.tasksmanagementtracker.dto.TaskDTO;
import net.ukr.dreamsicle.tasksmanagementtracker.service.TaskService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public Page<TaskDTO> findAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable page) {
        return taskService.findAllTasks(page);
    }

    @GetMapping("/{id}")
    public TaskDTO findById(@PathVariable @Min(1) @Positive ObjectId id) {
        return taskService.findTaskById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TaskDTO create(@Validated @RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public TaskDTO update(@PathVariable @Min(1) @Positive ObjectId id, @Validated @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Min(1) @Positive ObjectId id) {
        taskService.closeTask(id);
    }
}