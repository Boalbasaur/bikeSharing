/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.UserRegistrationController;

/**
 *
 * @author Daniela Vinagreiro
 */
public class UserRegistrationUI {

    private UserRegistrationUI() {
        throw new IllegalStateException("Utility class");
    }

    public static void userRegistrationUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type:");
        String type = sc.nextLine();
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        System.out.println("Credit card number:");
        String creditCardNumber = sc.nextLine();
        System.out.println("Heigth:");
        double height = sc.nextDouble();
        System.out.println("Weight:");
        double weight = sc.nextDouble();
        System.out.println("Average Speed:");
        double avgSpeed = sc.nextDouble();
        
        UserRegistrationController.setData(name, username, email, password, creditCardNumber, height, weight,avgSpeed);
    }

}
