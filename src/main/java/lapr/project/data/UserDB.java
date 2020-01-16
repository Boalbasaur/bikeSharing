package lapr.project.data;

import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lapr.project.model.User;

public class UserDB extends DataHandler {

    /**
     * @param username
     * @return 
     */
    public User getUser(String username) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getUser(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, username);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                String name = rSet.getString(2);
                String email = rSet.getString(4);
                String password = rSet.getString(3);
                String creditCardNumber = rSet.getString(5);
                double height = rSet.getDouble(6);
                double weight = rSet.getDouble(7);
                String type = rSet.getString(8);
                int points = rSet.getInt(9);
                double avgSpeed = rSet.getDouble(10);

                return new User(name, username, email, password, creditCardNumber, height, weight, type, points,avgSpeed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No User with username:" + username);
    }

    public static void save(User user) {

        try {
            new UserDB().getUser(user.getUsername());
        } catch (IllegalArgumentException ex) {
            //Of the record does not exist, save it
            new UserDB().addUser(user);
        }
    }

    public void addUser(User user) {
        addUser(user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), user.getCreditCardNumber(), user.getHeight(), user.getWeight(), user.getAvgSpeed());
    }

    /**
     *
     * @param uusername
     * @param uname
     * @param ubirthDate
     * @param uemail
     * @param upassword
     * @param ucreditCardNumber
     * @param uheight
     * @param uweight
     * @param utype
     */
    private void addUser(String uusername, String uname, String uemail, String upassword, 
            String ucreditCardNumber, double uheight, double uweight, double avgSpeed) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call addUser(?,?,?,?,?,?,?,?,?) }");

            callStmt.setString(1, uusername);
            callStmt.setString(2, uname);
            callStmt.setString(3, upassword);
            callStmt.setString(4, uemail);
            callStmt.setString(5, ucreditCardNumber);
            callStmt.setDouble(6, uheight);
            callStmt.setDouble(7, uweight);
            callStmt.setInt(8, 1);
            callStmt.setDouble(9, avgSpeed);
            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String username) {
        new UserDB().removeUser(username);
    }

    /**
     * Remove o user especificado da tabela "User".
     *
     * @param uusername
     */
    public void removeUser(String uusername) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call removeUser(?) }");

            callStmt.setString(1, uusername);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param username
     * @return
     */
    public String getBikeType(String username) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getBikeType(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, username);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Trip with such username:" + username);
    }

    public void addUserPoints(String username, int points) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call addUserPoints(?,?) }");

            callStmt.setString(1, username);
            callStmt.setInt(2, points);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setUserPointsZero(String username, int points) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call SETUSERPOINTSZERO(?,?) }");

            callStmt.setString(1, username);
            callStmt.setInt(2, points);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

    public void updateUserPoints(String username, int pointsRestantes) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call updateUserPoints(?,?) }");

            callStmt.setString(1, username);
            callStmt.setInt(2, pointsRestantes);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


