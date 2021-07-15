package servicios;

import bdd.EstacionesRepo;
import modelo.Estacion;
import modelo.TareaMantenimiento;

public class AltaEstacionServicio {
	public static void AltaEstacion(Estacion estacion, TareaMantenimiento tarea) {
EstacionesRepo.AgregarEstacion(estacion);
	}

	public static void AltaEstacion(Estacion estacion) {
//TODO Alta de nueva estacion con estado ACTIVO
	}
}
