/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.rest;

import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import uts.wsd.Order;
import uts.wsd.OrderApplication;

/**
 * REST Web Service
 *
 * @author zhongzexin
 */
@Path("/orderApp")
public class OrderService {

    @Context
    private ServletContext application;

    private OrderApplication getOrderApplication() throws Exception {
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

    /**
     * This is a HTTP GET method of the REST web services. it will get all
     * orders that stored in the XML.
     *
     * @return list of order that stored in the XML
     * @throws Exception
     */
    @Path("history")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Order> getHistory() throws Exception {
        return getOrderApplication().getHistory().getOrders();
    }

    /**
     * This is a HTTP GET method of the REST web services. it passes a order Id as
     * a URL path parameter. Then fetch and return all matching order.
     * @param ID query order ID
     * @return
     * @throws Exception
     */
    @Path("idHistory/{ID}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Order getHistoryByOrderID(@PathParam("ID") String ID) throws Exception {
        return getOrderApplication().getOrderByID(ID);
    }

    /**
     * This is a HTTP GET method of the REST web services. it passes an email as
     * a URL path parameter Then fetch and return all matching order.
     *
     * @param email query email address
     * @return list of matching order
     * @throws Exception
     */
    @Path("emailHistory/{email}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Order> getHistoryByEmail(@PathParam("email") String email) throws Exception {
        return getOrderApplication().getHistory().getOrdersByEmail(email);
    }

    /**
     * This is a HTTP GET method of the REST web services. it passes a movie
     * title as a URL path parameter Then fetch and return all matching order.
     *
     * @param title query movie title
     * @return list of matching order
     * @throws Exception
     */
    @Path("titleHistory/{title}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Order> getHistoryByTitle(@PathParam("title") String title) throws Exception {
        return getOrderApplication().getOrdersByTitle(title);
    }

    /**
     * This is a HTTP GET method of the REST web services. it passes a status as
     * a URL path parameter Then fetch and return all matching order.
     *
     * @param status query order status
     * @return list of matching order
     * @throws Exception
     */
    @Path("statusHistory/{status}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Order> getHistoryByStatus(@PathParam("status") String status) throws Exception {
        return getOrderApplication().getHistoryByStatus(status);
    }
}
