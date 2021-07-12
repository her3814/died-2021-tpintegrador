package modelo;

import java.time.LocalTime;

public class Estacion {
	private int _id;
	private String _nombre;
	private LocalTime _horarioApertura;
	private LocalTime _horarioCierre;
	private EstadoEstacionEnum _estado;

	public Estacion(String nombre) {
		_nombre = nombre;
		_estado = EstadoEstacionEnum.MANTENIMIENTO;
	}

	public Estacion(int Id, String nombre, LocalTime horaApertura, LocalTime horaCierre, EstadoEstacionEnum estado) {
		_id = Id;
		_nombre = nombre;
		_estado = estado;
		_horarioApertura = horaApertura;
		_horarioCierre = horaCierre;

	}

	public int getId() {
		return _id;
	}
	
	public String getNombre() {
		return _nombre;
	}

	public EstadoEstacionEnum ToggleEstado() {
		if (_estado.equals(EstadoEstacionEnum.OPERATIVA))
			_estado = EstadoEstacionEnum.MANTENIMIENTO;
		else
			_estado = EstadoEstacionEnum.OPERATIVA;

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
		result = prime * result + _id;
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
		Estacion other = (Estacion) obj;
		if (_id != other._id)
			return false;
		return true;
	}	
	
	
	
}
