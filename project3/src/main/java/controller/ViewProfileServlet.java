package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Entity.Employee;
import model.dao.EmployeeDao;

@WebServlet("/viewProfile")
public class ViewProfileServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		
		EmployeeDao dao = new EmployeeDao();
		
		Employee emp = dao.getEmployeeByEmail(email);
		req.setAttribute("employee", emp);
		
		RequestDispatcher rd  = req.getRequestDispatcher("view_profile.jsp");
		rd.forward(req, resp);
	}
}
