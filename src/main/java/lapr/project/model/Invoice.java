/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Diogo Rolo
 */
public class Invoice {
    
    private final float pointsValue = 0.10f;
    private final float IVA = 0.23f;
    private String username;
    private String dateMonthYear; //1_18 primeiro mes de 2018
    private String emmissionDate;
    private float total;

    public Invoice( String username, String dateMonthYear, String emmissionDate, float total) {
        this.username = username;
        this.dateMonthYear = dateMonthYear;
        this.emmissionDate = emmissionDate;
        this.total = total;
    }


    public String getUsername() {
        return username;
    }

    public String getDateMonthYear() {
        return dateMonthYear;
    }

    public String getEmmissionDate() {
        return emmissionDate;
    }

    public float getTotal() {
        return total;
    }

    public float getIVA() {
        return IVA;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setDateMonthYear(String dateMonthYear) {
        this.dateMonthYear = dateMonthYear;
    }

    public void setEmmissionDate(String emmissionDate) {
        this.emmissionDate = emmissionDate;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public float precoFinalComPontoseIva(int pointsUser){
        // fazer aqui novo uc
        float descountPrice = pointsUser * pointsValue;
        total = total - descountPrice;
        return (IVA * total) + total;
    }
    
    public int totalPontosPodemSerUtilizados(int nPoints){
        int pontosRestantes = 0;
        int totalSdecimal = (int) total;
        if(totalSdecimal <= (nPoints/10)){
            pontosRestantes = nPoints - totalSdecimal * 10;
        }
        return pontosRestantes;
    }

    @Override
    public String toString() {
        return "Invoice:\n"
                + "\n"
                + "" + "IVA = " + IVA+"\n" 
                + "Username = " + username+"\n" 
                + "Mes_Ano = " + dateMonthYear+"\n"  
                + "Emmission Date = " + emmissionDate+"\n"  
                + "total a pagar = " + total+"euros";
    }
   
    
}
