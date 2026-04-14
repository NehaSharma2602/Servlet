<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




<form action="add_emp" method="post" enctype="multipart/form-data">
	
	Upload an image <input type="file" name="image"><br><br>
	Name: <input type="text" name="name"><br><br>
	Email: <input type="email" name="email"><br><br>
	Phone: <input type="tel" name="phone"><br><br>
	Password: <input type="password" name="password"><br><br>
	Date of birth: <input type="date" name="dob"><br><br>
	Gender: <br>
	<input type="radio" name="gender" value="female">Female
	<input type="radio" name="gender" value="male">Male
	<input type="radio" name="gender" value="others">Others
	<br><br>

	Skills: <br>
	<input type="checkbox" name="skills" value="Java Full stack">Java Full Stack <br>
	<input type="checkbox" name="skills" value="Mean stack">Mean stack<br>
	<input type="checkbox" name="skills" value="Devlops">Devlops<br>
	<input type="checkbox" name="skills" value="Manul Testing">Manul Testing<br>
	<input type="checkbox" name="skills" value="Automation Testing">Automation Testing<br><br>
	
	Department: 
	<select name = "department">
		<option value="IT">IT</option>
		<option value="HR">HR</option>
		<option value="Sales">Sales</option>
	
	</select>
	<br><br>
	
	Role: 
	<select name = "role">
		<option value="Admin">Admin</option>
		<option value="Employee">Employee</option>
	</select>
	<br>
	<br>
	
	<input type="submit">
	</form>

</body>
</html>