/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.User;

/**
 *
 * @author Asus
 */
public final class LoginController {

    private LoginController() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean loginController(String username, String password) {
        return User.login(username, password);
    }
}
