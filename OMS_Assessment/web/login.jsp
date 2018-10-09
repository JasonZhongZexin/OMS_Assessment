<%-- 
    Document   : login
    Created on : 12/09/2018, 9:35:58 PM
    Author     : Zexin Zhong
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>OMS Login Page</title>
    </head>
    <!--header, display the navigation bar-->
    <header>
        <nav class="nav">
            <div align="right" margin-left="200px">
                <a href = "index.jsp">Index page</a>
                &nbsp; 
                <a href = "register.jsp">Register</a>
            </div>
        </nav>
    </header>
    <body>
        <%
            //get the error message from the session
            String passwordErr = (String)session.getAttribute("passwordErr");
            String emailErr = (String)session.getAttribute("emailErr");
            String existErr = (String) session.getAttribute("existErr");
        %>
        <h1 align="center">Enter your details to login:<%=(existErr != null ? existErr : "")%></h1>
        <%session.setAttribute("existErr", null);%>
        <!-- display the login form-->
            <form action="loginAction.jsp" method="post">
                <table align="center">                
                    <tr><td>Username</td><td><input type="text" name="email" placeholder="Email" required><%=(emailErr != null ? emailErr : "")%></td></tr><%session.setAttribute("emailErr", null);%>
                    <tr><td>Password</td><td><input type="password" name="password" placeholder="password"required><%=(passwordErr != null ? passwordErr : "")%></td></tr><%session.setAttribute("passwordErr", null);%>                
                    <tr><td><input type="hidden" value="submitted" name="submitted"></td>
                        <td><input type="submit" value="Sign In"> 
                        </td>
                    </tr>
                </table>
            </form>
    <%
        if (request.getParameter("submitted") != null) {
            emailErr=existErr = passwordErr = null;
        }
    %>
</body>
</html>