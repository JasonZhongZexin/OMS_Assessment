<%-- 
    Document   : cancelAction
    Created on : 03/10/2018, 4:14:41 AM
    Author     : zhongzexin
--%>

<%@page import="uts.wsd.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Login Action Page</title>
    </head>
    <body>
        <% String filepath = application.getRealPath("WEB-INF/movies.xml");%>
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%=filepath%>"/>
        </jsp:useBean>
        <% String path = application.getRealPath("WEB-INF/history.xml");%>
        <jsp:useBean id="orderApp" class="uts.wsd.OrderApplication" scope="application">
            <jsp:setProperty name="orderApp" property="filePath" value="<%=path%>"/>
        </jsp:useBean>
        <%
            //get the order that user want to cancel from the session
            Order order = (Order) session.getAttribute("cancelOrder");
            ArrayList<Item> items = order.getOrderItems();
            if(order!=null){
                for(Item item : items){
                    //return the copies to the movie available copies
                    movieApp.addCopies(item.getMovieTitle(), item.getCopiesPurchased());
                    //save and update the MOVIE XML
                    movieApp.saveMovies();
                }
                //update the order status
                orderApp.changeOrderStatus(order.getID());
                //save and update the history XML
                orderApp.saveHistory();
            }
        %>
        <h2>The order <%=order.getID()%> has been canceled. Click <a href="main.jsp">here</a> to back to your main page!</h2>
    </body>
</html>
