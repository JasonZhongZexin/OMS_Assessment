/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zexin Zhong
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User implements Serializable {

    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "phoneNumber")
    private String phoneNumber;
    @XmlElement(name = "address")
    private String address;

    public User(String fullName, String email, String password, String phoneNumber, String address) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User() {
    }

    /**
     * This method will input the user's field with the new parameter.
     * @param fullName input full name 
     * @param email the input email
     * @param password the input password 
     * @param phoneNumber the input phone number
     * @param address  the input address
     */
    public void updateDetails(String fullName, String email, String password, String phoneNumber, String address) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    /**
     * This method will check if the input email match the user email
     *
     * @param email input email
     * @return true if match
     */
    public boolean matchEmail(String email) {

        return this.email.equals(email);

    }

    /**
     * This method will check if the input password match the user password
     *
     * @param password input password
     * @return true if match
     */
    public boolean matchPassword(String password) {

        return this.password.equals(password);

    }

    /**
     * This is the getter method of the full name field.
     *
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * THis is the getter of the email field.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This is the getter of the password field.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This is the getter of the phone number field.
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This is the getter of the address field.
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This is the setter of the full name field.
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * This is the setter of the email field,
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This is the setter of the password field,
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This is the setter of the phone number field,
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This is the setter of the address field.
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
