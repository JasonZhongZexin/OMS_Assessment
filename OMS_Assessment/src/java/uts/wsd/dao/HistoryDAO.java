/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.dao;

import java.io.Writer;
import java.util.ArrayList;
import uts.wsd.Order;
import uts.wsd.User;

/**
 *
 * @author User
 */
public interface HistoryDAO {
    public void addOrder(Order order);
    public ArrayList<Order> getUserOrder(User user);
    public void changeOrderStatus(String ID);
    public Order getOrderByID(String ID);
    public void print(ArrayList<Order> list, Writer sout);
    public void printHistory(ArrayList<Order> list, Writer sout);
    public ArrayList<Order> getOrdersByEmail(String email);
    public ArrayList<Order> getOrderByTitle(String title);
    public ArrayList<Order> getHistoryByStatus(String status);
}
