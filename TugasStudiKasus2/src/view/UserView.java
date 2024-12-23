/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author teknik_baru
 */
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserView extends JFrame {
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JTextField txtName, txtEmail, txtAddress, txtAge, txtPhone;
    private final JButton btnAdd, btnUpdate, btnDelete;

    public UserView() {
        setTitle("User Management");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Email", "Address", "Age", "Phone"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtAddress = new JTextField();
        txtAge = new JTextField();
        txtPhone = new JTextField();

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(txtEmail);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(txtAddress);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(txtAge);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(txtPhone);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(900, 600);
        setVisible(true);
    }

    public void populateTable(List<User> users) {
        tableModel.setRowCount(0);
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getId(), user.getName(), user.getEmail(), user.getAddress(), user.getAge(), user.getPhone()});
        }
    }

    public User getUserFromForm() {
        return new User(
                txtName.getText(),
                txtEmail.getText(),
                txtAddress.getText(),
                Integer.parseInt(txtAge.getText()),
                txtPhone.getText()
        );
    }

    public int getSelectedTableRow() {
        return table.getSelectedRow();
    }

    public int getUserIdFromSelectedRow() {
        return (int) tableModel.getValueAt(getSelectedTableRow(), 0);
    }

    public JButton getAddButton() {
        return btnAdd;
    }

    public JButton getUpdateButton() {
        return btnUpdate;
    }

    public JButton getDeleteButton() {
        return btnDelete;
    }
}