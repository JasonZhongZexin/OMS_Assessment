/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Zexin Zhong
 */
public class Validator {
    private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";   
    private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";    
    private String passwordPattern = "[0-9A-Za-z]{6,}";   
    private String phoneNumberPattern ="[0-9]{10}";
    private String yearPattern="[0-9]{4}";
    public Validator(){}
    
    public boolean validate(String pattern, String input){
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }    
    public boolean checkLoginEmpty(String email, String password){
        return  email.isEmpty() || password.isEmpty();
    }
    public boolean validateEmail(String email){                
        return validate(emailPattern,email);
    } 
    public boolean validateName(String name){        
        return validate(namePattern,name);
    }    
    public boolean validatePassword(String password){        
        return validate(passwordPattern,password);
    }     
    public boolean validatePhoneNumnber(String phone){
        return validate(phoneNumberPattern,phone);
    }
    
    public boolean validateYear(String year){
        return validate(yearPattern,year);
    }
}
