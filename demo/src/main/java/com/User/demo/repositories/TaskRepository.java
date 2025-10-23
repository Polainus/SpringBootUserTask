package com.User.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User.demo.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {}
