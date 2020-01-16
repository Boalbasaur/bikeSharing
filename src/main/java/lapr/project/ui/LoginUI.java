/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.LoginController;

/**
 *
 * @author Asus
 */
public class LoginUI {

    private LoginUI() {
        throw new IllegalStateException("Utility class");
    }

    public static String loginUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String password = scanner.next();
        if(LoginController.loginController(username, password)){
            return username;
        }else{
            System.out.println("\nInvalid data!\n");
            return "invalid";
        }
    }
}
