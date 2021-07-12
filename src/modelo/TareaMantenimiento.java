package modelo;

import java.time.LocalDate;

public class TareaMantenimiento {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Integer id;
	private String observaciones;
	
	public TareaMantenimiento(LocalDate fi, LocalDate ff, Integer id, String obs) {
		this.fechaFin=ff;
		this.fechaInicio=fi;
		this.id=id;
		this.observaciones=obs;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
	
}
