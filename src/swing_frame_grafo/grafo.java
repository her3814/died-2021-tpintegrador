package swing_frame_grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bdd.TramosRepo;
import modelo.Estacion;
import modelo.Linea;
import modelo.Tramo;
import modelo.TramoBoleto;

/**
 * Clase representando un grafo dibujable. No se debe utilizar esta clase para
 * calculos o procesamiento logico/matematico de grafos *
 */
public class grafo {

	private HashMap<Estacion, HashMap<Estacion, Recorrido[]>> _grafo;

	
	@Override
	public String toString() {
		return _grafo.toString();
	}
	
	public grafo() {
		_grafo = new HashMap<Estacion, HashMap<Estacion, Recorrido[]>>();
	}

	public HashMap<Estacion, Recorrido[]> getVertice(Estacion estacion) {
		return _grafo.get(estacion);
	}

	public void crearVertice(Estacion vertice, HashMap<Estacion, Recorrido[]> relacion) {
		_grafo.put(vertice, relacion);
	}

	public List<Estacion> getKeys() {
		List<Estacion> keys = new ArrayList<Estacion>();
		keys.addAll(_grafo.keySet());
		return keys;
	}

	public static grafo ObtenerGrafoDeLinea(Linea linea) {
		var recorrido = TramosRepo.ObtenerRecorrido(linea);
		return ObtenerGrafoDesdeRecorrido(recorrido);
	}

	public static grafo ObtenerGrafoDesdeBoleto(List<TramoBoleto> recorrido) {
		grafo g = new grafo();
		Set<Estacion> estaciones = new HashSet<Estacion>();

		for (TramoBoleto t : recorrido) {
			estaciones.add(t.getFakeEstacionOrigen());
			estaciones.add(t.getFakeEstacionDestino());
		}

		for (Estacion e : estaciones) {
			var tramosDesde = recorrido.stream().filter(t -> t.getFakeEstacionOrigen().equals(e))
					.collect(Collectors.toList());
			Set<Estacion> estacionesDestino = tramosDesde.stream().map(t -> t.getFakeEstacionDestino())
					.collect(Collectors.toSet());

			var recorridos = new HashMap<Estacion, Recorrido[]>();

			for (Estacion eD : estacionesDestino) {
				var aux = tramosDesde.stream().filter(t -> t.getFakeEstacionDestino().equals(eD))
						.map(t -> new Recorrido(t)).toArray(Recorrido[]::new);

				recorridos.put(eD, aux);
			}

			g.crearVertice(e, recorridos);

		}

		return g;
	}

	public static grafo ObtenerGrafoDesdeRecorrido(List<Tramo> recorrido) {
		grafo g = new grafo();
		Set<Estacion> estaciones = new HashSet<Estacion>();

		for (Tramo t : recorrido) {
			estaciones.add(t.getOrigen());
			estaciones.add(t.getDestino());
		}

		for (Estacion e : estaciones) {
			var tramosDesde = recorrido.stream().filter(t -> t.getOrigen().equals(e))
					.collect(Collectors.toList());
			Set<Estacion> estacionesDestino = tramosDesde.stream().map(t -> t.getDestino())
					.collect(Collectors.toSet());

			var recorridos = new HashMap<Estacion, Recorrido[]>();

			for (Estacion eD : estacionesDestino) {
				var aux = tramosDesde.stream().filter(t -> t.getDestino().equals(eD))
						.map(t -> new Recorrido(t)).toArray(Recorrido[]::new);

				recorridos.put(eD, aux);
			}

			g.crearVertice(e, recorridos);

		}

		return g;
	}
}
