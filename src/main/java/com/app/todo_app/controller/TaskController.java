package com.app.todo_app.controller;

import com.app.todo_app.models.Task;
import com.app.todo_app.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

//    The Model is a built-in Spring object. Think of it like a briefcase or a container used to pass data from your Java backend code over to your HTML frontend view.
    @GetMapping
    public String getAllTasks(Model model){
        List<Task> tasks=taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
//        This tells Spring Boot to look for an HTML file named tasks.html (usually located in your src/main/resources/templates/ folder) and render it in the user's browser.
    }

//The first parameter "tasks" is the key (the nickname the HTML page will use to find this data).
//The second parameter tasks is the actual value (the Java List we just fetched).

    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/tasks";
    }
}
