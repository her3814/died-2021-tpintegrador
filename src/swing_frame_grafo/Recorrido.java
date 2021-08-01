package swing_frame_grafo;

import modelo.Tramo;
import modelo.TramoBoleto;

class Recorrido {
	private Double _costo;
	private Double _distancia;
	private Double _duracion;
	private Integer _capacidad;
	private String _color;
	private String _lineaNombre;

	@Override
	public String toString() {
		return "Linea " + _lineaNombre + " - Costo: " + _costo + " Distancia: " + _distancia + "km"; 
	}
	
	public Recorrido(Tramo tramo) {
		_costo = tramo.getCosto();
		_distancia = tramo.getDistancia();
		_duracion = tramo.getDuracion();
		_capacidad = tramo.get_cantPasajeros();
		_color = tramo.getLinea().get_color();
		_lineaNombre = tramo.getLinea().get_nombre();
	}

	public Recorrido(TramoBoleto tramo) {
		_costo = tramo.get_trayecto_costo();
		_distancia = tramo.get_trayecto_distancia();
		_duracion = tramo.get_trayecto_duracion_min();
		_color = tramo.get_linea_color();
		_lineaNombre = tramo.get_linea_nombre();
	}

	public Double getCosto() {
		return _costo;
	}

	public Integer getCapacidad() {
		return _capacidad;
	}

	public Double getDistancia() {
		return _distancia;
	}

	public Double getDuracion() {
		return _duracion;
	}

	public String getLineaNombre() {
		return _lineaNombre;
	}

	public String getColor() {
		return _color;
	}
}
