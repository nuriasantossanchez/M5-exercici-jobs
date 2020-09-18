package com.jobs.domain;

/*
Clase de la capa de dominio. Extiende a la clase abstracta AbsStaffMember
 */
public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	/*
	Constructor de la clase Employee(capa de dominio), extiende a la clase abstracta AbsStaffMember(capa de dominio),
	hace una llamada a su clase padre para inicicalizar nombre, direccion y tlefno y añade el salario
	mensual del empleado y una referencia a la interfaz IPaymentRate(capa de dominio)
	 */
	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	/*
	Implementación del método abstracto pay heredado de la clase extendida AbsStaffMember(capa de dominio)

	Este método utiliza la referencia a la interfaz IPaymentRate(capa de dominio) para llamar al método
	pay de la interfaz, pasándole como parámetro el salario mensual del empleado. El valor devuelto
	sobreescribe el valor la variable totalPaid, heredada de la clase padre.
	 */
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}

	@Override
	public String toString(){
		char separatorChar='\n';
		String infoStaffMember= super.toString().concat(Character.toString(separatorChar))
				.concat("Salario mensual: ").concat(Double.toString(this.salaryPerMonth))
				.concat(Character.toString(separatorChar));
		return infoStaffMember;
	}

}
