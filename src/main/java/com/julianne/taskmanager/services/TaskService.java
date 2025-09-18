package com.julianne.taskmanager.services;

import com.julianne.taskmanager.entities.Status;
import com.julianne.taskmanager.entities.Task;
import com.julianne.taskmanager.exceptions.ResourceNotFoundException;
import com.julianne.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // return all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // return task by id
    public Task getTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    }

    // add new task
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    // update a task
    public Task updateTask(String id, Task updatedTask) {
        Task existing = getTaskById(id);
        existing.setTitle(updatedTask.getTitle());
        existing.setDescription(updatedTask.getDescription());
        existing.setStatus(updatedTask.getStatus());
        existing.setDueDate(updatedTask.getDueDate());
        return taskRepository.save(existing);
    }

    // update the status
    public Task updateStatus(String id, Status status) {
        Task existing = getTaskById(id);
        existing.setStatus(status);
        return taskRepository.save(existing);
    }

    // delete a task
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
