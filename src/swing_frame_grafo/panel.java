package swing_frame_grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class panel extends JPanel {
	ArrayList<vertice> vertices;
	ArrayList<arista> aristas;

	Random r = new Random();
	grafo grafo1;

	public panel(grafo grafo) {
		this.grafo1 = grafo;

		this.setSize(600, 320);
		this.setBackground(Color.DARK_GRAY);
		vertices = new ArrayList<vertice>();
		aristas = new ArrayList<arista>();

		crearMapa();
	}

	public void crearVertice(String v, int x, int y) {
		vertices.add(new vertice(v, x, y));
	}

	public void crearArista(Double d, int x, int y, int x1, int y1) {
		aristas.add(new arista(d, x, y, x1, y1));
	}

	public void crearMapa() {
		aleatoridad ram = new aleatoridad(grafo1.getKeys().size(), 600, 320, 40, 80);
		ArrayList<Point> ra = ram.getList();

		HashMap<String, Point> conjunto = new HashMap<String, Point>();

		List<String> keys = grafo1.getKeys();

		// Se cargan los vertices y su ubicación
		for (int i = 0; i < keys.size(); i++) {
			crearVertice(keys.get(i), ra.get(i).x, ra.get(i).y);
			conjunto.put(keys.get(i), new Point(ra.get(i).x, ra.get(i).y));
		}
		
		
		
		
		// Se cargan las aristas entre vertices
		for (int v = 0; v < grafo1.getKeys().size(); v++) {

			HashMap<String, Double> relacion = grafo1.getVertice(keys.get(v));

			List<String> kU = new ArrayList<String>();
			kU.addAll(relacion.keySet());
			
			for (int u = 0; u < kU.size(); u++) {
				Double val = relacion.get(kU.get(u));
				Point v1 = conjunto.get(keys.get(v));
				Point v2 = conjunto.get(kU.get(u));
				
				if(v2.x == v2.y)
					return;
				
				crearArista(val,v1.x, v1.y, v2.x, v2.y);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 
		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).paint(g);
		}

		for (int i = 0; i < aristas.size(); i++) {
			aristas.get(i).paint(g);
		}
		
		this.repaint();
	}
}
