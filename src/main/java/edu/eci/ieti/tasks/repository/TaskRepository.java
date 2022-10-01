package edu.eci.ieti.tasks.repository;

import edu.eci.ieti.tasks.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository  extends MongoRepository<Task, String>{
}
