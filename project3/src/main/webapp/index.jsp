<html>
<body>
<h1>Welcome To Employee Management System</h1>
    
    <form action="loginValidate" method="post">
       <label>Email : </label>
       <input type="email"  name="email"><br>
       
       <label>Login as: </label>
       <input type="radio" name="role" value="admin"><label>Admin</label>
       <input type="radio" name="role" value="employee"><label>Employee</label><br>
       
       <label>Password : </label>
       <input type="password" name="password"><br>
       
       <button type="submit" value="login">Login</button>
    
    </form>
    
    <%
       String msg = (String) request.getAttribute("msg");
       if(msg != null){
     %>
     <br>
     <p style="color: red"> <%= msg %></p>  
     <%
       }
     %> 
</body>
</html>
