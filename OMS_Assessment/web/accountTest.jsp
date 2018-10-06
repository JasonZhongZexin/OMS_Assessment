<%@page import="java.util.ArrayList"%>
<%@page import="controller.Validator"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="uts.wsd.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="OMS.css">
        <title>Account page</title>
    </head>
         <%
		String usersFilePath = application.getRealPath("WEB-INF/users.xml");
		String historyFilePath = application.getRealPath("WEB-INF/history.xml");
		String filePath = application.getRealPath("WEB-INF/movies.xml");
	%>
        	<jsp:useBean id="usersApp" class="uts.wsd.UsersApplication"
		scope="application">
		<jsp:setProperty name="studentApplication" property="filePath"
			value="<%=usersFilePath%>" />
	</jsp:useBean>
	
	<jsp:useBean id="moviesApp" class="uts.wsd.MoviesApplication"
		scope="application">
		<jsp:setProperty name="tutorApplication" property="filePath"
			value="<%=filePath%>" />
	</jsp:useBean>

	<jsp:useBean id="orderApp" class="uts.wsd.OrderApplication" 
                     scope="application">
		<jsp:setProperty name="orderApplication" property="filePath"
			value="<%=historyFilePath%>" />
	</jsp:useBean>
                
        <%Movies movies = moviesApp.getMovies();%>
        <%Users users = usersApp.getUsers();%>
        <%Order order= orderApp.getHistory().getOrders();%>
        
        <%

            Movie movie = (Movie) session.getAttribute("movie");
            User user = (User) session.getAttribute("user");
            Validator validator = new Validator();
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phoneNumber");
            String address = request.getParameter("address");
            
            if ( user != null && students.exist(student) && validator.edit(fullName, email, password, phoneNumber, address)) {
                 usersApp.editUsers(user, fullName, email, password, phoneNumber, address);
        
          }%>
        <%
            String log = "";
            String type = "";
            if (user != null) {
                log = " &lt " + user.getFullName() + " &gt";
            } else {
                log = " &lt " + " Unkonwn User " + " &gt";
            }
        %>
        <h2 class="header"><%=type%> Account</h2>
        <table class="main_table" >
            <tr ><td align="right" class="log" >You are logged in as  <%=log%></td></tr>
            <tr><td align="right"><u><a  class="link" href="booking.jsp">Bookings</a></u> &emsp;<u><a  class="link" href="main.jsp">Main</a></u> &emsp; <u><a class="link" href="logout.jsp">Logout</a></u>&emsp; </td></tr>            
        </table> 
        <h1 class="small_header">Account Details:</h1>   
        <%
            String cancel = request.getParameter("cancel");
            String edit = request.getParameter("edit");
            String action = "";
            if (cancel != null && edit == null) {
                if(student!=null) {
                    students.removeStudent(student);
                    studentApp.updateXML(students, studentPath);
                    ArrayList<Booking> studentBookings = bookings.getUserBookings(bookings.getList(), student.getName());
                    tutors.resetTutors(studentBookings, student.getName());
                    tutorApp.updateXML(tutors, tutorPath);
                    bookings.resetBookings(studentBookings);
                    bookingApp.updateXML(bookings, bookingsPath);
                } 
                action = "logout.jsp";
                response.sendRedirect(action);
            } else if (edit != null && cancel == null) {
                action = "edit_user.jsp";
                response.sendRedirect(action);
            }
        %>       
        <div class="div_form">          
            <form class="form" action="<%=action%>" method="POST">
                <table class="table_register">                
                    <tr><td>Full name:</td><td><input style="width:250px;" type="text" value="${student!=null ? student.getName() : tutor.getName()}" name="name" required><span class="validity" ></span></td></tr>
                    <tr><td>Password:</td><td><input style="width:250px;" type="password" value="${student!=null ? student.getEmail() : tutor.getEmail()}" name="password" required><span class="validity" ></span></td></tr>               
                    <tr><td>D.O.B.</td><td><input style="width:250px;" type="date" value="${student!=null ? student.getDob() : tutor.getDob()}" name="dob" min="1970-01-01" max="2000-01-01" required ><span class="validity" ></span></td></tr>
                    <tr><td></td><td><input class="button" type="submit" value=" Update " name="edit" > &emsp; <input class="button" type="submit" value="Cancel Account" name="cancel" ></td></tr>
                </table>                  
            </form>            
        </div>
    </body>
</html>