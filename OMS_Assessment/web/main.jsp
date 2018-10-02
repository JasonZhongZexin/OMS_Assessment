<%-- 
    Document   : main
    Created on : 12/09/2018, 10:09:42 PM
    Author     : Zexin Zhong
--%>

<%@page import="uts.wsd.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Main page</title>
    </head>
    <body>
        <% String path = application.getRealPath("WEB-INF/history.xml");%>
        <jsp:useBean id="orderApp" class="uts.wsd.OrderApplication" scope="application">
            <jsp:setProperty name="orderApp" property="filePath" value="<%=path%>"/>
        </jsp:useBean>
        <%
            User user = (User) session.getAttribute("userLogin");
            if (user != null) {
                ArrayList<Order> orders = orderApp.getUserOrder(user);
                History history = orderApp.getHistory();%>
        <h1>Welcome, <%=user.getFullName()%>!</h1>
    <center>
        <h2>Your Orders</h2>
        <form>
            <%
                if (orders.size() > 0) {
                    history.printHistory(orders, out);
                    orders = null;
                } else {%>
            <p>You have not place any order!</p>
            <%}%>
    </center>
    <%} else {%>
    <h1>You are not login to the system! Please click <a href="login.jsp">here </a>to login....</h1>
    <%
        }
    %>

</form>
</body>
</html>
