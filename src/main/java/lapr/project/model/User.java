/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;
import lapr.project.data.UserDB;

/**
 *
 * @author Daniela Vinagreiro
 */
public class User {

    private String name;
    private String username;
    private String email;
    private String password;
    private String creditCardNumber;
    private double height;
    private double weight;
    private boolean user;
    private boolean administrator;
    private int points;
    private double avgSpeed;

    private static final String USER_STRING = "User";
    private static final String ADMINISTRATOR_STRING = "Administrator";
    private static final Double THRESHOLD=.0001; 

    /**
     * Construct of the object User
     *
     * @param name
     * @param username
     * @param email
     * @param password
     * @param creditCardNumber
     * @param height
     * @param weight
     * @param avgSpeed
     */
    public User(String name, String username, String email, String password, String creditCardNumber, double height, double weight, double avgSpeed) {
        setName(name);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setCreditCardNumber(creditCardNumber);
        setHeight(height);
        setWeight(weight);
        this.user = true;
        setPoints(0);
    }
    
    /**
     * Construct of the object User
     *
     * @param name
     * @param username
     * @param email
     * @param password
     * @param creditCardNumber
     * @param height
     * @param weight
     * @param avgSpeed
     */
    public User(String name, String username, String email, String password, String creditCardNumber, double height, double weight, String type, int points, double avgSpeed) {
        setName(name);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setCreditCardNumber(creditCardNumber);
        setHeight(height);
        setWeight(weight);
        setType(type);
        setPoints(points);
        this.avgSpeed=avgSpeed;
    }

    /**
     * Empty constructor
     */
    public User() {

    }

    public static User getUser(String username) {
        return new UserDB().getUser(username);
    }

    /**
     * get name of the user
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * get username of the user
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * get email of the user
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * get password of the user
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * get credit card number of the user
     *
     * @return
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * get the heigth of the user
     *
     * @return
     */
    public double getHeight() {
        return height;
    }

    /**
     * get the weight of the user
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @return
     */
    public String getType() {
        if (isAdministrator()) {
            return ADMINISTRATOR_STRING;
        } else {
            return USER_STRING;
        }
    }

    public int getPoints() {
        return points;
    }
    

    /**
     * set method for the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param type
     */
    private void setType(String type) {
        switch (type) {
            case USER_STRING:
                this.user = true;
                break;
            case ADMINISTRATOR_STRING:
                this.administrator = true;
                break;
            default:
                break;
        }
    }

    /**
     * set method fot the username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * set method for the email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * set method for the password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * set method for the credit card number
     *
     * @param creditCardNumber
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * set method for the height
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * set method for the weight
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the avgSpeed
     */
    public double getAvgSpeed() {
        return avgSpeed;
    }

    /**
     * @param avgSpeed the avgSpeed to set
     */
    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }
    
    /**
     *
     * @param anotherObject
     * @return
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null) {
            return false;
        }
        if (this.getClass() != anotherObject.getClass()) {
            return false;
        }
        User newUser = (User) anotherObject;
        if (!newUser.name.equals(this.name)) {
            return false;
        }
        if (!newUser.username.equals(this.username)) {
            return false;
        }
        if (!newUser.email.equals(this.email)) {
            return false;
        }
        if (!newUser.password.equals(this.password)) {
            return false;
        }
        if (!newUser.creditCardNumber.equals(this.creditCardNumber)) {
            return false;
        }
        if (!(Math.abs(newUser.avgSpeed - this.avgSpeed) < THRESHOLD)) {
            return false;
        }
        if (!(Math.abs(newUser.height - this.height) < THRESHOLD)) {
            return false;
        }
        return (Math.abs(newUser.weight - this.weight) < THRESHOLD);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.creditCardNumber);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }

    /**
     *
     * @return
     */
    public boolean isUser() {
        return user;
    }

    /**
     *
     * @return
     */
    public boolean isAdministrator() {
        return administrator;
    }

    public static boolean login(String username, String password) {
        try {
            User user = User.getUser(username);
            return user.getPassword().equals(password);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "name=" + name + ", username=" + username + ", email=" + email + ", password=" + password + ", creditCardNumber=" + creditCardNumber + ", height=" + height + ", weight=" + weight+ ", average speed=" + avgSpeed;
    }
}
