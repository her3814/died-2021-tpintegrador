package grafo1;

import java.util.*;
import java.util.stream.Collectors;
import modelo.Estacion;
import modelo.Tramo;

public class Graph<T> {
	private List<Tramo> edges;
	private List<Estacion> vertexs;

	public Graph() {
		this.edges = new ArrayList<Tramo>();
		this.vertexs = new ArrayList<Estacion>();
	}

	public void printEdges() {
		System.out.println(this.edges.toString());
	}

	public Integer flujoMaximo1(Estacion e1, Estacion e2) {
		//Map<Tramo, Estacion> adyacentes = this.getNeighbourhood1(e1);
		int flujoMaximo = 0;
		List<Map<Tramo, Estacion>> recorridos = this.paths(e1, e2);

		Map<Tramo, Integer> pesos = new LinkedHashMap<Tramo, Integer>();
		// INICIALIZACIÓN DE LOS PESOS DE LOS TRAMOS -> funciona ben
		for (Map<Tramo, Estacion> rec : recorridos) {
			for (Tramo t : rec.keySet()) {
				pesos.put(t, t.get_cantPasajeros());
			}
		}
		Integer menorPeso;
		for (Map<Tramo, Estacion> rec : recorridos) {
			// Primero debemos ver si el recorrido no tiene pesos 0 en ninguna arista
			if (!tienePesos0(rec, pesos)) {
				menorPeso = rec.keySet().stream().mapToInt(t -> pesos.get(t)).min().getAsInt();
				flujoMaximo = flujoMaximo + menorPeso;
				for (Tramo t : rec.keySet()) {
					pesos.replace(t, pesos.get(t) - menorPeso);
				}
			}
		}
		return flujoMaximo;
	}

	public Boolean tienePesos0(Map<Tramo, Estacion> recorrido, Map<Tramo, Integer> pesos) {
		for (Tramo t : recorrido.keySet()) {
			if (pesos.containsKey(t) && pesos.get(t) == 0) {
				return true;
			}
		}
		return false;
	}

	public Integer gradoEntrada(Estacion vertice) {
		Integer res = 0;
		for (Tramo arista : this.edges) {
			if (arista.getDestino().equals(vertice))
				++res;
		}
		return res;
	}

	public Integer gradoSalida(Estacion vertice) {
		Integer resultado = 0;
		for (Tramo arista : this.edges) {
			if (arista.getOrigen().equals(vertice))
				++resultado;
		}
		return resultado;
	}

	public List<Tramo> getEdges() {
		return edges;
	}

	public void setEdges(List<Tramo> edges) {
		this.edges = edges;
	}

	public List<Estacion> getVertexs() {
		return vertexs;
	}

	public void setVertexs(List<Estacion> vertexs) {
		this.vertexs = vertexs;
	}

	public Map<Estacion, Double> pageRank1(Graph<T> grafo) {
		Double cantidadNodos = (double) grafo.getVertexs().size();
		Double pr = (1 / cantidadNodos);

		List<Estacion> vertices = grafo.getVertexs();
		Map<Estacion, Double> pageRank = new HashMap<Estacion, Double>();
		Map<Estacion, List<Estacion>> estacionesQueLLegan = estacionesQueLLegan(grafo);
		Map<Estacion, Integer> gradoSalida = new HashMap<Estacion, Integer>();

		for (Estacion e : vertices) {
			gradoSalida.put(e, grafo.gradoSalida(e));
		}

		Double pageIntermedio;

		// inicialización
		for (int i = 0; i < vertices.size(); i++) {
			pageRank.put(vertices.get(i), pr);
		}

		for (int j = 0; j < vertices.size() - 1; j++) { // cantidad de iteraciones
			for (int i = 0; i < vertices.size(); i++) { // cantidad de vértices
				pageIntermedio = 0.0;
				for (Estacion e : estacionesQueLLegan.get(vertices.get(i))) { // por cada estacion que llega a la cual
																				// estoy analizando
					pageIntermedio = pageIntermedio + pageRank.get(vertices.get(i)) / gradoSalida.get(e); // el valor de
																											// la
																										// anterior
				}
				if (pageIntermedio.equals(0.0)) {
					pageRank.put(vertices.get(i), pr);
				} else {
					pageRank.put(vertices.get(i) // en el vertice sub(i) voy a cambiar el pageRank
							, pageIntermedio);
				}
			}
		}
		return pageRank;

	}

	public Map<Estacion, List<Estacion>> estacionesQueLLegan(Graph<T> grafo) {
		List<Estacion> vertices = grafo.getVertexs();
		List<Tramo> aristas = grafo.getEdges();
		Map<Estacion, List<Estacion>> retorno = new HashMap<Estacion, List<Estacion>>();
		for (Estacion e : vertices) {
			List<Estacion> queMeLLegan = new ArrayList<Estacion>();
			for (Tramo arista : aristas) {
				if (arista.getDestino().equals(e)) {
					queMeLLegan.add(arista.getOrigen());
				}
			}
			retorno.put(e, queMeLLegan);
		}
		return retorno;
	}

	public Map<Estacion, Double> pageRank(Graph<T> grafo) {
		Double cantidadNodos = (double) grafo.getVertexs().size();
		Double pr = (1 / cantidadNodos);

		List<Estacion> vertices = new ArrayList<Estacion>();
		vertices = grafo.getVertexs();
		Map<Estacion, Double> map = new HashMap<Estacion, Double>();

		for (int i = 0; i < vertices.size(); i++) {
			map.put(vertices.get(i), pr);
		}
		for (int i = 0; i < vertices.size(); i++) {
			// para cada nodo del grafo, veo a quienes llega y le actualizo el pr
			for (int j = 0; j < vertices.size(); j++) {
				if (i == j) {
				} else {
					Double k = (double) grafo.gradoSalida(vertices.get(i));
					if (k != 0) {
						Double divisor = (1 / k);
						if (grafo.hayCamino(vertices.get(i), vertices.get(j))) {
							// son adyacentes, entonoces le sumo el pr a j
							Double pr_viejo = map.get(vertices.get(j));
							map.replace(vertices.get(j), pr_viejo + map.get(vertices.get(i)) * divisor);
						}
					}
				}
			}
		}
		return map;

	}

	private boolean hayCamino(Estacion e1, Estacion e2) {
		List<Estacion> ady = this.getNeighbourhood(e1);
		for (Estacion unAdy : ady) {
			if (unAdy.equals(e2))
				return true;
		}
		return false;
	}

	private List<Estacion> getNeighbourhood(Estacion e) {
		List<Estacion> salida = new ArrayList<Estacion>();
		for (Tramo tramo : this.edges) {
			if (tramo.getOrigen().equals(e)) {
				salida.add(tramo.getDestino());
			}
		}
		return salida;
	}

	private Map<Tramo, Estacion> getNeighbourhood1(Estacion e) {
		Map<Tramo, Estacion> salida = new LinkedHashMap<Tramo, Estacion>();
		for (Tramo tramo : this.edges) {
			if (tramo.getOrigen().equals(e) && tramo.get_cantPasajeros() > 0) {
				salida.put(tramo, tramo.getDestino());
			}
		}
		return salida;
	}

	public List<Map<Tramo, Estacion>> paths(Estacion e1, Estacion e2) {
		List<Map<Tramo, Estacion>> salida = new ArrayList<Map<Tramo, Estacion>>();
		Map<Tramo, Estacion> marcados = new LinkedHashMap<Tramo, Estacion>();
		findPathAux(e1, e1, e2, marcados, salida);
		return salida;
	}

	private void findPathAux(Estacion e1, Estacion original, Estacion e2, Map<Tramo, Estacion> marcados,
			List<Map<Tramo, Estacion>> todos) {
		Map<Tramo, Estacion> adyacentes = this.getNeighbourhood1(e1);
		// el tramo inicia en e1 y termina en la estacion que tiene en el value
		Map<Tramo, Estacion> copiaMarcados = null;
		for (Tramo ady : adyacentes.keySet()) {
			if (adyacentes.get(ady).equals(original)) {
			} else {
				copiaMarcados = marcados.keySet().stream().collect(Collectors.toMap(t -> t, t -> marcados.get(t)));
				if (adyacentes.get(ady).equals(e2)) {
					copiaMarcados.put(ady, e2);
					todos.add(new LinkedHashMap<Tramo, Estacion>(copiaMarcados));
				} else {
					if (!copiaMarcados.containsKey(ady)) {
						copiaMarcados.put(ady, adyacentes.get(ady));
						this.findPathAux(adyacentes.get(ady), original, e2, copiaMarcados, todos);
					}
				}
			}
		}
	}
}
