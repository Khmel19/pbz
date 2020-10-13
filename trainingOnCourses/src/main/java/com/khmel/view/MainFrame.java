package com.khmel.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton teacherButton = new JButton("Teachers");
    private JButton courseButton = new JButton("Courses");
    private JButton organizationButton = new JButton("Organizations");
    private JButton bidButton = new JButton("Bids");
    private JButton priceListButton = new JButton("PriceList");
    private JButton teacherScheduleButton= new JButton("TeacherSchedule");
    private JButton courseFillingButton= new JButton("CourseFilling");
    private JPanel buttonPanel = new JPanel();

    public MainFrame() throws HeadlessException {
        super("MainFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        buttonPanel.setLayout(null);
        buttonPanel.setLocation(0, 0);
        buttonPanel.setSize(600, 550);
        buttonPanel.add(updateComponent(teacherButton,10,100,120,50));
        buttonPanel.add(updateComponent(courseButton,290,100,120,50));
        buttonPanel.add(updateComponent(organizationButton,140,100,140,50));
        buttonPanel.add(updateComponent(bidButton,420,100,120,50));
        buttonPanel.add(updateComponent(priceListButton,10,160,120,50));
        buttonPanel.add(updateComponent(teacherScheduleButton,140,160,140,50));
        buttonPanel.add(updateComponent(courseFillingButton,290,160,120,50));


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
        organizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new OrganizationFrame();
            }
        });
        bidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BidFrame();
            }
        });
        priceListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                new PriceListFrame();
            }
        });
        teacherScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TeacherScheduleFrame();
            }
        });
        courseFillingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CourseFillingFrame();
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
