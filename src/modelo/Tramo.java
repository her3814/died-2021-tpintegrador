package modelo;

public class Tramo {
	
	private Integer _id;
	private Double _distancia;
	private Double _duracionViaje;
	private Integer _cantPasajeros;
	private EstadoTramo _estadoTRamo;
	private Double _costo;
	private TipoMedioTransporte _tipoMedio;
	
	
	public Boolean equals(Tramo t) {
		return this.get_id()==t.get_id();
	}


	public Integer get_id() {
		return _id;
	}


	public void set_id(Integer _id) {
		this._id = _id;
	}
}
