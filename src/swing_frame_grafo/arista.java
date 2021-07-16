package swing_frame_grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Random;

public class arista {
	Color color;
	Random r = new Random();
	int x1, y1, x2, y2;
	Double valor;

	public arista(Double d, int x, int y, int x1, int y1) {
		color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));

		this.x1 = x+20;
		this.y1 = y;
		this.x2 = x1-20;
		this.y2 = y1;

		this.valor = d;
	}

	public void paint(Graphics g) {
		// Solucion para colocar flecha en la arista https://stackoverflow.com/a/27461352
		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx * dx + dy * dy);
		double xm = D - 5, xn = xm, ym = 5, yn = -5, x;
		double sin = dy / D, cos = dx / D;

		x = xm * cos - ym * sin + x1;
		ym = xm * sin + ym * cos + y1;
		xm = x;

		x = xn * cos - yn * sin + x1;
		yn = xn * sin + yn * cos + y1;
		xn = x;

	    int[] xpoints = {x2, (int) xm, (int) xn};
	    int[] ypoints = {y2, (int) ym, (int) yn};

		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);

		g.setColor(color);
		g.fillPolygon(xpoints, ypoints, 3);

		g.setColor(color);
		g.drawString(valor.toString(), ((x1 + x2) / 2), ((y1 + y2) / 2));
	}
}
