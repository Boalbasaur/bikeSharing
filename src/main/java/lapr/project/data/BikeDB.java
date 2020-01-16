package lapr.project.data;

import lapr.project.model.Bike;
import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BikeDB extends DataHandler {

    public void saveBike(Bike bike) {

        try {
            getBike(bike.getIdBike());
        } catch (IllegalArgumentException e) {
            //Of the record does not exist, save it
            new BikeDB().addBike(bike);
        }
    }

    public void deleteBike(Bike bike) {
        removeBike(bike.getIdBike());
    }

    public Bike getBike(String idBike) {

        /* Objeto "callStmt" para invocar a função "getBike" armazenada na BD.
         *
         * FUNCTION getBike(id NUMBER) RETURN pkgBikes.ref_cursor
         * PACKAGE pkgBikes AS TYPE ref_cursor IS REF CURSOR; END pkgBikes;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getBike(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getBike".
            callStmt.setString(2, idBike);

            // Executa a invocação da função "getBike".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                String idbike = rSet.getString(1);
                String idtype = rSet.getString(2);
                int availability = rSet.getInt(3);
                String battery = rSet.getString(4);
                String maxCapacity = rSet.getString(5);
                int weight = rSet.getInt(6);
                double mechanicalCoefficient = rSet.getDouble(7);
                double aerodynamicCoefficient = rSet.getDouble(8);
                float parkLongitude = rSet.getFloat(9);
                float parkLatitude = rSet.getFloat(10);
                double area = rSet.getDouble(11);
                if ("eletric".equalsIgnoreCase(idtype)) {
                    return new Bike(idbike, idtype, availability, battery, maxCapacity, weight, mechanicalCoefficient, aerodynamicCoefficient, parkLongitude, parkLatitude,area);
                } else {
                    return new Bike(idbike, idtype, availability, weight, mechanicalCoefficient, aerodynamicCoefficient, parkLongitude, parkLatitude,area);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Bike with ID:" + idBike);
    }

    public void addBike(Bike bike) {
        addBike(bike.getIdBike(), bike.getIdType(), bike.getAvailability(), bike.getBattery(), bike.getMaxCapacity(), bike.getWeight(), bike.getMechanicalCoefficient(), bike.getAerodynamicCoefficient(), bike.getParkLongitude(), bike.getParkLatitude(), bike.getArea());
    }

    /**
     * Exemplo de invocação de uma "stored procedure".
     * <p>
     * Adiciona o marinheiro especificado à tabela "Sailors".
     *
     * @param sid o identificador do marinheiro.
     * @param sname o nome do marinheiro.
     * @param rating o "rating" do marinheiro.
     * @param age a idade do marinheiro.
     */
    private void addBike(String description, String idType, int availability, String battery, String maxCapacity, 
            int weight, double mechanicalCoefficient,
            double aerodynamicCoefficient,
            float parkLongitude,
            float parkLatitude, double area) {

        try {
            openConnection();
            /*
             *  Objeto "callStmt" para invocar o procedimento "addSailor" armazenado
             *  na BD.
             *
             *  PROCEDURE addSailor(sid NUMBER, sname VARCHAR, rating NUMBER, age NUMBER)
             *  PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
             */
            CallableStatement callStmt = getConnection().prepareCall("{ call addBike(?,?,?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, description);
            callStmt.setString(2, idType);
            callStmt.setInt(3, 1);
            callStmt.setString(4, battery);
            callStmt.setString(5, maxCapacity);
            callStmt.setInt(6, weight);
            callStmt.setDouble(7, mechanicalCoefficient);
            callStmt.setDouble(8, aerodynamicCoefficient);
            callStmt.setFloat(9, parkLongitude);
            callStmt.setFloat(10, parkLatitude);
            callStmt.setDouble(11, area);
            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exemplo de invocação de uma "stored procedure".
     * <p>
     * Remove o marinheiro especificado da tabela "Sailors".
     *
     * @param sid o identificador do marinheiro a remover.
     */
    public void removeBike(String idBike) {

        try {
            openConnection();
            /*
             *  Objeto "callStmt" para invocar o procedimento "removeSailor"
             *  armazenado na BD.
             *
             *  PROCEDURE removeSailor(sid NUMBER)
             *  PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
             */
            CallableStatement callStmt = getConnection().prepareCall("{ call removeBike(?) }");

            callStmt.setString(1, idBike);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
