<%-- 
    Document   : removeItemAction
    Created on : 06/10/2018, 12:30:06 AM
    Author     : Zexin Zhong
--%>

<%@page import="uts.wsd.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
        <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
        <jsp:getProperty name="shoppingCartApp" property="shoppingCart"/>
    </jsp:useBean>
    <body>
        <%
            //get the shopping cart from the session
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            
            //get the movie title that user choose to remove from the request parameter
            String title = request.getParameter("removeItem");
            
            // remove the item from the shopping cart
            shoppingCart.removeItem(title);
            //send back to checkout page
            response.sendRedirect("checkOut.jsp");
        %>
    </body>
</html>
