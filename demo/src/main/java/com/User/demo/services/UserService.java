package com.User.demo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.User.demo.entities.User;
import com.User.demo.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Crear usuario con validación de nombre único
    @Transactional
    public User createUser(User user) {
        if (userRepository.existsByName(user.getName())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }
        return userRepository.save(user);
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar usuario por ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
    }

    // Actualizar usuario
    @Transactional
    public User updateUser(Long id, User updatedUser) {
        User existing = getUserById(id);

        // Validar que el nuevo nombre no esté en uso por otro usuario
        if (!existing.getName().equals(updatedUser.getName()) &&
            userRepository.existsByName(updatedUser.getName())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }

        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setPassword(updatedUser.getPassword());

        return userRepository.save(existing);
    }

    // Eliminar usuario
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public Optional<User> login(String name, String password) {
    return userRepository.findByNameAndPassword(name, password);
}

}
