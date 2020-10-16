package com.khmel.model;

public class Bid extends Model{
    private int id;
    private int idCompany;
    private int idCourse;
    private int term;
    private int countOfTrainees;

    public Bid() { }

    public Bid( int idCompany, int idCourse, int term,
               int countOfTrainees) {
        this.id = id;
        this.idCompany = idCompany;
        this.idCourse = idCourse;
        this.term = term;
        this.countOfTrainees = countOfTrainees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getCountOfTrainees() {
        return countOfTrainees;
    }

    public void setCountOfTrainees(int countOfTrainees) {
        this.countOfTrainees = countOfTrainees;
    }

    @Override
    public String toString() {
        return "Bid\n" +
                " id=" + id +
                ",\n idCompany=" + idCompany +
                ",\n idCourse=" + idCourse +
                ",\n term=" + term +
                ",\n countOfTrainees=" + countOfTrainees;
    }
}