package com.khmel.view;

import com.khmel.controller.CRUDController;
import com.khmel.dao.BidDao;
import com.khmel.model.Bid;
import com.khmel.model.Organization;
import com.khmel.model.Teacher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BidFrame extends JFrame {
    private CRUDController crudController;

    private JPanel tablePanel = new JPanel();
    private JPanel componentPanel = new JPanel();
    private JScrollPane scrollPane;
    private Table bidTable;

    private JLabel idCompanyLabel = new JLabel("COMPANY ID: ");
    private JLabel idCourseLabel = new JLabel("COURSE ID: ");
    private JLabel termLabel = new JLabel("TERM: ");
    private JLabel countOfTraineesLabel = new JLabel("COUNT OF TRAINEES: ");
    private JLabel getIdLabel = new JLabel("ID: ");

    private JTextField idCompanyTextField = new JTextField("");
    private JTextField idCourseTextField = new JTextField("");
    private JTextField termTextField = new JTextField("");
    private JTextField countOfTraineesTextField = new JTextField("");
    private JTextField getIdTextField = new JTextField("");

    private JButton addButton = new JButton("Add");
    private JButton updateButton = new JButton("Update");
    private JButton getButton = new JButton("Get");
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");

    public BidFrame() {
        super("BidFrame");
        crudController = new CRUDController();
        crudController.setDao(new BidDao());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        bidTable = crudController.createTable();

        scrollPane = new JScrollPane(bidTable);
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

        componentPanel.add(updateComponent(idCompanyLabel, 10, 10, 90, 20));
        componentPanel.add(updateComponent(idCourseLabel, 10, 60, 80, 20));
        componentPanel.add(updateComponent(termLabel, 10, 110, 80, 20));
        componentPanel.add(updateComponent(countOfTraineesLabel, 10, 160, 140, 20));
        componentPanel.add(updateComponent(idCompanyTextField, 150, 10, 80, 20));
        componentPanel.add(updateComponent(idCourseTextField, 150, 60, 80, 20));
        componentPanel.add(updateComponent(termTextField, 150, 110, 80, 20));
        componentPanel.add(updateComponent(countOfTraineesTextField, 150, 160, 80, 20));
        componentPanel.add(updateComponent(addButton, 10, 260, 170, 40));
        componentPanel.add(updateComponent(updateButton, 190, 260, 170, 40));
        componentPanel.add(updateComponent(getIdLabel, 370, 60, 30, 20));
        componentPanel.add(updateComponent(getIdTextField, 400, 60, 80, 20));
        componentPanel.add(updateComponent(getButton, 370, 90, 110, 40));
        componentPanel.add(updateComponent(deleteButton, 370, 260, 170, 40));
        componentPanel.add(updateComponent(backButton, 370, 200, 170, 40));
        add(tablePanel);
        add(componentPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCompany = Integer.parseInt(idCompanyTextField.getText());
                int idCourse = Integer.parseInt(idCourseTextField.getText());
                int term = Integer.parseInt(termTextField.getText());
                int countOfTrainees = Integer.parseInt(countOfTraineesTextField.getText());

                Bid bid = new Bid(idCompany, idCourse, term, countOfTrainees);

                tablePanel.remove(scrollPane);
                bidTable = crudController.insertIntoTable(bid);
                scrollPane = new JScrollPane(bidTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                idCompanyTextField.setText("");
                idCourseTextField.setText("");
                termTextField.setText("");
                countOfTraineesTextField.setText("");
                tablePanel.updateUI();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                List<Bid> bidList = new ArrayList();
                bidTable.repaint();
                for (int i = 0; i < bidTable.getRowCount(); i++) {
                    int j = 0;
                    id = Integer.parseInt((String) bidTable.getValueAt(i, j++));

                    bidList.add(new Bid(Integer.parseInt((String) bidTable.getValueAt(i, j++)),
                            Integer.parseInt((String) bidTable.getValueAt(i, j++)),
                            Integer.parseInt((String) bidTable.getValueAt(i, j++)),
                            Integer.parseInt((String) bidTable.getValueAt(i, j++))
                    ));
                    bidList.get(i).setId(id);
                }
                for (Bid bid : bidList) {
                    bidTable = crudController.updateTable(bid);
                }
            }
        });

        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean exist = false;
                    int id = Integer.valueOf(getIdTextField.getText());
                    for (int i = 0; i < bidTable.getRowCount(); i++) {
                        if (id == Integer.parseInt((String) bidTable.getValueAt(i, 0))) {
                            exist = true;
                            break;
                        }
                    }
                    if (exist) {
                        Bid bid = (Bid) crudController.getFromTable(id);
                        JOptionPane.showMessageDialog(componentPanel, bid, "Organization", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(componentPanel, "Doesn't exists", "Organization", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(componentPanel, "Bad value", "Error", JOptionPane.ERROR_MESSAGE);
                }
                getIdTextField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = bidTable.getSelectedRow();
                int colomn = 0;
                int id = Integer.parseInt((String) bidTable.getValueAt(row, colomn++));
                Bid bid = new Bid(Integer.parseInt((String) bidTable.getValueAt(row, colomn++)),
                        Integer.parseInt((String) bidTable.getValueAt(row, colomn++)),
                        Integer.parseInt((String) bidTable.getValueAt(row, colomn++)),
                        Integer.parseInt((String) bidTable.getValueAt(row, colomn++))
                        );
                bid.setId(id);
                crudController.deleteFromTable(bid);
                tablePanel.remove(scrollPane);
                bidTable = crudController.createTable();
                scrollPane = new JScrollPane(bidTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                tablePanel.add(scrollPane);
                tablePanel.updateUI();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
