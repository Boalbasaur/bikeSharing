/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.BlockBikeController;
import lapr.project.model.Trip;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class BlockBikeUI {
    
    private BlockBikeController controller;
    private Trip t;

    public BlockBikeUI() {
        controller = new BlockBikeController();
    }

    public boolean blockBike(String username) {
        Scanner scanner = new Scanner(System.in);
        String confirm = "";
        while (!confirm.equals("S")) {
            if(confirm.equals("N")){
                return false;
            }
            System.out.println("Do you wish to block your bike in the current park? (S or N)");
            confirm = scanner.next();
        }
        this.t = controller.getTripNotBlocked(username);
        if(this.t == null){
            System.out.println("You don't have any active bike right now.");
            return false;
        }
        //controller.lockBike(this.t); //parâmetros!!!
        controller.sendEmail(this.t);
        return true;
    }
}
