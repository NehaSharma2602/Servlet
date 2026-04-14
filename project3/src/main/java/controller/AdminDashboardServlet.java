package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Entity.Employee;
import model.dao.EmployeeDao;

@WebServlet("/admin_dashboard")
public class AdminDashboardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeDao dao = new EmployeeDao();
		
		List<Employee> list = dao.getAllEmployee();
		
		req.setAttribute("employees", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("admin_dashboard.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
