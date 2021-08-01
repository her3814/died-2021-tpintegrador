package swing_frame_grafo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
/**
 * Clase de paquete representando un vertice de un grafo dibujable.
 * No se debe utilizar esta clase para calculos o procesamiento logico/matematico de grafos *
 */
class vertice {
	Color color;
	int x, y;
	String nombre;

	public vertice(Estacion estacion, int x, int y){
		color = estacion.getEstado().equals(EstadoEstacionEnum.OPERATIVA) ? new Color(45,87,44) : new Color(76,0,19);
		this.x = x-20;
		this.y = y-20;
		this.nombre = estacion.getNombre();
		
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 40, 40);
		g.setColor(Color.BLACK);
		

		FontMetrics fm = g.getFontMetrics();
		Font fuente = new Font("Sans Serif", Font.BOLD, 10);
		g.setFont(fuente);
		g.setColor(Color.BLACK);
		g.drawString(nombre.toUpperCase(),20+x - fm.stringWidth(nombre) / 2, y +54);
		
		
	}
}
