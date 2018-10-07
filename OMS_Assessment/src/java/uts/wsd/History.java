/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import uts.wsd.dao.HistoryDAO;

/**
 *
 * @author zhongzexin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "history")
public class History implements Serializable,HistoryDAO {

    @XmlElement(name = "order")
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public ArrayList<Order> getUserOrder(User user) {
        ArrayList<Order> matches = new ArrayList<>();
        for (Order order : orders) {
            if (order.matchEmail(user.getEmail())) {
                matches.add(order);
            }
        }
        return matches;
    }

    @Override
    public void changeOrderStatus(String ID) {
        for (Order order : orders) {
            if (order.matchID(ID)) {
                order.setStatus("cancelled");
            }
        }
    }

    @Override
    public Order getOrderByID(String ID) {
        Order match = new Order();
        for (Order order : orders) {
            if (order.getID().equals(ID)) {
                match = order;
            }
        }
        return match;
    }

    @Override
    public void print(ArrayList<Order> list, Writer sout) {
        PrintWriter out = new PrintWriter(sout);
        out.print("<table align=\"center\">");
        out.print("\n<thead><th>Order ID</th><th>Payment Method</th><th>Sale Total</th><th>Status</th></thead>");
        list.stream().map((order) -> {
            out.println("<tr > ");
            out.println("<td>" + order.getID() + "</td>");
            return order;
        }).map((order) -> {
            out.println("<td >" + order.getPaymentMethod() + "</td>");
            return order;
        }).map((order) -> {
            out.println("<td >" + order.getSaleTotal() + "</td>");
            return order;
        }).map((order) -> {
            out.println("<td >" + order.getStatus() + "</td>");
            return order;
        }).forEach((_item) -> {
            out.println("</tr>");
        });
        out.print("</table>");
    }

    public void printHistory(ArrayList<Order> list, Writer sout) {

        PrintWriter out = new PrintWriter(sout);

        out.print("<table align=\"center\">");
        out.print("\n<thead><th>Order ID</th><th>Payment Method</th><th>Sale Total</th><th>Status</th></thead>");

        list.stream().map((order) -> {
            String href = order.verifyStatus() ? "<a class=\"link\" href=\"cancel.jsp?bookingIDSelect=" + order.getID() + "\" >" + order.getID() + "</a>" : order.getID();
            out.println("<tr > ");
            out.println("<td>" + href + "</td>");
            return order;
        }).map((order) -> {
            out.println("<td >" + order.getPaymentMethod() + "</td>");
            return order;
        }).map((order) -> {
            out.println("<td >" + order.getSaleTotal() + "</td>");
            return order;
        }).map((order) -> {
            out.println("<td >" + order.getStatus() + "</td>");
            return order;
        }).forEach((_item) -> {
            out.println("</tr>");
        });
        out.print("</table>");
    }

    @Override
    public ArrayList<Order> getOrdersByEmail(String email) {
        ArrayList<Order> matches = new ArrayList<>();
        for (Order order : orders) {
            if (order.matchEmail(email)) {
                matches.add(order);
            }
        }
        return matches;
    }
    
    @Override
    public ArrayList<Order> getOrderByTitle(String title){
        ArrayList<Order> matches = new ArrayList<>();
        for(Order order: orders){
            if(order.isContainsItem(title))
                matches.add(order);
        }
        return matches;
    }
    
    @Override
    public ArrayList<Order> getHistoryByStatus(String status){
        ArrayList<Order> matches = new ArrayList<>();
        for(Order order: orders){
            if(order.isMatchStatus(status))
                matches.add(order);
        }
        return matches;
    }
}
