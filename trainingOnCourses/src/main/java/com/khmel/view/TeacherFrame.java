package com.khmel.view;

import com.khmel.controller.CRUDController;
import com.khmel.dao.TeacherDao;
import com.khmel.model.Teacher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TeacherFrame extends JFrame {
    private CRUDController crudController;

    private JPanel tablePanel = new JPanel();
    private JPanel componentPanel = new JPanel();
    private JScrollPane scrollPane;
    private Table teacherTable;

    private JLabel nameLabel = new JLabel("NAME: ");
    private JLabel birthdayLabel = new JLabel("BIRTHDAY: ");
    private JLabel genderLabel = new JLabel("GENDER: ");
    private JLabel educationLabel = new JLabel("EDUCATION: ");
    private JLabel categoryLabel = new JLabel("CATEGORY: ");
    private JLabel getIdLabel = new JLabel("ID: ");

    private JTextField nameTextField = new JTextField("");
    private JTextField birthdayTextField = new JTextField("");
    private JTextField genderTextField = new JTextField("");
    private JTextField educationTextField = new JTextField("");
    private JTextField categoryTextField = new JTextField("");
    private JTextField getIdTextField = new JTextField("");

    private JButton addButton = new JButton("Add");
    private JButton updateButton = new JButton("Update");
    private JButton getButton = new JButton("Get");
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");

    public TeacherFrame() {
        super("TeacherFrame");
        crudController = new CRUDController();
        crudController.setDao(new TeacherDao());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        teacherTable = crudController.createTable();

        scrollPane = new JScrollPane(teacherTable);
        scrollPane.setVisible(true);
        scrollPane.setLocation(0, 0);
        scrollPane.setSize(585, 200);

        tablePanel.setSize(600, 200);
        tablePanel.setLocation(0, 0);
        tablePanel.setLayout(null);
        tablePanel.add(scrollPane);

        componentPanel.setSize(600, 349);
        componentPanel.setLocation(0, 201);
        componentPanel.setLayout(null);

        componentPanel.add(updateComponent(nameLabel, 10, 10, 80, 20));
        componentPanel.add(updateComponent(birthdayLabel, 10, 60, 80, 20));
        componentPanel.add(updateComponent(genderLabel, 10, 110, 80, 20));
        componentPanel.add(updateComponent(educationLabel, 10, 160, 80, 20));
        componentPanel.add(updateComponent(categoryLabel, 10, 210, 80, 20));
        componentPanel.add(updateComponent(nameTextField, 100, 10, 80, 20));
        componentPanel.add(updateComponent(birthdayTextField, 100, 60, 80, 20));
        componentPanel.add(updateComponent(genderTextField, 100, 110, 80, 20));
        componentPanel.add(updateComponent(educationTextField, 100, 160, 80, 20));
        componentPanel.add(updateComponent(categoryTextField, 100, 210, 80, 20));
        componentPanel.add(updateComponent(addButton, 10, 260, 170, 40));
        componentPanel.add(updateComponent(updateButton, 190, 260, 170, 40));
        componentPanel.add(updateComponent(getIdLabel, 230, 60, 30, 20));
        componentPanel.add(updateComponent(getIdTextField, 260, 60, 80, 20));
        componentPanel.add(updateComponent(getButton, 230, 90, 110, 40));
        componentPanel.add(updateComponent(deleteButton, 370, 260, 170, 40));
        componentPanel.add(updateComponent(backButton,370,200,170,40));
        add(tablePanel);
        add(componentPanel);
       // setSize(601, 551);


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
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                nameTextField.setText("");
                birthdayTextField.setText("");
                genderTextField.setText("");
                educationTextField.setText("");
                categoryTextField.setText("");
                tablePanel.updateUI();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                List<Teacher> teachers = new ArrayList();
                teacherTable.repaint();
                for (int i = 0; i < teacherTable.getRowCount(); i++) {
                    int j = 0;
                    id = Integer.parseInt((String) teacherTable.getValueAt(i, j++));

                    teachers.add(new Teacher((String) teacherTable.getValueAt(i, j++),
                            (String) teacherTable.getValueAt(i, j++),
                            (String) teacherTable.getValueAt(i, j++),
                            (String) teacherTable.getValueAt(i, j++),
                            (String) teacherTable.getValueAt(i, j++)));
                    teachers.get(i).setId(id);
                }
                for (Teacher teacher : teachers) {
                    teacherTable = crudController.updateTable(teacher);
                }
            }
        });
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    boolean exist = false;
                    int id = Integer.valueOf(getIdTextField.getText());
                    for (int i = 0; i < teacherTable.getRowCount(); i++) {
                        if (id == Integer.parseInt((String) teacherTable.getValueAt(i, 0))) {
                            exist = true;
                            break;
                        }
                    }
                    if (exist) {
                        Teacher teacher = (Teacher) crudController.getFromTable(id);
                        JOptionPane.showMessageDialog(componentPanel, teacher, "Teacher", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(componentPanel, "Doesn't exists", "Teacher", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(componentPanel, "Bad value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                getIdTextField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = teacherTable.getSelectedRow();
                int colomn = 0;
                int id = Integer.parseInt((String) teacherTable.getValueAt(row, colomn++));
                Teacher teacher = new Teacher((String) teacherTable.getValueAt(row, colomn++),
                        (String) teacherTable.getValueAt(row, colomn++),
                        (String) teacherTable.getValueAt(row, colomn++),
                        (String) teacherTable.getValueAt(row, colomn++),
                        (String) teacherTable.getValueAt(row, colomn++));
                teacher.setId(id);
                crudController.deleteFromTable(teacher);
                tablePanel.remove(scrollPane);
                teacherTable = crudController.createTable();
                scrollPane = new JScrollPane(teacherTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                tablePanel.add(scrollPane);
                tablePanel.updateUI();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                new MainFrame();
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
