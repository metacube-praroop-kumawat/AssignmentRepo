/*******************************************************************************************************
* @classname: Main
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         Main class file
********************************************************************************************************/

package com.Example.Company;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Organization org = new Organization();
		Scanner sc = new Scanner(System.in);
		Department SoftwareEngineer = new Department("Software Engineer");
		org.addDepartment(SoftwareEngineer);
		Department HR = new Department("HR");
		org.addDepartment(HR);
//		for (int i = 0; i < org.departmentList.size(); i++) {
//			System.out.println(org.departmentList.get(i).departmentName);
//		}
		Employee e =  new Developer(0);
		Employee e1 = new ProjectLead(10);
		HR.join(e);
		SoftwareEngineer.join(e1);
		List<Employee> newl = org.getEmployees();
//		System.out.print(newl.size());
		Payroll payroll = new Payroll();
		payroll.salarySlip(newl);
		for (int i = 0; i < newl.size(); i++) {
			newl.get(i);
		}
	}
}
