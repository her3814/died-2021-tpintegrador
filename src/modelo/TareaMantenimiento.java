package modelo;

import java.time.LocalDate;

public class TareaMantenimiento {
	private final Integer _id;
	private LocalDate _fechaInicio;
	private LocalDate _fechaFin;
	private String _observaciones;
	
	public TareaMantenimiento(LocalDate fi, LocalDate ff, String obs) {
		_id = null;
		_fechaFin=ff;
		_fechaInicio=fi;
		_observaciones=obs;
	}
	
	public TareaMantenimiento(Integer id, LocalDate fi, LocalDate ff, String obs) {
		_fechaFin=ff;
		_fechaInicio=fi;
		_id=id;
		_observaciones=obs;
	}
	
	public LocalDate getFechaInicio() {
		return _fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this._fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return _fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this._fechaFin = fechaFin;
	}
	public Integer getId() {
		return _id;
	}

	public String getObservaciones() {
		return _observaciones;
	}
	public void setObservaciones(String observaciones) {
		this._observaciones = observaciones;
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
		TareaMantenimiento other = (TareaMantenimiento) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}
	
	
	
	
}
