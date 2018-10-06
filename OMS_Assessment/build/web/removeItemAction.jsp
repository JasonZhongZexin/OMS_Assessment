<%-- 
    Document   : removeItemAction
    Created on : 06/10/2018, 12:30:06 AM
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
    <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
        <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
        <jsp:getProperty name="shoppingCartApp" property="shoppingCart"/>
    </jsp:useBean>
    <body>
        <%
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            String title = request.getParameter("removeItem");
            shoppingCart.removeItem(title);
            response.sendRedirect("checkOut.jsp");
        %>
    </body>
</html>
