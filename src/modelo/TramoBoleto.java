package modelo;

public class TramoBoleto {
	private int _boletoNumero;
	private int _trayecto_orden;
	private String _linea_nombre;
	private String _linea_color;
	private String _linea_tipo_transporte;
	private String _estacion_origen_nombre;
	private String _estacion_destino_nombre;
	private Double _trayecto_duracion_min;
	private Double _trayecto_costo;
	private Double _trayecto_distancia;

	public TramoBoleto(Tramo tramo) {
		_linea_nombre = tramo.getLinea().get_nombre();
		_linea_color = tramo.getLinea().get_color();
		_linea_tipo_transporte = tramo.getLinea().get_tipoTransporte().name();
		_estacion_destino_nombre = tramo.getDestino().getNombre();
		_estacion_origen_nombre=tramo.getOrigen().getNombre();
		_trayecto_costo=tramo.getCosto();
		_trayecto_distancia=tramo.getDistancia();
		_trayecto_duracion_min=tramo.getDuracion();

	}
	
	public TramoBoleto(int nroBoleto, int orden, String nombreLinea, String lineaColor, String tipoTransporte, String origen, String destino, Double duracion, Double costo, Double distancia)
	{
		_boletoNumero=nroBoleto;
		_trayecto_orden=orden;
		_linea_nombre=nombreLinea;
		_linea_color=lineaColor;
		_linea_tipo_transporte=tipoTransporte;
		_estacion_origen_nombre=origen;
		_estacion_destino_nombre=destino;
		_trayecto_duracion_min=duracion;
		_trayecto_costo=costo;
		_trayecto_distancia=distancia;
	}
	public int get_boletoNumero() {
		return _boletoNumero;
	}

	public int get_trayecto_orden() {
		return _trayecto_orden;
	}

	public String get_linea_nombre() {
		return _linea_nombre;
	}

	public String get_linea_color() {
		return _linea_color;
	}

	public String get_linea_tipo_transporte() {
		return _linea_tipo_transporte;
	}

	public String get_estacion_origen_nombre() {
		return _estacion_origen_nombre;
	}

	public String get_estacion_destino_nombre() {
		return _estacion_destino_nombre;
	}

	public Double get_trayecto_duracion_min() {
		return _trayecto_duracion_min;
	}

	public Double get_trayecto_costo() {
		return _trayecto_costo;
	}

	public Double get_trayecto_distancia() {
		return _trayecto_distancia;
	}
	
	
	
}
