<%-- 
    Document   : Cancel
    Created on : 02/10/2018, 9:20:40 PM
    Author     : Zexin Zhong
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<?xml-stylesheet type="text/xsl" href="xsl/orderItem.xsl"?>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Cancel Page</title>
    </head>
    <body>
        <% String path = application.getRealPath("WEB-INF/history.xml");%>
        <jsp:useBean id="orderApp" class="uts.wsd.OrderApplication" scope="application">
            <jsp:setProperty name="orderApp" property="filePath" value="<%=path%>"/>
        </jsp:useBean>
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
    <center>
        <form action="cancelAction.jsp" method = "post">
            <%
                String ID = request.getParameter("bookingIDSelect");
                Order order = orderApp.getOrderByID(ID);
                ArrayList<Item> items = order.getOrderItems();
                if (order != null) {%>
            <h1>Do you want to cancel your order #<%=ID%>? </h1>
            <c:set var = "xmltext">
                <order>
                    <%
                        if (items.size() > 0) {
                            for (Item item : items) {
                    %>
                    <orderItem>
                        <movieTitle><%=item.getMovieTitle()%></movieTitle>
                        <movieGenre><%=item.getMovieGenre()%></movieGenre>
                        <releaseDate><%=item.getReleaseDate()%></releaseDate>
                        <copiesPurchased><%=item.getCopiesPurchased()%></copiesPurchased>
                    </orderItem>
                    <%
                                session.setAttribute("cancelOrder", order);
                            }
                        }%>
                </order>
            </c:set>
            <c:import url = "//WEB-INF/orderItem.xsl" var = "xslt"/>
            <x:transform xml = "${xmltext}" xslt = "${xslt}"></x:transform>
            <%}%>
            <input type="submit" value="Cancel Order"/>
        </form>
    </center>
</body>
</html>
