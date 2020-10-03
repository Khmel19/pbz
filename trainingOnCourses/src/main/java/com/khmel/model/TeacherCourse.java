package com.khmel.model;

public class TeacherCourse {
    private int idTeacher;
    private int idCourse;
    private String endDate;
    private String startDate;

    public TeacherCourse() { }

    public TeacherCourse(int idTeacher, int idCourse,
                         String endDate, String startDate) {
        this.idTeacher = idTeacher;
        this.idCourse = idCourse;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}