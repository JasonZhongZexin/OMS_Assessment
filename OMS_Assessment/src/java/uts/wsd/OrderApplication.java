/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Zexin Zhong
 */
public class OrderApplication implements Serializable {

    private String filePath;
    private History history;

    public OrderApplication() {
    }

    public OrderApplication(String filePath, History history) {
        super();
        this.filePath = filePath;
        this.history = history;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws JAXBException, FileNotFoundException, IOException {
        JAXBContext jc = JAXBContext.newInstance(History.class);
        Unmarshaller u = jc.createUnmarshaller();
        this.filePath = filePath;
        FileInputStream fin = new FileInputStream(filePath);
        history = (History) u.unmarshal(fin);
        fin.close();
    }

    /**
     * This method will save and update the history XML 
     * @param filePath
     * @param history
     * @throws JAXBException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void updateXML(String filePath, History history) throws JAXBException, FileNotFoundException, IOException {
        this.history = history;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(History.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(history, fout);
        fout.close();
    }

    /**
     * This method will save the history to the XML 
     * @throws JAXBException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveHistory() throws JAXBException, FileNotFoundException, IOException {
        JAXBContext jc = JAXBContext.newInstance(History.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(history, fout);
        fout.close();
    }

    /**
     * This is the getter of the history field 
     * @return history 
     */
    public History getHistory() {
        return this.history;
    }

    /**
     * This is the setter of the history field 
     * @param history 
     */
    public void setHistory(History history) {
        this.history = history;
    }

    /**
     * This method will return all orders that belong to the specified user.
     * @param user the query user 
     * @return all matches orders
     */
    public ArrayList<Order> getUserOrder(User user) {
        return history.getUserOrder(user);
    }

    /**
     * This order will change the status of the specified order.
     * @param ID the order id
     */
    public void changeOrderStatus(String ID) {
        history.changeOrderStatus(ID);
    }

    /**
     * This method will add an order to the history.
     * @param order 
     */
    public void addOrder(Order order) {
        history.addOrder(order);
    }

    /**
     * This method will returns all orders that match the specified Order ID.
     * @param ID the query order ID
     * @return all matches orders
     */
    public Order getOrderByID(String ID) {
        return history.getOrderByID(ID);
    }
    
    /**
     * This method will returns all orders that match the specified email.
     * @param email the query email 
     * @return all matches orders
     */
    public ArrayList<Order> getOrdersByEmail(String email){
        return history.getOrdersByEmail(email);
    }
    
    /**
     * This method will returns all orders that match the specified movie title.
     * @param title the query movie title 
     * @return all matches orders
     */
    public ArrayList<Order> getOrdersByTitle(String title){
        return history.getOrderByTitle(title);
    }
    
    /**
     * This method will returns all orders that match the specified status.
     * @param status the query order status 
     * @return all matches orders
     */
    public ArrayList<Order> getHistoryByStatus(String status){
        return history.getHistoryByStatus(status);
    }
}
