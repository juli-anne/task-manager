package com.julianne.taskmanager.mappers;

import com.julianne.taskmanager.dtos.TaskRequest;
import com.julianne.taskmanager.dtos.TaskResponse;
import com.julianne.taskmanager.entities.Status;
import com.julianne.taskmanager.entities.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequest request) {
        return new Task(
                request.title(),
                request.description(),
                request.status() != null ? request.status() : Status.TODO,
                request.dueDate(),
                null // createdAt goes through service
        );
    }

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate(),
                task.getCreatedAt()
        );
    }
}
