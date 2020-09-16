package net.ukr.dreamsicle.tasksmanagementtracker.repository;

import net.ukr.dreamsicle.tasksmanagementtracker.model.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, ObjectId> {
    Optional<Task> findByName(String name);

    Boolean existsByName(String name);
}
