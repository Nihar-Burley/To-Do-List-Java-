package com.tut.service;

import com.tut.entity.Task;
import com.tut.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        // Check if the task is found
        if (task.isPresent()) {
            return task.get(); // Return the Task if present
        } else {
            throw new RuntimeException("Task not found with id: " + id); // Handle the case when task is not found
        }
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.save(updatedTask);
    }

    @Override
    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Task has been deleted Successfully";
    }
}
