package com.khmel.dao;

import com.khmel.db.DB;
import com.khmel.model.Bid;

import java.awt.geom.Arc2D;
import java.sql.Connection;

public class DaoFactory {
    public static GenericDao createDao(String type, DB db) {
        GenericDao genericDao = null;
        switch (type) {
            case "BidDao":
                genericDao = (GenericDao<Bid>)new BidDao(db);
                break;
            case "CollaboratorDao":
                genericDao = new CollaboratorDao(db);
                break;
            case "CompanyCollaboratorDao":
                genericDao = new CompanyCollaboratorDao(db);
                break;
            case "CompanyDao":
                genericDao = new CompanyDao(db);
                break;
            case "CourseDao":
                genericDao = new CourseDao(db);
                break;
            case "OrganizationDao":
                genericDao = new OrganizationDao(db);
                break;
            case "PriceDao":
                genericDao = new PriceDao(db);
                break;
            case "TeacherCourseDao":
                genericDao = new TeacherCourseDao(db);
                break;
            case "TeacherDao":
                genericDao = new TeacherDao(db);
                break;
        }

        return genericDao;
    }


}
