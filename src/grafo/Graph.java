package grafo;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
	
	
  
}
	