<%-- 
    Document   : Cancel
    Created on : 02/10/2018, 9:20:40 PM
    Author     : zhongzexin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <table border="2">
                <tr>
                    <th>Title</th>
                    <th>Genre</th>
                    <th>Release Year</th>
                    <th>Copies Purchased</th>
                </tr>
                <%
                    if (items.size() > 0) {
                        for (Item item : items) {
                            String title = item.getMovieTitle();
                            String genre = item.getMovieGenre();
                            String releaseDate = item.getReleaseDate();
                            int copiesPurchased = item.getCopiesPurchased();
                %>
                <tr>
                    <td><%=title%></td>
                    <td><%=genre%></td>
                    <td><%=releaseDate%></td>
                    <td><%=copiesPurchased%></td>
                </tr>
                <%
                            session.setAttribute("cancelOrder", order);
                        }
                    }%>
            </table>
            <%}%>
            <input type="submit" value="Cancel Order"/>
        </form>
    </center>
</body>
</html>
