package swing_frame_grafo;

import modelo.Tramo;

public class Recorrido {
	private Double _costo;
	private Double _distancia;
	private Double _longitud;
	private Double _duracion;
	private Integer _capacidad;
	private String _color;
	private String _lineaNombre;

	public Recorrido(Tramo tramo) {
		_costo = tramo.getCosto();
		_distancia = tramo.getDistancia();
		_duracion = tramo.getDuracion();
		_capacidad = tramo.get_cantPasajeros();
		_color = tramo.getLinea().get_color();
		_lineaNombre = tramo.getLinea().get_nombre();
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

	public Double getLongitud() {
		return _longitud;
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
