package com.boancionut.ToDoApp.repo;

import com.boancionut.ToDoApp.model.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoTask, Long> {

}
