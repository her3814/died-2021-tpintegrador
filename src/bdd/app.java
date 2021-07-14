package bdd;

import java.time.LocalTime;

import modelo.Estacion;
import modelo.EstadoEstacionEnum;

/* Clase temporal de apoyo para realizar pruebas de funcionamiento de los repositorios y conexiones a BDD. 
 * Deberá ser descartada en futuras versiones del proyecto
 */
public class app {

	public static void main(String[] args) {

		var filtro = new EstacionesFiltro();
		filtro.horaAperturaDesde = LocalTime.of(7, 0);
		filtro.horaCierreHasta = LocalTime.of(22, 30);
		filtro.id = 12;
		var resultado = EstacionesRepo.ObtenerEstaciones(filtro);
		System.out.println(resultado);

		var est = EstacionesRepo.ObtenerEstacion(2);
		est.ToggleEstado();
		EstacionesRepo.ActualizarEstacion(est);
	}

}
