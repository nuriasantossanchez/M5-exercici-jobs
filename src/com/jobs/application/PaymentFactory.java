package com.jobs.application;

import com.jobs.domain.IPaymentRate;

/*
Clase de la capa de aplicación. Clase experta.
Calcula el pago de cada empleado en función del tipo de empleado, haciendo uso del Creator Pattern.

Cada método crea una nueva instancia de la interfaz IPaymentRate(capa de dominio),
en cuya implementación se calcula la tasa de pago personalizada para cada tipo de empleado
 */
public class PaymentFactory {

	/*
	Incrementa el salario de los empleados de tipo Boss en un 50%.

	Devuelve una nueva instancia de la interfaz IPaymentRate(capa de Dominio) donde se
	implementa su metodo pay para calcular el incremento del sueldo
	 */
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}

	/*
	Decrementa el salario de los empleados de tipo Employee en un 15%.

	Devuelve una nueva instancia de la interfaz IPaymentRate(capa de Dominio) donde se
	implementa su metodo pay para calcular el decremento del sueldo
	 */
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*0.85;
			}
		};
	}

	/*
	Incrementa el salario de los empleados de tipo Manager en un 10%.

	Devuelve una nueva instancia de la interfaz IPaymentRate(capa de Dominio) donde se
	implementa su metodo pay para calcular el incremento del sueldo
	 */
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1;
			}
		};
	}
}
