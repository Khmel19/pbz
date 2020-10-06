package com.khmel.view;

import com.khmel.controller.CRUDController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane;
    private Table teacherTable;

    public MainFrame(){
        super("MainFrame");
       // teacherTable.setLayout(null);
        CRUDController crudController=new CRUDController();
        teacherTable = crudController.createTable();
        scrollPane = new JScrollPane(teacherTable);
    //    scrollPane.setPreferredSize(new Dimension(880, 100));
        scrollPane.setLocation(0,0);
        panel.setLayout(new BorderLayout());;
        panel.setSize(500, 100);
        panel.setLocation(0, 150);
      //teacherTable.setLocation(0,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        //setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        panel.add(scrollPane);
        add(panel);


    }
}
