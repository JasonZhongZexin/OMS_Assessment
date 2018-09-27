/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Zexin Zhong
 */
public class UsersApplication implements Serializable{
    
    private String filePath;
    private Users users;
    
    public UsersApplication(){}

    public UsersApplication(String filePath, Users users) {
        super();
        this.filePath = filePath;
        this.users = users;
    }
    
    public String getFilePath(){
        return filePath;
    }
    
    public void setFilePath(String filePath) throws Exception{
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Unmarshaller u = jc.createUnmarshaller();
        this.filePath = filePath;
        FileInputStream fin = new FileInputStream(filePath);
        users = (Users) u.unmarshal(fin);
        fin.close();
    }
    
    public void updateXML(String filePath,Users users) throws Exception{
        this.users = users;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(users, fout);
        fout.close();  
    }
    
    public void saveUsers() throws JAXBException, IOException{
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(users,fout);
        fout.close();
    }
    
    public Users getUsers(){
        return this.users;
    }
    
    public void setUsers(Users users){
        this.users=users;
    }
    
    public void editUsers(User user, String fullName, String email, String password
    ,String phoneNumber,String address) throws Exception{
        users.remove(user);
        user.updateDetails(fullName, email, password, phoneNumber, address);
        users.addUser(user);
        updateXML(filePath,users);
    }
    
    public void addUser(User user){
        users.addUser(user);
    }
    
    public User checkUser(String email){
        User user = users.getUser(email);
        return user;
    }
    
    public User loginUser(String emial, String password){
        return users.login(emial, password);
    }
    
    public User logoutUser(){
        return null;
    }
}
