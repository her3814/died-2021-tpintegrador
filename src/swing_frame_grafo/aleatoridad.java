package swing_frame_grafo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class aleatoridad {
	Random r;
	int ini, fin;
	int lim;

	int limiteX;
	int limiteY;
	int pad;
	ArrayList<Point> puntos;

	public aleatoridad(int cantVertices, int ancho, int alto, int padding, int diamVertices) {
		r = new Random();
		ini = 0;
		fin = cantVertices;
		limiteX = ancho;
		limiteY = alto;
		pad = padding;
		puntos = new ArrayList<Point>();
		lim = (int) (diamVertices * 1.5);
		crearCirculos();
	}

	private boolean rango(int distancia, int e) {
		boolean salida = false;
		// Si no hay puntos no compruebo nada
		if (puntos.isEmpty()) {
			return true;
		} 
		else {
			
			for (Point i : puntos) {
				int x = i.x;
				int y = i.y;
				if ((e == 1 && Math.abs(distancia - x) >= lim) || (e == 0 && Math.abs(distancia - y) >= lim))
					return true;
			}
		}
		return salida;
	}

	private void crearCirculos() {
		while (ini < fin) {
			int x = r.nextInt(limiteX);
			int y = r.nextInt(limiteY);

			if (x > pad && x < limiteX - pad && y > pad && y < limiteY - pad && (rango(x, 1) || rango(y, 0))) {
				puntos.add(new Point(x, y));
				ini++;
			}
		}
	}

	public ArrayList<Point> getList() {
		return puntos;
	}
}
