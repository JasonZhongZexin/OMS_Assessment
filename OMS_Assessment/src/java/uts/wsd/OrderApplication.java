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
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author zhongzexin
 */
public class OrderApplication {
    
    private String filePath;
    private History history;

    public OrderApplication() {
    }

    public OrderApplication(String filePath, History history) {
        super();
        this.filePath = filePath;
        this.history = history;
    }
    
    public String getFilePath(){
        return filePath;
    }
    
    public void setFilePath(String filePath) throws JAXBException, FileNotFoundException, IOException{
        JAXBContext jc = JAXBContext.newInstance(History.class);
        Unmarshaller u = jc.createUnmarshaller();
        this.filePath = filePath;
        FileInputStream fin = new FileInputStream(filePath);
        history = (History) u.unmarshal(fin);
        fin.close();
    }
    
    public void updateXML(String filePath, History history) throws JAXBException, FileNotFoundException, IOException{
        this.history = history;
        this.filePath = filePath;
        JAXBContext jc = JAXBContext.newInstance(History.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(history, fout);
        fout.close();
    }
    
    public void saveHistory() throws JAXBException, FileNotFoundException, IOException{
        JAXBContext jc = JAXBContext.newInstance(History.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(filePath);
        m.marshal(history, fout);
        fout.close();
    }
    
    public History getHistory(){
        return this.history;
    }
    
    public void setHistory(History history){
        this.history = history;
    }
    
    public ArrayList<Order> getUserOrder(User user){
        return history.getUserOrder(user);
    }
    
    public void changeOrderStatus(String ID){
        history.changeOrderStatus(ID);
    }
    
    public void addOrder(Order order){
        history.addOrder(order);
    }
    public Order getOrderByID(String ID){
        return history.getOrderByID(ID);
    }
}
