<%-- 
    Document   : logout
    Created on : 27/09/2018, 2:46:02 AM
    Author     : zhongzexin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>OMS Logout Page</title>
    </head>
    <body>
        <%
            //invalidate all sessions
            session.invalidate();
        %>
        <p>You have been logged out. Click <a class="link" href="index.jsp">here</a> to return to the home page.</p>
    </body>
</html>
