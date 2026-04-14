package controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Entity.Employee;
import model.dao.EmployeeDao;

@WebServlet("/emp_img")
public class EmployeeImageServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("emial");
		
		EmployeeDao dao = new EmployeeDao(); 
		
		Employee emp = dao.getEmployeeByEmail(email);
		
		byte[] img = emp.getImage();
		
		resp.setContentType("image/jpg");
		
		OutputStream os = resp.getOutputStream();
		os.write(img);
		os.close();
	}
}

	
