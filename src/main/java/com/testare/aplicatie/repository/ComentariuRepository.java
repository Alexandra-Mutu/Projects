package com.testare.aplicatie.repository;

import com.testare.aplicatie.model.Comentariu;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface ComentariuRepository extends JpaRepository<Comentariu,Long> {
    List<Comentariu> findByTaskId(Long id);
}
