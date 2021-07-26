package swing_frame_grafo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import modelo.ColoresLineasEnum;

/**
 * Clase de paquete representando una arista de un grafo dibujable.
 * No se debe utilizar esta clase para calculos o procesamiento logico/matematico de grafos *
 */
class arista {
	Color color;
	Random r = new Random();
	int x1, y1, x2, y2;
	Map<Color, String> valores;

	public arista(Recorrido[] recorridos, int x1, int y1, int x2, int y2, TramoMostrarEnum mostrar) {

		this.x1 = x1 + 20;
		this.y1 = y1;
		this.x2 = x2 - 20;
		this.y2 = y2;
		valores = new HashMap<Color, String>();
		for (Recorrido recorrido : recorridos) {
			String texto = null;
			switch (mostrar) {
			case CAPACIDAD:
				texto = recorrido.getCapacidad() + "PASAJEROS";
				break;
			case COSTO:
				texto = "$" + recorrido.getCosto();
				break;
			case DURACION:
				texto = recorrido.getDuracion() + "MINS";
				break;
			case LINEA:
				texto =  recorrido.getLineaNombre();
				break;
			case TODO:
				texto = String.format(Locale.CANADA, "%s - T: %s MINS, C: %s, L: %s KM, V: %s",
						recorrido.getLineaNombre(), recorrido.getDuracion().toString(),
						recorrido.getCapacidad().toString(), recorrido.getDistancia().toString(),
						recorrido.getCosto().toString());
			default:
				break;
			}

			valores.put(ColorToRgb.GetRgb(ColoresLineasEnum.valueOf(recorrido.getColor())), texto);
		}

	}

	public void paint(Graphics2D g) {
		// Solucion para colocar flecha en la arista
		// https://stackoverflow.com/a/27461352
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

		int[] xpoints = { x2, (int) xm, (int) xn };
		int[] ypoints = { y2, (int) ym, (int) yn };

		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(x1, y1, x2, y2);
		g.setStroke(new BasicStroke(3));
		g.setColor(color);
		g.fillPolygon(xpoints, ypoints, 3);

		Font fuente = new Font("Courier", Font.BOLD, 12);
		g.setFont(fuente);

		int i = 0;
		for (Color color : valores.keySet()) {
			FontMetrics fm = g.getFontMetrics();
			int hFont = fm.getHeight()/2 * i;
			g.setColor(color);
			g.drawString(valores.get(color), ((x1 + x2) / 2) - fm.stringWidth(valores.get(color)) / 2,
					((y1 + y2) / 2) - hFont);
			i++;
		}

	}

	public void drawCenteredString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int x = (w - fm.stringWidth(s)) / 2;
		int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(s, x, y);
	}
}
