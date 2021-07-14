package filtros;

import java.time.LocalTime;

import modelo.EstadoEstacionEnum;

public class EstacionesFiltro {
	public String nombre;
	public Integer id;
	public LocalTime horaAperturaDesde;
	public LocalTime horaAperturaHasta;
	public LocalTime horaCierreDesde;
	public LocalTime horaCierreHasta;
	public EstadoEstacionEnum estado;

	public EstacionesFiltro() {
		nombre = null;
		id = null;
		horaAperturaDesde = null;
		horaAperturaHasta = null;
		horaCierreDesde = null;
		horaCierreHasta = null;
		estado = null;
	}

	public Boolean esVacio() {
		return (nombre == null && id == null && horaAperturaDesde == null && horaAperturaHasta == null
				&& horaCierreDesde == null && horaAperturaDesde == null && estado == null);
	}
}
