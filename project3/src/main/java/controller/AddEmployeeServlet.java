package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Entity.Employee;
import model.dao.EmployeeDao;


@WebServlet("/add_emp")
@MultipartConfig

public class AddEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		Long phone = Long.parseLong(req.getParameter("phone"));
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		
		String[] skills = req.getParameterValues("skills");
		Part part = req.getPart("image");
		InputStream is = part.getInputStream();
		String department = req.getParameter("department");
		String role = req.getParameter("role");
		
		Employee emp = new Employee(name, email, phone, null, gender, skills, null, department, department, role);
		
		EmployeeDao  Dao = new EmployeeDao();
		
		boolean result = Dao.addEmployee(emp, is);
		is.close();
		
		PrintWriter pw = resp.getWriter();
		
		resp.setContentType("text/html");
		
		
		if(result) {
//			resp.sendRedirect("add_student.jsp");
			pw.println("add student");
		}
		else{
			pw.println(" unable to add student");
		}
	}
		
		
	}



