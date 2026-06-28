package com.app.todo_app.service;

import com.app.todo_app.models.Task;
import com.app.todo_app.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

//    any variable marked final must be initialized when the object is created (either right where it's declared or inside the constructor). @Autowired on a field attempts to inject the dependency after the object has already been instantiated via reflection, which violates Java's rules for final variables.
    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks(){
       return taskRepo.findAll();
    }

    public void createTask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(Long id) {
       Task task= taskRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Id not found"));
       task.setCompleted(!task.isCompleted());
       taskRepo.save(task);
    }
}
