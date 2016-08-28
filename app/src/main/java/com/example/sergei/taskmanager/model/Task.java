package com.example.sergei.taskmanager.model;

/**
 * Created by sergei on 28.08.2016.
 */
public class Task {
    private int idTask;
    private String textTask;
    private String dateTask;
    private boolean isComplete = false;

    public Task(int idTask, String textTask, String dateTask, boolean isComplete) {
        this.idTask = idTask;
        this.textTask = textTask;
        this.dateTask = dateTask;
        this.isComplete = isComplete;
    }

    public Task(String textTask, String dateTask, boolean isComplete) {
        this.textTask = textTask;
        this.dateTask = dateTask;
        this.isComplete = isComplete;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public String getDateTask() {
        return dateTask;
    }

    public void setDateTask(String dateTask) {
        this.dateTask = dateTask;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
