package swing_menu_principal;

import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import bdd.EstacionesRepo;
import bdd.LineasRepo;
import bdd.TareaMantenimientoRepo;
import bdd.TramosRepo;
import excepciones.FechaFinMenorFechaInicioException;
import excepciones.HoraCierreMenorHoraAperturaException;
import modelo.*;
import swing_lineas.PanelAgregarLinea;
import swing_lineas.PanelBuscarLinea;
import swing_lineas.PanelDefinirTrayectos;
import swing_boletos.PanelAgregarBoleto;
import swing_boletos.PanelBuscarBoleto;
import swing_boletos.PanelGestionarBoletos;
import swing_estaciones.PanelAgregarEstacion;
import swing_estaciones.PanelBuscarEstacion;
import swing_estaciones.PanelFlujoMaximo;
import swing_estaciones.PanelGestionarEstaciones;
import swing_estaciones.PanelInformacionEstaciones;
import swing_estaciones.PanelModificarEstacion;
import swing_estaciones.PanelPageRank;
import swing_estaciones.PanelProximoMantenimiento;
import swing_estaciones.PanelVerHistorialTareaMantenimientoDesdeBuscar;
import swing_lineas.PanelGestionarLineas;
import swing_lineas.PanelModificarLinea;
import swing_tareas_mantenimiento.PanelAgregarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelBuscarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelGestionarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelModificarTareaMantenimiento;
import swing_tareas_mantenimiento.PanelVerHistorialTareaMantenimiento;
import swing_tramos.PanelAgregarTramo;
import swing_tramos.PanelBuscarTramo;
import swing_tramos.PanelGestionarTramos;
import swing_tramos.PanelModificarTramo;

import java.awt.Color;
import java.awt.Dimension;

public class VentanaPrincipal {

	private static JFrame ventana1;
	private static PanelMenuPrincipal panelMenuPrincipal;

	public static void main(String[] args) {
		ventana1 = new JFrame();
		ventana1.setTitle("MENU PRINCIPAL");
		ventana1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ventana1.setPreferredSize(new Dimension(500, 500));
		ventana1.setMinimumSize(new Dimension(300, 300));
		ventana1.setBackground(Color.WHITE);

		panelMenuPrincipal = new PanelMenuPrincipal();
		panelMenuPrincipal.getTramos().setBackground(new Color(204, 204, 0));
		panelMenuPrincipal.getBoletos().setBackground(new Color(204, 204, 51));
		panelMenuPrincipal.getLineas().setBackground(new Color(204, 204, 102));
		panelMenuPrincipal.getTareas_mantenimiento().setBackground(new Color(204, 204, 153));
		panelMenuPrincipal.getEstaciones().setBackground(new Color(204, 204, 204));
		GridBagLayout gridBagLayout = (GridBagLayout) panelMenuPrincipal.getLayout();
		gridBagLayout.columnWeights = new double[] { 1.0 };

		ventana1.setContentPane(panelMenuPrincipal);
		ventana1.pack();
		ventana1.setSize(new Dimension(500, 300));
		ventana1.setMinimumSize(new Dimension(600, 500));
		ventana1.setLocationRelativeTo(null);
		ventana1.setVisible(true);

//MENU PRINCIPAL
		panelMenuPrincipal.getEstaciones().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR ESTACIONES");
				PanelGestionarEstaciones panelGestionarEstaciones = new PanelGestionarEstaciones();
				panelGestionarEstaciones.setBackground(Color.WHITE);
				ventana1.setContentPane(panelGestionarEstaciones);
				ventana1.setVisible(true);
				ventana1.pack();

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
						PanelAgregarEstacion panelAgregarEstacion = new PanelAgregarEstacion();
						panelAgregarEstacion.setBackground(Color.WHITE);
						ventana1.setContentPane(panelAgregarEstacion);
						ventana1.setVisible(true);
						ventana1.pack();

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
								try {
									panelAgregarEstacion.agregarEstacion();
								} catch (HoraCierreMenorHoraAperturaException e1) {
									panelAgregarEstacion.horarioCierrePostAp();
								}
							}
						});

						panelAgregarEstacion.getBtnNewButton_3().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelAgregarEstacion.limpiarDatos();
								panelAgregarEstacion.limpiarWarnings();
								panelAgregarEstacion.sacarMantenimiento();
								panelAgregarEstacion.habilitarBotones();
								panelAgregarEstacion.habilitar();
								ventana1.setTitle("GESTIONAR ESTACIONES");
								ventana1.setContentPane(panelGestionarEstaciones);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});

						panelAgregarEstacion.getBtnNewButton4().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelAgregarEstacion.limpiarWarnings();
								Estacion nueva = null;
								try {
									nueva = panelAgregarEstacion.getEstacionCreada();
								} catch (HoraCierreMenorHoraAperturaException e1) {
									panelAgregarEstacion.horarioCierrePostAp();
								}
								nueva = EstacionesRepo.AgregarEstacion(nueva);
								panelAgregarEstacion.agregarTareaMantenimiento(nueva);
							}
						});
					}
				});

				panelGestionarEstaciones.getBuscar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("BUSCAR ESTACION");
						PanelBuscarEstacion panelBuscarEstacion = new PanelBuscarEstacion();
						panelBuscarEstacion.setBackground(Color.WHITE);
						ventana1.setContentPane(panelBuscarEstacion);
						ventana1.setVisible(true);
						ventana1.pack();

						panelBuscarEstacion.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("GESTIONAR ESTACIONES");
								ventana1.setContentPane(panelGestionarEstaciones);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});

						panelBuscarEstacion.getHistorial().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("VER HISTORIAL TAREAS DE MANTENIMIENTO");
								PanelVerHistorialTareaMantenimientoDesdeBuscar panelVerHistorialTareaMantenimientoDesdeBuscar = new PanelVerHistorialTareaMantenimientoDesdeBuscar(
										panelBuscarEstacion.getActual());
								panelVerHistorialTareaMantenimientoDesdeBuscar.setBackground(Color.WHITE);
								ventana1.setContentPane(panelVerHistorialTareaMantenimientoDesdeBuscar);
								ventana1.setVisible(true);
								ventana1.pack();

								panelVerHistorialTareaMantenimientoDesdeBuscar.getCancelar()
										.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												ventana1.setTitle("BUSCAR ESTACION");
												ventana1.setContentPane(panelBuscarEstacion);
												ventana1.setVisible(true);
												ventana1.pack();
											}
										});

							}
						});
						panelBuscarEstacion.getModificar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("MODIFICAR ESTACION");
								PanelModificarEstacion panelModificarEstacion = new PanelModificarEstacion(
										panelBuscarEstacion.getActual());
								panelModificarEstacion.setBackground(Color.WHITE);
								ventana1.setContentPane(panelModificarEstacion);
								ventana1.setVisible(true);
								ventana1.pack();

								// volver desde modificar a buscar
								panelModificarEstacion.getBtnNewButton_1().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelModificarEstacion.limpiarDatos();
										panelModificarEstacion.limpiarWarnings();
										panelModificarEstacion.habilitarBotones();
										panelModificarEstacion.habilitar();
										ventana1.setTitle("BUSCAR ESTACIONES");
										ventana1.setContentPane(panelBuscarEstacion);
										ventana1.setVisible(true);
										ventana1.pack();
									}
								});

								panelModificarEstacion.getBtnNewButton().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelModificarEstacion.limpiarWarnings();
										try {
											panelModificarEstacion.modificarEstacion();
											panelBuscarEstacion.setModel(panelBuscarEstacion
													.renovarTabla(EstacionesRepo.ObtenerEstaciones()));
										} catch (HoraCierreMenorHoraAperturaException e1) {
											panelModificarEstacion.horarioCierrePostAp();
										}
									}
								});

								panelModificarEstacion.getBtnNewButton_3().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelModificarEstacion.limpiarDatos();
										panelModificarEstacion.limpiarWarnings();
										panelModificarEstacion.sacarMantenimiento();
										panelModificarEstacion.habilitarBotones();
										panelModificarEstacion.habilitar();
										ventana1.setTitle("BUSCAR ESTACION");
										ventana1.setContentPane(panelBuscarEstacion);
										ventana1.setVisible(true);
										ventana1.pack();
									}
								});
								// fin
								panelModificarEstacion.getBtnNewButton5().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelModificarEstacion.limpiarWarnings();
										Estacion nueva = null;
										try {
											nueva = panelModificarEstacion.getEstacionModificada();
										} catch (HoraCierreMenorHoraAperturaException e1) {
											panelModificarEstacion.horarioCierrePostAp();
										}
										// EstacionesRepo.ModificarEstacion(nueva);
										try {
											TareaMantenimientoRepo.FinalizarTareaDeMantenimiento(
													TareaMantenimientoRepo.ObtenerActiva(nueva));
										} catch (FechaFinMenorFechaInicioException e1) {
											e1.printStackTrace();
										}
										panelModificarEstacion.getLblNewLabel_6().setVisible(true);
										panelModificarEstacion.getBtnNewButton5().setEnabled(false);
										panelModificarEstacion.getDateChooser_1().setEnabled(false);
										panelBuscarEstacion.setModel(
												panelBuscarEstacion.renovarTabla(EstacionesRepo.ObtenerEstaciones()));
									}
								});

								// inicio
								panelModificarEstacion.getBtnNewButton4().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelModificarEstacion.limpiarWarnings();
										Estacion nueva = null;
										try {
											nueva = panelModificarEstacion.getEstacionModificada();
										} catch (HoraCierreMenorHoraAperturaException e1) {
											panelModificarEstacion.horarioCierrePostAp();
										}
										// EstacionesRepo.ModificarEstacion(nueva);
										panelModificarEstacion.agregarTareaMantenimiento(nueva);
										panelBuscarEstacion.setModel(
												panelBuscarEstacion.renovarTabla(EstacionesRepo.ObtenerEstaciones()));

									}
								});
							}
						});
						panelBuscarEstacion.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("GESTIONAR ESTACIONES");
								ventana1.setContentPane(panelGestionarEstaciones);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});

					}

				});

				panelGestionarEstaciones.getInformacion().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("INFORMACION DE ESTACIONES");
						PanelInformacionEstaciones panelInformacionEstaciones = new PanelInformacionEstaciones();
						panelInformacionEstaciones.setBackground(Color.WHITE);
						ventana1.setContentPane(panelInformacionEstaciones);
						ventana1.setVisible(true);
						ventana1.pack();

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
								PanelProximoMantenimiento panelProximoMantenimiento = new PanelProximoMantenimiento();
								panelProximoMantenimiento.setBackground(Color.WHITE);
								ventana1.setContentPane(panelProximoMantenimiento);
								ventana1.setVisible(true);
								ventana1.pack();

								panelProximoMantenimiento.getCancelar().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ventana1.setTitle("INFORMACION DE ESTACIONES");
										ventana1.setContentPane(panelInformacionEstaciones);
										ventana1.setVisible(true);
										ventana1.pack();
									}
								});
							}
						});

						panelInformacionEstaciones.getPageRank().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("PAGE RANK");
								PanelPageRank panelPageRank = new PanelPageRank();
								panelPageRank.setBackground(Color.WHITE);
								ventana1.setContentPane(panelPageRank);
								ventana1.setVisible(true);
								ventana1.pack();

								panelPageRank.getCancelar().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ventana1.setTitle("INFORMACION DE ESTACIONES");
										ventana1.setContentPane(panelInformacionEstaciones);
										ventana1.setVisible(true);
										ventana1.pack();
									}
								});
							}
						});

						panelInformacionEstaciones.getFlujoMaximo().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("FLUJO MAXIMO");
								PanelFlujoMaximo panelFlujoMaximo = new PanelFlujoMaximo();
								panelFlujoMaximo.setBackground(Color.WHITE);
								ventana1.setContentPane(panelFlujoMaximo);
								ventana1.setVisible(true);
								ventana1.pack();
								
								panelFlujoMaximo.getBuscar().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelFlujoMaximo.calcularFM();
										panelFlujoMaximo.deshabilitar();
									}
								});

								panelFlujoMaximo.getCancelar().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ventana1.setTitle("INFORMACION DE ESTACIONES");
										ventana1.setContentPane(panelInformacionEstaciones);
										panelFlujoMaximo.habilitar();
										ventana1.setVisible(true);
										ventana1.pack();
									}
								});
							}
						});
					}
				});
			}
		});

		panelMenuPrincipal.getLineas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR LINEAS");
				PanelGestionarLineas panelGestionarLineas = new PanelGestionarLineas();
				panelGestionarLineas.setBackground(Color.WHITE);
				ventana1.setContentPane(panelGestionarLineas);
				ventana1.setVisible(true);
				ventana1.pack();

				panelGestionarLineas.getVolver().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("MENU PRINCIPAL");
						ventana1.setContentPane(panelMenuPrincipal);
						ventana1.setVisible(true);
						ventana1.pack();
					}
				});


				panelGestionarLineas.getAgregar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("AGREGAR LINEA");
						PanelAgregarLinea panelAgregarLinea = new PanelAgregarLinea();
						panelAgregarLinea.setBackground(Color.WHITE);
						ventana1.setContentPane(panelAgregarLinea);
						ventana1.setVisible(true);
						ventana1.pack();

						panelAgregarLinea.getBtnCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelAgregarLinea.limpiarDatos();
								panelAgregarLinea.limpiarWarnings();
								panelAgregarLinea.habilitarGuardar();
								ventana1.setTitle("GESTIONAR LINEAS");
								ventana1.setContentPane(panelGestionarLineas);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});

						panelAgregarLinea.getBtnGuardar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelAgregarLinea.limpiarWarnings();
								panelAgregarLinea.agregarLinea();
							}
						});
					}
				});

				panelGestionarLineas.getBuscar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("BUSCAR LINEA");
						PanelBuscarLinea panelBuscarLinea = new PanelBuscarLinea();
						panelBuscarLinea.setBackground(Color.WHITE);
						ventana1.setContentPane(panelBuscarLinea);
						ventana1.setVisible(true);
						ventana1.pack();

						panelBuscarLinea.getModificar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("MODIFICAR LINEA");
								PanelModificarLinea panelModificarLinea = new PanelModificarLinea(
										panelBuscarLinea.getActual());
								panelModificarLinea.setBackground(Color.WHITE);
								ventana1.setContentPane(panelModificarLinea);
								ventana1.setVisible(true);
								ventana1.pack();
								panelModificarLinea.getGuardar().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panelModificarLinea.limpiarWarnings();
										panelModificarLinea.modificarLinea();
										panelBuscarLinea
												.setModel(panelBuscarLinea.renovarTabla(LineasRepo.ObtenerLineas()));
									}
								});

								panelModificarLinea.getCancelar().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ventana1.setTitle("BUSCAR LINEA");
										ventana1.setContentPane(panelBuscarLinea);
										ventana1.setVisible(true);
										ventana1.pack();
									}
								});
							}
						});

						panelBuscarLinea.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("GESTIONAR LINEAS");
								ventana1.setContentPane(panelGestionarLineas);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});
					}
				});
			}
		});

		panelMenuPrincipal.getBoletos().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR BOLETOS");
				PanelGestionarBoletos panelGestionarBoletos = new PanelGestionarBoletos();
				panelGestionarBoletos.setBackground(Color.WHITE);
				ventana1.setContentPane(panelGestionarBoletos);
				ventana1.setVisible(true);
				ventana1.pack();

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
						PanelAgregarBoleto panelAgregarBoleto = new PanelAgregarBoleto();
						panelAgregarBoleto.setBackground(Color.WHITE);
						ventana1.setContentPane(panelAgregarBoleto);
						ventana1.setVisible(true);
						ventana1.pack();


						panelAgregarBoleto.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setContentPane(panelGestionarBoletos);
								ventana1.setTitle("GESTIONAR BOLETOS");
								ventana1.setVisible(true);
								ventana1.pack();
								panelAgregarBoleto.limpiarWarnings();
								panelAgregarBoleto.limpiarDatos();
							}
						});
					}
				});

				panelGestionarBoletos.getBuscar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("BUSCAR BOLETO");
						PanelBuscarBoleto panelBuscarBoleto = new PanelBuscarBoleto();
						panelBuscarBoleto.setBackground(Color.WHITE);
						ventana1.setContentPane(panelBuscarBoleto);
						ventana1.setVisible(true);
						ventana1.pack();

						panelBuscarBoleto.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("GESTIONAR BOLETOS");
								ventana1.setContentPane(panelGestionarBoletos);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});

					}
				});

			}
		});

		panelMenuPrincipal.getTramos().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TRAMOS");
				PanelGestionarTramos panelGestionarTramos = new PanelGestionarTramos();
				panelGestionarTramos.setBackground(Color.WHITE);
				ventana1.setContentPane(panelGestionarTramos);
				ventana1.setVisible(true);
				ventana1.pack();

				panelGestionarTramos.getVolver().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("MENU PRINCIPAL");
						ventana1.setContentPane(panelMenuPrincipal);
						ventana1.setVisible(true);
						ventana1.pack();
					}
				});

				panelGestionarTramos.getCrear().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("AGREGAR TRAMO");
						PanelAgregarTramo panelAgregarTramo = new PanelAgregarTramo();
						panelAgregarTramo.setBackground(Color.WHITE);
						ventana1.setContentPane(panelAgregarTramo);
						ventana1.setVisible(true);
						ventana1.pack();

						panelAgregarTramo.getBtnCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelAgregarTramo.limpiarWarnings();
								panelAgregarTramo.limpiarDatos();
								panelAgregarTramo.habilitarGuardar();
								ventana1.setTitle("GESTIONAR TRAMOS");
								ventana1.setContentPane(panelGestionarTramos);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});
					}
				});

				panelGestionarTramos.getBuscar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("BUSCAR TRAMO");
						PanelBuscarTramo panelBuscarTramo = new PanelBuscarTramo();
						panelBuscarTramo.setBackground(Color.WHITE);
						ventana1.setContentPane(panelBuscarTramo);
						ventana1.setVisible(true);
						ventana1.pack();

						panelBuscarTramo.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("GESTIONAR TRAMOS");
								ventana1.setContentPane(panelGestionarTramos);
								ventana1.setVisible(true);
								ventana1.pack();
							}

						});
						panelBuscarTramo.getModificar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("MODIFICAR TRAMO");
								PanelModificarTramo panelModificarTramo = new PanelModificarTramo(
										panelBuscarTramo.getActual());
								panelModificarTramo.setBackground(Color.WHITE);
								ventana1.setContentPane(panelModificarTramo);
								ventana1.setVisible(true);
								ventana1.pack();

								panelModificarTramo.getCancelar().addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										ventana1.setTitle("BUSCAR TRAMO");
										ventana1.setContentPane(panelBuscarTramo);
										ventana1.setVisible(true);
										ventana1.pack();

										panelModificarTramo.getGuardar().addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												panelModificarTramo.limpiarWarnings();
												panelModificarTramo.modificarTramo();
												panelBuscarTramo.setModel(
														panelBuscarTramo.renovarTabla(TramosRepo.obtenerTramos()));
											}
										});
									}
								});

							}
						});
					}
				});
			}
		});

		panelMenuPrincipal.getTareas_mantenimiento().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
				PanelGestionarTareaMantenimiento panelGestionarTareaMantenimiento = new PanelGestionarTareaMantenimiento();
				panelGestionarTareaMantenimiento.setBackground(Color.WHITE);
				ventana1.setContentPane(panelGestionarTareaMantenimiento);
				ventana1.setVisible(true);
				ventana1.pack();

				panelGestionarTareaMantenimiento.getVolver().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("MENU PRINCIPAL");
						ventana1.setContentPane(panelMenuPrincipal);
						ventana1.setVisible(true);
						ventana1.pack();
					}
				});

				panelGestionarTareaMantenimiento.getCrear().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("AGREGAR TAREA DE MANTENIMIENTO");
						PanelAgregarTareaMantenimiento panelAgregarTareaMantenimiento = new PanelAgregarTareaMantenimiento();
						panelAgregarTareaMantenimiento.setBackground(Color.WHITE);
						ventana1.setContentPane(panelAgregarTareaMantenimiento);
						ventana1.setVisible(true);
						ventana1.pack();

						panelAgregarTareaMantenimiento.getBtnNewButton().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								panelAgregarTareaMantenimiento.limpiarWarnings();
								try {
									panelAgregarTareaMantenimiento.agregarTareaMantenimiento();
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
								ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
								ventana1.setContentPane(panelGestionarTareaMantenimiento);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});
					}
				});

				panelGestionarTareaMantenimiento.getBuscar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("BUSCAR TAREA DE MANTENIMIENTO");
						PanelBuscarTareaMantenimiento panelBuscarTareaMantenimiento = new PanelBuscarTareaMantenimiento();
						panelBuscarTareaMantenimiento.setBackground(Color.WHITE);
						ventana1.setContentPane(panelBuscarTareaMantenimiento);
						ventana1.setVisible(true);
						ventana1.pack();

						panelBuscarTareaMantenimiento.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
								ventana1.setContentPane(panelGestionarTareaMantenimiento);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});
						panelBuscarTareaMantenimiento.getModificar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("MODIFICAR TAREA DE MANTENIMIENTO");
								PanelModificarTareaMantenimiento panelModificarTareaMantenimiento = new PanelModificarTareaMantenimiento(
										panelBuscarTareaMantenimiento.getActual());
								panelModificarTareaMantenimiento.setBackground(Color.WHITE);
								ventana1.setContentPane(panelModificarTareaMantenimiento);
								ventana1.setVisible(true);
								ventana1.pack();

								panelModificarTareaMantenimiento.getBtnNewButton_1()
										.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												panelModificarTareaMantenimiento.limpiarWarnings();
												panelModificarTareaMantenimiento.limpiarDatos();
												panelModificarTareaMantenimiento.habilitarBotones();
												ventana1.setTitle("BUSCAR TAREA DE MANTENIMIENTO");
												ventana1.setContentPane(panelBuscarTareaMantenimiento);
												ventana1.setVisible(true);
												ventana1.pack();
											}
										});
								panelModificarTareaMantenimiento.getBtnNewButton()
										.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												panelModificarTareaMantenimiento.limpiarWarnings();
												try {
													panelModificarTareaMantenimiento.modificarTareaMantenimiento();
													panelBuscarTareaMantenimiento.setModel(panelBuscarTareaMantenimiento
															.renovarTabla(TareaMantenimientoRepo.Obtener()));
												} catch (FechaFinMenorFechaInicioException e1) {
													e1.printStackTrace();
												}

											}
										});
							}
						});
					}
				});

				panelGestionarTareaMantenimiento.getHistorial().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ventana1.setTitle("VER HISTORIAL");
						PanelVerHistorialTareaMantenimiento panelVerHistorialTareaMantenimiento = new PanelVerHistorialTareaMantenimiento();
						panelVerHistorialTareaMantenimiento.setBackground(Color.WHITE);
						ventana1.setContentPane(panelVerHistorialTareaMantenimiento);
						ventana1.setVisible(true);
						ventana1.pack();

						panelVerHistorialTareaMantenimiento.getCancelar().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ventana1.setTitle("GESTIONAR TAREAS DE MANTENIMIENTO");
								ventana1.setContentPane(panelGestionarTareaMantenimiento);
								ventana1.setVisible(true);
								ventana1.pack();
							}
						});
					}
				});
			}
		});
	}
}