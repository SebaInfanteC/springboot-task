package com.sebastian.springboot.todo.springboot_todo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebastian.springboot.todo.springboot_todo.models.Task;
import com.sebastian.springboot.todo.springboot_todo.services.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("")
    public ResponseEntity<Task> createTask(@RequestBody Task body) {
        Task newTask = service.createTask(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping("")
    public Collection<Task> getAllTask() {
        return service.getAllTask();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = service.getTaskById(id);
        // if (task == null) {
        //     return ResponseEntity.notFound().build();
        // }
        return ResponseEntity.ok(task);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task body) {
        Task task = service.updateTask(id, body);
        // if (task == null) {
        //     return ResponseEntity.notFound().build();
        // }
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id) {
        // boolean deleted = service.deleteTask(id);
        // if (!deleted) {
        //     return ResponseEntity.notFound().build();
        // }

        return ResponseEntity.noContent().build();
    }

}
