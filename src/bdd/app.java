package bdd;

import java.time.LocalTime;
import java.util.List;

import filtros.EstacionesFiltro;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.Linea;
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
	 est = EstacionesRepo.ObtenerEstacion(1);
	System.out.println(est);
	}

}
