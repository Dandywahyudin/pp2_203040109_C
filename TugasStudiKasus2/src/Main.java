/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author teknik_baru
 */

import controller.UserController;
import model.UserDAO;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        // Initialize DAO
        UserDAO userDAO = new UserDAO();
        
        // Initialize View
        UserView userView = new UserView();
        
        // Initialize Controller
        new UserController(userDAO, userView);
    }
}
