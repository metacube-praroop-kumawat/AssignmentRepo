/*******************************************************************************************************
* @classname: Payroll
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         function to print salary slip and calculate tax
********************************************************************************************************/

package com.Example.Company;

public class Payroll {
	
	private static float taxRate = 0.18f;
	public int calculateTax(Employee employee, Department department) {
		Employee e;
		for (Integer key : department.employeeData.keySet()) {
			if (key == employee.id) {
				e = department.employeeData.get(key);
			}
		}
		int tax = (int) ((employee.getCompenstaion()*12)*taxRate);
		System.out.print("Salary slip of employee " + employee.id 
				+ " is :-" + "\n" + " Salary:- " 
				+ employee.getbasicSalaray() + "\n" 
				+ " Bonus:- " 
				+ employee.getBonus() + "\n" 
				+ " Compensation:- " 
				+ employee.getCompenstaion() + '\n' 
				+"Deducted tax:-" + tax/12);
		return tax;
	}
}
