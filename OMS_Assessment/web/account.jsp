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
            //get the login user form the session
            User user = (User) session.getAttribute("userLogin");
            String editAccountResult = (String) session.getAttribute("editAccountResult");
            if (user != null) {%>


        <h2 align="center"> <%=(editAccountResult != null ? editAccountResult : "")%></h2>
        <%session.setAttribute("editAccountResult", "null");%>
        <!-- account edit form-->
        <form action="accountAction.jsp">
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
                        <td>
                            <input type="submit" value="Save">
                            &nbsp;
                            <button type ="button" onClick="location.href = 'accountAction.jsp?action=cancel'">Cancel</button>
                        </td> 
                    </tr>
                </table>
            </center>
        </form>
        <% } else {%>
        <h1 align = "center">You are not login to the system! Please click <a href="login.jsp">here </a>to login....</h1>
        <%}%>

    </body>
</html>