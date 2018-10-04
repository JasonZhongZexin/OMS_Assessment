<%-- 
    Document   : checkOut
    Created on : 4-Oct-2018, 04:30:51
    Author     : Zexin Zhong
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="uts.wsd.*" import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Check Out Page</title>
    </head>
    <body>
                <%
            User user = (User) session.getAttribute("userLogin");
            if (user == null) {%>
        <header>
            <nav class="nav">
                <ul>
                    <li><a href = "index.jsp">Home</a></li>
                </ul>
                <div align="right" margin-left="200px">
                    <a href = "login.jsp">Login</a>
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
        <% String filePath = application.getRealPath("WEB-INF/movies.xml");%>
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%= filePath%>"/>
        </jsp:useBean>
        <% String path = application.getRealPath("WEB-INF/history.xml");%>
        <jsp:useBean id="orderApp" class="uts.wsd.OrderApplication" scope="application">
            <jsp:setProperty name="orderApp" property="filePath" value="<%=path%>"/>
        </jsp:useBean>
        <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
            <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
            <jsp:getProperty name="shoppingCartApp" property="shoppingCart"/>
        </jsp:useBean>
        <%
            String title = request.getParameter("movieSelect");
            Movie movie = movieApp.getMovieByTitle(title);
            Item item = new Item();
            item.setMovieTitle(movie.getMovie_title());
            item.setMovieGenre(movie.getMovie_genre());
            item.setMoviePrice(movie.getMovie_price());
            item.setReleaseDate(movie.getMovie_release_date());
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.updateShoppingCart(item);
            session.setAttribute("shoppingCart", shoppingCart);
            response.sendRedirect("test.jsp");
        %>
        <h1>the select movie is <%=movie.getMovie_title()%></h1>
        <h1>the items is <%=shoppingCart.getShoppingCart().size()%></h1>
        <h1>the select movie available copies is <%=movie.getAvailable_copies()%></h1>
    </body>
</html>
