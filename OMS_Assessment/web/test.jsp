<%-- 
    Document   : test.jsp
    Created on : 04/10/2018, 8:18:27 AM
    Author     : zhongzexin
--%>

<%@page import="uts.wsd.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
            <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
            <jsp:getProperty name="shoppingCartApp" property="shoppingCart"/>
        </jsp:useBean>
        <%
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        %>
        <h1>the items is <%=shoppingCart.getShoppingCart().size()%></h1>
    </body>
</html>
