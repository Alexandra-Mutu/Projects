package com.testare.aplicatie.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Subtask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //realizam legatura dintre entitati si setam cheia straina
    //toate subtask urile au cate un task
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    private String titlu;
    private String descriere;
    private Date dueDate;


    //constructori cu si fara parametrii
    public Subtask() {}
    public Subtask(Task task, String titlu, String descrere, Date dueDate) {
        this.task = task;
        this.titlu = titlu;
        this.descriere = descrere;
        this.dueDate = dueDate;
    }

    //getteri si setteri
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
