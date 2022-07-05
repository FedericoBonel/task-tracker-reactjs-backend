package com.federicobonel.tasktrackerreactjsbackend.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "task_date")
    private String day;

    @Column(name = "reminder")
    private Boolean reminder;
}
