package modelo;

public class Linea {
	private Integer _id;
	private String _nombre;
	private String _color;
	private EstadoLineaEnum _estado;
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public String get_nombre() {
		return _nombre;
	}
	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}
	public String get_color() {
		return _color;
	}
	public void set_color(String _color) {
		this._color = _color;
	}
	public EstadoLineaEnum get_estado() {
		return _estado;
	}
	public void set_estado(EstadoLineaEnum _estado) {
		this._estado = _estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}
	
	
}
