package swing_frame_grafo;

import javax.swing.JFrame;

public class frame {
	public frame(grafo g) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(600,320);
		frame.setUndecorated(true);
				
		panel p = new panel(g);
		frame.getContentPane().add(p);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] a) {
		grafo g = grafo.ObtenerGrafoEstacionesPorCosto();
		frame f = new frame(g);
	}
}
