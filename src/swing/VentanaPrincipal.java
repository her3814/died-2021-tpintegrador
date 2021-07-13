package swing;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VentanaPrincipal {

	private static JFrame ventana1;
	private static PanelGestionarEstacion panelGestionarEstacion;
	private static PanelAgregarEstacion panelAgregarEstacion;
	private static PanelBuscarEstacion panelBuscarEstacion;
	public static void main(String[] args) {
		ventana1= new JFrame();
		ventana1.setTitle("GESTIONAR ESTACIONES");
		ventana1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	//	ventana1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//ventana1.setSize(900, 900);
		
		
		panelGestionarEstacion=  new PanelGestionarEstacion();
		panelAgregarEstacion= new PanelAgregarEstacion();
		panelBuscarEstacion = new PanelBuscarEstacion();
		
		ventana1.setContentPane(panelGestionarEstacion);
		//ventana1.setContentPane(panelAgregarEstacion);
		//ventana1.setContentPane(panelBuscarEstacion);
		ventana1.pack();
		ventana1.setLocationRelativeTo(null); // me abre la ventana en el centro de mi pantalla
		ventana1.setVisible(true);
		
		panelGestionarEstacion.getCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("AGREGAR ESTACION");
				ventana1.setContentPane(panelAgregarEstacion);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelGestionarEstacion.getBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("BUSCAR ESTACION");
				ventana1.setContentPane(panelBuscarEstacion);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelBuscarEstacion.getBtnNewButton_2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstacion);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
	}
	

	
	
}