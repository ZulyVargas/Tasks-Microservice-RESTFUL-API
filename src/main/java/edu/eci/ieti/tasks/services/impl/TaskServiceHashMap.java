package edu.eci.ieti.tasks.services.impl;

import edu.eci.ieti.tasks.entities.Task;
import edu.eci.ieti.tasks.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class TaskServiceHashMap implements TaskService {

    HashMap<String, Task> tasks = new HashMap<>();

    @Override
    public Task create(Task task) {
        tasks.put(task.getId(),task);
        return tasks.get(task.getId());
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        List<Task> listTasks = new ArrayList<>(tasks.values());
        return listTasks;
    }

    @Override
    public boolean deleteById(String id) {
        tasks.remove(id);
        return !tasks.containsKey(id);
    }

    @Override
    public Task update(Task task, String id) {
        tasks.replace(id,task);
        return tasks.get(id);
    }
}
