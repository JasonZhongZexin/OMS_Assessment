<%-- 
    Document   : main
    Created on : 12/09/2018, 10:09:42 PM
    Author     : Zexin Zhong
--%>

<%@page import="uts.wsd.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<?xml-stylesheet type="text/xsl" href="xsl/history.xsl"?>

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
            if (user != null) {%>
        <header>
            <nav class="nav">
                <ul>
                    <li><a href = "index.jsp">Home</a></li>
                    <li><a href = "main.jsp">My History</a></li>
                </ul>
                <div align="right" margin-left="200px">
                    <a href = "account.jsp">Edit account details </a>
                    &nbsp; 
                    <a href = "logout.jsp">Logout</a>
                </div>
            </nav>
        </header>
        <%
            ArrayList<Order> orders = orderApp.getUserOrder(user);
            History history = orderApp.getHistory();%>
        <h1>Welcome, <%=user.getFullName()%>!</h1>
    <center>
        <h2>Your Orders</h2>
        <%
            if (orders.size() > 0) {%>
        <c:set var = "xmltext">
            <history>
                <%
                    for (Order order : orders) {
                %>
                <order>
                    <ID><%=order.getID()%></ID>
                    <paymentMethod><%=order.getPaymentMethod()%></paymentMethod>
                    <saleTotal><%=order.getSaleTotal()%></saleTotal>
                    <status><%=order.getStatus()%></status>
                </order>
                <%
                    }
                %>
            </history>
        </c:set>
        <c:import url = "//WEB-INF/history.xsl" var = "xslt"/>
        <x:transform xml = "${xmltext}" xslt = "${xslt}"></x:transform>
        <% orders = null;
        } else {%>
        <p>You have not place any order!</p>
        <%}%>
    </center>
    <%} else {%>
    <header>
        <nav class="nav">
            <ul>
                <li><a href = "index.jsp">Home</a></li>
                <li><a href = "main.jsp">My History</a></li>
            </ul>
            <div align="right" margin-left="200px">
                <a href = "login.jsp">Login</a>
                &nbsp; 
                <a href = "register.jsp">Register</a>
            </div>
        </nav>
    </header>
    <h1>You are not login to the system! Please click <a href="login.jsp">here </a>to login....</h1>
    <%
        }
    %>
</body>
</html>
