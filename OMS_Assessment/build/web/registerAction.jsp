<%-- 
    Document   : registerAction
    Created on : 21/09/2018, 10:10:12 PM
    Author     : zhongzexin
--%>

<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Login Action Page</title>
    </head>
    <body>
        <% String usersPath = application.getRealPath("WEB-INF/users.xml");%>
        <jsp:useBean id="userApp" class="uts.wsd.UsersApplication" scope="application">
            <jsp:setProperty name="userApp" property="filePath" value="<%=usersPath%>"/>
        </jsp:useBean>
        <%
            Users users = userApp.getUsers();
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("username");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            User user = new User();
            user.updateDetails(fullName, email, password, phoneNumber, address);
            User checkUser = userApp.checkUser(email);

            /**
             * check if the input email has been used. if the input email has
             * been used show an error message in the register page, else ,
             * registed the account and launch to the index page.
             */
            if (checkUser != null) {
                session.setAttribute("existErr", "The input email has been used. Please change your email address.");
                response.sendRedirect("register.jsp");
            } else {
                if (user == null) {
                    session.setAttribute("existErr", "Register account fail! Please double check your register detial!");
                    response.sendRedirect("register.jsp");
                } else {
                    userApp.addUser(user);
                    userApp.saveUsers();
                    session.setAttribute("userLogin", user);
                    response.sendRedirect("main.jsp");
                    
                }
            }
        %>
    </body>
</html>
