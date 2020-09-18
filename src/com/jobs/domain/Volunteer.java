package com.jobs.domain;

/*
Clase de la capa de dominio. Extiende a la clase abstracta AbsStaffMember
 */
public class Volunteer extends AbsStaffMember {

	protected String description;

	/*
	Constructor de la clase Volunteer(capa de dominio), extiende a la clase abstracta AbsStaffMember(capa de dominio),
	hace una llamada a su clase padre para inicicalizar nombre, direccion y tlefno y añade una variable
	con la descripcion
	 */
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);

		this.description=description;
	}

	/*
	Al ser un método abstracto heredado, la implementación es obligatoria.

	No modifica el valor de la variable totalPaid=0, heredada de la clase padre,
	lo mantiene a 0 ya que los empleados de tipo voluntario no cobran.
	No añade ninguna funcionalidad, no necesita hacer ningun calculo.
	 */
	@Override
	public void pay() { }

	@Override
	public String toString(){
		char separatorChar='\n';
		String infoStaffMember= super.toString().concat(Character.toString(separatorChar))
				.concat(this.description).concat(Character.toString(separatorChar));
		return infoStaffMember;
	}

}
