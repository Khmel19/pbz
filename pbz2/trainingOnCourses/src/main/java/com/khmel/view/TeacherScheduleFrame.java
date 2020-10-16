package com.khmel.view;

import com.khmel.db.DB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TeacherScheduleFrame extends JFrame {
    private JPanel tablePanel = new JPanel();
    private JPanel componentPanel = new JPanel();

    private JLabel termLabel = new JLabel("TERM : ");
    private JLabel nameLabel = new JLabel("TEACHER : ");
    private JTextField termTextField = new JTextField("");
    private JTextField nameTextField = new JTextField("");

    private JButton getButton = new JButton("Get");
    private JButton backButton = new JButton("Back");

    private JScrollPane scrollPane;
    private Table teacherScheduleTable;

    TeacherScheduleFrame() {
        super("TeacherScheduleFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        tablePanel.setSize(600, 200);
        tablePanel.setLocation(0, 0);
        tablePanel.setLayout(null);

        teacherScheduleTable = new Table();

        scrollPane = new JScrollPane(teacherScheduleTable);
        scrollPane.setVisible(true);
        scrollPane.setLocation(0, 0);
        scrollPane.setSize(585, 200);
        componentPanel.setSize(600, 349);
        componentPanel.setLocation(0, 201);
        componentPanel.setLayout(null);

        componentPanel.add(updateComponent(termLabel, 105, 55, 80, 20));
        componentPanel.add(updateComponent(nameLabel, 290, 55, 80, 20));
        componentPanel.add(updateComponent(termTextField, 195, 55, 80, 20));
        componentPanel.add(updateComponent(nameTextField, 385, 55, 80, 20));
        componentPanel.add(updateComponent(getButton, 205, 85, 170, 40));
        componentPanel.add(updateComponent(backButton, 205, 150, 170, 40));

        add(tablePanel);
        add(componentPanel);

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int term = Integer.parseInt(termTextField.getText());
                if (name.equals("") || term == 0) {
                    JOptionPane.showMessageDialog(componentPanel, "Input value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                String sql = "SELECT teacher.name, course.name, teacher_course.start_date, teacher_course.end_date FROM teacher_course \n" +
                        "JOIN teacher ON teacher.id=teacher_course.id_teacher \n" +
                        "JOIN course ON course.id=teacher_course.id_course\n" +
                        "WHERE teacher.name='" + name + "' AND course.count_of_days=" + term;

                tablePanel.remove(scrollPane);
                try {
                    DB.getConnection();
                    teacherScheduleTable = new Table(DB.query(sql));
                    DB.closeConnectionAndStatement();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
                scrollPane = new JScrollPane(teacherScheduleTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                nameTextField.setText("");
                termTextField.setText("");
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
