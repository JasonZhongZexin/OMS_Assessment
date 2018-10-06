<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="uts.wsd.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
         <link rel="stylesheet" href="OMS.css"> 
        <title>Account page</title>
    </head>
    <body>
        <a href="main.jsp">Main</a>&nbsp;
        <a href="logout.jsp">Logout</a><br><br>
        <%
            User user = (User) session.getAttribute("userLogin");
            if (user != null) {%>


        <form action="accountAction.jsp">
            <input type="hidden" name="sub" value="save">
            <center>
            <table>
                <tr>
                    <td>Full Name </td>
                    <td><input type="text" name="fullname" value="<%=user.getFullName()%>"> </td>
                </tr>
                <tr>
                    <td>Email</td>  
                    <td><input type="text" value="<%=user.getEmail()%>" readonly="readonly" name="email"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input name="password" type="password" value="<%=user.getPassword()%>"></td>
                </tr>
                <tr>
                    <td>Phone number</td> 
                    <td><input name="phonenumber" type="tel" value="<%=user.getPhoneNumber()%>"></td>
                </tr>
                <tr>
                    <td>Address</td>  
                    <td><input name="address" type="text" value="<%=user.getAddress()%>"></td>
                </tr>
                <tr>
                    
                    <td align="center" colspan="2"><input type="submit" value="save">&nbsp;</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="button" value="Remove account" onclick="window.location.href = 'accountAcction.jsp?sub=canceled'"></td>
                </tr>
            </table>
            </center>
            <% }%>

        </form>

    </body>
</html>