package bdd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import excepciones.FechaFinMenorFechaInicioException;
import filtros.EstacionesFiltro;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.Linea;
import modelo.TareaMantenimiento;
import modelo.Tramo;
import modelo.TramosFunciones;
import servicios.VenderBoletoServicio;

/* Clase temporal de apoyo para realizar pruebas de funcionamiento de los repositorios y conexiones a BDD. 
 * Deberá ser descartada en futuras versiones del proyecto
 */
public class app {

	public static void main(String[] args) {

		EstacionesFiltro filtro = new EstacionesFiltro();
		filtro.horaAperturaDesde = LocalTime.of(7, 0);
		filtro.horaCierreHasta = LocalTime.of(22, 30);
		filtro.estado = EstadoEstacionEnum.OPERATIVA;
		List<Estacion> resultado = EstacionesRepo.ObtenerEstaciones(filtro);
		System.out.println(resultado);

		Estacion est = EstacionesRepo.ObtenerEstacion(2);
		System.out.println(est);

		var tareas = TareaMantenimientoRepo.Obtener();
		System.out.println(tareas);

		tareas = TareaMantenimientoRepo.Obtener(est);
		System.out.println(tareas);

		var t = tareas.get(0);
		
		TareaMantenimientoRepo.EliminarTareaMantenimiento(t);
	

		tareas = TareaMantenimientoRepo.Obtener(est);
		System.out.println(tareas);
	}

}
