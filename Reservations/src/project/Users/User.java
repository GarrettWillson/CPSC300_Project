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
abstract public class User {

    String userName;

    public User(String name) {
        userName = name;
    }

    /*returns the user name*/
    public String getUserName() {
        return userName;
    }

    /*sets the user name*/
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
