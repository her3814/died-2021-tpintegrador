package modelo;

import java.util.Objects;

public class Tramo {
	
	private Linea _linea;
	private Integer _orden;
	private Estacion _origen;
	private Estacion _destino;
	private Double _duracionViaje;
	private Double _distancia;
	private Integer _cantPasajeros;
	private Double _costo;
	private EstadoTramoEnum _estadoTramo;

	public Tramo(Linea linea, Integer orden, Estacion origen, Estacion destino, Integer cant_pasajeros,
			Double duracion, Double distancia, Double costo, EstadoTramoEnum estado) {
		_linea = linea;
		_orden = orden;
		_origen = origen;
		_destino = destino;
		_duracionViaje = duracion;
		_distancia = distancia;
		_cantPasajeros = cant_pasajeros;
		_costo = costo;
		_estadoTramo = estado;		
	}

	public Estacion getOrigen() {
		return _origen;
	}
	
	public Estacion getDestino() {
		return _destino;
	}

	public Double getCosto() {
		return _costo;
	}

	public Double getDuracion() {
		return _duracionViaje;
	}

	public Double getDistancia() {
		return _distancia;
	}

	public Linea getLinea() {
		return _linea;
	}
	
	public int getOrden() {
		return _orden;
	}
	@Override
	public int hashCode() {
		return Objects.hash(_linea, _orden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tramo other = (Tramo) obj;
		return Objects.equals(_linea, other._linea) && Objects.equals(_orden, other._orden);
	}
	
	@Override
	public String toString() {
		return "TRAMO LINEA " + "A COMPLETAR" + ": " + _origen.getNombre() + " a " + _destino.getNombre() + _costo;
	}

	public Integer get_cantPasajeros() {
		return _cantPasajeros;
	}

	public EstadoTramoEnum get_estadoTramo() {
		return _estadoTramo;
	}
}
