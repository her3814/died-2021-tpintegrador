package swing_menu_principal;
import java.awt.GridBagLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

import bdd.EstacionesRepo;
import bdd.TareaMantenimientoRepo;
import excepciones.FechaFinMenorFechaInicioException;
import filtros.EstacionesFiltro;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.TareaMantenimiento;
import servicios.AltaEstacionServicio;
import swing_lineas.PanelAgregarLinea;
import swing_lineas.PanelBuscarLinea;
import swing_menu_principal.PanelMenuPrincipal;
import swing_boletos.PanelAgregarBoleto;
import swing_boletos.PanelBuscarBoleto;
//import swing_boletos.PanelAgregarBoleto;
//import swing_boletos.PanelBuscarBoleto;
import swing_boletos.PanelGestionarBoletos;
import swing_estaciones.PanelAgregarEstacion;
import swing_estaciones.PanelBuscarEstacion;
import swing_estaciones.PanelFlujoMaximo;
import swing_estaciones.PanelGestionarEstaciones;
import swing_estaciones.PanelInformacionEstaciones;
import swing_estaciones.PanelPageRank;
import swing_estaciones.PanelProximoMantenimiento;
import swing_lineas.PanelGestionarLineas;
import swing_tareas_mantenimiento.PanelAgregarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelBuscarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelGestionarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelVerHistorialTareaMantenimiento;
import swing_tramos.PanelAgregarTramo;
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
	private static PanelInformacionEstaciones panelInformacionEstaciones;
	private static PanelProximoMantenimiento panelProximoMantenimiento;
	private static PanelFlujoMaximo panelFlujoMaximo;
	private static PanelPageRank panelPageRank;

	private static PanelGestionarTramos panelGestionarTramos;
	private static PanelAgregarTramo panelAgregarTramo;
	
	private static PanelGestionarBoletos panelGestionarBoletos;
	private static PanelAgregarBoleto panelAgregarBoleto;
	private static PanelBuscarBoleto panelBuscarBoleto;

	private static PanelMenuPrincipal panelMenuPrincipal;
	
	private static PanelGestionarLineas panelGestionarLineas;
	private static PanelAgregarLinea panelAgregarLinea;
	private static PanelBuscarLinea panelBuscarLinea;
	

	public static void main(String[] args) {
		ventana1= new JFrame();
		ventana1.setTitle("MENU PRINCIPAL");
		ventana1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		ventana1.setPreferredSize(new Dimension(500,500));
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
		panelGestionarTareaMantenimiento.setBackground(Color.WHITE);

		panelAgregarTareaMantenimiento = new PanelAgregarTareaMantenimiento();
		panelAgregarTareaMantenimiento.setBackground(Color.WHITE);

		panelBuscarTareaMantenimiento = new PanelBuscarTareaMantenimiento();
		panelBuscarTareaMantenimiento.setBackground(Color.WHITE);

		panelVerHistorialTareaMantenimiento = new PanelVerHistorialTareaMantenimiento();
		panelVerHistorialTareaMantenimiento.setBackground(Color.WHITE);

		//ESTACIONES
		panelGestionarEstaciones = new PanelGestionarEstaciones();
		panelGestionarEstaciones.setBackground(Color.WHITE);

		panelAgregarEstacion = new PanelAgregarEstacion();
		panelAgregarEstacion.setBackground(Color.WHITE);

		panelBuscarEstacion = new PanelBuscarEstacion();
		panelBuscarEstacion.setBackground(Color.WHITE);

		panelInformacionEstaciones = new PanelInformacionEstaciones();
		panelInformacionEstaciones.setBackground(Color.WHITE);

		panelFlujoMaximo = new PanelFlujoMaximo();
		panelFlujoMaximo.setBackground(Color.WHITE);

		panelPageRank = new PanelPageRank();
		panelPageRank.setBackground(Color.WHITE);

		panelProximoMantenimiento = new PanelProximoMantenimiento();
		panelProximoMantenimiento.setBackground(Color.WHITE);


		//TRAMOS
		panelGestionarTramos = new PanelGestionarTramos();
		panelGestionarTramos.setBackground(Color.WHITE);
		
		panelAgregarTramo = new PanelAgregarTramo();
		panelAgregarTramo.setBackground(Color.WHITE);
		
		//BOLETOS
		panelGestionarBoletos = new PanelGestionarBoletos();
		panelGestionarBoletos.setBackground(Color.WHITE);

		panelAgregarBoleto = new PanelAgregarBoleto();
		panelAgregarBoleto.setBackground(Color.WHITE);
		
		panelBuscarBoleto = new PanelBuscarBoleto();
		panelBuscarBoleto.setBackground(Color.WHITE);
		
		//LINEAS
		panelGestionarLineas= new PanelGestionarLineas();
		panelGestionarLineas.setBackground(Color.WHITE);

		panelAgregarLinea = new PanelAgregarLinea();
		panelAgregarLinea.setBackground(Color.WHITE);

		panelBuscarLinea= new PanelBuscarLinea();
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
		
		//------------------------------------------------------------------------------------
		// 					TRAMOS
		
		panelMenuPrincipal.getTramos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TRAMOS");
				ventana1.setContentPane(panelGestionarTramos);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelGestionarTramos.getCrear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("AGREGAR TRAMO");
				ventana1.setContentPane(panelAgregarTramo);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelAgregarTramo.getBtnCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TRAMOS");
				ventana1.setContentPane(panelGestionarTramos);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		/*
		panelGestionarTramos.getBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("BUSCAR TRAMO");
				ventana1.setContentPane(panelBuscarTramo);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		})*/
		
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
		
		panelAgregarTareaMantenimiento.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarTareaMantenimiento.limpiarWarnings();
				try {
					VentanaPrincipal.agregarTareaMantenimiento();
				} catch (FechaFinMenorFechaInicioException e1) {
					panelAgregarTareaMantenimiento.mensajeFechaErronea();
				}
			}
		});
		
		panelAgregarTareaMantenimiento.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarTareaMantenimiento.limpiarWarnings();
				panelAgregarTareaMantenimiento.limpiarDatos();
				panelAgregarTareaMantenimiento.habilitarBotones();
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
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

		//------------------------------------------------------------------------------------
		// 						ESTACIONES
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
		
		panelGestionarEstaciones.getInformacion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("INFORMACION DE ESTACIONES");
				ventana1.setContentPane(panelInformacionEstaciones);
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
		
		panelInformacionEstaciones.getVolver().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelInformacionEstaciones.getMantenimiento().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("PROXIMO MANTENIMIENTO");
				ventana1.setContentPane(panelProximoMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelInformacionEstaciones.getPageRank().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("PAGE RANK");
				ventana1.setContentPane(panelPageRank);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelInformacionEstaciones.getFlujoMaximo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("FLUJO MAXIMO");
				ventana1.setContentPane(panelFlujoMaximo);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
			
		panelPageRank.getCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("INFORMACION DE ESTACIONES");
				ventana1.setContentPane(panelInformacionEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelFlujoMaximo.getCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("INFORMACION DE ESTACIONES");
				ventana1.setContentPane(panelInformacionEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelProximoMantenimiento.getCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("INFORMACION DE ESTACIONES");
				ventana1.setContentPane(panelInformacionEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelAgregarEstacion.getBtnNewButton_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarEstacion.limpiarDatos();
				panelAgregarEstacion.limpiarWarnings();
				panelAgregarEstacion.habilitarBotones();
				panelAgregarEstacion.habilitar();
				ventana1.setTitle("GESTIONAR ESTACIONES");
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		
		panelAgregarEstacion.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarEstacion.limpiarWarnings();
				VentanaPrincipal.agregarEstacion();
			}
		});
		panelAgregarEstacion.getBtnNewButton_3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarEstacion.limpiarDatos();
				panelAgregarEstacion.limpiarWarnings();
				panelAgregarEstacion.sacarMantenimiento();
				panelAgregarEstacion.habilitarBotones();
				panelAgregarEstacion.habilitar();
				ventana1.setTitle("AGREGAR ESTACION");
				ventana1.setContentPane(panelAgregarEstacion);
				ventana1.setVisible(true);
				ventana1.pack();
			}
		});
		panelAgregarEstacion.getBtnNewButton4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgregarEstacion.limpiarWarnings();
				if(panelAgregarEstacion.getDateChooser_1().getDate()==null) {
					panelAgregarEstacion.faltaFechaMant();
				}
				else {
					Estacion nueva =panelAgregarEstacion.getEstacionCreada();
					TareaMantenimiento tarea=null;
					try {
						tarea = panelAgregarEstacion.getTareaMantenimiento(nueva);
					} catch (FechaFinMenorFechaInicioException e1) {
						panelAgregarEstacion.mensajeFechaErronea();
					}
					if(tarea.getFechaFin().isAfter(tarea.getFechaInicio())) {
					AltaEstacionServicio.AltaEstacion(nueva, tarea);
					panelAgregarEstacion.limpiarWarnings();
					panelAgregarEstacion.mensajeEstacionCreada();
					panelAgregarEstacion.deshabilitarGuardado1();
					//panelAgregarEstacion.deshabilitarCambios();
					}
				}
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
		if(nueva.getNombre().isEmpty()) {
			panelAgregarEstacion.nombreFaltante();			
		}
		if(nueva.getHorarioCierre()==null) {
			panelAgregarEstacion.horaCierreFaltante();
		}
		if(nueva.getHorarioApertura()==null) {
			panelAgregarEstacion.horaAperturaFaltante();
		}
		if(nueva.getEstado()!=EstadoEstacionEnum.OPERATIVA && nueva.getEstado()!=EstadoEstacionEnum.MANTENIMIENTO) {
			panelAgregarEstacion.estadoFaltante();
		}
		if(!nueva.getNombre().isEmpty() && nueva.getHorarioCierre()!=null && nueva.getHorarioApertura()!=null){
			
		if(nueva.getEstado()==EstadoEstacionEnum.OPERATIVA) {
			AltaEstacionServicio.AltaEstacion(nueva);
			panelAgregarEstacion.mensajeEstacionCreada();
			panelAgregarEstacion.deshabilitarGuardado();
			
		}else {
			panelAgregarEstacion.mostrarDatosMantenimiento();
			panelAgregarEstacion.deshabilitarCambios();
		}
		}
	}
	
	public static void agregarTareaMantenimiento() throws FechaFinMenorFechaInicioException {
		TareaMantenimiento nueva = panelAgregarTareaMantenimiento.getTareaCreada();
		if(nueva.getEstacion()==null) {
			panelAgregarTareaMantenimiento.seleccioneEstacion();
		}
		if(nueva.getFechaInicio()==null) {
			panelAgregarTareaMantenimiento.seleccioneFechaInicio();
		}
		if(nueva.getFechaFin()==null) {
			panelAgregarTareaMantenimiento.seleccioneFechaFin();
		}
		if(nueva.getEstacion()!=null && nueva.getFechaInicio()!=null && nueva.getFechaFin()!=null){
			//AltaTareaMantenimiento.AltaTareaMantenimiento(nueva);
			panelAgregarTareaMantenimiento.mensajeTareaCreada();
			panelAgregarTareaMantenimiento.deshabilitarGuardado();
			TareaMantenimientoRepo.AgregarTareaMantenimiento(nueva);
		}
		
	}
}