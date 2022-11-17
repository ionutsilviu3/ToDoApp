package com.boancionut.ToDoApp.controller;

import com.boancionut.ToDoApp.model.ToDoTask;
import com.boancionut.ToDoApp.repo.ToDoRepository;
import com.boancionut.ToDoApp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/todo")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDoTask> findAll()
    {
        return toDoService.getToDoTasks();
    }

    @PostMapping
    public void save(@RequestBody ToDoTask task)
    {
        toDoService.createToDoTask(task);
    }

    @PutMapping(path = {"id"})
    public void update(@PathVariable Long id, @RequestBody ToDoTask task)
    {
        toDoService.updateTask(id,task);
    }

    @DeleteMapping(path = {"id"})
    public void remove(@PathVariable Long id)
    {
        toDoService.deleteTask(id);
    }
}
