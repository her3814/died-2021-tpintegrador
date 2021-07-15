package swing_menu_principal;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import bdd.EstacionesRepo;
import filtros.EstacionesFiltro;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import swing_lineas.PanelAgregarLinea;
import swing_lineas.PanelBuscarLinea;
import swing_menu_principal.PanelMenuPrincipal;
//import swing_boletos.PanelAgregarBoleto;
//import swing_boletos.PanelBuscarBoleto;
import swing_boletos.PanelGestionarBoletos;
import swing_estaciones.PanelAgregarEstacion;
import swing_estaciones.PanelBuscarEstacion;
import swing_estaciones.PanelErrorEnTodo;
import swing_estaciones.PanelEstacionAgregada;
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
	private static PanelEstacionAgregada panelEstacionAgregada;
	private static PanelErrorEnTodo panelErrorEnTodo;
	
	private static PanelGestionarTramos panelGestionarTramos;
	
	private static PanelGestionarBoletos panelGestionarBoletos;
//	private static PanelAgregarBoleto panelAgregarBoleto;
//	private static PanelBuscarBoleto panelBuscarBoleto;

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
		ventana1.setBackground(Color.WHITE);
		
		panelMenuPrincipal = new PanelMenuPrincipal();
		panelMenuPrincipal.getTramos().setBackground(new Color(204, 204, 0));
		panelMenuPrincipal.getBoletos().setBackground(new Color(204, 204, 51));
		panelMenuPrincipal.getLineas().setBackground(new Color(204, 204, 102));
		panelMenuPrincipal.getTareas_mantenimiento().setBackground(new Color(204, 204, 153));
		panelMenuPrincipal.getEstaciones().setBackground(new Color(204, 204, 204));
		GridBagLayout gridBagLayout = (GridBagLayout) panelMenuPrincipal.getLayout();
		gridBagLayout.columnWeights = new double[]{1.0};
		
		//TAREA MANTENIMIENTO
		panelGestionarTareaMantenimiento =  new PanelGestionarTareaMantenimiento();
		panelGestionarTareaMantenimiento.setSize(new Dimension(600,600));
		panelGestionarTareaMantenimiento.setMinimumSize(new Dimension(300,300));
		panelGestionarTareaMantenimiento.setBackground(Color.WHITE);

		panelAgregarTareaMantenimiento = new PanelAgregarTareaMantenimiento();
		panelAgregarTareaMantenimiento.setSize(new Dimension(600,600));
		panelAgregarTareaMantenimiento.setMinimumSize(new Dimension(300,300));
		panelAgregarTareaMantenimiento.setBackground(Color.WHITE);

		panelBuscarTareaMantenimiento = new PanelBuscarTareaMantenimiento();
		panelBuscarTareaMantenimiento.setSize(new Dimension(600,600));
		panelBuscarTareaMantenimiento.setMinimumSize(new Dimension(600,500));
		panelBuscarTareaMantenimiento.setBackground(Color.WHITE);

		panelVerHistorialTareaMantenimiento = new PanelVerHistorialTareaMantenimiento();
		panelVerHistorialTareaMantenimiento.setSize(new Dimension(600,600));
		panelVerHistorialTareaMantenimiento.setMinimumSize(new Dimension(600,500));
		panelVerHistorialTareaMantenimiento.setBackground(Color.WHITE);

		//ESTACIONES
		panelGestionarEstaciones = new PanelGestionarEstaciones();
		panelGestionarEstaciones.setSize(new Dimension(600,600));
		panelGestionarEstaciones.setMinimumSize(new Dimension(600,500));
		panelGestionarEstaciones.setBackground(Color.WHITE);

		panelAgregarEstacion = new PanelAgregarEstacion();
		panelAgregarEstacion.setSize(new Dimension(600,600));
		panelAgregarEstacion.setMinimumSize(new Dimension(600,500));
		panelAgregarEstacion.setBackground(Color.WHITE);

		panelBuscarEstacion = new PanelBuscarEstacion();
		panelBuscarEstacion.setSize(new Dimension(600,600));
		panelBuscarEstacion.setMinimumSize(new Dimension(600,500));
		panelBuscarEstacion.setBackground(Color.WHITE);
		
		panelEstacionAgregada = new PanelEstacionAgregada();
		panelEstacionAgregada.setSize(new Dimension(600,600));
		panelEstacionAgregada.setMinimumSize(new Dimension(600,500));
		panelEstacionAgregada.setBackground(Color.WHITE);
		
		panelErrorEnTodo = new PanelErrorEnTodo();
		panelErrorEnTodo.setSize(new Dimension(600,600));
		panelErrorEnTodo.setMinimumSize(new Dimension(600,500));
		panelErrorEnTodo.setBackground(Color.WHITE);

		//TRAMOS
		panelGestionarTramos = new PanelGestionarTramos();
		panelGestionarTramos.setSize(new Dimension(600,600));
		panelGestionarTramos.setMinimumSize(new Dimension(600,500));
		panelGestionarTramos.setBackground(Color.WHITE);

		//BOLETOS
		panelGestionarBoletos = new PanelGestionarBoletos();
		panelGestionarBoletos.setSize(new Dimension(600,600));
		panelGestionarBoletos.setMinimumSize(new Dimension(600,500));
		panelGestionarBoletos.setBackground(Color.WHITE);

	/*	panelAgregarBoleto = new PanelAgregarBoleto();
		panelAgregarBoleto.setSize(new Dimension(600,600));
		panelAgregarBoleto.setMinimumSize(new Dimension(600,500));
		panelAgregarBoleto.setBackground(Color.WHITE);
		
		panelBuscarBoleto = new PanelBuscarBoleto();
		panelBuscarBoleto.setSize(new Dimension(600,600));
		panelBuscarBoleto.setMinimumSize(new Dimension(600,500));
		panelBuscarBoleto.setBackground(Color.WHITE);
		
		*/
		//LINEAS
		panelGestionarLineas= new PanelGestionarLineas();
		panelGestionarLineas.setSize(new Dimension(600,600));
		panelGestionarLineas.setMinimumSize(new Dimension(600,500));
		panelGestionarLineas.setBackground(Color.WHITE);

		panelAgregarLinea = new PanelAgregarLinea();
		panelAgregarLinea.setSize(new Dimension(600,600));
		panelAgregarLinea.setMinimumSize(new Dimension(600,500));
		panelAgregarLinea.setBackground(Color.WHITE);

		panelBuscarLinea= new PanelBuscarLinea();
		panelBuscarLinea.setSize(new Dimension(600,600));
		panelBuscarLinea.setMinimumSize(new Dimension(600,500));
		panelBuscarLinea.setBackground(Color.WHITE);

		ventana1.setContentPane(panelMenuPrincipal);
		ventana1.pack();
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
		panelBuscarTareaMantenimiento.getCancelar().addActionListener(new ActionListener() {
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
		
		//------------------------------------------------------------------------------------
		// 					BOLETOS
		panelGestionarBoletos.getVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("MENU PRINCIPAL");
				ventana1.setContentPane(panelMenuPrincipal);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		/*
		panelGestionarBoletos.getCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("AGREGAR BOLETO");
				ventana1.setContentPane(panelAgregarBoleto);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelGestionarBoletos.getBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("BUSCAR BOLETO");
				ventana1.setContentPane(panelBuscarBoleto);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelAgregarBoleto.getCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR BOLETOS");
				ventana1.setContentPane(panelGestionarBoletos);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelBuscarBoleto.getCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR BOLETOS");
				ventana1.setContentPane(panelGestionarBoletos);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		*/

		//------------------------------------------------------------------------------------
		// 					ESTACIONES
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
				panelAgregarEstacion.limpiarDatos();
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		//public Estacion( String nombre, LocalTime horaApertura, LocalTime horaCierre)
	
		panelAgregarEstacion.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaPrincipal.agregarEstacion();
				//Estacion nueva =panelAgregarEstacion.getEstacionCreada();
				//EstacionesRepo.AgregarEstacion(nueva);
				//System.out.println(panelAgregarEstacion.estacionIngresada());
			}
		});
		
		panelEstacionAgregada.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarEstacion.limpiarDatos();
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelErrorEnTodo.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelBuscarEstacion.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstacionesFiltro ef= new EstacionesFiltro();
				ef.setNombre(panelBuscarEstacion.getTextoEscrito());
				ef.setId(Integer.getInteger(panelBuscarEstacion.getTextoEscrito()));
				
				JTable nuevaTabla= panelBuscarEstacion.renovarTabla(EstacionesRepo.ObtenerEstaciones(ef));
				
				//aplicar filtro segun el texto ingresado
			}
		});
		//------------------------------------------------------------------------------------
		// 					BOTONES VOLVER
		
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
	
	public static void agregarEstacion() {
		Estacion nueva =panelAgregarEstacion.getEstacionCreada();
		//Error en todo
		if(!nueva.getNombre().isEmpty() && nueva.getHorarioApertura()!=null && nueva.getHorarioCierre()!=null) {
			//EstacionesRepo.AgregarEstacion(nueva);
		}		
		if(nueva.getNombre().isEmpty() && nueva.getHorarioApertura()==null && nueva.getHorarioCierre()==null) {
			ventana1.setTitle("AGREGAR ESTACION");
			ventana1.setContentPane(panelErrorEnTodo);
			ventana1.setVisible(true);
			ventana1.pack();
		}
		
	}
}