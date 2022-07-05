package com.federicobonel.tasktrackerreactjsbackend.services;

import com.federicobonel.tasktrackerreactjsbackend.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findById(Long id);

    void deleteById(Long id);

    Task save(Task task);

    Task updateById(Long id, Task task);
}
