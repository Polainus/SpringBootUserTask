package com.User.demo.services;

import com.User.demo.entities.Task;
import com.User.demo.entities.User;
import com.User.demo.repositories.TaskRepository;
import com.User.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task create(Task task, Long userId) {
        // Buscar al usuario
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Asociar tarea al usuario
        task.setUser(user);

        // Guardar tarea
        return taskRepository.save(task);
    }

    public Task update(Long id, Task t) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada"));

        existing.setTitle(t.getTitle());
        existing.setDescription(t.getDescription());
        existing.setCompleted(t.isCompleted());

        return taskRepository.save(existing);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> getById(Long id) {
    return taskRepository.findById(id);
    }

}
