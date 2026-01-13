package com.sebastian.springboot.todo.springboot_todo.models;

public class Task {

    private Long id;
    private String title;
    private boolean completed;

    public Task() {
    }

    public Task(Long id, boolean completed, String title) {
        this.id = id;
        this.completed = completed;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
