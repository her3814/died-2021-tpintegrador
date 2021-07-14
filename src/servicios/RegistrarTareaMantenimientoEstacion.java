package servicios;

import java.time.LocalDate;

import bdd.EstacionesRepo;
import excepciones.EstacionEnMantenimientoException;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.TareaMantenimiento;

public class RegistrarTareaMantenimientoEstacion {

	public TareaMantenimiento RegistrarTareaManteminiento(Estacion estacion, LocalDate fechaInicio, LocalDate fechaFin, String observaciones) throws EstacionEnMantenimientoException {
		Estacion est = EstacionesRepo.ObtenerEstacion(estacion.getId());
		
		if(est.getEstado() == EstadoEstacionEnum.MANTENIMIENTO)
			throw new EstacionEnMantenimientoException(estacion);
		
		// La clase TareaMantenimiento no posee referencia a que Estacion corresponde?
		TareaMantenimiento tarea = new TareaMantenimiento(fechaInicio, fechaFin, null, observaciones);
		//var tarea = TareaMantenimento.Agregar(tarea, est);
		
		est.ToggleEstado();
		
		//EstacionesRepo.Guardar(est);
		
		return tarea;

	}

	public void ActualizarTareaMantenimiento(TareaMantenimiento tarea) {

	}
}
