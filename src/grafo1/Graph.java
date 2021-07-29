package grafo1;


import java.util.*;

import java.util.Map.Entry;
import java.util.stream.Collectors;

import bdd.EstacionesRepo;
import bdd.TramosRepo;
//import died.clase.grafos.Vertex;
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

	public void flujoMaximo(Estacion e1, Estacion e2) {
		List<List<Estacion>> caminos = new ArrayList<List<Estacion>>();
		caminos = this.caminos(e1, e2);
		int flujoMaximo = 0;
		List<Tramo> tramos = new ArrayList<Tramo>();
		tramos = TramosRepo.obtenerTramos();
		for(int i=0;i<caminos.size();i++) {
			List<Tramo> tramo = new ArrayList<Tramo>();
			List<Estacion> estaciones = caminos.get(i);
			//me quedo con un camino de todos los que hay entre esas dos estaciones
			//busco para cada tramo del camino su peso
			for(int j = 0;j<estaciones.size();j++) {
				//tramo = tramos.stream().filter(t -> t.getOrigen().equals(estaciones.get(j)) &&
					//	t.getDestino().equals(estaciones.get(j+1)))
				
			}
		}
	}
	
	public Integer flujoMaximo1(Estacion e1, Estacion e2) {
    	Map<Estacion, Tramo> adyascentes = this.getNeighbourhood1(e1);
    	int flujoMaximo=0;
    	List<Map<Estacion, Tramo>> recorridos= this.paths(e1, e2);
    	
    	Map<Tramo, Integer> pesos = new LinkedHashMap<Tramo, Integer>();
    	//List<Map<Tramo, Integer>> pesos = new ArrayList<Map<Tramo, Integer>>();
    	//INICIALIZACIÓN DE LOS PESOS DE LOS TRAMOS -> funciona ben 
    	for(Map<Estacion, Tramo> rec: recorridos) {
    	for(Estacion e: rec.keySet()) {
    		pesos.put(rec.get(e), rec.get(e).get_cantPasajeros());
    	}
    	}
    	Integer menorPeso;
   /* 	for(Estacion e: adyascentes.keySet()) {
    		if(((Tramo)adyascentes.get(e)).get_cantPasajeros()> mayorPeso) mayorPeso = ((Tramo)adyascentes.get(e)).get_cantPasajeros();
    		tramoMayorPeso= e;
    	}
    	*/
    	for(Map<Estacion, Tramo> rec : recorridos) {
    		// Primero debemos ver si el recorrido no tiene pesos 0 en ninguna arista
    		if(! tienePesos0(rec, pesos)) { 
    			menorPeso= rec.keySet().stream()
    						.mapToInt(e -> pesos.get(rec.get(e)))
    						.min()
    						.getAsInt();
    			for(Estacion e: rec.keySet()) {
        			pesos.put(rec.get(e), pesos.get(rec.get(e))-menorPeso);
        			flujoMaximo=flujoMaximo+menorPeso;
        		}
    		}
    			
    	}
    	return flujoMaximo;
    }

	
	public Boolean tienePesos0(Map<Estacion, Tramo> recorrido,Map<Tramo, Integer> pesos ) {
		for(Estacion e: recorrido.keySet()) {
		//TODO CAMBIARLO EN FUNCION DE LOS PESOS, QUE ES LO QUE SE VA ACTUALIZANDO
			//if(recorrido.get(e).get_cantPasajeros()==0) return true;
			Tramo actual = recorrido.get(e);
		if(pesos.containsKey(actual) && pesos.get(actual)==0) {
			return true;
		}
		}
		return false;
	}
	
	public List<List<Estacion>> caminos (Estacion e1, Estacion e2){
		List<List<Estacion>> salida = new ArrayList<List<Estacion>>();
		List<Estacion> marcados = new ArrayList<Estacion>();
		marcados.add(e1);
		buscarCaminos(e1,e2,marcados,salida);
		return salida;
	}
	public void buscarCaminos(Estacion e1, Estacion e2, List<Estacion> marcados, List<List<Estacion>> salida) {
		List<Estacion> adyacentes = this.getNeighbourhood(e1);
		List<Estacion> copiaMarcados = null;
		for(Estacion ady : adyacentes) {
			copiaMarcados = marcados.stream().collect(Collectors.toList());
			if(ady.equals(e2)) {
				copiaMarcados.add(e2);
				salida.add(new ArrayList<Estacion>(copiaMarcados));
			}
			else {
				if (! copiaMarcados.contains(ady)) {
					copiaMarcados.add(ady);
					this.buscarCaminos(ady, e2, copiaMarcados, salida);
				}		
			}
		}
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
	/*	Map<Estacion, Double> pr = new HashMap<Estacion, Double>();
		pr= grafo.pageRank(grafo);
		for(int i=0; i<pr.size();i++) {
			System.out.println(vertices.get(i).toString()+": pageRank -> "+ pr.get(vertices.get(i)));
		}
		*/
		/*List<Map<Estacion, Tramo>>recorridos = grafo.paths(EstacionesRepo.ObtenerEstacion(47), EstacionesRepo.ObtenerEstacion(49));
		for(Map<Estacion, Tramo> rec: recorridos) {
			System.out.println(rec.keySet().toString());
		}*/
		
		/*List<List<Estacion>> recorridos= grafo.caminos(EstacionesRepo.ObtenerEstacion(47), EstacionesRepo.ObtenerEstacion(49));
		for(List<Estacion> rec: recorridos) {
			System.out.println(rec.toString());
		}
		*/
	//	Map<Estacion, Tramo> vecinos = grafo.getNeighbourhood1(EstacionesRepo.ObtenerEstacion(47));
		//System.out.println(vecinos.toString());
		System.out.println(grafo.flujoMaximo1(EstacionesRepo.ObtenerEstacion(47), EstacionesRepo.ObtenerEstacion(49)));
		
		
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
	private Map<Estacion, Tramo> getNeighbourhood1(Estacion e){ 
		Map<Estacion, Tramo> salida = new LinkedHashMap<Estacion, Tramo>();
		for(Tramo tramo : this.edges){
			if(tramo.getOrigen().equals(e) && tramo.get_cantPasajeros()>0) {
				salida.put(tramo.getDestino(),tramo);
			}
		}
		return salida;
	}
	
	    public List<Map<Estacion, Tramo>> paths(Estacion e1 ,Estacion e2){
	    	List<Map<Estacion, Tramo>>salida = new ArrayList<Map<Estacion, Tramo>>();
	    	Map<Estacion, Tramo> marcados = new LinkedHashMap<Estacion, Tramo>();
	    //	marcados.put(e1, null);
	    	findPathAux(e1,e2,marcados, salida);
	    	return salida;
	    }

	    private void findPathAux(Estacion e1,Estacion e2, Map<Estacion, Tramo> marcados, List<Map<Estacion, Tramo>> todos) {
	    	Map <Estacion, Tramo> adyascentes = this.getNeighbourhood1(e1);
	    	Map<Estacion, Tramo> copiaMarcados = null;
	    	for(Estacion ady: adyascentes.keySet()) {
	    	copiaMarcados= marcados.keySet().stream().collect(Collectors.toMap(e -> e,e -> marcados.get(e))); 
	    		if(ady.equals(e2)) {
	    			copiaMarcados.put(e2, adyascentes.get(ady));
	    			todos.add(new LinkedHashMap<Estacion, Tramo>(copiaMarcados));
	    		}else {
	    			if(!copiaMarcados.keySet().contains(ady)) {
	    				copiaMarcados.put(ady, adyascentes.get(ady));
	    				this.findPathAux(ady,e2,copiaMarcados, todos);
	    			}
	    		}
	    	}
	    }
	    
	    
  
}
	