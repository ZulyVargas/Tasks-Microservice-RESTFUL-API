package edu.eci.ieti.tasks.repository;

import edu.eci.ieti.tasks.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TaskRepository  extends MongoRepository<Task, String>{

    List<Task> findByAssignedToLike(String regexp);

}
