package com.khmel.view;

import com.khmel.controller.CRUDController;
import com.khmel.dao.TeacherDao;
import com.khmel.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private JPanel tablePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JScrollPane scrollPane;
    private Table teacherTable;

    private JLabel nameLabel = new JLabel("NAME: ");
    private JLabel birthdayLabel = new JLabel("BIRTHDAY: ");
    private JLabel genderLabel = new JLabel("GENDER: ");
    private JLabel educationLabel = new JLabel("EDUCATION: ");
    private JLabel categoryLabel = new JLabel("CATEGORY: ");

    private JTextField nameTextField = new JTextField("");
    private JTextField birthdayTextField = new JTextField("");
    private JTextField genderTextField = new JTextField("");
    private JTextField educationTextField = new JTextField("");
    private JTextField categoryTextField = new JTextField("");
    private JButton addButton = new JButton("Add");
    private JButton updateButton = new JButton("Update");

    public MainFrame() {
        super("MainFrame");
        CRUDController crudController = new CRUDController();
        crudController.setDao(new TeacherDao());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 600);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        teacherTable = crudController.createTable();

        scrollPane = new JScrollPane(teacherTable);
        scrollPane.setVisible(true);
        scrollPane.setLocation(0, 0);
        scrollPane.setSize(585, 200);

        tablePanel.setSize(600, 200);
        tablePanel.setLocation(0, 0);
        tablePanel.setLayout(null);
        tablePanel.add(scrollPane);

        buttonPanel.setSize(600, 399);
        buttonPanel.setLocation(0, 201);
        buttonPanel.setLayout(null);

        buttonPanel.add(updateComponent(nameLabel, 10, 10, 80, 20));
        buttonPanel.add(updateComponent(birthdayLabel, 10, 60, 80, 20));
        buttonPanel.add(updateComponent(genderLabel, 10, 110, 80, 20));
        buttonPanel.add(updateComponent(educationLabel, 10, 160, 80, 20));
        buttonPanel.add(updateComponent(categoryLabel, 10, 210, 80, 20));
        buttonPanel.add(updateComponent(nameTextField,100,10,80,20));
        buttonPanel.add(updateComponent(birthdayTextField,100,60,80,20));
        buttonPanel.add(updateComponent(genderTextField, 100, 110,80,20));
        buttonPanel.add(updateComponent(educationTextField,100,160,80,20));
        buttonPanel.add(updateComponent(categoryTextField,100,210,80,20));
        buttonPanel.add(updateComponent(addButton,10,240,170,40));
        buttonPanel.add(updateComponent(updateButton,190,300,200,40));

        add(tablePanel);
        add(buttonPanel);
        setSize(601, 601);



        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameTextField.getText();
                String birthday = birthdayTextField.getText();
                String gender = genderTextField.getText();
                String education = educationTextField.getText();
                String category = categoryTextField.getText();

                Teacher teacher = new Teacher(name, birthday, gender, education, category);
                tablePanel.remove(scrollPane);
                teacherTable = crudController.insertIntoTable(teacher);
                scrollPane = new JScrollPane(teacherTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                //teacherTable.setPreferredScrollableViewportSize(new Dimension(455,150));


                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                tablePanel.updateUI();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //teacherTable.updateUI();
                int id;
                String name;
                String birthday;
                String gender;
                String education;
                String category;
                Teacher teacher;
                List<Teacher> teachers = new ArrayList();
                teacherTable.repaint();
                for (int i = 0; i < teacherTable.getRowCount(); i++) {
                    int j = 0;
                    id = Integer.parseInt((String) teacherTable.getValueAt(i, j++));
                    name = (String) teacherTable.getValueAt(i, j++);
                    birthday = (String) teacherTable.getValueAt(i, j++);
                    gender = (String) teacherTable.getValueAt(i, j++);
                    education = (String) teacherTable.getValueAt(i, j++);
                    category = (String) teacherTable.getValueAt(i, j++);
                    teachers.add(new Teacher(name, birthday, gender, education, category));
                    teachers.get(i).setId(id);
                }
                for (Teacher teacher1 : teachers) {
                    teacherTable = crudController.updateTable(teacher1);
                }


            }
        });


    }

    private JComponent updateComponent(JComponent component, int locationX, int locationY,
                                       int sizeX, int sizeY) {
        component.setSize(sizeX, sizeY);
        component.setLocation(locationX, locationY);

        return component;
    }
}
