package com.User.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User.demo.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Buscar usuario por nombre
    Optional<User> findByName(String name);

    // Buscar usuario por correo
    Optional<User> findByEmail(String email);

    // Comprobar si ya existe un nombre
    boolean existsByName(String name);

    Optional<User> findByNameAndPassword(String name, String password);
}
