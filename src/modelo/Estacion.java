package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bdd.TareaMantenimientoRepo;
import excepciones.HoraCierreMenorHoraAperturaException;



public class Estacion {
	private final Integer _id;
	private String _nombre;
	private LocalTime _horarioApertura;
	private LocalTime _horarioCierre;
	private EstadoEstacionEnum _estado;
	
	public Estacion(int Id, String nombre, LocalTime horaApertura, LocalTime horaCierre, EstadoEstacionEnum estado) throws HoraCierreMenorHoraAperturaException {
		if(horaApertura!=null && horaCierre!=null && horaCierre.isBefore(horaApertura)) {
			throw new HoraCierreMenorHoraAperturaException();
		}
		_id = Id;
		_nombre = nombre;
		_estado = estado;  
		_horarioApertura = horaApertura;
		_horarioCierre = horaCierre;
	}

	public Estacion(String nombre, LocalTime horaApertura, LocalTime horaCierre) throws HoraCierreMenorHoraAperturaException  {
		if(horaApertura!=null && horaCierre!=null && horaCierre.isBefore(horaApertura)) {
			throw new HoraCierreMenorHoraAperturaException();
		}
		_id = null;
		_nombre = nombre;
		_horarioApertura = horaApertura;
		_horarioCierre = horaCierre;
	}
	 
	public Estacion( String nombre, LocalTime horaApertura, LocalTime horaCierre, EstadoEstacionEnum estado) throws HoraCierreMenorHoraAperturaException  {
		if(horaApertura!=null && horaCierre!=null && horaCierre.isBefore(horaApertura)) {
			throw new HoraCierreMenorHoraAperturaException();
		}
		_id = null;
		_nombre = nombre;
		_estado = estado;
		_horarioApertura = horaApertura;
		_horarioCierre = horaCierre;
	}
	
	public Integer getId() {
		return _id;
	}
	
	public String getNombre() {
		return _nombre;
	}

	@Override
	public String toString() {
		return "Estacion " + _nombre + " (" + _estado + ")";
	}

	public EstadoEstacionEnum getEstado() {
		return _estado;
	}

	public LocalTime getHorarioApertura() {
		return _horarioApertura;
	}

	public void setHorarioApertura(LocalTime _horarioApertura) throws HoraCierreMenorHoraAperturaException{
		if(_horarioApertura!=null && _horarioCierre!=null &&_horarioCierre.isBefore(_horarioApertura)) {
			throw new HoraCierreMenorHoraAperturaException();
		}
		this._horarioApertura = _horarioApertura;
	}

	public LocalTime getHorarioCierre() {
		return _horarioCierre;
	}

	public void setHorarioCierre(LocalTime _horarioCierre) throws HoraCierreMenorHoraAperturaException{
		if(_horarioApertura!=null && _horarioCierre!=null && _horarioCierre.isBefore(_horarioApertura)) {
			throw new HoraCierreMenorHoraAperturaException();
		}
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
	
	public LocalDate getFechaUltimoMantenimiento () {
		List<TareaMantenimiento> tareas = new ArrayList<TareaMantenimiento>();
		Comparator<TareaMantenimiento> comparador = (TareaMantenimiento t1, TareaMantenimiento t2) -> t2.getFechaFin().compareTo(t1.getFechaFin());
		tareas = TareaMantenimientoRepo.Obtener(this);
		if(tareas.size()>1) {
		List<LocalDate> retorno = new ArrayList<LocalDate>();
		retorno = TareaMantenimientoRepo.Obtener(this)
				.stream()
				.sorted(comparador)
				.map(t1 -> t1.getFechaFin())
				.collect(Collectors.toList());
		return retorno.get(0);
		}
		else return LocalDate.now();
	}
}
