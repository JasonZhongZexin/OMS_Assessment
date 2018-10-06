<%@page import="uts.wsd.Users,uts.wsd.User, uts.wsd.Movie, uts.wsd.Movies,uts.wsd.Order,uts.wsd.History, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit Account</title>
</head>
<body>
	<%
		String userFilePath = application.getRealPath("WEB-INF/users.xml");
		String historyFilePath = application.getRealPath("WEB-INF/history.xml");
		String filePath = application.getRealPath("WEB-INF/movies.xml");
	%>
	<jsp:useBean id="UsersApplication" class="uts.wsd.UsersApplication"
		scope="application">
		<jsp:setProperty name="studentApplication" property="filePath"
			value="<%=userFilePath%>" />
	</jsp:useBean>
	
	<jsp:useBean id="MoviesApplication" class="uts.wsd.MoviesApplication"
		scope="application">
		<jsp:setProperty name="tutorApplication" property="filePath"
			value="<%=filePath%>" />
	</jsp:useBean>

	<jsp:useBean id="orderApplication" class="uts.wsd.OrderApplication" 
                     scope="application">
		<jsp:setProperty name="orderApplication" property="filePath"
			value="<%=historyFilePath%>" />
	</jsp:useBean>

<%
	String sub = request.getParameter("sub");

	if ("canceled".equals(sub)) {
		User user = (User)request.getSession().getAttribute("userLogin");
		for (Order order : orderApplication.getHistory().getOrdersByEmail(user.getEmail())) {
			if (order.getFullName().equals(user.getFullName())) {
                                orderApplication.getHistory().changeOrderStatus(order.getID());
                                orderApplication.saveHistory();
			}	
		}
		session.invalidate();
		response.sendRedirect("index.jsp");
	} else {
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
                String phoneNumber = request.getParameter("phoneNumber");
                String address = request.getParameter("address");
		
		if (request.getSession().getAttribute("userLogin") instanceof User) {
			User user = (User)request.getSession().getAttribute("userLogin");
			User u = UsersApplication.getUsers().getUser(user.getEmail());
			u.setFullName(fullName);
			u.setEmail(email);
			u.setPassword(password);
                        u.setPhoneNumber(phoneNumber);
                        u.setAddress(address);
			UsersApplication.updateXML(userFilePath, UsersApplication.getUsers());
			request.getSession().setAttribute("userLogin", u);
		} 
		response.sendRedirect("account.jsp");
	}
%>
</body>
</html>
