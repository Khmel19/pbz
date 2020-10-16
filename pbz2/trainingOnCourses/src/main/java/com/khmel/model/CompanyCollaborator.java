package com.khmel.model;

public class CompanyCollaborator {
    private int idCompany;
    private int idCollaborator;

    public CompanyCollaborator() { }

    public CompanyCollaborator(int idCompany, int idCollaborator) {
        this.idCompany = idCompany;
        this.idCollaborator = idCollaborator;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdCollaborator() {
        return idCollaborator;
    }

    public void setIdCollaborator(int idCollaborator) {
        this.idCollaborator = idCollaborator;
    }
}