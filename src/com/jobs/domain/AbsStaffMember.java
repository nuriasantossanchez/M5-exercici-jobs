package com.jobs.domain;

/*
Clase abstracta de la capa de dominio. La extienden el resto de clases
del modelo de dominio (Employee y Volunteer).
 */
public abstract class AbsStaffMember {

	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;

	private static int COUNTER_MEMBERS = 1;

	public AbsStaffMember(String name, String address, String phone) throws Exception {
		if (name.equals(""))
			throw new Exception();
		if (address.equals(""))
			throw new Exception();
		if (phone.equals(""))
			throw new Exception();

		this.name = name;
		this.address = address;
		this.phone = phone;
		id = COUNTER_MEMBERS;
		COUNTER_MEMBERS++;
	}

	public abstract void pay();


	@Override
	public String toString(){
		char separatorChar='\n';
		String infoStaffMember= Character.toString(separatorChar)
				.concat(Integer.toString(this.id)).concat(Character.toString(separatorChar))
				.concat(this.name).concat(Character.toString(separatorChar))
				.concat(this.address).concat(Character.toString(separatorChar))
				.concat(this.phone).concat(Character.toString(separatorChar))
				.concat("Total pagado: ").concat(Double.toString(this.totalPaid));
		return infoStaffMember;
	}
}
