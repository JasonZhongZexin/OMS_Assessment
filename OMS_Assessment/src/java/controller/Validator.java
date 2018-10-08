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
    private String phoneNumberPattern = "[0-9]{10}";
    private String yearPattern = "[0-9]{4}";

    public Validator() {
    }

    public boolean validate(String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }

    /**
     *
     * @param email the given password
     * @param password the given email
     * @return return true if email is not empty or password is not empty
     * otherwise return false
     */
    public boolean checkLoginEmpty(String email, String password) {
        return email.isEmpty() || password.isEmpty();
    }

    /**
     * This method will check if the given email match the email pattern.
     *
     * @param email the given email
     * @return return true if match otherwise return false
     */
    public boolean validateEmail(String email) {
        return validate(emailPattern, email);
    }

    /**
     * This method will check if the given name match the name pattern.
     *
     * @param name the given name
     * @return return true if match otherwise return false
     */
    public boolean validateName(String name) {
        return validate(namePattern, name);
    }

    /**
     * This method will check if the given password match the password pattern.
     *
     * @param password the given password
     * @return return true if match otherwise return false
     */
    public boolean validatePassword(String password) {
        return validate(passwordPattern, password);
    }

    /**
     * This method will valid if the given phone number match the phone number
     * pattern.
     *
     * @param phone the given phone number
     * @return return true if match otherwise return false
     */
    public boolean validatePhoneNumnber(String phone) {
        return validate(phoneNumberPattern, phone);
    }

    /**
     * This method will valid if the given year match the year pattern.
     *
     * @param year the given year string
     * @return return true if match otherwise return false
     */
    public boolean validateYear(String year) {
        return validate(yearPattern, year);
    }
}
