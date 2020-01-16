/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Park;

/**
 *
 * @author Diogo Rolo
 */
public class GetParksDB extends DataHandler {

    /**
     *
     * @return
     */
    public List<Park> getParks() {
        /**
         * arraylist com os registos dos parques
         */
        List<Park> rp = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin://@vsrvbd1.dei.isep.ipp.pt:1521/pdborcl", "LAPR3_G25", "sala207");
            if(!con.isClosed()){
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from park");
            Park parque;
            while (rs.next()) {
                int num = rs.getInt(1);
                String nome = rs.getString(2);
                float lat = rs.getFloat(3);
                float lon = rs.getFloat(4);
                int capacityNonEletric = rs.getInt(5);
                int capacityEletric =  rs.getInt(6);
                float alt = rs.getFloat(7);
                double vol = rs.getDouble(8);
                double cur = rs.getDouble(9);
                parque = new Park(num, nome, lat, lon, capacityNonEletric, capacityEletric, alt, vol, cur);
                rp.add(parque);
            }
            con.close();
            return rp;
            }
        } catch (SQLException e) {
            System.out.println("Erro");
        }
         throw new IllegalArgumentException("No Parks");
    }

}
