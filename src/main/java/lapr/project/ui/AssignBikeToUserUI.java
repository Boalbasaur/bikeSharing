/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.adjacencyMap.Graph;
import static lapr.project.controller.AssignBikeToUserController.assignBikeToUserController;
import lapr.project.model.PathInfo;

/**
 *
 * @author Fabio Santos
 */
public class AssignBikeToUserUI {

    private AssignBikeToUserUI() {
        throw new IllegalStateException("Utility class");
    }

    public static void AssignBikeToUserUI(Graph<String, PathInfo> grafo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID Park:");
        int idPark = sc.nextInt();
        System.out.println("idType:");
        String idType = sc.nextLine();
        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Data Inicio");
        String dataInicio = sc.nextLine();
        System.out.println("Parque Destination(0 if dont have a destination)");
        int destination = sc.nextInt();
        System.out.println("Price:");
        float price = sc.nextFloat();

        boolean assign = assignBikeToUserController(idPark, idType, username, dataInicio, idPark, destination);
        if (assign == false) {
            System.out.println("Didnt assign any bike");
        }else{
        SuggestedRoutesUI.suggestedRoutes(idType, idPark, destination, grafo);
        }
    }
}
