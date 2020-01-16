/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;


import java.util.List;
import java.util.Scanner;
import lapr.project.controller.NearestParksController;
import lapr.project.model.Park;
/**
 *
 * @author Diogo Rolo
 */
public class NearestParksUI {

    private NearestParksUI() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void nearestParkUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Coordenadas Atuais:\n");
        System.out.println("Qual a sua altitude?");
        float alt = input.nextFloat();
        System.out.println("Qual a sua longitude??");
        float lon = input.nextFloat();
        System.out.println("Qual a sua latitude??");
        float lat = input.nextFloat();
        List<Park> p = NearestParksController.nearesParkController(alt, lon, lat);
        System.out.println("Parques mais proximos:\n");
        for(int i=0;i<p.size();i++){
            System.out.println(p.get(i).getName());
        }
    }
}
