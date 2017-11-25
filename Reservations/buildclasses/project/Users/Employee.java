/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Users;

/**
 *
 * @author fontai1
 */
public class Employee extends User {

    String password;
    String restaurantName;

    public Employee(String name, String secret, String restaurant) {
        super(name);
        password = secret;
        restaurantName = restaurant;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public boolean isCorrectPassword(String other) {
        return password.equals(other);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
