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
    
    /**
     * This is a SOAP web method which will check if the user application are created on the server.
     * if the application are not created, it will generator the Oder application instance and return the 
     * user application.
     * @return user application.
     * @throws Exception 
     */
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
    
    /**
     * This is a SOAP web method which will check if the movie application are created on the server.
     * if the application are not created, it will generator the move application instance and return the 
     * movie application.
     * @return movie  application.
     * @throws Exception 
     */
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

    /**
     * This is a SOAP web method which will check if the order application are created on the server.
     * if the application are not created, it will generator the Oder application instance and return the 
     * order application.
     * @return order application.
     * @throws Exception 
     */
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

    /**
     * This is a SOAP web method which will logout the user and return the current the current user.
     * @return the current user
     * @throws Exception 
     */
    @WebMethod
    public User logout() throws Exception {
        return getUserApplication().logoutUser();
    }

    /**
     * This is a SOAP web method which will fetch all orders that stored in the history XML.
     *
     * @return
     * @throws Exception
     */
    @WebMethod
    public ArrayList<Order> fetchHistory() throws Exception {
        return getOrderApplication().getHistory().getOrders();
    }

    /**
     * This is a SOAP web method which will fetch all orders that match with the
     * user's input order id.
     *
     * @param ID user's input order id
     * @return
     * @throws Exception
     */
    @WebMethod
    public Order fetchHistoryByOrderID(String ID) throws Exception {
        return getOrderApplication().getOrderByID(ID);
    }

    /**
     * This is a SOAP web method which will fetch all orders that match with the
     * user's input email address.
     *
     * @param email users input email address
     * @return
     * @throws Exception
     */
    @WebMethod
    public ArrayList<Order> fetchHistoryByEmail(String email) throws Exception {
        return getOrderApplication().getOrdersByEmail(email);
    }

    /**
     * This is a SOAP web method which will fetch all orders that include user's
     * input movie title.
     *
     * @param title user's input movie title
     * @return
     * @throws Exception
     */
    @WebMethod
    public ArrayList<Order> fetchHistoryByTitle(String title) throws Exception {
        return getOrderApplication().getOrdersByTitle(title);
    }

    /**
     * This is a SOAP web method which will fetch all orders that match with the
     * user's input order status.
     *
     * @param status user's input order status
     * @return
     * @throws Exception
     */
    @WebMethod
    public ArrayList<Order> fetchHistoryByStatus(String status) throws Exception {
        return getOrderApplication().getHistoryByStatus(status);
    }

    /**
     * This is a SOAP web method. it will generator an new order with the user's
     * pick up item. then save the new order into the XML file and update the
     * movies available copies.
     *
     * @param user the login user
     * @param items a list of order items that user purchase.
     * @param paymentMethod the payment method that user choose
     * @throws Exception
     */
    @WebMethod
    public void placeOrder(User user, ArrayList<Item> items, String paymentMethod) throws Exception {
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

    /**
     * This method is a SOAP web method. it will fetch and return all orders
     * that include the user's input movie.
     *
     * @param title is the movie title that user input
     * @return
     * @throws Exception
     */
    @WebMethod
    public Movie findMovieByTitle(String title) throws Exception {
        return getMoviesApplication().getMovieByTitle(title);
    }

    /**
     * This method is a SOAP web method. it will decrease the available copies
     * of all movies that user choose to place an order.
     *
     * @param items a list of order items that user purchase.
     * @throws Exception
     */
    @WebMethod
    public void updateCopies(ArrayList<Item> items) throws Exception {
        for (Item item : items) {
            getMoviesApplication().minusCopies(item.getMovieTitle(), item.getCopiesPurchased());
        }
        getMoviesApplication().saveMovies();
    }
}
