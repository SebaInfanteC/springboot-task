package com.sebastian.springboot.todo.springboot_todo.exceptions;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Task con id " + id + " no encontrada");
    }
}
