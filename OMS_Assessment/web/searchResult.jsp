<%-- 
    Document   : searchResult
    Created on : 06/10/2018, 5:02:27 AM
    Author     : Hyein Yu
--%>
<%@page import="uts.wsd.*" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<?xml-stylesheet type="text/xsl" href="xsl/movies.xsl"?>

<% String filePath = application.getRealPath("WEB-INF/movies.xml");%>
<jsp:useBean id="moviesApp" class="uts.wsd.MoviesApplication" scope="application">
    <jsp:setProperty name="moviesApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>

<%Movies movies = moviesApp.getMovies();%>
<%
    String genre = request.getParameter("genre");
    String title = request.getParameter("title");
    String startYear = request.getParameter("startYear");
    String endYear = request.getParameter("endYear");
    List<Movie> list = (List<Movie>) request.getAttribute("search");
    
%>

<!-- XSL transfer the searching result -->
<c:set var = "xmltext"> 
    <movies>
        <%
            for (Movie movie : list) {
        %>
        <movie>
            <title><%= movie.getMovie_title()%></title>
            <genre><%= movie.getMovie_genre()%></genre>
            <relase_date><%= movie.getMovie_release_date()%></relase_date>
            <price><%= movie.getMovie_price()%></price>
            <available_copies><%=movie.getAvailable_copies()%></available_copies>
          
        </movie>
        <%}%>
    </movies>
</c:set>
<c:import url = "//WEB-INF/movies.xsl" var = "xslt"/>
<x:transform xml = "${xmltext}" xslt = "${xslt}"></x:transform>