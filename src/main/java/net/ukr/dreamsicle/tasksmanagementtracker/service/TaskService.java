package net.ukr.dreamsicle.tasksmanagementtracker.service;

import lombok.AllArgsConstructor;
import net.ukr.dreamsicle.tasksmanagementtracker.client.ApiClient;
import net.ukr.dreamsicle.tasksmanagementtracker.dto.TaskDTO;
import net.ukr.dreamsicle.tasksmanagementtracker.dto.TaskMapper;
import net.ukr.dreamsicle.tasksmanagementtracker.dto.UserDTO;
import net.ukr.dreamsicle.tasksmanagementtracker.exception.CustomDataAlreadyExistsException;
import net.ukr.dreamsicle.tasksmanagementtracker.exception.ResourceNotFoundException;
import net.ukr.dreamsicle.tasksmanagementtracker.model.Task;
import net.ukr.dreamsicle.tasksmanagementtracker.repository.TaskRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static net.ukr.dreamsicle.tasksmanagementtracker.model.TaskStatus.DONE;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ApiClient apiClient;


    public Page<TaskDTO> findAllTasks(Pageable pageable) {
        return taskMapper.toPageTaskDTO(taskRepository.findAll(pageable));
    }

    public TaskDTO findTaskById(ObjectId id) {
        return taskRepository
                .findById(id)
                .map(taskMapper::toTaskDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public TaskDTO createTask(TaskDTO taskDTO) {
        if (Boolean.TRUE.equals(taskRepository.existsByName(taskDTO.getName()))) {
            throw new CustomDataAlreadyExistsException("Username is already in use!");
        }

        UserDTO userDTO = apiClient.userExistenceCheck(taskDTO.getTaskAuthor());

        Task actualTaskDTO = taskMapper.fromTaskDTO(taskDTO);

        Task task = Task.builder()
                .name(actualTaskDTO.getName())
                .description(actualTaskDTO.getDescription())
                .taskOwner(userDTO.getUsername())
                .taskAuthor(actualTaskDTO.getTaskAuthor())
                .type(actualTaskDTO.getType())
                .status(actualTaskDTO.getStatus())
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .updated(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        return taskMapper.toTaskDTO(taskRepository.save(task));
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public TaskDTO updateTask(ObjectId id, TaskDTO userDTO) {
        Task task = taskRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return taskMapper.toTaskDTO(
                taskRepository.save(
                        taskMapper.toPartialUpdate(
                                task,
                                userDTO
                        )
                )
        );
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void closeTask(ObjectId id) {
        Task user = taskRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        user.setStatus(DONE);
        taskRepository.save(user);
    }
}