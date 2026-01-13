package com.sebastian.springboot.todo.springboot_todo.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.sebastian.springboot.todo.springboot_todo.exceptions.TaskNotFoundException;
import com.sebastian.springboot.todo.springboot_todo.models.Task;

@Service
public class TaskServiceImpl implements TaskService {

    private final Map<Long, Task> tasks = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Task createTask(Task task) {
        Long id = idGenerator.getAndIncrement();
        Task newTask = new Task(id, task.isCompleted(), task.getTitle());
        tasks.put(id, newTask);

        return newTask;
    }

    @Override
    public Collection<Task> getAllTask() {
        return tasks.values();
    }

    @Override
    public Task getTaskById(Long id) {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException(id);
        }
        return tasks.get(id);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException(id);
        }
        tasks.put(id, new Task(id, task.isCompleted(), task.getTitle()));
        return tasks.get(id);
    }

    @Override
    public boolean deleteTask(Long id) {
        if (!tasks.containsKey(id)) {
            throw new TaskNotFoundException(id);
        }
        return tasks.remove(id) != null;
    }

}
