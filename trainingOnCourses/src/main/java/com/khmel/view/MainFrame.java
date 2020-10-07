package com.khmel.view;

import com.khmel.controller.CRUDController;
import com.khmel.dao.TeacherDao;
import com.khmel.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel tablePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JScrollPane scrollPane;
    private Table teacherTable;
    private JTextField nameTextField=new JTextField("name");
    private JTextField birthdayTextField=new JTextField("birth");
    private JTextField genderTextField=new JTextField("gender");
    private JTextField educationTextField=new JTextField("education");
    private JTextField categoryTextField=new JTextField("category");
    private JButton addButton= new JButton("Add");

    public MainFrame(){
        super("MainFrame");
       // teacherTable.setLayout(null);
        CRUDController crudController=new CRUDController();
        crudController.setDao(new TeacherDao());
        teacherTable = crudController.createTable();
        scrollPane = new JScrollPane(teacherTable);
       // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVisible(true);
        //scrollPane.setPreferredSize(new Dimension(880, 100));
        teacherTable.setPreferredScrollableViewportSize(new Dimension(455,150));
        scrollPane.setLocation(0,0);
        //scrollPane.setSize(500,100);
       // panel.setLayout(new BorderLayout());;
        tablePanel.setSize(500, 180);
        tablePanel.setLocation(0, 0);
        buttonPanel.setSize(500, 100);
        buttonPanel.setLocation(0, 400);
      //teacherTable.setLocation(0,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        //setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        tablePanel.add(scrollPane);
        nameTextField.setSize(40,20);
        nameTextField.setLocation(10,10);
        buttonPanel.add(nameTextField);

        birthdayTextField.setSize(40,20);
        birthdayTextField.setLocation(60,10);
        buttonPanel.add(birthdayTextField);

        genderTextField.setSize(40,20);
        genderTextField.setLocation(110,10);
        buttonPanel.add(genderTextField);

        educationTextField.setSize(40,20);
         educationTextField.setLocation(160,10);
        buttonPanel.add(educationTextField);

        categoryTextField.setSize(40,20);
         categoryTextField.setLocation(210,10);
        buttonPanel.add(categoryTextField);

        addButton.setSize(40,20);
         addButton.setLocation(260,10);
        buttonPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameTextField.getText();
                String birthday=birthdayTextField.getText();
                String gender=genderTextField.getText();
                String education=educationTextField.getText();
                String category=categoryTextField.getText();

                Teacher teacher= new Teacher(name,birthday,gender,education,category);
                tablePanel.remove(scrollPane);
                teacherTable = crudController.insertIntoTable(teacher);
                teacherTable.setPreferredScrollableViewportSize(new Dimension(455,150));

                scrollPane = new JScrollPane(teacherTable);

                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                tablePanel.updateUI();
            }
        });
        add(tablePanel);
        add(buttonPanel);



    }
}
