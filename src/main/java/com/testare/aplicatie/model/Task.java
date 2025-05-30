package com.testare.aplicatie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Task {
    @Id //cheia primara
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incrementare
    private Long id;

    //legatura dintre tabele
    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL) //tip de relatie
    @JsonIgnore
    private List<Subtask> subtasks=new ArrayList<>(); //lista de subtask uri

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL) //tip de relatie
    @JsonIgnore
    private List<Comentariu> comments=new ArrayList<>();

    public List<Comentariu> getComments() {
        return comments;
    }

    public void setComments(List<Comentariu> comments) {
        this.comments = comments;
    }

    private String titlu;
    private String descriere;
    private Date dueDate;
    private String responsabil;

    //Constructori cu si fara parametrii

    public Task() {
    }

    public Task(String titlu, String descriere, Date dueDate, String responsabil) {
        this.titlu = titlu;
        this.descriere = descriere;
        this.dueDate = dueDate;
        this.responsabil = responsabil;
    }
    //getteri si setteri
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsabil() {
        return responsabil;
    }

    public void setResponsabil(String responsabil) {
        this.responsabil = responsabil;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }
}
