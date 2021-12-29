package it.company.services;

import java.util.List;

import it.company.pojo.EmployeePojo;


public interface EmployeeService {
	//String Welcome();
	
	EmployeePojo saveEmployee(EmployeePojo employeePojo);
	
	EmployeePojo getEmployee(long empid);
	
	List<EmployeePojo> listEmployee();
	
	List<EmployeePojo> listEmployeeBasedOnSalary(double Amt);
	
	List<EmployeePojo> searchEmployeeBasedOnLetter(String str); 
	
	void update(EmployeePojo employeePojo);
	
	void delete(long empid);
}
