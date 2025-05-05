package com.testare.aplicatie.controller;

import com.testare.aplicatie.model.Comentariu;
import com.testare.aplicatie.model.Task;
import com.testare.aplicatie.service.ComentariuService;
import com.testare.aplicatie.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commenttask")
public class ComentariuController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ComentariuService comentariuService;

    // adugare comentariu pentru un task
    @PostMapping("/{taskId}/comments")
    public Comentariu addCommentToTask(@PathVariable Long taskId, @RequestBody Comentariu comentariu) {
        Optional<Task> taskOpt = taskService.getTasksById(taskId);
        //
        if (taskOpt.isPresent()) {
            comentariu.setTask(taskOpt.get());
            return comentariuService.createComentariu(comentariu);
        } else {
            return null;
        }
    }

    // preluarea tuturor comentariilor pe un task
    @GetMapping("/{taskId}/comments")
    public List<Comentariu> getCommentsByTaskId(@PathVariable Long taskId) {
        return comentariuService.getComentariuBytaskId(taskId);
    }

    // sortarea dupa un id
    @GetMapping("/comments/{id}")
    public Comentariu getCommentById(@PathVariable Long id) {
        return comentariuService.getCommentById(id).orElse(null);
    }

    // stergere dupa id
    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        comentariuService.deleteComment(id);
    }
}
