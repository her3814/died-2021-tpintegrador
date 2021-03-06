package modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import bdd.BoletosRepo;

public class Boleto {
	private final Integer _nroBoleto;
	private String _correoCliente;
	private String _nombreCliente;
	private LocalDate _fechaVenta;
	private Double _costo;
	private String _origen;
	private String _destino;
	private List<TramoBoleto> _tramos;

	public Boleto(Integer numeroBoleto, String correo, String nombre, LocalDate fechaVenta, Double costo,
			String nombreEstacionOrigen, String nombreEstacionDestino) {
		_nroBoleto = numeroBoleto;
		_correoCliente = correo;
		_nombreCliente = nombre;
		_fechaVenta = fechaVenta;
		_costo = costo;
		_origen = nombreEstacionOrigen;
		_destino = nombreEstacionDestino;
		_tramos = BoletosRepo.ObtenerTramos(this);
	}

	public Boleto(String correo, String nombre, LocalDate fechaVenta, Double costo, Estacion origen, Estacion destino,
			List<Tramo> recorrido) {
		_nroBoleto = null;
		_correoCliente = correo;
		_nombreCliente = nombre;
		_fechaVenta = fechaVenta;
		_costo = costo;
		_origen = origen.getNombre();
		_destino = destino.getNombre();
		_tramos = recorrido.stream().map(t -> new TramoBoleto(t)).collect(Collectors.toList());
	}

	public Double get_costo() {
		return _costo;
	}

	public void set_costo(Double _costo) {
		this._costo = _costo;
	}

	public String get_origen() {
		return _origen;
	}

	public String get_destino() {
		return _destino;
	}

	public List<TramoBoleto> get_tramos() {
		return _tramos;
	}

	public void set_tramos(List<TramoBoleto> _tramos) {
		this._tramos = _tramos;
	}

	public Integer get_nroBoleto() {
		return _nroBoleto;
	}

	public String get_correoCliente() {
		return _correoCliente;
	}

	public void set_correoCliente(String _correoCliente) {
		this._correoCliente = _correoCliente;
	}

	public String get_nombreCliente() {
		return _nombreCliente;
	}

	public void set_nombreCliente(String _nombreCliente) {
		this._nombreCliente = _nombreCliente;
	}

	public LocalDate get_fechaVenta() {
		return _fechaVenta;
	}

	public void set_fechaVenta(LocalDate _fechaVenta) {
		this._fechaVenta = _fechaVenta;
	}

	public Double getCosto() {
		return _costo;
	}

	public void setCosto(Double costo) {
		this._costo = costo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_nroBoleto == null) ? 0 : _nroBoleto.hashCode());
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
		Boleto other = (Boleto) obj;
		if (_nroBoleto == null) {
			if (other._nroBoleto != null)
				return false;
		} else if (!_nroBoleto.equals(other._nroBoleto))
			return false;
		return true;
	}

}
