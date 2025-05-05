package com.testare.aplicatie.controller;

import com.testare.aplicatie.model.Task;
import com.testare.aplicatie.model.Subtask;
import com.testare.aplicatie.service.TaskService;
import com.testare.aplicatie.service.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TotalController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private SubtaskService subtaskService;

    // === CRUD Task ===

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTasksById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }

    // === Subtask-uri pentru un Task ===

    @GetMapping("/{taskId}/subtasks")
    public List<Subtask> getSubtasksByTaskId(@PathVariable Long taskId) {
        Optional<Task> taskOpt = taskService.getTasksById(taskId);
        if (taskOpt.isPresent()) {
            return taskOpt.get().getSubtasks();
        } else {
            return null;
        }
    }


    // === CRUD Subtask ===

    @PostMapping("/{taskId}/subtasks")
    public Subtask createSubtask(@PathVariable Long taskId, @RequestBody Subtask subtask) {
        Optional<Task> task = taskService.getTasksById(taskId);
        if (task.isPresent()) {
            subtask.setTask(task.get());
            return subtaskService.createSubtask(subtask);
        }
        return null;
    }

    @GetMapping("/subtasks")
    public List<Subtask> getAllSubtasks() {
        return subtaskService.getAllSubtasks();
    }

    @GetMapping("/subtasks/{id}")
    public Subtask getSubtaskById(@PathVariable Long id) {
        return subtaskService.getSubtaskById(id).orElse(null);
    }

    @DeleteMapping("/subtasks/{id}")
    public void deleteSubtask(@PathVariable Long id) {
        subtaskService.deleteSubtask(id);
    }
}
