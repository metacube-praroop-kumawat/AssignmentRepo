/*******************************************************************************************************
* @classname: Payroll
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         function to print salary slip and calculate tax
********************************************************************************************************/

package com.Example.Company;

import java.util.List;
import java.util.ArrayList;

public class Payroll {
	
	private static float taxRate = 0.18f;
	public List<Float> salarySlip(List<Employee> employeeList) {
		int tax = 0;
		List<Float> taxList = new ArrayList<>();
		for (Employee employee : employeeList) {
			tax = (int) ((employee.getCompenstaion()*12)*taxRate);
			System.out.print("\n" + "Salary slip of employee " + employee.id 
					+ " is :-" + "\n" + " Salary:- " 
					+ employee.getbasicSalaray() + "\n" 
					+ " Bonus:- " 
					+ employee.getBonus() + "\n" 
					+ " Compensation:- " 
					+ employee.getCompenstaion() + '\n' 
					+" Deducted tax:-" + tax/12);
			System.out.println();
			taxList.add((float)tax/12);
		}
		
		return taxList;
	}
}
