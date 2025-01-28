package com.todoapp.todo_hardy.repository;

import com.todoapp.todo_hardy.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
