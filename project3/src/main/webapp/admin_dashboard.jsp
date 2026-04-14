<%@page import="model.Entity.Employee"%>
<%@page import="java.util.List"%>
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
    String mess = (String)request.getAttribute("msg");
    if(mess != null){
        out.print("<h3 style='color:green'>" + mess + "</h3>");
    }
%>

	<a href="#">View Profile</a> | 
	<a href="#">Update Profile</a> | 
	<a href="#">Logout</a>

<hr>
<br>
<a href="add_emp.jsp">Add Employee</a>
<br><br>

<%
    List<Employee> list = (List<Employee>) request.getAttribute("employees");
    if(list != null && !list.isEmpty()){
%>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Actions</th>
    </tr>
<%
        for(Employee emp : list){
%>
    <tr>
        <td><%= emp.getId() %></td>
        <td><%= emp.getName() %></td>
        <td><%= emp.getEmail() %></td>
        <td><%= emp.getPhone() %></td>
        <td>
            <a href="viewProfile?email=<%= emp.getEmail() %>">View</a> |
            <a href="editEmp?email=<%= emp.getEmail() %>">Edit</a> |
            <a href="deleteEmp?id=<%= emp.getId() %>">Delete</a>
        </td>
    </tr>
<%
        }
%>
</table>
<%
    } else {
%>
      <p>No employees found.</p>
<%
    }
%>


</body>
</html>