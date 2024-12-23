/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.User;
import model.UserDAO;
import view.UserView;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author teknik_baru
 */
public class UserController {
    private final UserDAO userDAO;
    private final UserView userView;

    public UserController(UserDAO userDAO, UserView userView) {
        this.userDAO = userDAO;
        this.userView = userView;
        setupListeners();
        loadTableData();
    }

    private void setupListeners() {
        userView.getAddButton().addActionListener(e -> addData());
        userView.getUpdateButton().addActionListener(e -> updateData());
        userView.getDeleteButton().addActionListener(e -> deleteData());
    }

    private void loadTableData() {
        List<User> users = userDAO.getAllUsers();
        userView.populateTable(users);
    }

    private void addData() {
        User user = userView.getUserFromForm();
        if (userDAO.addUser(user)) {
            JOptionPane.showMessageDialog(userView, "Data added successfully!");
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(userView, "Failed to add data.");
        }
    }

    private void updateData() {
        int selectedRow = userView.getSelectedTableRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(userView, "Please select a row to update.");
            return;
        }

        User user = userView.getUserFromForm();
        user.setId(userView.getUserIdFromSelectedRow());

        if (userDAO.updateUser(user)) {
            JOptionPane.showMessageDialog(userView, "Data updated successfully!");
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(userView, "Failed to update data.");
        }
    }

    private void deleteData() {
        int selectedRow = userView.getSelectedTableRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(userView, "Please select a row to delete.");
            return;
        }

        int userId = userView.getUserIdFromSelectedRow();

        if (userDAO.deleteUser(userId)) {
            JOptionPane.showMessageDialog(userView, "Data deleted successfully!");
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(userView, "Failed to delete data.");
        }
    }
}