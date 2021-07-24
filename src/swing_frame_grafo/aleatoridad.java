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
		lim = (int) (diamVertices * 1.2);
		crearCirculos();
	}

	private boolean rango(int distancia, int e) {
		boolean salida = false;
		// Si no hay puntos no compruebo nada
		if (puntos.isEmpty()) {
			return true;
		} else {

			for (Point i : puntos) {
				int x = i.x;
				int y = i.y;
				if ((e == 1 && Math.abs(distancia - x) >= lim) || (e == 0 && Math.abs(distancia - y) >= lim))
					return true;
			}
		}
		return salida;
	}

	/**
	 * Comprueba que no exista un punto en la posición indicada
	 * 
	 * @param x
	 * @param y
	 * @return false si existe un punto cercano a la posicion brindada, true si no
	 *         existen puntos en esa posición
	 */
	private boolean checkPoint(int x, int y) {
		for (Point p : puntos) {
			if (Math.abs(x - p.getX()) <= lim && Math.abs(y - p.getY()) <= lim)
				return false;
		}
		return true;
	}

	private void crearCirculos() {
		while (ini < fin) {

			int x = r.nextInt(7);
			int y = r.nextInt(3);

			x = 20 + 40 * Math.floorMod(y, 2) + 80 * x;
			y = 40 + 100 * Math.floorMod(y, 3);
			if (x > pad && x < limiteX - pad && y > pad && y < limiteY - pad && checkPoint(x, y)) {
				puntos.add(new Point(x, y));
				ini++;
			}
		}
	}

	public ArrayList<Point> getList() {
		return puntos;
	}
}
