package com.Example.Company;
/*******************************************************************************************************
* @classname: Employee
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         defining abstract methods for Employee
********************************************************************************************************/
public abstract class Employee {
	int id;
	public Employee(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	abstract int getbasicSalaray();
	abstract int getBonus();
	abstract int getCompenstaion();
}
