package modelo;

public class Tramo {
	
	private Integer _id;
	private Linea _linea;
	private Integer _orden;
	private Estacion _origen;
	private Estacion _destino;
	private Double _duracionViaje;
	private Double _distancia;
	private Integer _cantPasajeros;
	private Double _costo;
	private EstadoTramoEnum _estadoTramo;

	public Tramo(Integer id, Linea linea, Estacion origen, Estacion destino, Integer orden, Integer cant_pasajeros,
			Double duracion, Double distancia, Double costo, EstadoTramoEnum estado) {
		_id = id;
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

	public Boolean equals(Tramo t) {
		return this.get_id()==t.get_id();
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		return result;
	}


	public Integer get_id() {
		return _id;
	}


	public void set_id(Integer _id) {
		this._id = _id;
	}

	public Double getDuracion() {
		return _duracionViaje;
	}

	public Double getDistancia() {
		return _distancia;
	}
}
