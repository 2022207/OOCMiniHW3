/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oocminihw3;

/**
 *
 * @author castr
 */
public class Member {//this class compose each Member of the list
    
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    
    public Member (int id, String firstName, String lastName, String email){
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        //this code will present the string representation to each Member
        return "Member " + id + ", " + firstName + " " + lastName + ", E-mail: " + email;
    }
}
