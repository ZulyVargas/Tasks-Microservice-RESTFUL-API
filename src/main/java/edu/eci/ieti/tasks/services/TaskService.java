package edu.eci.ieti.tasks.services;

import edu.eci.ieti.tasks.entities.Task;

import java.util.List;

public interface TaskService {


    Task create(Task task );

    Task findById( String id );

    List<Task> getAll();

    void deleteById( String id );

    Task update( Task task, String id );

    List<Task> getTasksById(String idUser);
}
