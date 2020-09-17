package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){

		repository = new EmployeeRepository();
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(boss);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// TODO Auto-generated method stub
		
	}


	public void payAllEmployeers() {
		for(AbsStaffMember member: repository.getAllMembers()){
			member.pay();
		}
	
	}

	public String getAllEmployees() {
		String employess="";
		for(AbsStaffMember member: repository.getAllMembers()){
			employess=employess.concat(member.toString());
		}
		return employess;
	}

	public void createVolunteer(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
