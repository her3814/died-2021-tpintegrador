/**
 * 
 */
package excepciones;

import modelo.Estacion;

public class EstacionEnMantenimientoException extends Exception {
	
	public EstacionEnMantenimientoException(Estacion estacion) {
		super("La estacion " + estacion.getNombre() + " ya se encuentra en mantenimiento.");
	}

}
