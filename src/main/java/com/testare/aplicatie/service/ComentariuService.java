package com.testare.aplicatie.service;

import com.testare.aplicatie.model.Comentariu;
import com.testare.aplicatie.repository.ComentariuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentariuService {

    @Autowired
    private ComentariuRepository comentariuRepository;

    public List<Comentariu> getComentariuBytaskId(Long taskId) {
        return comentariuRepository.findByTaskId(taskId);  // Căutare comentarii pentru un task
    }

    public Comentariu createComentariu(Comentariu comentariu) {
        return comentariuRepository.save(comentariu);  // Salvare comentariu
    }

    public Optional<Comentariu> getCommentById(Long id) {
        return comentariuRepository.findById(id);  // Găsire comentariu după ID
    }

    public void deleteComment(Long id) {
        comentariuRepository.deleteById(id);  // Ștergere comentariu după ID
    }
}
