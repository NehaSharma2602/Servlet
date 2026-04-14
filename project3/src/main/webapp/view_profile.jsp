<%@page import="model.Entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<%
	Employee emp = (Employee)request.getAttribute("employee");
	if(emp == null){
	    out.print("<h3>Employee not found!</h3>");
	    return;
	}
	
	%>
	
	<img src="emp_img?email=<%=emp.getEmail() %>" height="100" width="100" alt = "image doesnot exsit">
	
	<h1>Id: <%=emp.getId() %></h1>
	<h1>Name: <%=emp.getName() %></h1>
	<h1>Email: <%=emp.getEmail() %></h1>
	<h1>Phone: <%=emp.getPhone() %></h1>
	<h1>Dob: <%=emp.getDob() %></h1>
	<h1>Role: <%=emp.getRole() %></h1>
	<h1>Department: <%=emp.getDepartment() %></h1>
	<h1>Gender: <%=emp.getGender() %></h1>
	<h1>Skills: </h1>
	
	<ul>
	<%
		for(String s: emp.getSkills()){
			
	%>
		<li><%= s %></li>
	<%
		}
	%>
	
	
	</ul>
</body>
</html>