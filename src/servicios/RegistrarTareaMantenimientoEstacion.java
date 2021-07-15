package servicios;

import java.time.LocalDate;

import bdd.EstacionesRepo;
import excepciones.EstacionEnMantenimientoException;
import excepciones.FechaFinMenorFechaInicioException;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.TareaMantenimiento;

public class RegistrarTareaMantenimientoEstacion {

	public TareaMantenimiento RegistrarTareaManteminiento(Estacion estacion, LocalDate fechaInicio, LocalDate fechaFin, String observaciones) throws EstacionEnMantenimientoException, FechaFinMenorFechaInicioException {
		
		Estacion est = EstacionesRepo.ObtenerEstacion(estacion.getId());
		
		if(est.getEstado() == EstadoEstacionEnum.MANTENIMIENTO)
			throw new EstacionEnMantenimientoException(estacion);
		
		// La clase TareaMantenimiento no posee referencia a que Estacion corresponde?
		TareaMantenimiento tarea = new TareaMantenimiento(estacion, fechaInicio, fechaFin, observaciones);
		//var tarea = TareaMantenimento.Agregar(tarea, est);
				
		return tarea;

	}

	public void ActualizarTareaMantenimiento(TareaMantenimiento tarea) {
		//TareasMantenimientoRepo.Modificar(tarea);
	}
}
