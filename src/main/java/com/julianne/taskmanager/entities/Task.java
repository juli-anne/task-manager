package com.julianne.taskmanager.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data // at compile time generates getters, setters, constructors
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    @NotBlank
    private String title;
    private String description;
    private Status status = Status.TODO;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt = LocalDateTime.now();
}
