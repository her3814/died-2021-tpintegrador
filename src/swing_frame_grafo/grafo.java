package swing_frame_grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bdd.EstacionesRepo;
import bdd.TramosRepo;
import modelo.Estacion;
import modelo.Linea;
import modelo.Tramo;

public class grafo {
	private HashMap<Estacion, HashMap<Estacion, Recorrido[]>> _grafo;

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

	/**
	 * Genera un grafo con todas las estaciones y tramos existentes
	 * 
	 * @return
	 */
	public static grafo ObtenerGrafoCompleto() {
		grafo g = new grafo();

		List<Estacion> estaciones = EstacionesRepo.ObtenerEstaciones();

		for (Estacion e : estaciones) {
			var tramosDesde = TramosRepo.ObtenerDestinosDesde(e);
			Set<Estacion> estacionesDestino = tramosDesde.stream().map(t -> t.getDestino()).collect(Collectors.toSet());

			var recorridos = new HashMap<Estacion, Recorrido[]>();

			for (Estacion eD : estacionesDestino) {
				var aux = tramosDesde.stream().filter(t -> t.getDestino().equals(eD)).map(t -> new Recorrido(t))
						.toArray(Recorrido[]::new);

				recorridos.put(eD, aux);
			}

			g.crearVertice(e, recorridos);
		}
		return g;
	}

	public static grafo ObtenerGrafoDeLinea(Linea linea) {
		return null;
	}

	public static grafo ObtenerGrafoDesdeRecorrido(List<Tramo> recorrido) {
		grafo g = new grafo();

		Set<Estacion> estacionesOrigen = recorrido.stream().map(t -> t.getOrigen()).collect(Collectors.toSet());

		for (Estacion eO : estacionesOrigen) {

			Set<Estacion> estacionesDestino = recorrido.stream().filter(t -> t.getOrigen().equals(eO))
					.map(t -> t.getDestino()).collect(Collectors.toSet());

			var recorridos = new HashMap<Estacion, Recorrido[]>();

			for (Estacion eD : estacionesDestino) {
				var aux = recorrido.stream().filter(t -> t.getDestino().equals(eD) && t.getOrigen().equals(eO))
						.map(t -> new Recorrido(t)).toArray(Recorrido[]::new);

				recorridos.put(eD, aux);
			}

			g.crearVertice(eO, recorridos);
		}
		return g;
	}

	public static void main(String[] args) {
		var g = grafo.ObtenerGrafoCompleto();
		System.out.println(grafo.ObtenerGrafoCompleto());
	}
//	
//	
//	
//	public static grafo ObtenerGrafoEstacionesPorPasajeros() {
//		grafo g = new grafo();
//
//		List<Estacion> est = EstacionesRepo.ObtenerEstaciones();
//
//		for (int i = 0; i < est.size(); i++) {
//
//			var con = TramosRepo.ObtenerDestinosDesde(est.get(i));
//			var aux = new HashMap<String, Double>();
//			for (int j = 0; j < con.size(); j++) {
//				aux.put(con.get(j).getDestino().getNombre(), con.get(j).get_cantPasajeros().doubleValue());
//			}
//
//			g.crearVertice(est.get(i).getNombre(), aux);
//
//		}
//		return g;
//
//	}
//
//	public static grafo ObtenerGrafoEstacionesPorCosto() {
//		grafo g = new grafo();
//
//		List<Estacion> est = EstacionesRepo.ObtenerEstaciones();
//
//		for (int i = 0; i < est.size(); i++) {
//
//			var con = TramosRepo.ObtenerDestinosDesde(est.get(i));
//
//			var aux = new HashMap<String, Double>();
//			for (int j = 0; j < con.size(); j++) {
//				aux.put(con.get(j).getDestino().getNombre(), con.get(j).getCosto());
//			}
//
//			g.crearVertice(est.get(i).getNombre(), aux);
//		}
//
//		return g;
//	}

}
