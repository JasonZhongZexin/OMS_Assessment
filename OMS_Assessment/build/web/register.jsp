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
        <header>
            <nav class="nav">
                <div align="right" margin-left="200px">
                    <a href = "index.jsp">Index page</a>
                    <a href = "login.jsp">Login</a>
                </div>
            </nav>
        </header>
        <%
            String nameErr = (String)session.getAttribute("nameErr");
            String emailErr = (String)session.getAttribute("emailErr");
            String passwordErr = (String)session.getAttribute("passwordErr");
            String phoneNumberErr = (String)session.getAttribute("phoneNumberErr");
            String addressErr = (String)session.getAttribute("addressErr");
        %>
        <h1>Enter your details to create an account:</h1>
            <form action="registerAction.jsp" method="post">
                <table>
                    <tr><td>Full Name</td><td><input type="text" name="fullName" 
                                                     placeholder="full name" required><span class="error"><c:if test="${nameErr!=null}"><span class="error"><c:out value="${nameErr}"/></span></c:if></span></td></tr>
                    <tr><td>Email</td><td><input type="text" name="username" 
                                                 placeholder="email address"required><span class="error"><c:if test="${emailErr!=null}"><span class="error"><c:out value="${emailErr}"/></span></c:if></span></td></tr>
                    <tr><td>Password</td><td><input type="password" name="password" 
                                                    placeholder="password" required><span class="error"><c:if test="${passwordErr!=null}"><span class="error"><c:out value="${passwordErr}"/></span></c:if></span></td></tr>
                    <tr><td>Phone number</td><td><input type="text" name="phoneNumber" 
                                                        placeholder="phone number"required><span class="error"><c:if test="${phoneNumberErr!=null}"><span class="error"><c:out value="${phoneNumberErr}"/></span></c:if></span></td></tr>
                    <tr><td>Address</td><td><input type="text" name="address" 
                                                   placeholder="address"required><span class="error"><c:if test="${addressErr!=null}"><span class="error"><c:out value="${addressErr}"/></span></c:if></span></td></tr>
                    <tr><td><input type="hidden" value="submitted" name="submitted"></td>
                        <td><input type="submit" value="Sign Up"> 
                        </td>
                    </tr>
                </table>
            </form>
        <%
            if (request.getParameter("submitted") != null) {

                addressErr = phoneNumberErr=nameErr=emailErr=passwordErr=null;
            }

            session.invalidate();

        %>
    </body>
</html>
