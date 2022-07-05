package com.federicobonel.tasktrackerreactjsbackend.web.v1.controllers;

import com.federicobonel.tasktrackerreactjsbackend.model.Task;
import com.federicobonel.tasktrackerreactjsbackend.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(TaskController.TASK_URI)
public class TaskController {

    public static final String TASK_URI = "/api/v1/task";

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        log.info("Getting all tasks");

        return taskService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskById(@PathVariable Long taskId) {
        log.info("Getting task by id " + taskId);

        return taskService.findById(taskId);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@Validated @RequestBody Task task) {
        log.info("Creating task with description: " + task.getDescription());

        return taskService.save(task);
    }

    @CrossOrigin
    @PutMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public Task updateTask(@PathVariable Long taskId, @Validated @RequestBody Task task) {
        log.info("Updating task with id: " + taskId);

        return taskService.updateById(taskId, task);
    }

    @CrossOrigin
    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskById(@PathVariable Long taskId) {
        log.info("Deleting task by id " + taskId);

        taskService.deleteById(taskId);
    }
}
