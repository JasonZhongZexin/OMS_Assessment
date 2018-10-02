<%-- 
    Document   : index
    Created on : 09/09/2018, 10:24:47 PM
    Author     : Zexin Zhong
--%>

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
    </head>
    <body>

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
    <center>
        <% String filePath = application.getRealPath("WEB-INF/movies.xml");%>
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%= filePath%>"/>
        </jsp:useBean>

        <form action="searchAction.jsp"  >

            &nbsp;Title: <input type="text" name="title">  
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
    <center> <table border="2">
            <%
                if (request.getParameter("submitted") != null) {
                    List<Movie> list = (List<Movie>) request.getAttribute("search");
                    if (list != null && list.size()>0) {%>
            <tr>
                <td>Movie title</td>
                <td>Genre</td>
                <td>Release date</td>
                <td>Price</td>
                <td>Available copies</td>
                <td>Check out</td>
            </tr>
            <%
                for (Movie movie : list) {
            %>
            <tr>
                <td><%=movie.getMovie_title()%></td>
                <td><%=movie.getMovie_genre()%></td>
                <td><%=movie.getMovie_release_date()%></td>
                <td><%=movie.getMovie_price()%></td>
                <td><%=movie.getAvailable_copies()%></td> 
                <td>Check out now</a></td> 

            </tr>   
            <%
                        }
                    } else {
                        response.sendRedirect("404MovieNoFound.jsp");
                    }
                }
            %>


        </table>
    </center>
</body>
</html>