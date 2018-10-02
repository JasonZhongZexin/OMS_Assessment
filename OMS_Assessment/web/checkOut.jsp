<%-- 
    Document   : check out
    Created on : 27-Sep-2018, 09:19:51
    Author     : Leo
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="uts.wsd.*" import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Check out</title>
        <style type="text/css">
table{
                    width:60%;
                    }
th, td {
                    padding: 8px;
                    }
th {
                    background-color: #0099FF;
                    color: white;
                    font-weight:bold;
                    }
h2,p{
                    font-family:Arial;
                    sans-serif;
                    text-align:center;
                    width:60%;
                    font-weight:bold;
                    }		
tbody{
                    background-color: white; 
                    font-weight:bold;
                    text-align:center;
                    }		
    </style>
    </head>
    
    <% String moviePath = application.getRealPath("WEB-INF/movies.xml");%>
    <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
        <jsp:setProperty name="movieApp" property="filePath" value="<%=moviePath%>"/>
    </jsp:useBean>
    
    
    
     <%
        //Movie movie = (Movie) session.getAttribute("movieSelect");
        Movies movies = movieApp.getMovies();
        String title = request.getParameter("select");
        ArrayList<Movie> purchases = movies.getMoviesByTitile(title);
    %>
    
    <body>  
            <h1>Shopping cart</h1>  
            <table>
            <%
                for (Movie movie : purchases){    
            %>
            <tr>
                <td>  <%= movie.getMovie_title()%> </td>
                 <td>  <%= movie.getMovie_genre()%> </td>
                  <td>  <%= movie.getMovie_release_date()%> </td>
                   <td>  <%= movie.getMovie_price()%> </td>
                    <td> <%= movie.getAvailable_copies()%>  </td>
            </tr>
             <%}%> 
            
            </table>
             
          
       <button class="button" type="button" onclick="location.href = 'movieShopping.jsp'" >Continue Shopping </button>
        &emsp;
        <button class="button" type="button" onclick="location.href = 'movieShopping.jsp'" >Purchase order </button>
    
    <%
                //Movie moviePurchase = 
                session.setAttribute("moviePurchase", purchases);
    %> 
    
    
    </body>
</html>
