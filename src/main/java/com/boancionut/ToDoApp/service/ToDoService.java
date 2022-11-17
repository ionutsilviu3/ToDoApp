package com.boancionut.ToDoApp.service;

import com.boancionut.ToDoApp.model.ToDoTask;
import com.boancionut.ToDoApp.repo.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService implements IToDoService{
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDoTask> getToDoTasks() {
        return toDoRepository.findAll();
    }

    @Override
    public void createToDoTask(ToDoTask toDoTask) {
        toDoRepository.save(toDoTask);
    }

    @Override
    public void updateTask(Long id, ToDoTask toDoTask) {
        ToDoTask taskToUpdate = toDoRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                String.format("Task with id %s doesn't exist!", id)));
        taskToUpdate.setName(toDoTask.getName());
        taskToUpdate.setDescription(toDoTask.getDescription());
        taskToUpdate.setStatus(toDoTask.getStatus());

        toDoRepository.save(taskToUpdate);

    }

    @Override
    public void deleteTask(Long id) {
        boolean taskExists = toDoRepository.existsById(id);
        if(!taskExists)
            throw new IllegalStateException(String.format("Task with id %s doesn't exist!", id));
        toDoRepository.deleteById(id);
    }
}
