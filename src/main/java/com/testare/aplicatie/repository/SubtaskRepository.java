package com.testare.aplicatie.repository;

import com.testare.aplicatie.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
}
