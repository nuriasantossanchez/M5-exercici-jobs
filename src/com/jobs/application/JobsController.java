package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

/*
Clase de la capa de aplicacion.
Crea los objetos de la capa de dominio y los añade a la capa de persistencia
 */
public class JobsController {

    private EmployeeRepository repository;

    public JobsController() {
		/*
			En el constructor de la clase JobsController(capa de Aplicacion)
			se instancia la clase EmployeeRepository(capa de Persistencia),
			el objeto repository puede acceder a los metodos de su clase
		 */
        repository = new EmployeeRepository();
    }
    /*
        Crea el objeto boss de tipo Employee(capa de Dominio) y lo añade al repository(capa de Persistencia)
        llamanado al metodo addMenber de la clase EmployeeRepository.
     */

    public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
        Employee boss = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateBoss());
        repository.addMember(boss);
    }

    /*
        Crea el objeto employee de tipo Employee(capa de Dominio). En el constructor del objeto
        le pasa una referencia a la interfaz IPaymentRate con los calculos adecuados al tipo de empleado.

        De estos calculos se encarga la clase PaymentFactory(capa de aplicación), que encapsula, en la
        implementacion de la interfaz instanciada, el calculo del pago del empleado en función del
        tipo de empleado (clase experta).

        Añade el objeto creado al repository(capa de Persistencia) llamanado al metodo addMenber de la
        clase EmployeeRepository.

        El método addMenber recibe como parámetro el objeto a añadir, de tipo AbsStaffMember.
        Todas las clases del dominio(Employee y Volunteer) heredan de la clase abstracta AbsStaffMember,
        por lo que el parámetro pasado al método permite(y obliga) cualquier implementación concreta/hija
        de la clase abstracta AbsStaffMember.
     */
    public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
        Employee employee = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
        repository.addMember(employee);
    }

    /*
        Crea el objeto manager de tipo Employee(capa de Dominio) y lo añade al repository(capa de Persistencia)
        llamanado al metodo addMenber de la clase EmployeeRepository.
     */
    public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception {
        Employee manager = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
        repository.addMember(manager);

    }
    /*
        Crea el objeto volunteer de tipo Volunteer(capa de Dominio) y lo añade al repository(capa de Persistencia)
        llamanado al metodo addMenber de la clase EmployeeRepository.
     */
    public void createVolunteer(String name, String address, String phone, String description) throws Exception {
        Volunteer volunteer = new Volunteer(name, address, phone, description);
        repository.addMember(volunteer);
    }

    /*
        Recupera todos los objetos añadidos al repository de empleados y
        llama al método pay de cada objeto.

        Todos los objetos añadidos al repository extienden a la clase abstracta AbsStaffMember,
        al ser hijos de AbsStaffMember la llamada al método repository.getAllMembers() devuelve
        una lista formada por todos los objetos hijos que heredan/extienden al padre
        Cada hijo sobreescribe el método abstracto pay heredado del padre.

     */
    public void payAllEmployeers() {
        for (AbsStaffMember staffMember : repository.getAllMembers()) {
            staffMember.pay();
        }

    }

    /*
        Recupera todos los objetos añadidos al repository de empleados y
        llama al método toString() sobreescrito en la clase abstracta AbsStaffMember,
        que heredan el resto de clases del dominio que la extienden (Employee y Volunteer)
        y que tambien lo sobreescriben para añadir funcinalidad.
     */
    public String getAllEmployees() {
        String infoEmployees = "";
        for (AbsStaffMember staffMember : repository.getAllMembers()) {
            infoEmployees = infoEmployees.concat(staffMember.toString());
        }
        return infoEmployees;
    }

}
