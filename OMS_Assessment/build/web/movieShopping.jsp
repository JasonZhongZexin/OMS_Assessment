<%-- 
    Document   : movieShopping
    Created on : 29-Sep-2018, 12:29:19
    Author     : Leo
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="uts.wsd.*" import="java.util.*" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Movie Shopping</title>
    </head>
    <body>
         <% String moviePath = application.getRealPath("WEB-INF/movies.xml");%>
    <jsp:useBean id="movieApp" class="uts.wsd.MoviesApplication" scope="application">
        <jsp:setProperty name="movieApp" property="filePath" value="<%=moviePath%>"/>
    </jsp:useBean>
        <%
        
        
        %>
        <h2>Movie list</h2>
        <c:import url="WEB-INF/movies.xml"
                  var="inputDoc" />

        <c:import url="WEB-INF/movies.xsl"
                  var="stylesheet" />

        <x:transform xml  = "${inputDoc}" xslt = "${stylesheet}"/>
        
        <form action="checkOut.jsp" method="post">
        <table>
                <tr>
                    <td>Type what you want to Purchase</td><td><input size="23" type="text" name="select"></td>
                    <td>Then click Order now</td><td> <input class="button" type="submit" value="Order now"> </td>
                </tr>
        </table>
        </form>
        <%
            
        %>
    </body>
</html>
