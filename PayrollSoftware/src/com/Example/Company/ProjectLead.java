/*******************************************************************************************************
* @classname: ProjectLead
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/11/05         extending Employee class for ProjectLead position
********************************************************************************************************/

package com.Example.Company;

public class ProjectLead extends Employee {

	public ProjectLead(int id) {
		super(id);
	}

	@Override
	int getbasicSalaray() {
		return 80000;
	}

	@Override
	int getBonus() {
		return 15000;
	}

	@Override
	int getCompenstaion() {
		return 95000;
	}
}
