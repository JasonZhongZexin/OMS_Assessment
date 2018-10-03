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
                Movies movies = movieApp.getMovies();
                if (request.getParameter("submitted") != null) {
                    ArrayList<Movie> list = (ArrayList<Movie>) request.getAttribute("search");
                    if (list != null && list.size()>0) {
                        movies.printMovies(list, out);
                        list = null;
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