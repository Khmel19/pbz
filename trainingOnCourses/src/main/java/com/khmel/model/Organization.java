package com.khmel.model;

public class Organization extends Model{
    private int id;
    private int idCourse;
    private String name;
    private String address;
    private String telephone;
    private String email;

    public Organization() { }

    public Organization(int idCourse, String name,
                        String address, String telephone, String email) {
        this.idCourse = idCourse;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Organization\n" +
                "id = " + id +
                "\nidCourse = " + idCourse +
                "\nname = " + name +
                "\naddress = " + address +
                "\ntelephone = " + telephone +
                "\nemail = " + email;
    }
}