/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Asus
 */
public class Payment {
    private int idPayment; 
    private int idInvoice;
    private String paymentDate; 

    public Payment(int idPayment, int idInvoice, String paymentDate) {
        this.idPayment = idPayment;
        this.idInvoice = idInvoice;
        this.paymentDate = paymentDate;
    }

    /**
     * @return the idPayment
     */
    public int getIdPayment() {
        return idPayment;
    }

    /**
     * @param idPayment the idPayment to set
     */
    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    /**
     * @return the idInvoice
     */
    public int getIdInvoice() {
        return idInvoice;
    }

    /**
     * @param idInvoice the idInvoice to set
     */
    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    /**
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
