package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;

public class EmployeeRepository {

	private static List<AbsStaffMember> members=new ArrayList<>();
	
	public EmployeeRepository(){
		
	}

	/*
		Devuleve un listado de objetos de tipo AbsStaffMember, al ser una clase abstracta,
		devuelve un listado de objetos del tipo de las clases hijas que la extienden.
	 */
	public List<AbsStaffMember> getAllMembers(){
		return new ArrayList<>(members);
	}
	
	/*
		Añade elementos a una lista de objetos de tipo AbsStaffMember.
		Recibe como parámetro el objeto a añadir, de tipo AbsStaffMember.

		AbsStaffMember es una clase abstracta a la que extienden el resto de clases del Dominio
		(Employee y Volunteer), por lo tanto el listado estará formado por objetos de las clases hijo.
	 */
	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
	
}
