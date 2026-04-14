package model.Entity;

import java.sql.Date;

public class Employee {
	
	private Integer id;
	private String name;
	private String email;
	private Long phone;
	private Date dob;
	private String gender;
	private String[] skills;
	private byte[] image;
	private String department;
	private String password;
	private String role;
	
	public Employee() {
		// Default Constructor
	}

	public Employee(String name, String email, Long phone, Date dob, String gender, String[] skills, byte[] image,
			String department, String password, String role) {

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.skills = skills;
		this.image = image;
		this.department = department;
		this.password = password;
		this.role = role;
	}

	public Employee(Integer id, String name, String email, Long phone, Date dob, String gender, String[] skills,
			byte[] image, String department, String password, String role) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.skills = skills;
		this.image = image;
		this.department = department;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}

