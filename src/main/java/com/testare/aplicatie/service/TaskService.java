package com.testare.aplicatie.service;

import com.testare.aplicatie.model.Task;
import com.testare.aplicatie.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //il declara de tip "service"
public class TaskService {

    @Autowired //injecteaza automat taskRepository
    private TaskRepository taskRepository;

    //creaza si salveaza un task in baza de date
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    //cauta si returneaza toate task-urile
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    //identifica task-ul dupa id
    public Optional getTasksById(Long id) {
        return taskRepository.findById(id);
    }

    //identificare dupa responsabil
    public List<Task> getTasksByresponsabil(String Responsabil) {
        return taskRepository.findByResponsabil(Responsabil);
    }

    //identificare dupa titlu
    public Task getTaskByTitlu(String Titlu) {
        return taskRepository.findByTitlu(Titlu);
    }

    //sterge dupa id
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    //actualizeaza dupa id
    //cautam daca exista acelasi id si daca da, suprascriem datele acelui task
    public Task update(Long id, Task newtask) {
        Optional<Task> thistask = taskRepository.findById(id);
        if (thistask.isPresent()) {
            Task task=thistask.get();

            task.setTitlu(newtask.getTitlu());
            task.setDescriere(newtask.getDescriere());
            task.setDueDate(newtask.getDueDate());
            task.setResponsabil(newtask.getResponsabil());
            return taskRepository.save(newtask);
        }
        return null;
    }
}
