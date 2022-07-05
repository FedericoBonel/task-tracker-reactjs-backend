package com.federicobonel.tasktrackerreactjsbackend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "task_date")
    private String day;

    @NotNull
    @Column(name = "reminder")
    private Boolean reminder;
}
