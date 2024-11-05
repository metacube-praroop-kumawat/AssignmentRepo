package com.Example.Company;

import java.util.List;
import java.util.ArrayList;

public class Department {
	//employeeList is department for example
	String departmentName;
	List<Employee> departmentNameemployeeList = new ArrayList<>();
	
	public Department(String name) {
		departmentName = name;
	}
	
	public boolean join(Employee employee) {
		if(!departmentNameemployeeList.contains(employee)) {
			departmentNameemployeeList.add(employee);
			return true;
		}
		return false;
	}
	
	public boolean relieve(Employee employee) {
		if(departmentNameemployeeList.contains(employee)) {
			departmentNameemployeeList.remove(employee);
			return true;
		}
		return false;
	}
	
	public List<Employee> getAllEmployees(){
		return departmentNameemployeeList;
	}
}
