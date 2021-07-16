/**
 * 
 */
package excepciones;

import modelo.Estacion;

public class EstacionEnMantenimientoException extends Exception {
	
	private static final long serialVersionUID = 5376230940816081311L;

	public EstacionEnMantenimientoException(Estacion estacion) {
		super("La estacion " + estacion.getNombre() + " ya se encuentra en mantenimiento.");
	}

}
