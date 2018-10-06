<%-- 
    Document   : clearShoppingCart
    Created on : 06/10/2018, 12:14:03 AM
    Author     : zhongzexin
--%>

<%@page import="uts.wsd.User"%>
<%@page import="uts.wsd.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
    </head>
    <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
        <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
        <jsp:getProperty name="shoppingCartApp" property="shoppingCart"/>
    </jsp:useBean>
    <body>
        <header>
            <%
                User user = (User) session.getAttribute("userLogin");
                if (user == null) {%>
            <nav class="nav">
                <ul>
                    <li><a href = "index.jsp">Home</a></li>
                </ul>
                <div align="right" margin-left="200px">
                    <a href = "login.jsp">Login</a>
                    &nbsp; 
                    <a href = "register.jsp">Register</a>
                </div>
            </nav>
        </header>
        <%} else {%>
        <header>
            <nav class="nav">
                <ul>
                    <li><a href = "index.jsp">Home</a></li>
                    <li><a href = "main.jsp">My History</a></li>
                </ul>
                <div align="right" margin-left="200px">
                    <a href = "logout.jsp">Logout</a>
                </div>
            </nav>
        </header>
        <%}%>
        <%
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            if (shoppingCart.getShoppingCart().size() > 0) {
                shoppingCart.clearShoppingCart();
            }
        %>
    <center>
        <h1>Your shopping cart has been clear. Click <a href="index.jsp">here</a> to continue...</h1>
    </center>
</body>
</html>
