package com.khmel.dao;

import java.sql.Connection;

public interface DaoFactory {
    public Connection getConnection();
    public BidDao getBidDao();
    public CollaboratorDao getCollaboratorDao();
    public CompanyCollaboratorDao getCompanyCollaboratorDao();
    public CompanyDao getCompanyDao();
    public CourseDao getCourseDao();
    public OrganizationDao getOrganizationDao();
    public PriceDao getPriceDao();
    public TeacherCourseDao getTeacherCourseDao();
    public TeacherDao getTeacherDao();
    
}
