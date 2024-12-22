package controller;

import model.User;
import model.UserMapper;
import view.UserView;
import view.UserPdf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getnameInput();
            String email = view.getEmailInput();
            if (!name.isEmpty() && !email.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            String[] userArray = users.stream().map(u -> u.getName() + "(" + u.getEmail() + ")").toArray(String[]::new);
            view.setUserList(userArray);
        }
    }

    class ExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<User> users = mapper.getAllUsers();
                if (users == null || users.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "No users to export.", "Export Failed", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String outputFileName = System.getProperty("user.dir") + "/users_report.pdf";
                pdf.exportPdf(users, outputFileName);

                JOptionPane.showMessageDialog(view, "PDF exported successfully to: " + outputFileName);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Error while exporting PDF: " + ex.getMessage(), "Export Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
