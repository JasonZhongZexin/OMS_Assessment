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
    
    /**
     * This is the save users method. It will stored users into the XML file.
     * @throws JAXBException
     * @throws IOException 
     */
    public void saveUsers() throws JAXBException, IOException{
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(users,fout);
        fout.close();
    }
    
    /**
     * This is the getter method of the users field. it will return Users
     * @return users
     */
    public Users getUsers(){
        return this.users;
    }
    
    /**
     * This is a setter method of the users field.
     * @param users 
     */
    public void setUsers(Users users){
        this.users=users;
    }
    
    /**
     * This is the edit user detail method. it will update the user detail with the input detail and 
     * stored it into the XML file.
     * @param user the user that wish to modify 
     * @param fullName the input new user full name
     * @param email the user email address
     * @param password the input new password
     * @param phoneNumber the input new phone number
     * @param address the input new address
     * @throws Exception 
     */
    public void editUsers(User user, String fullName, String email, String password
    ,String phoneNumber,String address) throws Exception{
        users.remove(user);
        user.updateDetails(fullName, email, password, phoneNumber, address);
        users.addUser(user);
        updateXML(filePath,users);
    }
    
    /**
     * This is the add user method. it will add the new user to the users list.
     * @param user 
     */
    public void addUser(User user){
        users.addUser(user);
    }
    
    /**
     * This is the check user method. It will check if the input email has been record in the system.
     * @param email the input email
     * @return the match user 
     */
    public User checkUser(String email){
        User user = users.getUser(email);
        return user;    
    }
    
    /**
     * This is the login user. it will login the user with the email and password. then return the user.
     * @param email the input email
     * @param password the input password
     * @return login user
     */
    public User loginUser(String email, String password){
        User user = users.login(email, password);
        return user;
    }
    
    /**
     * This is a logout User method. it will set the user to null and return it.
     * @return null
     */
    public User logoutUser(){
        return null;
    }
    
    /**
     * This is the update user method which will update the user detail.
     * @param user 
     */
    public void updateUser(User user ){
        users.updateUser(user);
    }
    
    /**
     * This is the cancel user method. It will remove the user from users.
     * @param user the user that request to cancel account
     * @throws JAXBException
     * @throws IOException
     * @throws Exception 
     */
    public void cancelUser(User user) throws JAXBException, IOException, Exception{
        users.cancelUser(user);
    }
}
