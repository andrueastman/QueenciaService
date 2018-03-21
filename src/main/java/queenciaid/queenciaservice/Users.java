/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queenciaid.queenciaservice;

/**
 *
 * @author danial
 */
public class Users {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;;
  
    
    //Constructor
    public Users(String firstName, String lastName, String phoneNumber) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    
    public String getfirstName() {
        return firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public String getphoneNumber() {
        return phoneNumber;
    }

}
