package com.julianne.taskmanager.dtos;

import com.julianne.taskmanager.entities.Status;

import java.time.LocalDateTime;

public record TaskResponse(
        String id,
        String title,
        String description,
        Status status,
        LocalDateTime dueDate,
        LocalDateTime createdAt
) {}