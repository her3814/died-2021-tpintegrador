package modelo;

import java.time.LocalTime;

public class Estacion {

	private LocalTime _horarioApertura;
	private LocalTime _horarioCierre;
	private String _nombre;
	private EstadoEstacionEnum _estado;

	public Estacion(String nombre) {
		_nombre = nombre;
		_estado = EstadoEstacionEnum.CERRADA;
	}

	public Estacion(String nombre, LocalTime horaApertura, LocalTime horaCierre, EstadoEstacionEnum estado) {
		_nombre = nombre;
		_estado = estado;
		_horarioApertura = horaApertura;
		_horarioCierre = horaCierre;

	}

	public String getNombre() {
		return _nombre;
	}

	public EstadoEstacionEnum ToggleEstado() {
		if (_estado.equals(EstadoEstacionEnum.ABIERTA))
			_estado = EstadoEstacionEnum.CERRADA;
		else
			_estado = EstadoEstacionEnum.ABIERTA;

		return _estado;
	}

	@Override
	public String toString() {
		return "Estacion [ " + _nombre + " ]";
	}

	public EstadoEstacionEnum getEstado() {
		return _estado;
	}

	public LocalTime getHorarioApertura() {
		return _horarioApertura;
	}

	public void setHorarioApertura(LocalTime _horarioApertura) {
		this._horarioApertura = _horarioApertura;
	}

	public LocalTime getHorarioCierre() {
		return _horarioCierre;
	}

	public void setHorarioCierre(LocalTime _horarioCierre) {
		this._horarioCierre = _horarioCierre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_estado == null) ? 0 : _estado.hashCode());
		result = prime * result + ((_horarioApertura == null) ? 0 : _horarioApertura.hashCode());
		result = prime * result + ((_horarioCierre == null) ? 0 : _horarioCierre.hashCode());
		result = prime * result + ((_nombre == null) ? 0 : _nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Estacion))
			return false;
		Estacion other = (Estacion) obj;
		if (_estado != other._estado)
			return false;
		if (_horarioApertura == null) {
			if (other._horarioApertura != null)
				return false;
		} else if (!_horarioApertura.equals(other._horarioApertura))
			return false;
		if (_horarioCierre == null) {
			if (other._horarioCierre != null)
				return false;
		} else if (!_horarioCierre.equals(other._horarioCierre))
			return false;
		if (_nombre == null) {
			if (other._nombre != null)
				return false;
		} else if (!_nombre.equals(other._nombre))
			return false;
		return true;
	}

}
