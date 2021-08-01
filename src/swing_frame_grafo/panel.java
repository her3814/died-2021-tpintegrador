package swing_frame_grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import modelo.Estacion;

public class panel extends JPanel {
	ArrayList<vertice> vertices;
	ArrayList<arista> aristas;

	Random r = new Random();
	grafo grafo;
	TramoMostrarEnum _mostrar;

	public panel(grafo grafo, TramoMostrarEnum mostrar) {
		this.grafo = grafo;
		this.setBackground(Color.WHITE);
		vertices = new ArrayList<vertice>();
		aristas = new ArrayList<arista>();
		_mostrar = mostrar;
		crearMapa();
	}

	public void crearVertice(Estacion e, int x, int y) {
		vertices.add(new vertice(e, x, y));
	}

	public void crearArista(Recorrido[] r, int x1, int y1, int x2, int y2) {
		aristas.add(new arista(r, x1, y1, x2, y2, _mostrar));
	}

	public void crearMapa() {
		aleatoridad ram = new aleatoridad(grafo.getKeys().size(), 600, 320, 25, 40);
		ArrayList<Point> ra = ram.getList();

		HashMap<Estacion, Point> conjunto = new HashMap<Estacion, Point>();

		List<Estacion> keys = grafo.getKeys();

		// Se cargan los vertices y su ubicación
		for (int i = 0; i < keys.size(); i++) {
			crearVertice(keys.get(i), ra.get(i).x, ra.get(i).y);
			conjunto.put(keys.get(i), new Point(ra.get(i).x, ra.get(i).y));
		}

		// Se cargan las aristas entre vertices
		for (int v = 0; v < grafo.getKeys().size(); v++) {

			HashMap<Estacion, Recorrido[]> relacion = grafo.getVertice(keys.get(v));

			List<Estacion> kU = new ArrayList<Estacion>();
			kU.addAll(relacion.keySet());

			for (int u = 0; u < kU.size(); u++) {
				Recorrido[] val = relacion.get(kU.get(u));
				Point v1 = conjunto.get(keys.get(v));
				Point v2 = conjunto.get(kU.get(u));

				if (v2 == null)
					return;

				crearArista(val, v1.x, v1.y, v2.x, v2.y);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D graph2 = (Graphics2D) g;

		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).paint(g);
		}

		for (int i = 0; i < aristas.size(); i++) {
			aristas.get(i).paint(graph2);
		}

		this.repaint();
	}
}
