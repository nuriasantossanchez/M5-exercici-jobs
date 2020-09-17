package com.jobs.domain;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {

		totalPaid=paymentRate.pay(salaryPerMonth);
	}

	@Override
	public String toString(){
		char saltoLinea='\n';
		String employeeToString= Character.toString(saltoLinea)
				.concat(Integer.toString(this.id)).concat(Character.toString(saltoLinea))
				.concat(this.name).concat(Character.toString(saltoLinea))
				.concat(this.address).concat(Character.toString(saltoLinea))
				.concat(this.phone).concat(Character.toString(saltoLinea))
				.concat(Double.toString(this.salaryPerMonth)).concat(Character.toString(saltoLinea))
				.concat(Double.toString(this.totalPaid)).concat(Character.toString(saltoLinea));
		return employeeToString;
	}

}
