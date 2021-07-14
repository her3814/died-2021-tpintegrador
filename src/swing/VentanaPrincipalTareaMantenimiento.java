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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Font;

public class VentanaPrincipalTareaMantenimiento {

	private static JFrame ventana1;
	private static PanelGestionarTareaMantenimiento panelGestionarTareaMantenimiento;
	private static PanelAgregarTareaMantenimiento panelAgregarTareaMantenimiento;
	private static PanelBuscarTareaMantenimiento panelBuscarTareaMantenimiento;
	private static PanelVerHistorial panelVerHistorial;

	public static void main(String[] args) {
		ventana1= new JFrame();
		ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
		ventana1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panelGestionarTareaMantenimiento=  new PanelGestionarTareaMantenimiento();
		panelGestionarTareaMantenimiento.getHistorial().setBackground(new Color(204, 204, 0));
		GridBagLayout gridBagLayout = (GridBagLayout) panelGestionarTareaMantenimiento.getLayout();
		gridBagLayout.columnWeights = new double[]{1.0};
		panelGestionarTareaMantenimiento.getBuscar().setBackground(new Color(204, 204, 102));
		panelGestionarTareaMantenimiento.getCrear().setBackground(new Color(204, 204, 153));
		panelGestionarTareaMantenimiento.getCrear().setText("CREAR TAREA DE MANTENIMIENTO");
		panelAgregarTareaMantenimiento = new PanelAgregarTareaMantenimiento();
		panelBuscarTareaMantenimiento = new PanelBuscarTareaMantenimiento();
		panelVerHistorial = new PanelVerHistorial();
		
		ventana1.setContentPane(panelGestionarTareaMantenimiento);
		ventana1.pack();
		ventana1.setBackground(Color.WHITE);
		ventana1.setSize(new Dimension(500,300));
		ventana1.setMinimumSize(new Dimension(500,500));
		ventana1.setLocationRelativeTo(null);
		ventana1.setVisible(true);
		
		panelGestionarTareaMantenimiento.getCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("CREAR TAREA DE MANTENIMIENTO");
				ventana1.setContentPane(panelAgregarTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelGestionarTareaMantenimiento.getBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("BUSCAR TAREA DE MANTENIMIENTO");
				ventana1.setContentPane(panelBuscarTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelGestionarTareaMantenimiento.getHistorial().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("VER HISTORIAL");
				ventana1.setContentPane(panelVerHistorial);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelVerHistorial.getBtnNewButton_2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
				ventana1.setContentPane(panelGestionarTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelBuscarTareaMantenimiento.getBtnNewButton_2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
				ventana1.setContentPane(panelGestionarTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelAgregarTareaMantenimiento.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
				ventana1.setContentPane(panelGestionarTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
	}
	

	
	
}