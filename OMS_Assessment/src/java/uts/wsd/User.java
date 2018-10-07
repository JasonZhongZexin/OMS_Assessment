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
import uts.wsd.dao.UserDAO;

/**
 *
 * @author zhongzexin
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User implements Serializable,UserDAO{
    
    @XmlElement(name="fullName")
    private String fullName;
    @XmlElement(name="email")
    private String email;
    @XmlElement(name="password")
    private String password;
    @XmlElement(name="phoneNumber")
    private String phoneNumber;
    @XmlElement(name="address")
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
        
    
    @Override
    public void updateDetails(String fullName,String email,String password,String phoneNumber,String address){
    
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        
    }
    
    @Override
    public boolean matchEmail(String email){
    
        return this.email.equals(email);
        
    }
    
    @Override
    public boolean matchPassword(String password){
    
        return this.password.equals(password);
        
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
       
}
