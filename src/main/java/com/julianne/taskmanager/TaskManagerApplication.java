package com.julianne.taskmanager;

import com.julianne.taskmanager.entities.Status;
import com.julianne.taskmanager.entities.Task;
import com.julianne.taskmanager.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TaskRepository taskRepository) {
        return args -> {

            // create new task
            Task task = new Task(
                    "Make lunch",
                    "Rice and chicken",
                    Status.TODO,
                    LocalDateTime.parse("2025-09-18T14:00:00"),
                    LocalDateTime.now()
            );

            taskRepository.save(task);
        };
    }

}
