package com.khmel.model;

public class Collaborator {
    private int id;
    private int idCourse;
    private String name;
    private String position;

    public Collaborator() { }

    public Collaborator( int idCourse, String name, String position) {
        this.id = id;
        this.idCourse = idCourse;
        this.name = name;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}