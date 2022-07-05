package com.federicobonel.tasktrackerreactjsbackend.datainitializer;

import com.federicobonel.tasktrackerreactjsbackend.model.Task;
import com.federicobonel.tasktrackerreactjsbackend.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public DataInitializer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (taskRepository.count() == 0) {
            initializeTasks();
        }
    }

    private void initializeTasks() {
        Task task1 = new Task();
        task1.setDescription("Hello");
        task1.setDay("Date");
        task1.setReminder(false);

        taskRepository.save(task1);
        log.info("Initialized tasks in data initializer");
    }
}
