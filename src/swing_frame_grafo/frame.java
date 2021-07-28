package swing_frame_grafo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import bdd.LineasRepo;
import bdd.TramosRepo;
import modelo.Linea;
import modelo.Tramo;

public class frame {

	
	public static void createFrame(grafo g, TramoMostrarEnum mostrar) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(600, 320);
		frame.setUndecorated(true);

		panel p = new panel(g, mostrar);
		frame.getContentPane().add(p);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		Action closeAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		};

		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(esc, "closex");
		frame.getRootPane().getActionMap().put("closex", closeAction);

		KeyStroke ctrlW = KeyStroke.getKeyStroke("control W");
		frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(ctrlW, "close");
		frame.getRootPane().getActionMap().put("close", closeAction);

	}

	public static void main(String[] a) {
		Linea l = LineasRepo.ObtenerLinea(17);
		List<Tramo> t = TramosRepo.ObtenerRecorrido(l);
		grafo g = grafo.ObtenerGrafoDesdeRecorrido(t);
		frame.createFrame(g, TramoMostrarEnum.DURACION);
	}
}
