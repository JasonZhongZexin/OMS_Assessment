/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.dao;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import uts.wsd.User;
import uts.wsd.Users;

/**
 *
 * @author User
 */
public interface UsersApplicationDAO {
    public void updateXML(String filePath,Users users) throws Exception;
    public void saveUsers() throws JAXBException, IOException;
    public void editUsers(User user, String fullName, String email, String password
    ,String phoneNumber,String address) throws Exception;
    public void addUser(User user);
    public User checkUser(String email);
    public User loginUser(String emial, String password);
    public User logoutUser();
    public void updateUser(User user);
}
