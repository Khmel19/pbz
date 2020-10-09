package com.khmel.view;

import com.khmel.controller.CRUDController;
import com.khmel.dao.CollaboratorDao;
import com.khmel.dao.OrganizationDao;
import com.khmel.model.Organization;
import com.khmel.model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrganizationFrame extends JFrame {
    private CRUDController crudController;

    private JPanel tablePanel = new JPanel();
    private JPanel componentPanel = new JPanel();
    private JScrollPane scrollPane;
    private Table organizationTable;

    private JLabel idCourseLabel = new JLabel("COURSE ID: ");
    private JLabel nameLabel = new JLabel("NAME: ");
    private JLabel addressLabel = new JLabel("ADDRESS: ");
    private JLabel telephoneLabel = new JLabel("TELEPHONE: ");
    private JLabel emailLabel = new JLabel("EMAIL: ");
    private JLabel getIdLabel = new JLabel("ID: ");

    private JTextField idCourseTextField = new JTextField("");
    private JTextField nameTextField = new JTextField("");
    private JTextField addressTextField = new JTextField("");
    private JTextField telephoneTextField = new JTextField("");
    private JTextField emailTextField = new JTextField("");
    private JTextField getIdTextField = new JTextField("");

    private JButton addButton = new JButton("Add");
    private JButton updateButton = new JButton("Update");
    private JButton getButton = new JButton("Get");
    private JButton deleteButton = new JButton("Delete");
    private JButton backButton = new JButton("Back");

    public OrganizationFrame() {
        super("OrganizationFrame");
        crudController = new CRUDController();
        crudController.setDao(new OrganizationDao());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        organizationTable = crudController.createTable();

        scrollPane = new JScrollPane(organizationTable);
        scrollPane.setVisible(true);
        scrollPane.setLocation(0, 0);
        scrollPane.setSize(585, 200);

        tablePanel.setSize(600, 200);
        tablePanel.setLocation(0, 0);
        tablePanel.setLayout(null);
        tablePanel.add(scrollPane);

        componentPanel.setSize(600, 349);
        componentPanel.setLocation(0, 200);
        componentPanel.setLayout(null);

        componentPanel.add(updateComponent(nameLabel, 10, 10, 80, 20));
        componentPanel.add(updateComponent(addressLabel, 10, 60, 80, 20));
        componentPanel.add(updateComponent(telephoneLabel, 10, 110, 100, 20));
        componentPanel.add(updateComponent(emailLabel, 10, 160, 80, 20));
        componentPanel.add(updateComponent(idCourseLabel, 10, 210, 80, 20));
        componentPanel.add(updateComponent(nameTextField, 100, 10, 80, 20));
        componentPanel.add(updateComponent(addressTextField, 100, 60, 80, 20));
        componentPanel.add(updateComponent(telephoneTextField, 100, 110, 80, 20));
        componentPanel.add(updateComponent(emailTextField, 100, 160, 80, 20));
        componentPanel.add(updateComponent(idCourseTextField, 100, 210, 80, 20));
        componentPanel.add(updateComponent(addButton, 10, 260, 170, 40));
        componentPanel.add(updateComponent(updateButton, 190, 260, 170, 40));
        componentPanel.add(updateComponent(getIdLabel, 230, 60, 30, 20));
        componentPanel.add(updateComponent(getIdTextField, 260, 60, 80, 20));
        componentPanel.add(updateComponent(getButton, 230, 90, 110, 40));
        componentPanel.add(updateComponent(deleteButton, 370, 260, 170, 40));
        componentPanel.add(updateComponent(backButton, 370, 200, 170, 40));
//        for (Component component:componentPanel.getComponents()
//             ) {component.setVisible(true);
//
//        }
        add(tablePanel);
        add(componentPanel);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idCourse = Integer.parseInt(idCourseTextField.getText());
                String name = nameTextField.getText();
                String address = addressTextField.getText();
                String telephone = telephoneTextField.getText();
                String email = emailTextField.getText();

                Organization organization = new Organization(idCourse, name, address, telephone, email);

                tablePanel.remove(scrollPane);
                organizationTable = crudController.insertIntoTable(organization);
                scrollPane = new JScrollPane(organizationTable);
                scrollPane.setLocation(0, 0);
                scrollPane.setSize(585, 200);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tablePanel.add(scrollPane);
                idCourseTextField.setText("");
                nameTextField.setText("");
                addressTextField.setText("");
                telephoneTextField.setText("");
                emailTextField.setText("");
                tablePanel.updateUI();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                List<Organization> organizations = new ArrayList();
                organizationTable.repaint();
                for (int i = 0; i < organizationTable.getRowCount(); i++) {
                    int j = 0;
                    id = Integer.parseInt((String) organizationTable.getValueAt(i, j++));

                    organizations.add(new Organization(Integer.parseInt((String) organizationTable.getValueAt(i, j++)),
                            (String) organizationTable.getValueAt(i, j++),
                            (String) organizationTable.getValueAt(i, j++),
                            (String) organizationTable.getValueAt(i, j++),
                            (String) organizationTable.getValueAt(i, j++)));
                    organizations.get(i).setId(id);
                }
                for (Organization organization : organizations) {
                    organizationTable = crudController.updateTable(organization);
                }
            }
        });
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean exist = false;
                    int id = Integer.valueOf(getIdTextField.getText());
                    for (int i = 0; i < organizationTable.getRowCount(); i++) {
                        if (id == Integer.parseInt((String) organizationTable.getValueAt(i, 0))) {
                            exist = true;
                            break;
                        }
                    }
                    if (exist) {
                        Organization organization = (Organization) crudController.getFromTable(id);
                        JOptionPane.showMessageDialog(componentPanel, organization, "Organization", JOptionPane.INFORMATION_MESSAGE);
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
                int row = organizationTable.getSelectedRow();
                int colomn = 0;
                int id = Integer.parseInt((String) organizationTable.getValueAt(row, colomn++));
                Organization organization = new Organization(Integer.parseInt((String) organizationTable.getValueAt(row, colomn++)),
                        (String) organizationTable.getValueAt(row, colomn++),
                        (String) organizationTable.getValueAt(row, colomn++),
                        (String) organizationTable.getValueAt(row, colomn++),
                        (String) organizationTable.getValueAt(row, colomn++));
                organization.setId(id);
                crudController.deleteFromTable(organization);
                tablePanel.remove(scrollPane);
                organizationTable = crudController.createTable();
                scrollPane = new JScrollPane(organizationTable);
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
