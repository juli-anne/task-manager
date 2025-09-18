package com.julianne.taskmanager.controllers;

import com.julianne.taskmanager.dtos.TaskRequest;
import com.julianne.taskmanager.dtos.TaskResponse;
import com.julianne.taskmanager.entities.Status;
import com.julianne.taskmanager.entities.Task;
import com.julianne.taskmanager.mappers.TaskMapper;
import com.julianne.taskmanager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // get request as TaskRequest, return response as TaskResponse, convert it with TaskMapper
    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        return TaskMapper.toResponse(task);
    }

    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
        Task task = TaskMapper.toEntity(request);
        Task saved = taskService.createTask(task);
        return TaskMapper.toResponse(saved);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable String id, @Valid @RequestBody TaskRequest request) {
        Task updated = taskService.updateTask(id, TaskMapper.toEntity(request));
        return TaskMapper.toResponse(updated);
    }

    @PatchMapping("/{id}/status")
    public TaskResponse updateStatus(@PathVariable String id, @RequestParam Status status) {
        Task updated = taskService.updateStatus(id, status);
        return TaskMapper.toResponse(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
    }
}
