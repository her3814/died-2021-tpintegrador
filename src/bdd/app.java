package bdd;

import java.time.LocalTime;
import java.util.List;

import modelo.Estacion;
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
		filtro.id = 12;
		List<Estacion> resultado = EstacionesRepo.ObtenerEstaciones(filtro);
		System.out.println(resultado);

		Estacion est = EstacionesRepo.ObtenerEstacion(2);
		est.ToggleEstado();
		EstacionesRepo.ActualizarEstacion(est);
		
		List<Tramo> tramos = TramosRepo.ObtenerDestinosDesde(est);
		System.out.println(tramos);
		
		Linea linea = new Linea(1);
		List<Tramo> recLin = TramosRepo.ObtenerRecorrido(linea);
		System.out.println(recLin);
		

		System.out.println("---------MENOR DISTANCIA");
		List<Tramo> camino = VenderBoletoServicio.CalcularCaminoMenorDistancia(EstacionesRepo.ObtenerEstacion(1), EstacionesRepo.ObtenerEstacion(4));
		System.out.println(camino);
		System.out.println("Costo: " + TramosFunciones.calcularCostoRecorrido.apply(camino));
		System.out.println("Distancia: " + TramosFunciones.calcularDistanciaRecorrido.apply(camino));
		System.out.println("Duracion: " + TramosFunciones.calcularDuracionRecorrido.apply(camino));
		

		System.out.println("---------MAS BARATO");
		List<Tramo> caminoB = VenderBoletoServicio.CalcularCaminoMasBarato(EstacionesRepo.ObtenerEstacion(1), EstacionesRepo.ObtenerEstacion(4));
		System.out.println(caminoB);
		System.out.println("Costo: " + TramosFunciones.calcularCostoRecorrido.apply(caminoB));
		System.out.println("Distancia: " + TramosFunciones.calcularDistanciaRecorrido.apply(caminoB));
		System.out.println("Duracion: " + TramosFunciones.calcularDuracionRecorrido.apply(caminoB));
		


		System.out.println("---------DESDE A");
		List<List<Tramo>> caminos = VenderBoletoServicio.CalcularCaminos(EstacionesRepo.ObtenerEstacion(1));
		System.out.println(caminos);
		
	}

}
