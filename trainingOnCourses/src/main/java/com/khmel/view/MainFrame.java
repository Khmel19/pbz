package com.khmel.view;

import javax.swing.*;

public class MainFrame extends JFrame {
    private Table teacherTable;
    public MainFrame(){
        super("MainFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 385);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        add(teacherTable);
    }
}
