package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.Entity.Employee;

public class EmployeeDao {

	FileInputStream fis;
	Connection con;
	Properties property;
	PreparedStatement ps;
	ResultSet rs;
	Statement stm;
	
	
	public EmployeeDao(){
		
		try {
			fis = new FileInputStream("C:\\Users\\Neha\\OneDrive\\Desktop\\Advance java\\servlet\\project3\\src\\main\\resources\\data.properties");
			property = new Properties();
			property.load(fis);
			
			//Step 1: Load the Driver
			
			String driver = property.getProperty("driver");
			Class.forName(driver);
			
			// Step 2: Establish the Connection
			
			String url =  property.getProperty("url");
			con = DriverManager.getConnection(url,property);
			
//			System.out.println("Connection Done");
			stm = con.createStatement();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean adminValidate(Employee emp) {
		String query = "select * from employee where email = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1,emp.getEmail());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(emp.getPassword()) && rs.getString("role").equalsIgnoreCase("admin")) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	
	public List<Employee> getAllEmployee(){
		List<Employee> data = new ArrayList<>();
		String query = "select * from employee where role != 'admin'";
		
		
		try {
			rs = stm.executeQuery(query);
			
			while(rs.next()) {  // <-- Use while, not do-while
	            Array skillsArray = rs.getArray("skills");
	            String[] skills = skillsArray != null ? (String[]) skillsArray.getArray() : new String[0];

	            Employee emp = new Employee(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("email"),
	                rs.getLong("phone"),
	                rs.getDate("dob"),
	                rs.getString("gender"),
	                skills,
	                rs.getBytes("image"), // make sure column name is correct
	                rs.getString("department"),
	                rs.getString("password"),
	                rs.getString("role")
	            );

	            data.add(emp);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return data;
		
	}
	
	
	public boolean addEmployee(Employee emp, InputStream is) {
		String query = "Insert into employee(name, email, phone, dob, gender, skills,image,department, password,  role) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			
			
			
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail() );
			ps.setLong(3, emp.getPhone());
			ps.setDate(4, emp.getDob());
			ps.setString(5, emp.getGender());
			
			Array skills = con.createArrayOf("varchar", emp.getSkills());
			ps.setArray(6, skills);
			ps.setBinaryStream(7, is);
			ps.setString(8, emp.getDepartment() );
			ps.setString(9, emp.getPassword());
			ps.setString(10, emp.getRole());
			if(ps.executeUpdate()>0) {
				return true;
			}
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Employee getEmployeeByEmail(String email) {
		String query = "select * from employee where email = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				Array skills = rs.getArray("skills");
				String[] nSkills = (String[])skills.getArray();
				return new Employee(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getLong("phone"), 
						rs.getDate("dob"),
						rs.getString("gender"), 
						nSkills,
						rs.getBytes("image"), 
						rs.getString("department"),
						rs.getString("password"), 
						rs.getString("role"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleteEmployeeById(int id) {
	    String query = "DELETE FROM employee WHERE id = ?";
	    try {
	        ps = con.prepareStatement(query);
	        ps.setInt(1, id);
	        return ps.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
