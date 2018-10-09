<%-- 
    Document   : loginAction
    Created on : 14/09/2018, 10:47:28 PM
    Author     : zhongzexin
--%>
<%@page import="controller.Validator"%>
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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = users.login(email, password);
            
            /**
             * validate the user input. if any input is invalid, return error
             * message to the login page. check if the input email is invalidate.
             * if the input email format or password format is invalidate, send the error 
             * message to the login page. check if the input email and password is correct.
             * if email and password is corret and user are login to the system, navigate to 
             * the main page. otherwise, send back the login fail message to the login page.
             */
            Validator v = new Validator();
            if(!v.validateEmail(email)){
                session.setAttribute("emailErr", "Email format is incorrect!");
                response.sendRedirect("login.jsp");
            }else if(!v.validatePassword(password)){
                session.setAttribute("passwordErr", "Password format is incorrect!");
                response.sendRedirect("login.jsp");
            }else if (user != null) {
                session.setAttribute("userLogin", user);
                response.sendRedirect("main.jsp");                        
            }
            else{
                session.setAttribute("existErr", "User profile does not exist or incorrect password and username !");
                response.sendRedirect("login.jsp");                               
            }
        %>
    </body>
</html>