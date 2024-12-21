package com.tut.controller;

import com.tut.entity.Task;
import com.tut.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks()
    {
      return  ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id)
    {
        return  taskService.getTaskById(id);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task)
    {
        System.out.println("Log ----- "+task);
        Task createdTask = taskService.createTask(task);
        System.out.println(createdTask);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id , @RequestBody Task task)
    {
    return taskService.updateTask(id,task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id)
    {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }
}
