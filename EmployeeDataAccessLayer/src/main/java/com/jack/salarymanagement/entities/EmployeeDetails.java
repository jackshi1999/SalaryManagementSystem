package com.jack.salarymanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "employeeid", unique = true)
	private Integer employeeid;
	@Column(name = "name")
	private String name;
	@Column(name = "mail")
	private String mail;
	@Column(name = "phno")
	private String phno;
	@Column(name = "location")
	private String location;
	@Column(name = "pan")
	private String pan;
	@Column(name = "bankacc")
	private String bankacc;

	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(Integer employeeid, String name, String mail, String phno, String location, String pan,
			String bankacc) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.mail = mail;
		this.phno = phno;
		this.location = location;
		this.pan = pan;
		this.bankacc = bankacc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getBankacc() {
		return bankacc;
	}

	public void setBankacc(String bankacc) {
		this.bankacc = bankacc;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", employeeid=" + employeeid + ", name=" + name + ", mail=" + mail
				+ ", phno=" + phno + ", location=" + location + ", pan=" + pan + ", bankacc=" + bankacc + "]";
	}

}
