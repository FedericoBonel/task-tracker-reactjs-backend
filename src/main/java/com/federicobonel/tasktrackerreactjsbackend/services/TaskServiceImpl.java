package com.federicobonel.tasktrackerreactjsbackend.services;

import com.federicobonel.tasktrackerreactjsbackend.exceptions.ResourceNotFoundException;
import com.federicobonel.tasktrackerreactjsbackend.model.Task;
import com.federicobonel.tasktrackerreactjsbackend.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task save(Task task) {
        // Make sure id is not set
        task.setId(null);

        return taskRepository.save(task);
    }

    @Override
    public Task updateById(Long id, Task task) {
        //  Make sure the id is set
        task.setId(id);

        return taskRepository.save(task);
    }
}
