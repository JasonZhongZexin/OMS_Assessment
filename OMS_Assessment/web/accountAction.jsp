
<%@page import="java.util.ArrayList"%>
<%@ page import="uts.wsd.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Edit Account</title>
    </head>
    <body>
        <% String usersPath = application.getRealPath("WEB-INF/users.xml");%>
        <jsp:useBean id="userApp" class="uts.wsd.UsersApplication" scope="application">
            <jsp:setProperty name="userApp" property="filePath" value="<%=usersPath%>"/>
        </jsp:useBean>
        <% String moviePath = application.getRealPath("WEB-INF/movies.xml");%>
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%= moviePath%>"/>
        </jsp:useBean>
        <% String historyPath = application.getRealPath("WEB-INF/history.xml");%>
        <jsp:useBean id="orderApp" class="uts.wsd.OrderApplication" scope="application">
            <jsp:setProperty name="orderApp" property="filePath" value="<%=historyPath%>"/>
        </jsp:useBean>


        <%
            //get the login user from the session
            User user = (User) session.getAttribute("userLogin");
            //get the user select action from the request parameter
            String action = request.getParameter("action");
            //if the user action is null, update the user with the new user detail.
            //if the user action is cancel, cancel the login user account
            if (action == null && user != null) {
                //get the new user detail from the request parameter
                String email = request.getParameter("email");
                String fullName = request.getParameter("fullname");
                String password = request.getParameter("password");
                String phoneNumber = request.getParameter("phonenumber");
                String address = request.getParameter("address");
                //update the user detail
                userApp.editUsers(user, fullName, email, password, phoneNumber, address);
                //save users and update XML
                userApp.saveUsers();
                //send back the result and navigate to the account page
                session.setAttribute("editAccountResult", "Your account detail has been modified!");
                response.sendRedirect("account.jsp");
            } else if (action.equals("cancel") && user != null) {
                ArrayList<Order> orders = orderApp.getUserOrder(user);
                //set all user's orders status to cancel
                for (Order order : orders) {
                    orderApp.changeOrderStatus(order.getID());
                    ArrayList<Item> items = order.getOrderItems();
                    for (Item item : items) {
                        movieApp.addCopies(item.getMovieTitle(), item.getCopiesPurchased());
                    }
                }
                userApp.cancelUser(user);
                userApp.saveUsers();
                userApp.updateXML(usersPath, userApp.getUsers());
                //logout the user
                session.invalidate();
                //send back the user to the index page
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>