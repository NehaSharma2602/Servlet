package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Entity.Employee;
import model.dao.EmployeeDao;

@WebServlet("/loginValidate")
public class LoginValidateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		
		EmployeeDao dao = new EmployeeDao();
		
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setPassword(password);
		
		if(role.equals("admin")) {
			
			// for validating admin
			if(dao.adminValidate(emp)) {
				HttpSession session = req.getSession();
				session.setAttribute("email", email);
				
				req.setAttribute("msg", "login success");
				
				RequestDispatcher rd = req.getRequestDispatcher("admin_dashboard");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("msg", "invalid email or password");
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);;
				
				
			}
		}
		
	}
}
