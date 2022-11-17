package com.boancionut.ToDoApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ToDoTask {
    @Id
    @SequenceGenerator(
            name = "todotask_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "todotask_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;

    private String name;
    private String description;
    private String status;

    public ToDoTask() {

    }

    public ToDoTask(String name, String description, String status) {

        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
