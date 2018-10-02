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
@XmlRootElement(name = "history")
public class History implements Serializable {
    
    @XmlElement(name = "order")
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders(){
        return this.orders;
    }
    
    public void addOrder(Order order){
        orders.add(order);
    }
    
    public ArrayList<Order> getUserOrder(User user){
        ArrayList<Order> matches = new ArrayList<>();
        for(Order order: orders){
            if(order.matchEmail(user.getEmail()))
                matches.add(order);
        }
        return matches;
    }
    
    public void changeOrderStatus(String id,String status){
        for(Order order:orders){
            if(order.matchID(id))
                order.setStatus(status);
        }
    }
}
