/*******************************************************************************************************
* @classname: Department
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         functions to operate on department 
********************************************************************************************************/

package com.Example.Company;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Department {
	String departmentName;
	//List of employees present in current department
	List<Employee> departmentNameemployeeList = new ArrayList<>();
	HashMap<Integer, Employee> employeeData = new HashMap<>();
	
	public Department(String name) {
		departmentName = name;
	}
	
	/**
	 * function to add a new employee into organization
	 * @param employee who will be added
	 * @return true if employee id not already present and added successfully
	 */
	public boolean join(Employee employee) {
		if(!departmentNameemployeeList.contains(employee)) {
			departmentNameemployeeList.add(employee);
			employeeData.put(employee.id, employee);
			return true;
		}
		return false;
	}
	
	/**
	 * function to remove a existing employee from organization
	 * @param employee who will be removed
	 * @return true if employee is removed successfully
	 */
	public boolean relieve(Employee employee) {
		if(departmentNameemployeeList.contains(employee)) {
			departmentNameemployeeList.remove(employee);
			employeeData.remove(employee.id);
			return true;
		}
		return false;
	}
	
	/**
	 * function to give all employees present in department
	 * @return List of employees 
	 */
	public List<Employee> getAllEmployees(){
		return departmentNameemployeeList;
	}
}