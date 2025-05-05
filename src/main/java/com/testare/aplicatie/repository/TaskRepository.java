package com.testare.aplicatie.repository;

import com.testare.aplicatie.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitlu(String titlu);
    List<Task> findByResponsabil(String responsabil);
}
