<%-- 
    Document   : index
    Created on : 09/09/2018, 10:24:47 PM
    Author     : Zexin Zhong
--%>

<%@page import="uts.wsd.ShoppingCart"%>
<%@page import="uts.wsd.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.Movie"%>
<%@page import="uts.wsd.Movies"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Index Page</title>
        <% String filePath = application.getRealPath("WEB-INF/movies.xml");%>
    </head>
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
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%= filePath%>"/>
        </jsp:useBean>
        <jsp:useBean id="shoppingCartApp" class="uts.wsd.ShoppingCart" scope="session">
            <jsp:setProperty name="shoppingCartApp" property="shoppingCart"/>
        </jsp:useBean>
    <center>
        <form action="searchAction.jsp">
            <%
                String startDateErr = (String) session.getAttribute("startDateErr");
                String endDateErr = (String) session.getAttribute("endDateErr");
            %>
            <h1><%=(startDateErr != null ? startDateErr : "")%></h1>
            <h1><%=(endDateErr != null ? endDateErr : "")%></h1>
            <%
                session.setAttribute("endDateErr", null);
                session.setAttribute("startDateErr", null);
            %>
            Title: <input type="text" name="title">  
            Genre: <select name="genre">
                <option value="">Search by genre</option>>
                <option value = "Action">Action</option>
                <option value = "Sci-Fi">Sci-Fi</option>
                <option value = "Horror">Horror</option>
                <option value = "Comedy">Comedy</option>
            </select>
            &nbsp;Release Year: <input type="text" name="start_date" placeholder="From">    <input type = "text" name="end_date" placeholder="To">&nbsp;
            <input type="submit" value="submit" class="button">
            <input type="hidden" value="submitted" name="submitted">
        </form>
    </center>
    <%
        Movies movies = movieApp.getMovies();
        if (request.getParameter("submitted") != null) {
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();
            }
            ArrayList<Movie> list = (ArrayList<Movie>) request.getAttribute("search");
            if (list != null && list.size() > 0) {
                movies.printMovies(list, out);
                session.setAttribute("shoppingCart", shoppingCart);
                list = null;
            } else {
                response.sendRedirect("404MovieNoFound.jsp");
            }
        }

    %>
</body>
</html>