package com.todoapp.todo_hardy.service;

import com.todoapp.todo_hardy.entity.Task;
import com.todoapp.todo_hardy.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            System.out.println("Task cannot be empty");
        }
        if (task.getDescription() == null || task.getDescription().isEmpty()) {
            System.out.println("Description cannot be empty");
        }

        task.setDone(false);
        return taskRepository.save(task);

    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();

    }

}
