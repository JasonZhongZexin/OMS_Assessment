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
    <header>
        <nav class="nav">
                <div align="right" margin-left="200px">
                    <a href = "index.jsp">Index page</a>
                    <a href = "register.jsp">Register</a>
                </div>
            </nav>
    </header>
    <body>
        
        <%
            String error = request.getParameter("error");
            String emailErr = request.getParameter("emailErr");
        %>
        <h1>Enter your details to login: <span class="error"><c:if test="${existErr!=null}"><span class="error"><c:out value="${existErr}"/></span></c:if></span></h1>
            <form action="loginAction.jsp" method="post">
                <table>                
                    <tr><td>Username</td><td><input type="text" name="email" placeholder="Email"><span class="error"><c:if test="${emailErr!=null}"><span class="error"><c:out value="${emailErr}"/></span></c:if></span></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" placeholder="password"></td></tr>                
                    <tr><td><input type="hidden" value="submitted" name="submitted"></td>
                        <td><input type="submit" value="Sign In"> 
                        </td>
                    </tr>
                </table>
            </form>
        <%
            if (request.getParameter("submitted") != null) {

                emailErr=error = null;
            }

            session.invalidate();

        %>
    </body>
</html>