package com.Example.Company;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Organization org = new Organization();
		Scanner sc = Scanner(System.in);
//		org.addDepartment(new Department("Software Engineer"));
//		Department HR = new Department("HR");
//		org.addDepartment(HR);
//		for (int i = 0; i < org.departmentList.size(); i++) {
//			System.out.println(org.departmentList.get(i).departmentName);
//		}
//		Employee e =  new TempClass(0); 
//		HR.join(e);
//		List<Employee> newl = org.getEmployees();
//		//System.out.print(newl.size());
//		for (int i = 0; i < newl.size(); i++) {
//			System.out.println(newl.get(i).getId());
//		}
		System.out.print("1. Add Department" + "\n" + "2.Get all Employees of organization" + "\n" + 
						"");
		int choice = sc.nextInt();
		switch (choice) {
		
	}

}
