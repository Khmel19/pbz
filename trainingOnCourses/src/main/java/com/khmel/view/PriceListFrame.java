package com.khmel.view;

import com.khmel.db.DB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PriceListFrame extends JFrame {
    private JPanel tablePanel = new JPanel();
    private JPanel componentPanel = new JPanel();

    private JLabel dateLabel = new JLabel("DATE : ");
    private JTextField dateTextField = new JTextField("");

    private JButton getButton = new JButton("Get");
    private JButton backButton = new JButton("Back");

    private JScrollPane scrollPane;
    private Table priceListTable;

    public PriceListFrame() {
        super("PriceListFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        tablePanel.setSize(600, 200);
        tablePanel.setLocation(0, 0);
        tablePanel.setLayout(null);

        priceListTable = new Table();

        scrollPane = new JScrollPane(priceListTable);
        scrollPane.setVisible(true);
        scrollPane.setLocation(0, 0);
        scrollPane.setSize(585, 200);
        componentPanel.setSize(600, 349);
        componentPanel.setLocation(0, 201);
        componentPanel.setLayout(null);

        componentPanel.add(updateComponent(dateLabel, 205, 55, 80, 20));
        componentPanel.add(updateComponent(dateTextField, 295, 55, 80, 20));
        componentPanel.add(updateComponent(getButton, 205, 85, 170, 40));
        componentPanel.add(updateComponent(backButton, 205, 150, 170, 40));

        add(tablePanel);
        add(componentPanel);
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String date = dateTextField.getText();
                if (date.equals("")) {
                    JOptionPane.showMessageDialog(componentPanel, "Input value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                String sql = "SELECT course.name, course.count_of_days, price.price, price.price*1.2 as price_nds " +
                        "FROM price JOIN course ON course.id_price = price.id WHERE " +
                        "price.date = '" + date+"'";
                tablePanel.remove(scrollPane);
                try {
                    DB.getConnection();
                    priceListTable = new Table(DB.query(sql));
                    DB.closeConnectionAndStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                scrollPane = new JScrollPane(priceListTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                dateTextField.setText("");
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
