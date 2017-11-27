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

    /*creates an instance of an employee*/
    public Employee(String name, String secret, String restaurant) {
        super(name);
        password = secret;
        restaurantName = restaurant;
    }

    /*returns the restaurant name*/
    public String getRestaurantName() {
        return restaurantName;
    }

    /*sets the restaurant name*/
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /*returns if the password matches the employee's*/
    public boolean isCorrectPassword(String other) {
        return password.equals(other);
    }

    /*returns the password*/
    public String getPassword() {
        return password;
    }

    /*sets the password*/
    public void setPassword(String password) {
        this.password = password;
    }
}
