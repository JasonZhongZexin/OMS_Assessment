<%-- 
    Document   : checkoutAction
    Created on : 2018-10-4, 20:33:42
    Author     : samsung
--%>

<%@page import="uts.wsd.Movies"%>
<%@page import="uts.wsd.History"%>
<%@page import="uts.wsd.Order"%>
<%@page import="uts.wsd.User"%>
<%@page import="uts.wsd.Item"%>
<%@page import="uts.wsd.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Place Order</title>
    </head>
    <body>
        <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
            <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
            <jsp:getProperty name="shoppingCartApp" property="shoppingCart"/>
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
            //get the shoppingCart fromt he session
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            int saleTotal = 0;
            //purchased all item that stored in the shoppingCart
            for (Item item : shoppingCart.getShoppingCart()) {
                int copies = Integer.parseInt(request.getParameter(item.getMovieTitle()));
                item.setCopiesPurchased(copies);
                movieApp.minusCopies(item.getMovieTitle(), copies);
                saleTotal += item.getMoviePrice() * copies;
            }
            //get the payment method that user choose in the checkout page
            String paymentMethod = request.getParameter("paymentMethod");
            Order order = new Order();
            //generate the 3 digital order ID 
            int id = (int) (Math.random() * 900) + 100;
            order.setID(Integer.toString(id));
            order.setOrderItems(shoppingCart.getShoppingCart());
            order.setSaleTotal(saleTotal);
            order.setStatus("submitted");
            order.setPaymentMethod(paymentMethod);
            //if user have not login, set the order email and fullName as anonymous, otherwise set the order 
            //email with login user's email and password.
            if (user != null) {
                order.setEmail(user.getEmail());
                order.setFullName(user.getFullName());
            } else {
                order.setEmail("anonymous");
                order.setFullName("anonymous");
            }
            //update XML
            Movies movies = movieApp.getMovies();
            movieApp.updateXML(moviePath, movies);
            orderApp.addOrder(order);
            History history = orderApp.getHistory();
            orderApp.updateXML(historyPath, history);
            orderApp.saveHistory();
            ShoppingCart newShoppingCart = new ShoppingCart();
            session.setAttribute("shoppingCart", newShoppingCart);
        %>
        <h1>Your order has been placed ! Click <a href="index.jsp">here </a>for keep shopping....</h1>
    </body>
</html>
