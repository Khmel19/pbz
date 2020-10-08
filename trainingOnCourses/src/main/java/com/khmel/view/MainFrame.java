package com.khmel.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton teacherButton = new JButton("Teachers");
    private JButton courseButton = new JButton("Courses");
    private JPanel buttonPanel = new JPanel();

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        buttonPanel.setLayout(null);
        buttonPanel.setLocation(0, 0);
        buttonPanel.setSize(600, 550);
        buttonPanel.add(updateComponent(teacherButton,10,100,100,50));
        buttonPanel.add(updateComponent(courseButton,120,100,100,50));
        //setSize(601,551);
        add(buttonPanel);
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               dispose();
                new TeacherFrame();
            }
        });
        courseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                new CourseFrame();
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
