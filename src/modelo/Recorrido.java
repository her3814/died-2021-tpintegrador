package modelo;

import java.time.LocalTime;

public class Recorrido {
	Estacion origen;
	Estacion destino;
	LocalTime duracionViaje;
	Integer capacidadMax;
	Float costo;
	EstadoRecorridoEnum estado;

	public Recorrido() {

	}
}
