<%@page import="controller.Validator"%>
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
            //get the input query parameter
            String movie_title = request.getParameter("title");
            String movie_genre = request.getParameter("genre");
            String movie_release_start_date = request.getParameter("start_date");
            String movie_release_end_date = request.getParameter("end_date");

            /**
             * validate the user input. if any input is invalid, return error
             * message to the index page. validate if the input start year or end year range is valid.
             * if the input start date or end year is invalid, send back the error message to the index pag.
             * otherwise, searching movie according to the query parameter and send back the match movies to the index page.
             */
            Validator v = new Validator();
            if (!movie_release_start_date.equals("") && !v.validateYear(movie_release_start_date)) {
                session.setAttribute("startDateErr", "Incorrect searching start year. The correct format should be YYYY.");
                response.sendRedirect("index.jsp");
            } else if (!movie_release_end_date.equals("") && !v.validateYear(movie_release_end_date)) {
                session.setAttribute("endDateErr", "Incorrect searching end year. The correct format should be YYYY.");
                response.sendRedirect("index.jsp");
            } else {
                ArrayList<Movie> list = movieApp.searchMovie(movie_title, movie_genre, movie_release_start_date, movie_release_end_date);
                request.setAttribute("search", list);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
    </body>
</html>
