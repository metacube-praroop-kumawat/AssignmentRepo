package com.Example.Company;

import java.util.List;
import java.util.ArrayList;

public class Organization {
	List<Department> departmentList = new ArrayList<>();
	Department departmentByComposition = null;
	
//	public Organization(List<Department> departmentList) {
//		for (int i = 0; i < departmentList.size(); i++) {
//			this.departmentList.add(departmentList.get(i));
//		}
//	}
	
	public boolean addDepartment(Department department) {
		if (departmentList.contains(department)) {
			return false;
		}
		departmentList.add(department);
		return true;
	}
	
	public List<Employee> getEmployees(){
		List<Employee> totalEmployees = new ArrayList<>(); 
		for (int i = 0; i < this.departmentList.size(); i++) {
			//composition
			departmentByComposition = departmentList.get(i);
			totalEmployees= departmentByComposition.getAllEmployees();
			
		}
		return totalEmployees;
	}
}
