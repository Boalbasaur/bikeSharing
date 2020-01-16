/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.HashSet;
import java.util.Scanner;
import lapr.project.adjacencyMap.Graph;
import lapr.project.controller.SuggestedRoutesController;
import lapr.project.model.PathInfo;

/**
 *
 * @author Asus
 */
public final class SuggestedRoutesUI {

    private SuggestedRoutesUI() {
         throw new IllegalStateException("Utility class");
    }

    public static void suggestedRoutes(String bikeType, int idOrigin, int idDestination, Graph<String, PathInfo> grafo) {
        Scanner in = new Scanner(System.in);
        System.out.printf("\nDo you want a route suggestion(yes/no): ");
        String option = in.nextLine();
        if ("yes".equalsIgnoreCase(option)) {

            int op = menuUser(bikeType);
            if (idDestination == 0) {
                System.out.printf("\nID of Destination: ");
                idDestination = in.nextInt();
            }
            switch (op) {
                case 1:
                    String result1 = SuggestedRoutesController.getRouteShortestDistance(idOrigin, idDestination, grafo);
                    if (result1 != null) {
                        System.out.printf("\n" + result1 + "\n");
                    }
                    break;
                case 2:
                    String result2 =processCase( true, idOrigin, idDestination, grafo);
                    if (result2 != null) {
                        System.out.printf("\n" + result2 + "\n");
                    }
                    break;
                case 3:
                    String result3 =processCase( false, idOrigin, idDestination, grafo);
                    if (result3 != null) {
                        System.out.printf("\n" + result3 + "\n");
                    }
                    break;
                default:
                    System.out.println("\nInvalid option");
            }
        }
    }

    private static int menuUser(String bikeType) {
        Scanner in = new Scanner(System.in);
        if (("eletric").equals(bikeType)) {
            System.out.printf("\nMenu \n(1) Shortest Path \n(2) Shortest Path with Tourist Points \n(3) Best Energy Efficiente Path with Tourist Points \nChoose your option: ");
        } else {
            System.out.printf("\nMenu \n(1) Shortest Path \n(2) Shortest Path with Tourist Points \nChoose your option: ");
        }
        return in.nextInt();
    }

    private static String processCase(Boolean switchCase, int idOrigin, int idDestination, Graph<String, PathInfo> grafo) {
        Scanner in = new Scanner(System.in);
        HashSet<String> lista = new HashSet<>();
        int aux = 99999;
        System.out.printf("\nWrite the ID's of the Tourist Points (0 to stop) ");
        while (aux != 0) {
            System.out.printf("\nNext ID: ");
            aux = in.nextInt();
            if (aux != 0) {
                lista.add("TouristPoint_" + aux);
            }
        }
        int numSuggestions = numberSuggestions();
        boolean inverse=isInverse();
        return SuggestedRoutesController.getRouteShortestWithTP(grafo, idOrigin, idDestination, lista, switchCase, numSuggestions, inverse);
    }
    
    private static int numberSuggestions() {
        Scanner in = new Scanner(System.in);
        int num = 0;
        while (num < 1) {
            System.out.printf("\nHow many suggestions do you want: ");
            num = in.nextInt();
            if (num < 1) {
                System.out.printf("\nInvalid Option!");
            }
        }
        return num;
    }

    private static boolean isInverse() {
        Scanner in = new Scanner(System.in);
        boolean inverse = false;
        String aux = "";
        while (!"ascending".equalsIgnoreCase(aux) && !"descending".equalsIgnoreCase(aux)) {
            System.out.printf("\nDo you want ascending or descending  order (write 'ascending' or 'descending'): ");
            aux = in.nextLine();
            if("descending".equalsIgnoreCase(aux)){
                inverse=true;
            }
            if (!"ascending".equalsIgnoreCase(aux) && !"descending".equalsIgnoreCase(aux)) {
                System.out.printf("\nInvalid Option!");
            }
        }
        return inverse;
    }
}
