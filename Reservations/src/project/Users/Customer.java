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
public class Customer extends User {

    String phoneNumber;

    /*creates an instance of a customer*/
    public Customer(String name, String number) {
        super(name);
        phoneNumber = number;
    }

    /*returns their phone number*/
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*sets their phone number*/
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
