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
import uts.wsd.*;

/**
 *
 * @author zhongzexin
 */
@WebService(serviceName = "omsApp")
public class OMSSOAP {

    @Context
    private ServletContext application;
    @Resource
    private WebServiceContext context;
    @Context
    private ServletContext movieApplication;
    @Context
    private ServletContext orderApplication;

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
    private MoviesApplication getMoviesApplication() throws Exception {
        movieApplication = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (movieApplication) {
            MoviesApplication movieApp = (MoviesApplication) movieApplication.getAttribute("movieApp");
            if (movieApp == null) {
                movieApp = new MoviesApplication();
                movieApp.setFilePath(movieApplication.getRealPath("WEB-INF/movies.xml"));
                movieApplication.setAttribute("movieApp", movieApp);
            }
            return movieApp;
        }
    }

    @WebMethod
    private OrderApplication getOrderApplication() throws Exception {
        orderApplication = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (orderApplication) {
            OrderApplication orderApp = (OrderApplication) orderApplication.getAttribute("orderApp");
            if (orderApp == null) {
                orderApp = new OrderApplication();
                orderApp.setFilePath(orderApplication.getRealPath("WEB-INF/history.xml"));
                orderApplication.setAttribute("orderApp", orderApp);
            }
            return orderApp;
        }
    }

    @WebMethod
    public User login(String email, String password) throws Exception {
        return getUserApplication().loginUser(email, password);
    }

    @WebMethod
    public User logout() throws Exception {
        return getUserApplication().logoutUser();
    }

    @WebMethod
    public ArrayList<Order> fetchHistory() throws Exception {
        return getOrderApplication().getHistory().getOrders();
    }

    @WebMethod
    public Order fetchHistoryByOrderID(String ID) throws Exception {
        return getOrderApplication().getOrderByID(ID);
    }

    @WebMethod
    public ArrayList<Order> fetchHistoryByEmail(String email) throws Exception {
        return getOrderApplication().getOrdersByEmail(email);
    }

    @WebMethod
    public ArrayList<Order> fetchHistoryByTitle(String title) throws Exception {
        return getOrderApplication().getOrdersByTitle(title);
    }

    @WebMethod
    public ArrayList<Order> fetchHistoryByStatus(String status) throws Exception {
        return getOrderApplication().getHistoryByStatus(status);
    }

    @WebMethod
    public void placeOrder(User user, ArrayList<Item> items,String paymentMethod) throws Exception {
        Order order = new Order();
        order.setEmail(user.getEmail());
        order.setFullName(user.getFullName());
        order.setStatus("submitted");
        int id = (int) (Math.random() * 900) + 100;
        order.setID(Integer.toString(id));
        order.setOrderItems(items);
        order.setPaymentMethod(paymentMethod);
        int saleTotal = 0;
        for (Item item : items) {
            saleTotal += item.getCopiesPurchased() * item.getMoviePrice();
        }
        order.setSaleTotal(saleTotal);
        getOrderApplication().getHistory().addOrder(order);
        getOrderApplication().saveHistory();
    }
    
    @WebMethod
    public Movie findMovieByTitle(String title) throws Exception{
        return getMoviesApplication().getMovieByTitle(title);
    }
    
    @WebMethod
    public void updateCopies(ArrayList<Item> items) throws Exception{
        for(Item item:items){
            getMoviesApplication().minusCopies(item.getMovieTitle(), item.getCopiesPurchased());
        }
        getMoviesApplication().saveMovies();
    }
}
