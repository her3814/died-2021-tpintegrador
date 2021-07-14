package bdd;

import java.time.LocalTime;

import modelo.Linea;
import modelo.TramosFunciones;
import servicios.VenderBoletoServicio;

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
		
		var tramos = TramosRepo.ObtenerDestinosDesde(est);
		System.out.println(tramos);
		
		var linea = new Linea(1);
		var recLin = TramosRepo.ObtenerRecorrido(linea);
		System.out.println(recLin);
		

		System.out.println("---------MENOR DISTANCIA");
		var camino = VenderBoletoServicio.CalcularCaminoMenorDistancia(EstacionesRepo.ObtenerEstacion(1), EstacionesRepo.ObtenerEstacion(4));
		System.out.println(camino);
		System.out.println("Costo: " + TramosFunciones.calcularCostoRecorrido.apply(camino));
		System.out.println("Distancia: " + TramosFunciones.calcularDistanciaRecorrido.apply(camino));
		System.out.println("Duracion: " + TramosFunciones.calcularDuracionRecorrido.apply(camino));
		

		System.out.println("---------MAS BARATO");
		var caminoB = VenderBoletoServicio.CalcularCaminoMasBarato(EstacionesRepo.ObtenerEstacion(1), EstacionesRepo.ObtenerEstacion(4));
		System.out.println(caminoB);
		System.out.println("Costo: " + TramosFunciones.calcularCostoRecorrido.apply(caminoB));
		System.out.println("Distancia: " + TramosFunciones.calcularDistanciaRecorrido.apply(caminoB));
		System.out.println("Duracion: " + TramosFunciones.calcularDuracionRecorrido.apply(caminoB));
		


		System.out.println("---------DESDE A");
		var caminos = VenderBoletoServicio.CalcularCaminos(EstacionesRepo.ObtenerEstacion(1));
		System.out.println(caminos);
		
	}

}
