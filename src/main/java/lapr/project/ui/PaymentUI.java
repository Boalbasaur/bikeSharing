/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import java.util.Scanner;
import lapr.project.controller.PaymentController;
import lapr.project.model.Invoice;
import lapr.project.model.MonthlyTrips;
import lapr.project.model.Receipt;

/**
 *
 * @author Diogo Rolo
 */
public class PaymentUI {

    private PaymentUI() {
        throw new IllegalStateException("Utility class");
    }

    private PaymentController controller;

    public static void paymentUI(String username) {
        String frase1 = "Awnser format 'Y' ou 'N'";
        String frase2 = "Do you want to confirm your payments of ";
        String frase3 = "Pagamento accepted!";
        String frase4 = "Payment canceled!";
        String frase5 = "euros regarding the Month/Year ";
        Scanner input = new Scanner(System.in);
        List<MonthlyTrips> mtList = PaymentController.getListMonthlyTrips(username);
        if (!mtList.isEmpty()) {
            System.out.println("list of payments to be made:\n");
            for (MonthlyTrips mts : mtList) {
                System.out.println(PaymentController.getDateMonthYearMT(mts) + "\n");
            }
            String date;
            int check;
            do {
                System.out.println("choose the desired month: (format month_year)");
                date = input.nextLine();
                check = PaymentController.verificarSeExisteNaLista(mtList, date);
            } while (check == 0);
            //0 se não encontrar
            System.out.println("");
            MonthlyTrips mt = PaymentController.getMonthlyTrips(username, date);
            Invoice inv = PaymentController.returnInvoice(username, mt, mt.getTotalPrice());
            System.out.println(PaymentController.getInvoiceString(inv));
            String resposta;
            int nPoints = PaymentController.getUserPoints(username);
            int nPontosRestantes = PaymentController.totalPontosPodemSerUtilizados(inv, nPoints);
            int nPontosUtilizaveis = PaymentController.nPontosUtilizados(nPoints, nPontosRestantes);
            /*
            nPoints = 0 significa que o utilizador não tem pontos
            nPontosRestantes = 0 significa que o utilizador não tem pontos suficientes para utilizar num desconto
             */
            if (nPoints == 0 || nPontosRestantes == 0) {
                String resposta0;
                do {
                    System.out.println(frase2 + PaymentController.precoFinalComPontoseIva(inv, 0) + frase5 + PaymentController.getDateMonthYear(inv) +"? "+ frase1);
                    resposta0 = input.nextLine();
                } while (!"Y".equals(resposta0) && !"N".equals(resposta0));
                if ("Y".equals(resposta0)) {
                    Receipt re = PaymentController.returnReceipt(username, mt, inv, 0);
                    System.out.println(PaymentController.getReceiptString(re));
                    PaymentController.removeMothlyTrip(PaymentController.getIdMonthlyTrip(mt));
                    System.out.println(frase3);
                } else {
                    System.out.println(frase4);
                }
            } else {
                do {
                    System.out.println("Do you want to use your accumulated points? you have " + nPoints + "points. "+ frase1);
                    resposta = input.nextLine();
                } while (!"Y".equals(resposta) && !"N".equals(resposta));
                if ("Y".equals(resposta)) {
                    String resposta1;
                    do {
                        System.out.println(frase2 + PaymentController.precoFinalComPontoseIva(inv, nPontosUtilizaveis) + frase5 + PaymentController.getDateMonthYear(inv) + "? "+frase1);
                        resposta1 = input.nextLine();
                    } while (!"Y".equals(resposta1) && !"N".equals(resposta1));
                    if ("Y".equals(resposta1)) {
                        // Não remove totalmente userpoints
                        PaymentController.updateUserPoints(username, nPontosRestantes);
                        Receipt re = PaymentController.returnReceipt(username, mt, inv, nPontosUtilizaveis);
                        System.out.println(PaymentController.getReceiptString(re));
                        PaymentController.removeMothlyTrip(PaymentController.getIdMonthlyTrip(mt));
                        System.out.println(frase3);
                    } else {
                        System.out.println(frase4);
                    }
                } else if ("N".equals(resposta)) {
                    String resposta2;
                    do {
                        System.out.println(frase2 + PaymentController.precoFinalComPontoseIva(inv, 0) + frase5 + PaymentController.getDateMonthYear(inv) + "? "+frase1);
                        resposta2 = input.nextLine();
                    } while (!"Y".equals(resposta2) && !"N".equals(resposta2));
                    if ("Y".equals(resposta2)) {
                        Receipt re = PaymentController.returnReceipt(username, mt, inv, 0);
                        System.out.println(PaymentController.getReceiptString(re));
                        PaymentController.removeMothlyTrip(PaymentController.getIdMonthlyTrip(mt));
                        System.out.println(frase3);
                    } else {
                        System.out.println(frase4);
                    }
                }
            }
        } else {
            System.out.println("There are no payments in delay!");
        }
    }
}
