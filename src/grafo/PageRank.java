package grafo;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import bdd.EstacionesRepo;
import bdd.TramosRepo;
import modelo.Estacion;

public class PageRank {
	
	public static void main(String[] args) {
		Graph grafo = new Graph();
		grafo.setEdges(TramosRepo.obtenerTramos());
		grafo.setVertexs(EstacionesRepo.ObtenerEstaciones());
		System.out.println(pageRank(grafo));
	}
	

	
	
}