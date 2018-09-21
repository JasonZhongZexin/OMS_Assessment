<%-- 
    Document   : register
    Created on : 12/09/2018, 9:36:10 PM
    Author     : Zexin Zhong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>OMS Register</title>
    </head>
    <body>
        <%
            String error = request.getParameter("error");
        %>
        <h1>Enter your details to create an account: <span class="error"><c:if test="${existErr!=null}"><span class="error"><c:out value="${existErr}"/></span></c:if></span></h1>
            <form action="registerAction.jsp" method="post">
                <table>
                    <tr><td>Full Name</td><td><input type="text" name="fullName" 
                                                     placeholder="full name"></td></tr>
                    <tr><td>Email</td><td><input type="text" name="username" 
                                                 placeholder="username"></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" 
                                                    placeholder="password"></td></tr>
                    <tr><td>Phone number</td><td><input type="text" name="phoneNumber" 
                                                        placeholder="phone number"></td></tr>
                    <tr><td>Address</td><td><input type="text" name="address" 
                                                   placeholder="address"></td></tr>
                    <tr><td><input type="hidden" value="submitted" name="submitted"></td>
                        <td><input type="submit" value="Sign Up"> 
                        </td>
                    </tr>
                </table>
            </form>
        <%
            if (request.getParameter("submitted") != null) {

                error = null;
            }

            session.invalidate();

        %>
    </body>
</html>
