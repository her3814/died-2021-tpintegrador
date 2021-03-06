package modelo;

public class Linea {
	private final Integer _id;
	private String _nombre;
	private ColoresLineasEnum _color;
	private EstadoLineaEnum _estado;
	private LineaTipoTransporteEnum _tipoTransporte;

	public Linea(Integer id) {
		_id = id;
	}

	public Linea(Integer id, String nombre, String color, EstadoLineaEnum estado,
			LineaTipoTransporteEnum tipoTransporte) {
		_id = id;
		_nombre = nombre;
		_color = ColoresLineasEnum.valueOf(color);
		_estado = estado;		
		_tipoTransporte=tipoTransporte;
	}
	
	public Linea(String nombre, String color, EstadoLineaEnum estado,
			LineaTipoTransporteEnum tipoTransporte) {
		_id=null;
		_nombre = nombre;
		_color = ColoresLineasEnum.valueOf(color);
		_estado = estado;		
		_tipoTransporte=tipoTransporte;
	}

	public Integer get_id() {
		return _id;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String get_color() {
		return _color.toString();
	}

	public void set_color(String _color) {
		this._color = ColoresLineasEnum.valueOf(_color);
	}

	public EstadoLineaEnum get_estado() {
		return _estado;
	}

	public void set_estado(EstadoLineaEnum _estado) {
		this._estado = _estado;
	}


	public LineaTipoTransporteEnum get_tipoTransporte() {
		return _tipoTransporte;
	}

	public void set_tipoTransporte(LineaTipoTransporteEnum _tipoTransporte) {
		this._tipoTransporte = _tipoTransporte;
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

	@Override
	public String toString() {
		return String.format("Linea %s (%s)", _nombre, _color);
	}
	
}
