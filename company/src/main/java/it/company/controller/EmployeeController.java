package it.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.company.pojo.EmployeePojo;
import it.company.services.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;


	@GetMapping(value = "/")
	public String Welcome() {
		return "CRUD with Springboot REST service";
	}
	
	@PostMapping(value = "/save")
	public EmployeePojo saveEmployee(@RequestBody EmployeePojo employeePojo) {

		employeePojo = employeeService.saveEmployee(employeePojo);

		return employeePojo;
	}

	@GetMapping("getemp/{Empid}")
	public EmployeePojo getEmployee(@PathVariable("Empid") long employeeId) {

		EmployeePojo employeePojo = employeeService.getEmployee(employeeId);

		return employeePojo;
	}

	@GetMapping("api/list")
	public List<EmployeePojo> listEmployee() {

		List<EmployeePojo> listEmployee = employeeService.listEmployee();
		
		return listEmployee;
	}
	
	//list for salary>amount
	@GetMapping("getamt/{Amount}")
	public List<EmployeePojo> listEmployeeBasedOnSalary(@PathVariable("Amount") double Amt) {
		List<EmployeePojo> list = employeeService.listEmployeeBasedOnSalary(Amt);
		return list;
	}
	
	//list for name starting with given string
	@GetMapping("getstr/{str}")
	public List<EmployeePojo> listEmployeeBasedOnLetter(@PathVariable("str") String str){
		List<EmployeePojo> listE = employeeService.searchEmployeeBasedOnLetter(str);
		
		return listE;
	}

	@PostMapping(value = "/update")
	public EmployeePojo updateEmployee(@RequestBody EmployeePojo employeePojo) {

		employeeService.update(employeePojo);
		employeePojo = employeeService.getEmployee(employeePojo.getEmpid());
		return employeePojo;
	}

	@DeleteMapping(value = "/delete/{Empid}")
	public String deleteEmployee(@PathVariable("Empid") long empId) {
		employeeService.delete(empId);
		return "Employee deleted successfully with Employee id: " + empId;
	}

	
}
