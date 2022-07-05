package com.federicobonel.tasktrackerreactjsbackend.datainitializer;

import com.federicobonel.tasktrackerreactjsbackend.model.Task;
import com.federicobonel.tasktrackerreactjsbackend.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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
        task1.setDescription("Morning Jogging!");
        task1.setDay("July 7th 2022, 10:00 AM");
        task1.setReminder(true);

        Task task2 = new Task();
        task2.setDescription("Meeting with production team \uD83D\uDC68\u200D\uD83D\uDCBB");
        task2.setDay("July 7th 2022, 11:00 AM");
        task2.setReminder(true);

        Task task3 = new Task();
        task3.setDescription("Lunch \uD83C\uDF72");
        task3.setDay("July 7th 2022, 12:00 PM");
        task3.setReminder(false);

        taskRepository.saveAll(List.of(task1, task2, task3));
        log.info("Initialized tasks in data initializer");
    }
}
