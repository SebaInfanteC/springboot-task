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
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService service;

    //Version 1
    @PostMapping("/v1/tasks")
    public ResponseEntity<Task> createTaskV1(@RequestBody Task body) {
        Task newTask = service.createTask(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping("/v1/tasks")
    public Collection<Task> getAllTaskV1() {
        return service.getAllTask();
    }

    @GetMapping("/v1/tasks/{id}")
    public ResponseEntity<Task> getTaskByIdV1(@PathVariable Long id) {
        Task task = service.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/v1/tasks/{id}")
    public ResponseEntity<Task> updateTaskV1(@PathVariable Long id, @RequestBody Task body) {
        Task task = service.updateTask(id, body);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping("/v1/tasks/{id}")
    public ResponseEntity<Task> deleteTaskV1(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    //Version 2
    @PostMapping("/v2/tasks")
    public ResponseEntity<Task> createTaskV2(@RequestBody Task body) {
        Task newTask = service.createTask(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping("/v2/tasks")
    public Collection<Task> getAllTaskV2() {
        return service.getAllTask();
    }

    @GetMapping("/v2/tasks/{id}")
    public ResponseEntity<Task> getTaskByIdV2(@PathVariable Long id) {
        Task task = service.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/v2/tasks/{id}")
    public ResponseEntity<Task> updateTaskV2(@PathVariable Long id, @RequestBody Task body) {
        Task task = service.updateTask(id, body);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping("/v2/tasks/{id}")
    public ResponseEntity<Task> deleteTaskV2(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}
