package modelo;

import java.time.LocalDate;

public class TareaMantenimiento {
	private LocalDate _fechaInicio;
	private LocalDate _fechaFin;
	private Integer _id;
	private String _observaciones;
	
	public TareaMantenimiento(LocalDate fi, LocalDate ff, Integer id, String obs) {
		this._fechaFin=ff;
		this._fechaInicio=fi;
		this._id=id;
		this._observaciones=obs;
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
	public void setId(Integer id) {
		this._id = id;
	}
	public String getObservaciones() {
		return _observaciones;
	}
	public void setObservaciones(String observaciones) {
		this._observaciones = observaciones;
	}
	
	
	
	
}
