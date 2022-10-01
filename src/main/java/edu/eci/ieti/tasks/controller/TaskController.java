package edu.eci.ieti.tasks.controller;

import edu.eci.ieti.tasks.dto.TaskDto;
import edu.eci.ieti.tasks.entities.Task;
import edu.eci.ieti.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

@RestController

@RequestMapping( "/api/v1/task" )
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll(){
        //Get list of tasks and map them to dto tasks
        ModelMapper modelMapper = new ModelMapper();
        List<TaskDto>  tasksDTO = new ArrayList<>();

        try{
            List<Task> tasksList = taskService.getAll();
            for (Task task : tasksList){
                tasksDTO.add(modelMapper.map(task,TaskDto.class));

            }
            return new ResponseEntity<>(tasksDTO, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable String id){
        ModelMapper modelMapper = new ModelMapper();
        try {
            return new ResponseEntity<>(modelMapper.map(taskService.findById(id), TaskDto.class), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TaskDto>create(@RequestBody TaskDto taskDto) {
        ModelMapper modelMapper = new ModelMapper();
        try {
            taskService.create(modelMapper.map(taskDto, Task.class));
            return new ResponseEntity<>(taskDto,HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto>update(@RequestBody TaskDto taskDto, @PathVariable String id){
        ModelMapper modelMapper = new ModelMapper();
        try {
            taskService.update(modelMapper.map(taskDto, Task.class), id);
            return new ResponseEntity<>(taskDto,HttpStatus.ACCEPTED);
        } catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>delete(@PathVariable String id){
        try{
            taskService.deleteById(id);
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.ACCEPTED);
        }
    }

}
