package bdd;

import swing_frame_grafo.TramoMostrarEnum;
import swing_frame_grafo.frame;
import swing_frame_grafo.grafo;

/* Clase temporal de apoyo para realizar pruebas de funcionamiento de los repositorios y conexiones a BDD. 
 * Deberá ser descartada en futuras versiones del proyecto
 */
public class app {

	public static void main(String[] args) {
		var bol = BoletosRepo.ObtenerBoletos();
		System.out.print(bol);
		for(var b : bol) {
			System.out.println(String.format("BOLETO %c - CLIENTE: %s - CORREO: %s - COSTO: $ %f ", b.get_nroBoleto(), b.get_nombreCliente(), b.get_correoCliente(), b.get_costo()));
			for(var t : b.get_tramos()) {
				System.out.println("\t" + t);
				
			}

	//		grafo g = grafo.ObtenerGrafoDesdeRecorrido(b.get_tramos());	
		//	 frame.createFrame(g, TramoMostrarEnum.LINEA);
		}
		
	}

}
