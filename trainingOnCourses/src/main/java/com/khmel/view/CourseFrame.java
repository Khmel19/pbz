package com.khmel.view;

import com.khmel.controller.CRUDController;
import com.khmel.dao.CourseDao;
import com.khmel.model.Course;
import com.khmel.model.Teacher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CourseFrame extends JFrame{
    private CRUDController crudController;

    private JPanel tablePanel = new JPanel();
    private JPanel componentPanel = new JPanel();
    private JScrollPane scrollPane;
    private Table courseTable;

    private JLabel nameLabel = new JLabel("NAME: ");
    private JLabel typeLabel = new JLabel("TYPE: ");
    private JLabel countOfDaysLabel = new JLabel("COUNT OF DAYS: ");
    private JLabel countOfTraineesLabel = new JLabel("COUNT OF TRAINEES: ");
    private JLabel priceIdLabel = new JLabel("ID PRICE: ");
    private JLabel getIdLabel = new JLabel("ID: ");

    private JTextField nameTextField = new JTextField("");
    private JTextField typeTextField = new JTextField("");
    private JTextField countOfDaysTextField = new JTextField("");
    private JTextField countOfTraineesTextField = new JTextField("");
    private JTextField priceIdTextField = new JTextField("");
    private JTextField getIdTextField = new JTextField("");

    private JButton addButton = new JButton("Add");
    private JButton updateButton = new JButton("Update");
    private JButton getButton = new JButton("Get");
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");

    public CourseFrame() {
        super("CourseFrame");
        crudController = new CRUDController();
        crudController.setDao(new CourseDao());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        courseTable = crudController.createTable();

        scrollPane = new JScrollPane(courseTable);
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

        componentPanel.add(updateComponent(nameLabel, 10, 10, 100, 20));
        componentPanel.add(updateComponent(typeLabel, 10, 60, 80, 20));
        componentPanel.add(updateComponent(countOfDaysLabel, 10, 110, 120, 20));
        componentPanel.add(updateComponent(countOfTraineesLabel, 10, 160, 150, 20));
        componentPanel.add(updateComponent(priceIdLabel, 10, 210, 80, 20));
        componentPanel.add(updateComponent(nameTextField, 160, 10, 80, 20));
        componentPanel.add(updateComponent(typeTextField, 160, 60, 80, 20));
        componentPanel.add(updateComponent(countOfDaysTextField, 160, 110, 80, 20));
        componentPanel.add(updateComponent(countOfTraineesTextField, 160, 160, 80, 20));
        componentPanel.add(updateComponent(priceIdTextField, 160, 210, 80, 20));
        componentPanel.add(updateComponent(addButton, 10, 260, 170, 40));
        componentPanel.add(updateComponent(updateButton, 190, 260, 170, 40));
        componentPanel.add(updateComponent(getIdLabel, 370, 60, 30, 20));
        componentPanel.add(updateComponent(getIdTextField, 400, 60, 80, 20));
        componentPanel.add(updateComponent(getButton, 370, 90, 110, 40));
        componentPanel.add(updateComponent(deleteButton, 370, 260, 170, 40));
        componentPanel.add(updateComponent(backButton,370,200,170,40));
        add(tablePanel);
        add(componentPanel);
        // setSize(601, 551);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameTextField.getText();
                String type = typeTextField.getText();
                int countOfDays = Integer.parseInt(countOfDaysTextField.getText());
                int countOfTrainees = Integer.parseInt(countOfTraineesTextField.getText());
                int priceId = Integer.parseInt(priceIdTextField.getText());

                Course course = new Course(name, type, countOfDays, countOfTrainees, priceId);

                tablePanel.remove(scrollPane);
                courseTable = crudController.insertIntoTable(course);
                scrollPane = new JScrollPane(courseTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                nameTextField.setText("");
                typeTextField.setText("");
                countOfDaysTextField.setText("");
                countOfTraineesTextField.setText("");
                priceIdTextField.setText("");
                tablePanel.updateUI();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                List<Course> courses = new ArrayList();
                courseTable.repaint();
                for (int i = 0; i < courseTable.getRowCount(); i++) {
                    int j = 0;
                    id = Integer.parseInt((String) courseTable.getValueAt(i, j++));

                    courses.add(new Course((String) courseTable.getValueAt(i, j++),
                            (String) courseTable.getValueAt(i, j++),
                            Integer.parseInt((String) courseTable.getValueAt(i, j++)),
                            Integer.parseInt((String) courseTable.getValueAt(i, j++)),
                            Integer.parseInt((String) courseTable.getValueAt(i, j++))));
                    courses.get(i).setId(id);
                }
                for (Course course : courses) {
                    courseTable = crudController.updateTable(course);
                }
            }
        });
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    boolean exist = false;
                    int id = Integer.valueOf(getIdTextField.getText());
                    for (int i = 0; i < courseTable.getRowCount(); i++) {
                        if (id == Integer.parseInt((String) courseTable.getValueAt(i, 0))) {
                            exist = true;
                            break;
                        }
                    }
                    if (exist) {
                        Course course = (Course) crudController.getFromTable(id);
                        JOptionPane.showMessageDialog(componentPanel, course, "Course", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(componentPanel, "Doesn't exists", "Course", JOptionPane.INFORMATION_MESSAGE);
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
                int row = courseTable.getSelectedRow();
                int colomn = 0;
                int id = Integer.parseInt((String) courseTable.getValueAt(row, colomn++));
                Course course = new Course((String) courseTable.getValueAt(row, colomn++),
                        (String) courseTable.getValueAt(row, colomn++),
                        Integer.parseInt((String)courseTable.getValueAt(row, colomn++)),
                        Integer.parseInt((String)courseTable.getValueAt(row, colomn++)),
                        Integer.parseInt((String)courseTable.getValueAt(row, colomn++)));
                course.setId(id);
                crudController.deleteFromTable(course);
                tablePanel.remove(scrollPane);
                courseTable = crudController.createTable();
                scrollPane = new JScrollPane(courseTable);
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
