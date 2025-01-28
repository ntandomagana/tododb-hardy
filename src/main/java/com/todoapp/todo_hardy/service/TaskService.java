package com.todoapp.todo_hardy.service;

import com.todoapp.todo_hardy.entity.Task;
import com.todoapp.todo_hardy.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            System.out.println("Task with ID " + id + "not found");
        }
        return null;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();

    }

}
