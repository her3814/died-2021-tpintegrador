package swing_frame_grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import modelo.Estacion;
import modelo.EstadoEstacionEnum;

public class vertice {
	Color color;
	int x, y;
	String nombre;
	Random r = new Random();

	public vertice(String nombre, int x, int y) {
		color = Color.LIGHT_GRAY;
		this.x = x-20;
		this.y = y-20;
		this.nombre = nombre;	
		}
	
	public vertice(Estacion estacion, int x, int y) {
		color = estacion.getEstado().equals(EstadoEstacionEnum.OPERATIVA) ? Color.GREEN : Color.RED;		
		this.x = x ;
		this.y = y ;
		this.nombre = estacion.getNombre();
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 40, 40);
		g.setColor(Color.BLACK);
		g.drawString(nombre, x+20, y+20);
	}
}
