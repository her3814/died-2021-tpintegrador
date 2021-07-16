package swing_frame_grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import bdd.EstacionesRepo;
import bdd.TramosRepo;
import modelo.Estacion;

public class grafo {
	private HashMap<String, HashMap<String, Double>> Grafo;

	public grafo() {
		Grafo = new HashMap<String, HashMap<String, Double>>();
	}

	public HashMap<String, Double> getVertice(String vertice) {
		return Grafo.get(vertice);
	}

	public void crearVertice(String vertice, HashMap<String, Double> relacion) {
		Grafo.put(vertice, relacion);
	}

	public List<String> getKeys() {
		List<String> keys = new ArrayList<String>();
		keys.addAll(Grafo.keySet());
		return keys;
	}

	public static void main(String[] a) {

		System.out.println("GRAFO CON PESO POR PASAJEROS");
		var g = ObtenerGrafoEstacionesPorPasajeros();
		var keys = g.getKeys();

		for (int i = 0; i < keys.size(); i++) {
			System.out.println(keys.toArray()[i] + " -> " + g.getVertice((String) keys.toArray()[i]));
		}

		System.out.println("GRAFO CON PESO POR COSTO");
		g = ObtenerGrafoEstacionesPorCosto();
		keys = g.getKeys();

		for (int i = 0; i < keys.size(); i++) {
			System.out.println(keys.toArray()[i] + " -> " + g.getVertice((String) keys.toArray()[i]));
		}

	}

	public static grafo ObtenerGrafoEstacionesPorPasajeros() {
		grafo g = new grafo();

		List<Estacion> est = EstacionesRepo.ObtenerEstaciones();

		for (int i = 0; i < est.size(); i++) {

			var con = TramosRepo.ObtenerDestinosDesde(est.get(i));
			var aux = new HashMap<String, Double>();
			for (int j = 0; j < con.size(); j++) {
				aux.put(con.get(j).getDestino().getNombre(), con.get(j).get_cantPasajeros().doubleValue());
			}

			g.crearVertice(est.get(i).getNombre(), aux);

		}
		return g;

	}

	public static grafo ObtenerGrafoEstacionesPorCosto() {
		grafo g = new grafo();

		List<Estacion> est = EstacionesRepo.ObtenerEstaciones();

		for (int i = 0; i < est.size(); i++) {

			var con = TramosRepo.ObtenerDestinosDesde(est.get(i));
			var aux = new HashMap<String, Double>();
			for (int j = 0; j < con.size(); j++) {
				aux.put(con.get(j).getDestino().getNombre(), con.get(j).getCosto());
			}

			g.crearVertice(est.get(i).getNombre(), aux);
		}

		return g;

	}
}
