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
@XmlRootElement(name = "order")
public class Order implements Serializable{
    
    @XmlElement(name = "ID")
    private String ID;
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "paymentMethod")
    private String paymentMethod;
    @XmlElement(name = "saleTotal")
    private String saleTotal;
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "orderItem")
    private ArrayList<Item> orderItems;

    public Order() {
    }

    public Order(String ID, String fullName, String email, String paymentMethod, String saleTotal, String status, ArrayList<Item> orderItems) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.saleTotal = saleTotal;
        this.status = status;
        this.orderItems = orderItems;
    }
    
    public boolean matchID(String ID){
        return this.ID.equals(ID);
    }
    
    public boolean matchEmail(String email){
        return this.email.equals(email);
    }
    
    public String getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getSaleTotal() {
        return saleTotal;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Item> getOrderItems() {
        return orderItems;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setSaleTotal(String saleTotal) {
        this.saleTotal = saleTotal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderItems(ArrayList<Item> orderItems) {
        this.orderItems = orderItems;
    }
    
    public boolean verifyStatus(){
        return status.equalsIgnoreCase("Submitted");
    }
}
