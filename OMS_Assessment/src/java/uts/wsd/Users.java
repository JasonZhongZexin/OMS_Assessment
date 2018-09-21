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
 * @author zhongzexin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {

    @XmlElement(name = "user")
    private ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String email) {
        for (User user : users) {
            if (user.matchEmail(email)) {
                return user;
            }
        }
        return null;
    }

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

}
