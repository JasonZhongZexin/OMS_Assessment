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
@XmlRootElement(name = "history")
public class History implements Serializable {

    @XmlElement(name = "order")
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    /**
     * This method will add the order to the orders list 
     * @param order 
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * This is the setter of the orders field
     * @param orders 
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     * This method will get the order that belong to the specifically use.
     * @param user query user
     * @return list of matching orders 
     */
    public ArrayList<Order> getUserOrder(User user) {
        ArrayList<Order> matches = new ArrayList<>();
        for (Order order : orders) {
            if (order.matchEmail(user.getEmail())) {
                matches.add(order);
            }
        }
        return matches;
    }

    /**
     * This method will change the order status of the specifically order.
     * @param ID query order ID
     */
    public void changeOrderStatus(String ID) {
        for (Order order : orders) {
            if (order.matchID(ID)) {
                order.setStatus("cancelled");
            }
        }
    }

    /**
     * This method will return an order that match with the given Order ID
     * @param ID query Order ID
     * @return match orders 
     */
    public Order getOrderByID(String ID) {
        Order match = new Order();
        for (Order order : orders) {
            if (order.getID().equals(ID)) {
                match = order;
            }
        }
        return match;
    }


    /**
     * This method will return fetch orders that match with the given email address.
     * @param email query email address
     * @return list of matching orders 
     */
    public ArrayList<Order> getOrdersByEmail(String email) {
        ArrayList<Order> matches = new ArrayList<>();
        for (Order order : orders) {
            if (order.matchEmail(email)) {
                matches.add(order);
            }
        }
        return matches;
    }
    
    /**
     * This method will return orders that include a specifically movie.
     * @param title query movie title 
     * @return list of matching orders 
     */
    public ArrayList<Order> getOrderByTitle(String title){
        ArrayList<Order> matches = new ArrayList<>();
        for(Order order: orders){
            if(order.isContainsItem(title))
                matches.add(order);
        }
        return matches;
    }
    
    /**
     * This method will return order that matching the given order status.
     * @param status query order status 
     * @return list of matching orders
     */
    public ArrayList<Order> getHistoryByStatus(String status){
        ArrayList<Order> matches = new ArrayList<>();
        for(Order order: orders){
            if(order.isMatchStatus(status))
                matches.add(order);
        }
        return matches;
    }
}
