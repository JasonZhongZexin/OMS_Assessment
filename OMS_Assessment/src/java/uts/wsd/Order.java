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
@XmlRootElement(name = "order")
public class Order implements Serializable {

    @XmlElement(name = "ID")
    private String ID;
    @XmlElement(name = "fullName")
    private String fullName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "paymentMethod")
    private String paymentMethod;
    @XmlElement(name = "saleTotal")
    private int saleTotal;
    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "orderItem")
    private ArrayList<Item> orderItems;

    public Order() {
    }

    public Order(String ID, String fullName, String email, String paymentMethod, int saleTotal, String status, ArrayList<Item> orderItems) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.saleTotal = saleTotal;
        this.status = status;
        this.orderItems = orderItems;
    }

    /**
     * This Method will check if the order ID match the given order ID
     *
     * @param ID the query ID
     * @return true if match, otherwise, return false
     */
    public boolean matchID(String ID) {
        return this.ID.equals(ID);
    }

    /**
     * This Method will check if the order email match the given email
     *
     * @param email the query email
     * @return true if match, otherwise, return false
     */
    public boolean matchEmail(String email) {
        return this.email.equals(email);
    }

    /**
     * This is the getter of the ID field
     *
     * @return
     */
    public String getID() {
        return ID;
    }

    /**
     * This is the getter of the fullName field
     *
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This is the getter of the email field
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * This is the getter of the paymentMethod field
     *
     * @return
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * This is the getter of the saleTotal field
     *
     * @return
     */
    public int getSaleTotal() {
        return saleTotal;
    }

    /**
     * This is the getter of the status field
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * This is the getter of the orderItems field
     *
     * @return
     */
    public ArrayList<Item> getOrderItems() {
        return orderItems;
    }

    /**
     * This is the setter of the ID field
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * This is the setter of the fullName field
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * This is the setter of the email field.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This is the setter of the paymentMethod field
     *
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * This is the setter of the saleTotal field.
     *
     * @param saleTotal
     */
    public void setSaleTotal(int saleTotal) {
        this.saleTotal = saleTotal;
    }

    /**
     * This is the setter of the status field.
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This is the setter of the orderItems field
     *
     * @param orderItems
     */
    public void setOrderItems(ArrayList<Item> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * This method will check if the order status has been submitted.
     *
     * @return true if the order status is submitted
     */
    public boolean verifyStatus() {
        return status.equalsIgnoreCase("submitted");
    }

    /**
     * This method will check if the order list contains a specified movie
     *
     * @param title the query movie title
     * @return return true if any match,otherwise, return false
     */
    public boolean isContainsItem(String title) {
        for (Item item : orderItems) {
            if (item.getMovieTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method will check is the order status match the given status.
     *
     * @param status the query status
     * @return return true if match
     */
    public boolean isMatchStatus(String status) {
        return this.status.equals(status);
    }
}
