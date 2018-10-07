/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.dao;

/**
 *
 * @author User
 */
public interface UserDAO {
    public void updateDetails(String fullName,String email,String password,String phoneNumber,String address);
    public boolean matchEmail(String email);
    public boolean matchPassword(String password);
}
