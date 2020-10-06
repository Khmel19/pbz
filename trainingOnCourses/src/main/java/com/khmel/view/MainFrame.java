package com.khmel.view;

import com.khmel.controller.CRUDController;
import com.khmel.dao.TeacherDao;
import com.khmel.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel panel = new JPanel();
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
    //    scrollPane.setPreferredSize(new Dimension(880, 100));
        scrollPane.setLocation(0,0);
        scrollPane.setSize(500,100);
       // panel.setLayout(new BorderLayout());;
        panel.setSize(1000, 1000);
        panel.setLocation(0, 0);
      //teacherTable.setLocation(0,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1500, 1500);
        //setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        panel.add(scrollPane);
        nameTextField.setLocation(600,400);
        panel.add(nameTextField);

        birthdayTextField.setLocation(200,200);
        panel.add(birthdayTextField);

        genderTextField.setLocation(300,800);
         panel.add(genderTextField);

         educationTextField.setLocation(500,900);
         panel.add(educationTextField);

         categoryTextField.setLocation(300,700);
         panel.add(categoryTextField);

         addButton.setLocation(1000,1000);
         panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameTextField.getText();
                String birthday=birthdayTextField.getText();
                String gender=genderTextField.getText();
                String education=educationTextField.getText();
                String category=categoryTextField.getText();
                System.out.println("aaaaaaa");

                Teacher teacher= new Teacher(name,birthday,gender,education,category);
                scrollPane = new JScrollPane(crudController.insertIntoTable(teacher));
                panel.add(scrollPane);

            }
        });
        add(panel);



    }
}
