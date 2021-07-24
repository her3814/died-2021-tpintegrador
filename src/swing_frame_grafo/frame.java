package swing_frame_grafo;

import java.util.List;

import javax.swing.JFrame;

import bdd.LineasRepo;
import bdd.TramosRepo;
import modelo.Linea;
import modelo.Tramo;

public class frame {
	public frame(grafo g, TramoMostrarEnum mostrar) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(600,320);
		frame.setUndecorated(true);
				
		panel p = new panel(g, mostrar);
		frame.getContentPane().add(p);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] a) {
		Linea l = LineasRepo.ObtenerLinea(1);
		List<Tramo> t = TramosRepo.ObtenerRecorrido(l);
		grafo g = grafo.ObtenerGrafoDesdeRecorrido(t);	
		frame _f = new frame(g, TramoMostrarEnum.DURACION);
	}
}
