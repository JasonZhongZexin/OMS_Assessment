<%-- 
    Document   : index
    Created on : 09/09/2018, 10:24:47 PM
    Author     : Zexin Zhong
--%>

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
        <% String moviesPath = application.getRealPath("WEB-INF/movies.xml");%>
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%= moviesPath%>"/>
        </jsp:useBean>
        <header>
            <nav class="nav">
                <ul>
                    <li><a href = "index.jsp">Home</a></li>
                    <li><a href="history.jsp">History</a></li>
                </ul>
                <div align="right" margin-left="200px">
                    <a href = "login.jsp">Login</a>
                    <a href = "register.jsp">Register</a>
                </div>
            </nav>
        </header>
        <form action="index.jsp" method ="post">
            <table>
                <tr><td>Title: </td><td><input type="text" placeholder="Title of Movie" name = "search_bar"></td></tr>
                <tr><td>Genre: </td><td><select>
                            <option value="">Search by genre</option>>
                            <option value = "action">Action</option>
                            <option value = "Sci-Fi">Sci-Fi</option>
                            <option value = "Horror">Horror</option>
                            <option value = "Comedy">Comedy</option>
                        </select></td></tr>
                <tr><td>Release Year: </td><td><input type="text" name="start_date" placeholder="From">    <input type = "text" name="end_date" placeholder="To"></td></tr>
                <tr><td><input type="hidden" value="submitted" name="submitted"></td><td><input class = "button" type="submit" value="Search"></td></tr>
            </table>
        </form>
        <footer>
            
        </footer>
    </body>
</html>
