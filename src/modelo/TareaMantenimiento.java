package modelo;

import java.time.LocalDate;

import excepciones.FechaFinMenorFechaInicioException;

public class TareaMantenimiento {
	private final Integer _id;
	private Estacion _estacion;
	private LocalDate _fechaInicio;
	private LocalDate _fechaFin;
	private String _observaciones;

	public TareaMantenimiento(Estacion estacion, LocalDate fi, LocalDate ff, String obs)
			throws FechaFinMenorFechaInicioException {
		_id = null;
		_estacion = estacion;
		setFechaInicio(fi);
		setFechaFin(ff);
		_observaciones = obs;
	}

	public TareaMantenimiento(Integer id, Estacion estacion, LocalDate fi, LocalDate ff, String obs)
			throws FechaFinMenorFechaInicioException {
		_id = id;
		_estacion = estacion;
		setFechaInicio(fi);
		setFechaFin(ff);
		_observaciones = obs;
	}

	public Estacion getEstacion() {
		return _estacion;
	}

	public LocalDate getFechaInicio() {
		return _fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) throws FechaFinMenorFechaInicioException {
		if (_fechaFin != null && fechaInicio != null && _fechaFin.compareTo(fechaInicio) < 0)
			throw new FechaFinMenorFechaInicioException();

		this._fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return _fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) throws FechaFinMenorFechaInicioException {
		if (fechaFin != null && _fechaInicio != null && fechaFin.compareTo(_fechaInicio) < 0)
			throw new FechaFinMenorFechaInicioException();

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

	@Override
	public String toString() {
		if (this._fechaFin != null)
			return String.format("Tarea Mantenimiento en Estacion: %s de %s a %s", _estacion.getNombre(),
					_fechaInicio.toString(), _fechaFin.toString());
		else return String.format("Tarea Mantenimiento en Estacion: %s desde %s", _estacion.getNombre(),
				_fechaInicio.toString());

	}

}
