package modelo;

import java.time.LocalDate;

public class Boleto {
	private Integer _nroBoleto;
	private String _correoCliente;
	private String _nombreCliente;
	private LocalDate _fechaVenta;
	private Double costo;
	public Integer get_nroBoleto() {
		return _nroBoleto;
	}
	public void set_nroBoleto(Integer _nroBoleto) {
		this._nroBoleto = _nroBoleto;
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
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
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
