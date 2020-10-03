package com.khmel.model;

public class Teacher {
    private int id;
    private String name;
    private String birthday;
    private String education;
    private String category;

    public Teacher() { }

    public Teacher(int id, String name, String birthday,
                   String education, String category) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.education = education;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}