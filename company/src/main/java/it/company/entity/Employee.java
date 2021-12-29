package it.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="Employee")
public class Employee {
	@Id
	@Column(name = "empId")
	@SequenceGenerator(name = "empid_gen", sequenceName = "empid", initialValue = 60001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empid_gen")
	long empid;
	@Column(name="empName")
	String empName;
	@Column(name="salary")
	double salary;
	@Column(name="contactNo")
	String contactNo;

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
