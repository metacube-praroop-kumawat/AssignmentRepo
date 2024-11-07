package com.Example.Company;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PayrollTest {

	@Test
	void salarySlip_whenPassedArrayListOfEmployees_returns() {
		Organization org = new Organization();
		Department SoftwareEngineer = new Department("Software Engineer");
		org.addDepartment(SoftwareEngineer);
		Department HR = new Department("HR");
		org.addDepartment(HR);
		Employee e =  new Developer(0);
		Employee e1 = new ProjectLead(10);
		HR.join(e);
		SoftwareEngineer.join(e1);
		List<Employee> employees = org.getEmployees();
		Payroll payroll = new Payroll();
		
		List<Float> expected = payroll.salarySlip(employees);
		
		List<Float> actual = new ArrayList<>();
		actual.add((float)17100);
		actual.add((float)8100);
		
		assertArrayEquals(expected.toArray(), actual.toArray());
		
	}

}
