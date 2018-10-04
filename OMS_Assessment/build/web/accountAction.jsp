
<%@ page import="uts.wsd.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
		String movieFilePath = application.getRealPath("WEB-INF/movie.xml");
	%>
	<jsp:useBean id="usersApplication" class="UsersApplication"
		scope="application">
		<jsp:setProperty name="usersApplication" property="filePath"
			value="<%=userFilePath%>" />
	</jsp:useBean>
        <jsp:useBean id="orderApplication" class="OrderApplication"
		scope="application">
		<jsp:setProperty name="orderApplication" property="filePath"
			value="<%=historyFilePath%>" />
	</jsp:useBean>

	<jsp:useBean id="moviesApplication"
		class="MoviesApplication" scope="application">
		<jsp:setProperty name="moviesApplication" property="filePath"
			value="<%=movieFilePath%>" />
	</jsp:useBean>
        

<%
	String sub= request.getParameter("sub");

	if ("cancelled".equals(sub)) {
		User user = (User)request.getSession().getAttribute("user");
		for (Order order : orderApplication.getHistory().getHistory()) {
			if (order.getFullName().equals(user.getFullName()())) {
				booking.setStatus("cancelled");
				Tutor tutor = tutorApplication.getTutors().getTutorByEmail(booking.getTutorEmail());
				tutor.setStatus("available");
			}	
		}
		bookingApplication.updateXML(bookingApplication.getBookings(), bookingFilePath);
		studentApplication.getStudents().removeStudent(student);
		studentApplication.updateXML(studentApplication.getStudents(), studentFilePath);
		session.invalidate();
		response.sendRedirect("index.jsp");
	} else {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		
		if (request.getSession().getAttribute("user") instanceof Student) {
			Student student = (Student)request.getSession().getAttribute("user");
			Student s = studentApplication.getStudents().getStudentByEmail(student.getEmail());
			s.setBirthday(birthday);
			s.setPassword(password);
			s.setName(name);
			studentApplication.updateXML(studentApplication.getStudents(), studentFilePath);
			request.getSession().setAttribute("user", s);
		} else {
			Tutor tutor = (Tutor)request.getSession().getAttribute("user");
			Tutor t = tutorApplication.getTutors().getTutorByEmail(tutor.getEmail());
			t.setBirthday(birthday);
			t.setName(name);
			t.setPassword(password);
			tutorApplication.updateXML(tutorApplication.getTutors(), filePath);
			request.getSession().setAttribute("user", t);
		}
		
		response.sendRedirect("account.jsp");
	}
%>
</body>
</html>