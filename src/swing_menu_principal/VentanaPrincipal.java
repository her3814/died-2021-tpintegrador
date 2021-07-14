package swing_menu_principal;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import swing_lineas.PanelAgregarLinea;
import swing_lineas.PanelBuscarLinea;
import swing_menu_principal.PanelMenuPrincipal;
import swing_boletos.PanelGestionarBoletos;
import swing_estaciones.PanelAgregarEstacion;
import swing_estaciones.PanelBuscarEstacion;
import swing_estaciones.PanelGestionarEstaciones;
import swing_lineas.PanelGestionarLineas;
import swing_tareas_mantenimiento.PanelAgregarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelBuscarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelGestionarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelVerHistorialTareaMantenimiento;
import swing_tramos.PanelGestionarTramos;

import java.awt.Color;
import java.awt.Dimension;

public class VentanaPrincipal {

	private static JFrame ventana1;
	
	private static PanelGestionarTareaMantenimiento panelGestionarTareaMantenimiento;
	private static PanelAgregarTareaMantenimiento panelAgregarTareaMantenimiento;
	private static PanelBuscarTareaMantenimiento panelBuscarTareaMantenimiento;
	private static PanelVerHistorialTareaMantenimiento panelVerHistorialTareaMantenimiento;
	
	
	private static PanelGestionarEstaciones panelGestionarEstaciones;
	private static PanelAgregarEstacion panelAgregarEstacion;
	private static PanelBuscarEstacion panelBuscarEstacion;
	
	private static PanelGestionarTramos panelGestionarTramos;
	private static PanelGestionarBoletos panelGestionarBoletos;
	private static PanelMenuPrincipal panelMenuPrincipal;
	
	private static PanelGestionarLineas panelGestionarLineas;
	private static PanelAgregarLinea panelAgregarLinea;
	private static PanelBuscarLinea panelBuscarLinea;
	
	public static void main(String[] args) {
		ventana1= new JFrame();
		ventana1.setTitle("MENU PRINCIPAL");
		ventana1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		ventana1.setSize(new Dimension(600,600));
		ventana1.setMinimumSize(new Dimension(300,300));
		
		
		panelMenuPrincipal = new PanelMenuPrincipal();
		GridBagLayout gridBagLayout = (GridBagLayout) panelMenuPrincipal.getLayout();
		gridBagLayout.columnWeights = new double[]{1.0};
		
		//TAREA MANTENIMIENTO
		panelGestionarTareaMantenimiento=  new PanelGestionarTareaMantenimiento();
		panelAgregarTareaMantenimiento = new PanelAgregarTareaMantenimiento();
		panelBuscarTareaMantenimiento = new PanelBuscarTareaMantenimiento();
		panelVerHistorialTareaMantenimiento = new PanelVerHistorialTareaMantenimiento();
		
		//ESTACIONES
		panelGestionarEstaciones = new PanelGestionarEstaciones();
		panelAgregarEstacion = new PanelAgregarEstacion();
		panelBuscarEstacion = new PanelBuscarEstacion();
		
		//TRAMOS
		panelGestionarTramos = new PanelGestionarTramos();
		
		//BOLETOS
		panelGestionarBoletos = new PanelGestionarBoletos();
	
		//LINEAS
		panelGestionarLineas= new PanelGestionarLineas();
		panelAgregarLinea = new PanelAgregarLinea();
		panelBuscarLinea= new PanelBuscarLinea();

		ventana1.setContentPane(panelMenuPrincipal);
		ventana1.pack();
		ventana1.setBackground(Color.WHITE);
		ventana1.setSize(new Dimension(500,300));
		ventana1.setMinimumSize(new Dimension(600,500));
		ventana1.setLocationRelativeTo(null);
		ventana1.setVisible(true);
		
		//MENU PRINCIPAL
		panelMenuPrincipal.getEstaciones().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});

		panelMenuPrincipal.getLineas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR LINEAS");
				ventana1.setContentPane(panelGestionarLineas);
				ventana1.setVisible(true);
				ventana1.pack(); 
			}
		});
		
		panelMenuPrincipal.getBoletos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR BOLETOS");
				ventana1.setContentPane(panelGestionarBoletos);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelMenuPrincipal.getTramos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TRAMOS");
				ventana1.setContentPane(panelGestionarTramos);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		//------------------------------------------------------------------------------------
		// 						TAREAS DE MANTENIMIENTO 
		
		panelMenuPrincipal.getTareas_mantenimiento().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
				ventana1.setContentPane(panelGestionarTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});

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
				ventana1.setContentPane(panelVerHistorialTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelVerHistorialTareaMantenimiento.getBtnNewButton_2().addActionListener(new ActionListener() {
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
		
		

		//ESTACIONES
		panelGestionarEstaciones.getVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("MENU PRINCIPAL");
				ventana1.setContentPane(panelMenuPrincipal);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelGestionarEstaciones.getCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("AGREGAR ESTACION");
				ventana1.setContentPane(panelAgregarEstacion);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelGestionarEstaciones.getBuscar().addActionListener(new ActionListener() {
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
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelAgregarEstacion.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		//BOTONES VOLVER
		
		panelGestionarLineas.getVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("MENU PRINCIPAL");
				ventana1.setContentPane(panelMenuPrincipal);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelGestionarTramos.getVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("MENU PRINCIPAL");
				ventana1.setContentPane(panelMenuPrincipal);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelGestionarBoletos.getVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("MENU PRINCIPAL");
				ventana1.setContentPane(panelMenuPrincipal);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelGestionarTareaMantenimiento.getVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("MENU PRINCIPAL");
				ventana1.setContentPane(panelMenuPrincipal);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		
		//LINEAS
		panelGestionarLineas.getAgregar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("AGREGAR LINEA");
				ventana1.setContentPane(panelAgregarLinea);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelGestionarLineas.getBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("BUSCAR LINEA");
				ventana1.setContentPane(panelBuscarLinea);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelAgregarLinea.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR LINEAS");
				ventana1.setContentPane(panelGestionarLineas);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelBuscarLinea.getBtncancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR LINEAS");
				ventana1.setContentPane(panelGestionarLineas);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
	}
}