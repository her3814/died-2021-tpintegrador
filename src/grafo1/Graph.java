package grafo1;


import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import bdd.EstacionesRepo;
import bdd.TramosRepo;
//import died.clase.grafos.Edge;
//import died.clase.grafos.Vertex;
import modelo.Estacion;
import modelo.Tramo;

public class Graph <T> {
	private List<Tramo> edges;
	private List<Estacion> vertexs;

	public Graph(){
		this.edges = new ArrayList<Tramo>();
		this.vertexs = new ArrayList<Estacion>();
	}
	
	public void printEdges(){
		System.out.println(this.edges.toString());
	}

	public Integer gradoEntrada(Estacion vertice){
		Integer res =0;
		for(Tramo arista : this.edges){
			if(arista.getDestino().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Estacion vertice){
		Integer resultado =0;
		for(Tramo arista : this.edges){
			if(arista.getOrigen().equals(vertice)) ++resultado;
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
	
	
	
	public Map<Estacion,Double> pageRank1(Graph<T> grafo){
		Double cantidadNodos = (double) grafo.getVertexs().size();
		Double pr =   (1 / cantidadNodos);
		
		List<Estacion> vertices = new ArrayList<Estacion>();
		vertices = grafo.getVertexs();
		Map<Estacion, Double> pageRank = new HashMap<Estacion,Double>();
		Map<Estacion, List<Estacion>> estacionesQueLLegan = estacionesQueLLegan(grafo);
		Map<Estacion, Integer> gradoSalida = new HashMap<Estacion, Integer>();
		
		for(Estacion e: vertices) {
			gradoSalida.put(e, grafo.gradoSalida(e));
		}
		
		Double pageIntermedio;
		
		//inicialización
		for(int i=0; i<vertices.size();i++) {
			pageRank.put(vertices.get(i), pr);
		}
		
		
		for(int j=0; j< vertices.size()-1; j++) { // cantidad de iteraciones
		for(int i=0; i<vertices.size(); i++) { // cantidad de vértices
			pageIntermedio=0.0;
			for(Estacion e: estacionesQueLLegan.get(vertices.get(i))) { // por cada estacion que llega a la cual estoy analizando
				pageIntermedio= pageIntermedio + pageRank.get(vertices.get(i)) /gradoSalida.get(e);  // el valor de la iteración anterior
			}
			if(pageIntermedio.equals(0.0)) {
				pageRank.put(vertices.get(i), pr);
			}else {
			pageRank.put(vertices.get(i) // en el vertice sub(i) voy a cambiar el pageRank
					, pageIntermedio);
		}
		}
		}
		return pageRank;
		
	}
	
	public Map<Estacion, List<Estacion>> estacionesQueLLegan(Graph grafo){
		List<Estacion> vertices = grafo.getVertexs();
		List<Tramo> aristas = grafo.getEdges();
		Map<Estacion, List<Estacion>> retorno = new HashMap<Estacion, List<Estacion>>();
		for(Estacion e: vertices) {
			List<Estacion> queMeLLegan= new ArrayList<Estacion>();
				for(Tramo arista: aristas) {
					if(arista.getDestino().equals(e)) {
						queMeLLegan.add(arista.getOrigen());
					}
				}
				retorno.put(e, queMeLLegan);
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		Graph<Estacion> grafo = new Graph<Estacion>();
		grafo.setVertexs(EstacionesRepo.ObtenerEstaciones());
		grafo.setEdges(TramosRepo.obtenerTramos());
		List<Estacion> vertices = new ArrayList<Estacion>();
		vertices= grafo.getVertexs();		
		Map<Estacion, Double> pr = new HashMap<Estacion, Double>();
		pr= grafo.pageRank(grafo);
		for(int i=0; i<pr.size();i++) {
			System.out.println(vertices.get(i).toString()+": pageRank -> "+ pr.get(vertices.get(i)));
		}
		
	}
	
	public Map<Estacion, Double> pageRank(Graph grafo) {
		Double cantidadNodos = (double) grafo.getVertexs().size();
		Double pr =   (1 / cantidadNodos);
	
	List<Estacion> vertices = new ArrayList<Estacion>();
	vertices = grafo.getVertexs();
	Map<Estacion, Double> map = new HashMap<Estacion,Double>();
	
	for(int i=0;i<vertices.size();i++) {
		map.put(vertices.get(i),pr);
	}
	for(int i=0;i<vertices.size();i++) {
		//para cada nodo del grafo, veo a quienes llega y le actualizo el pr
		for(int j=0;j<vertices.size();j++) {
			if(i==j) {}
			else {
			Double k = (double)grafo.gradoSalida(vertices.get(i));
			if(k!=0) {
			Double divisor = (1/k);
			if(grafo.hayCamino(vertices.get(i),vertices.get(j))) {
					//son adyacentes, entonoces le sumo el pr a j
				Double pr_viejo = map.get(vertices.get(j));
				map.replace(vertices.get(j), pr_viejo + map.get(vertices.get(i))* divisor);
			}
			}
			}
		}
	}
	return map;
	
}
	
	private boolean hayCamino(Estacion e1,Estacion e2){
    	List<Estacion> ady = this.getNeighbourhood(e1);
        for(Estacion unAdy : ady){
        	if(unAdy.equals(e2)) return true;
        }
        return false;
    }
	private List<Estacion> getNeighbourhood(Estacion e){ 
		List<Estacion> salida = new ArrayList<Estacion>();
		for(Tramo tramo : this.edges){
			if(tramo.getOrigen().equals(e)) {
				salida.add(tramo.getDestino());
			}
		}
		return salida;
	}
	
  
}
	