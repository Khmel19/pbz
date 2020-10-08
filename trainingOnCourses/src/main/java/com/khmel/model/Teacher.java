package com.khmel.model;

public class Teacher extends Model{
    private int id;
    private String name;
    private String birthday;
    private String gender;
    private String education;
    private String category;

    public Teacher() { }

    public Teacher( String name, String birthday, String gender, String education, String category) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public String toString() {
        return "Фамилия: "+name + "\n" +
                "Др: "+ birthday + "\n" +
                "Пол: "+ gender + "\n"+
                "Образование: "+education + "\n" +
                "Категория: "+category;
    }
}