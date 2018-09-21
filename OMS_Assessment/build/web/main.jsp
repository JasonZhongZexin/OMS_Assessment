<%-- 
    Document   : main
    Created on : 12/09/2018, 10:09:42 PM
    Author     : Zexin Zhong
--%>

<%@page import="uts.wsd.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="OMS.css"> 
        <title>Main page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("userLogin");
            String fullName;
            if(user!=null){
                fullName = user.getFullName();
            }else{
            
                fullName="the login user is null";
                
            }
        %>
        
        <h1><%=fullName%></h1>
        
    </body>
</html>
