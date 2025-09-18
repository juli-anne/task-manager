package com.julianne.taskmanager.dtos;

import com.julianne.taskmanager.entities.Status;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TaskRequest(
        @NotBlank String title,
        String description,
        Status status,
        @Future LocalDateTime dueDate
) {}