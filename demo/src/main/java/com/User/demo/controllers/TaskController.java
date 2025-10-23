package com.User.demo.controllers;

import com.User.demo.entities.Task;
import com.User.demo.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Task t, @RequestParam Long userId) {
        try {
            Task created = service.create(t, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task t) {
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
    Optional<Task> task = service.getById(id);
    if (task.isPresent()) {
        return ResponseEntity.ok(task.get());
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Tarea con id " + id + " no encontrada");
    }
}

}
