package com.boancionut.ToDoApp.service;

import com.boancionut.ToDoApp.model.ToDoTask;

import java.util.List;

public interface IToDoService {

    List<ToDoTask> getToDoTasks();
    void createToDoTask(ToDoTask toDoTask);
    void updateTask(Long id, ToDoTask toDoTask);
    void deleteTask(Long id);
}
