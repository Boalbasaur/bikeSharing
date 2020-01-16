/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Fabio Santos
 */
public class Request {
    private int idRequest;
    private int idPark;
    private String username;
    private String dateRequest;

    public Request(int idRequest, int idPark, String username, String dateRequest) {
        this.idRequest = idRequest;
        this.idPark = idPark;
        this.username = username;
        this.dateRequest = dateRequest;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getIdPark() {
        return idPark;
    }

    public void setIdPark(int idPark) {
        this.idPark = idPark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(String dateRequest) {
        this.dateRequest = dateRequest;
    }
    
    
}
