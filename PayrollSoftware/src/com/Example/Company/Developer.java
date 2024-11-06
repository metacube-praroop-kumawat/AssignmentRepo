/*******************************************************************************************************
* @classname: Developer
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         extending Employee class for Developer position
********************************************************************************************************/
package com.Example.Company;

public class Developer extends Employee {

	public Developer(int id) {
		super(id);
	}

	@Override
	int getbasicSalaray() {
		return 40000;
	}

	@Override
	int getBonus() {
		return 5000;
	}

	@Override
	int getCompenstaion() {
		return 45000;
	}
}
