package grafo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PageRank {
	private static final double BETA = 0.85;
	private double eps;   //page rank convergence
	private int numEdges; //number of edges
	private int numVert;  //number of vertices
	private int numIter;  //number of page rank iterations
	private Map<String, List<String>> gradoSalida; //out degree of vertices
	private Map<String, List<String>> gradoEntrada; //in degree of vertices
	private Map<String, Double> pageRanks;  //page ranks of vertices
	private Set<String> nodeCounter;        //list of vertices
	
	/**
	 * Creates a new PageRank object.  This is used to find the pagerank
	 * of a graph represented as an edgelist in a text file.
	 * @param graph Name of text file containing graph edge list.
	 * @param eps Convergence parameter for pagerank.
	 * @throws FileNotFoundException If text file containing graph cannot be found.
	 * @throws IOException If error reading a text file.
	 */
	public PageRank(Graph grafo, double eps)  {
		this.eps = eps;
		numIter = 0;
		numEdges = grafo.getEdges().size();
		gradoSalida = new HashMap<String, List<String>>();
		gradoEntrada = new HashMap<String, List<String>>();
		Set<String> nodeCounter = new HashSet<String>();
	
		String nodes[];
		List<String> toList;
		List<String> fromList;
		for(int i=0;i<grafo.getEdges().size();i++) {
			nodes = grafo.getEdges().get(i).toString();
		}
		while((line = b.readLine()) != null) { 
			numEdges++;
			nodes = line.toLowerCase().split(" ");
			
			//A->B
			if(!AtoB.containsKey(nodes[0])) {
				toList = new ArrayList<String>();
				toList.add(nodes[1]);
				
				AtoB.put(nodes[0], toList);
			} else {
				toList = AtoB.get(nodes[0]);
				toList.add(nodes[1]);
				
				AtoB.put(nodes[0], toList);
			}
			//B->A
			if(!BtoA.containsKey(nodes[1])) {
				fromList = new ArrayList<String>();
				fromList.add(nodes[0]);
				
				BtoA.put(nodes[1], fromList);
			} else {
				fromList = BtoA.get(nodes[1]);
				fromList.add(nodes[0]);
				
				BtoA.put(nodes[1], fromList);
			}
			nodeCounter.add(nodes[0]);
			nodeCounter.add(nodes[1]);
		}
		this.nodeCounter = nodeCounter;
		numVert = nodeCounter.size();
		b.close();
		
		pageRanks = calcPageRank();
	}
	
	/**
	 * Returns the pagerank of this vertex.
	 * @param vertexName Name of vertex to find pagerank.
	 * @return Pagerank of this vertex.
	 */
	public double pageRankOf(String vertexName) {
		vertexName = vertexName.toLowerCase();
		return(pageRanks.get(vertexName));
	}
	