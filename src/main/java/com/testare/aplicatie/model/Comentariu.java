package com.testare.aplicatie.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comentariu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    private String continut;
    private String autor;
    private Date date;

    public Comentariu() {
    }

    public Comentariu(Task task, String continut, String autor, Date date) {
        this.task = task;
        this.continut = continut;
        this.autor = autor;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
