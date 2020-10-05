package com.khmel;

import com.khmel.dao.*;
import com.khmel.db.DB;
import com.khmel.model.Bid;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/resources/db.properties"));
        Properties p = new Properties();
        p.load(bis);
        String url = (String) p.get("url");
        String login = (String) p.get("login");
        String password = (String) p.get("password");
        String nameDB =(String) p.get("nameDb");
        String timeZone =(String) p.get("timeZone");
        System.out.println(Bid.class.getSimpleName());
         DB db = new DB(url,nameDB,timeZone,login,password);
        BidDao dao = new BidDao(db);
        big dao1 = (big) DaoFactory.createDao(BidDao.class.getSimpleName(),db);
        GenericDao<Bid> lll = new BidDao(db);
//



    }
}
