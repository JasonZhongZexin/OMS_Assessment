/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zexin Zhong
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {

    @XmlElement(name = "user")
    private ArrayList<User> users = new ArrayList<>();

    /**
     * This is the getter method of the users field. It will return the users list.
     * @return users
     */
    public ArrayList<User> getUsers() {
        return this.users;
    }

    /**
     * This is the add user method. it will add the user to the users list.
     * @param user 
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * This get user method will return the user which matches the input email.
     * @param email input email 
     * @return match user or null
     */
    public User getUser(String email) {
        for (User user : users) {
            if (user.matchEmail(email)) {
                return user;
            }
        }
        return null;
    }

    /**
     * This is the login method. it will loop over the users list and check if 
     * any user's email and password matching the input email and password. if math, return the match user. 
     * otherwise return null. 
     * @param email input login email
     * @param password input login password 
     * @return match user or null  
     */
    public User login(String email, String password) {

        for (User user : users) {
            if (user.matchEmail(email) && user.matchPassword(password)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getRemoveList(String email) {
        ArrayList<User> removelist = new ArrayList<>();
        for (User user : users) {
            if (user.matchEmail(email)) {
                removelist.add(user);
            }
        }
        return removelist;
    }

    public void remove(User user) {

        users.removeAll(getRemoveList(user.getEmail()));

    }

    public void updateUser(User user) {
        remove(user);
        addUser(user);
    }
    
    /**
     * This is the cancel user method. It will remove the user from users list.
     * @param user user that wish to remove
     */
    public void cancelUser(User user){
        for(int i=0;i<users.size();i++){
            if((users.get(i).getEmail()).equals(user.getEmail()))
                users.remove(i);
        }
    }
}
