package com.sebastian.springboot.todo.springboot_todo.services;

import java.util.Collection;

import com.sebastian.springboot.todo.springboot_todo.models.Task;

public interface TaskService {

    Collection<Task> getAllTask();

    Task getTaskById(Long id);

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    boolean deleteTask(Long id);

}
