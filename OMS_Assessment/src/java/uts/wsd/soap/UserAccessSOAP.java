/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.soap;

import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import uts.wsd.History;
import uts.wsd.Order;
import uts.wsd.OrderApplication;
import uts.wsd.User;
import uts.wsd.UsersApplication;

/**
 *
 * @author Zexin Zhong
 */
@WebService(serviceName = "omsApp")
public class UserAccessSOAP {
    
    @Context
    private ServletContext application;
    @Resource
    private WebServiceContext context;

    @WebMethod
    private UsersApplication getUserApplication() throws Exception {
        application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            UsersApplication userApp = (UsersApplication) application.getAttribute("userApp");
            if (userApp == null) {
                userApp = new UsersApplication();
                userApp.setFilePath(application.getRealPath("WEB-INF/users.xml"));
                application.setAttribute("userApp", userApp);
            }
            return userApp;
        }
    }
    
    @WebMethod
    private OrderApplication getOrderApplication() throws Exception {
        application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            OrderApplication orderApp = (OrderApplication) application.getAttribute("orderApp");
            if (orderApp == null) {
                orderApp = new OrderApplication();
                orderApp.setFilePath(application.getRealPath("WEB-INF/history.xml"));
                application.setAttribute("orderApp", orderApp);
            }
            return orderApp;
        }
    }
    
    @WebMethod
    public User loginUser(String email, String password) throws Exception{
        return getUserApplication().loginUser(email, password);
    }
    
    @WebMethod
    public String logoutUser() throws Exception{
        User user = getUserApplication().logoutUser();
        return "User has logged out";
    }
    
    @WebMethod
    public ArrayList<Order> getHistory() throws Exception{
        return getOrderApplication().getHistory().getOrders();
    }
    
    @WebMethod
    public Order getHistoryByOrderID(String ID) throws Exception{
        return getOrderApplication().getOrderByID(ID);
    }
    
    @WebMethod
    public  ArrayList<Order> getHistoryByEmail(String email) throws Exception{
        return getOrderApplication().getOrdersByEmail(email);
    }
    
    @WebMethod
    public ArrayList<Order> getHistoryByTitle(String title) throws Exception{
        return getOrderApplication().getOrdersByTitle(title);
    }
    
    @WebMethod
    public ArrayList<Order> getHistoryByStatus(String status) throws Exception{
        return getOrderApplication().getHistoryByStatus(status);
    }
}