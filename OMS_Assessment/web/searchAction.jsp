<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Search Action page</title>
    </head>
    <body>
        <% String filepath = application.getRealPath("WEB-INF/movies.xml");%>
        <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
            <jsp:setProperty name="movieApp" property="filePath" value="<%=filepath%>"/>
        </jsp:useBean>
        
        
        <%
	String movie_title = request.getParameter("title");
	String movie_genre = request.getParameter("genre");
	String movie_release_start_date = request.getParameter("start_date");
        String movie_release_end_date = request.getParameter("end_date");

        List<Movie> list = movieApp.searchMovie(movie_title,movie_genre,movie_release_start_date,movie_release_end_date);
	request.setAttribute("search", list);
	request.getRequestDispatcher("index.jsp").forward(request, response);
        %>
    </body>
</html>
