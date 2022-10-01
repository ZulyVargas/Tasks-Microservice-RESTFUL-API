package edu.eci.ieti.tasks.services.impl;

import edu.eci.ieti.tasks.entities.Task;
import edu.eci.ieti.tasks.repository.TaskRepository;
import edu.eci.ieti.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceMongoDB  implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceMongoDB(@Autowired TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }


    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task, String id) {
        taskRepository.save(task); ;
        return findById(id);
    }

    @Override
    public List<Task> getTasksById(String idUser) {
        return taskRepository.findByAssignedToLike(idUser);
    }
}
