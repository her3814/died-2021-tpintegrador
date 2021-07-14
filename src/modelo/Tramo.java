package modelo;

public class Tramo {
	
	private Integer _id;
	private Double _distancia;
	private Double _duracionViaje;
	private Integer _cantPasajeros;
	private EstadoTramo _estadoTRamo;
	private Double _costo;
	private TipoMedioTransporte _tipoMedio;
	private Estacion _origen;
	private Estacion _destino;
	
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
