/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.dao;

import java.util.ArrayList;
import uts.wsd.User;

/**
 *
 * @author User
 */
public interface UsersDAO {
    public void addUser(User user);
    public User getUser(String email);
    public User login(String email, String password);
    public ArrayList<User> getRemoveList(String email);
    public void remove(User user);
    public void updateUser(User user);
}
