/*******************************************************************************************************
* @classname: Organization
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         defining operations to add department and get all employees
********************************************************************************************************/

package com.Example.Company;

import java.util.List;
import java.util.ArrayList;

public class Organization {
	String name;
		public Organization(String name) {
			this.name = name;
		}
	//List of departments exists in organization
	List<Department> departmentList = new ArrayList<>();
	//composition
	Department departmentByComposition = null;
	
	/**
	 * function to add a new department to organixation
	 * @param department which we want to add
	 * @return true if department is added successfully
	 */
	public boolean addDepartment(Department department) {
		if (departmentList.contains(department)) {
			System.out.println("Department is already present");
			return false;
		}
		departmentList.add(department);
		System.out.println("Department added successfully");
		return true;
	}
	
	/**
	 * function to get all employees present in organization
	 * @return List of all employees
	 */
	public List<Employee> getAllEmployees(){
		List<Employee> totalEmployees = new ArrayList<>(); 
		for (int i = 0; i < this.departmentList.size(); i++) {
			//composition
			departmentByComposition = departmentList.get(i);
			totalEmployees.addAll(departmentByComposition.getEmployees());
			
		}
		return totalEmployees;
	}
}
