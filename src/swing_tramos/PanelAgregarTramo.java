package swing_tramos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bdd.EstacionesRepo;
import bdd.LineasRepo;
import filtros.EstacionesFiltro;
import modelo.Estacion;
import modelo.EstadoTramoEnum;
import modelo.Linea;
import modelo.Tramo;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class PanelAgregarTramo extends JPanel {
	
	private ButtonGroup estado;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JTextField textField; 
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel inserteOrigen;
	private JLabel inserteDestino;
	private JLabel inserteLinea;
	private JLabel inserteDuracion;
	private JLabel inserteDistancia;
	private JLabel inserteCP;
	private JLabel inserteCosto;
	private JLabel inserteEstado;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton1;
	private JLabel tramoAgregado;
	
	public PanelAgregarTramo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 135, 13, 85, 67, 0, 0, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 21, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		
		JLabel lblNewLabel = new JLabel("AGREGAR TRAMO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22)); 
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=7;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ESTACION ORIGEN:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		List<Estacion> estaciones = EstacionesRepo.ObtenerEstaciones();
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		comboBox.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		inserteOrigen = new JLabel("Por favor, seleccione una estación de origen.");
		inserteOrigen.setForeground(Color.RED);
		inserteOrigen.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_origen = new GridBagConstraints();
		gbc_i_origen.anchor = GridBagConstraints.EAST;
		gbc_i_origen.insets = new Insets(0, 0, 5, 5);
		gbc_i_origen.gridx = 1;
		gbc_i_origen.gridy = 3;
		gbc_i_origen.gridwidth=3;
		gbc_i_origen.anchor=GridBagConstraints.WEST;
		add(inserteOrigen, gbc_i_origen);
		inserteOrigen.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("ESTACION DESTINO:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 4;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		comboBox_1.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 4;
		add(comboBox_1, gbc_comboBox_1);
		
		inserteDestino = new JLabel("Por favor, seleccione una estación de destino.");
		inserteDestino.setForeground(Color.RED);
		inserteDestino.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteDestino.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_destino = new GridBagConstraints();
		gbc_i_destino.anchor = GridBagConstraints.EAST;
		gbc_i_destino.insets = new Insets(0, 0, 5, 5);
		gbc_i_destino.gridx = 1;
		gbc_i_destino.gridy = 5;
		gbc_i_destino.gridwidth=3;
		gbc_i_destino.anchor=GridBagConstraints.WEST;
		add(inserteDestino, gbc_i_destino);
		inserteDestino.setVisible(false);
		
		//TODO agregar en la lista desplegable las lineas existentes
		
		JLabel lblNewLabel_1_1_3 = new JLabel("LINEA:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_3.gridx = 1;
		gbc_lblNewLabel_1_1_3.gridy = 6;
		add(lblNewLabel_1_1_3, gbc_lblNewLabel_1_1_3);
		
		comboBox_1_1 = new JComboBox();
		
		List<Linea> lineas = LineasRepo.ObtenerLineas();
				comboBox_1_1.setModel(new DefaultComboBoxModel(		
						lineas.stream().map(e -> e.get_color())
						.collect(Collectors.toList())
						.toArray()));
			
		comboBox_1_1.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox_1_1 = new GridBagConstraints();
		gbc_comboBox_1_1.gridwidth = 2;
		gbc_comboBox_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1_1.gridx = 3;
		gbc_comboBox_1_1.gridy = 6;
		add(comboBox_1_1, gbc_comboBox_1_1);
		
		inserteLinea = new JLabel("Por favor, seleccione una linea.");
		inserteLinea.setForeground(Color.RED);
		inserteLinea.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteLinea.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_linea = new GridBagConstraints();
		gbc_i_linea.anchor = GridBagConstraints.EAST;
		gbc_i_linea.insets = new Insets(0, 0, 5, 5);
		gbc_i_linea.gridx = 1;
		gbc_i_linea.gridy = 7;
		gbc_i_linea.gridwidth=3;
		gbc_i_linea.anchor=GridBagConstraints.WEST;
		add(inserteLinea, gbc_i_linea);
		inserteLinea.setVisible(false);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("DURACION:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2.gridx = 1;
		gbc_lblNewLabel_1_1_2.gridy = 8;
		add(lblNewLabel_1_1_2, gbc_lblNewLabel_1_1_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 8;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("(minutos)");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 5;
		gbc_lblNewLabel_2_1.gridy = 8;
		gbc_lblNewLabel_2_1.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		inserteDuracion = new JLabel("Por favor, inserte una duración.");
		inserteDuracion.setForeground(Color.RED);
		inserteDuracion.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_duracion = new GridBagConstraints();
		gbc_i_duracion.anchor = GridBagConstraints.EAST;
		gbc_i_duracion.insets = new Insets(0, 0, 5, 5);
		gbc_i_duracion.gridx = 1;
		gbc_i_duracion.gridy = 9;
		gbc_i_duracion.gridwidth=3;
		gbc_i_duracion.anchor=GridBagConstraints.WEST;
		add(inserteDuracion, gbc_i_duracion);
		inserteDuracion.setVisible(false);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("DISTANCIA:");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1.gridx = 1;
		gbc_lblNewLabel_1_1_2_1.gridy = 10;
		add(lblNewLabel_1_1_2_1, gbc_lblNewLabel_1_1_2_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 10;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		inserteDistancia = new JLabel("Por favor, inserte una distancia.");
		inserteDistancia.setForeground(Color.RED);
		inserteDistancia.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteDistancia.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_distancia = new GridBagConstraints();
		gbc_i_distancia.anchor = GridBagConstraints.EAST;
		gbc_i_distancia.insets = new Insets(0, 0, 5, 5);
		gbc_i_distancia.gridx = 1;
		gbc_i_distancia.gridy = 11;
		gbc_i_distancia.gridwidth=3;
		gbc_i_distancia.anchor=GridBagConstraints.WEST;
		add(inserteDistancia, gbc_i_distancia);
		inserteDistancia.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("(km)");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 10;
		gbc_lblNewLabel_2.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("CANTIDAD DE PASAJEROS:");
		lblNewLabel_1_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_2.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_1_1_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_2.gridx = 1;
		gbc_lblNewLabel_1_1_2_2.gridy = 12;
		add(lblNewLabel_1_1_2_2, gbc_lblNewLabel_1_1_2_2);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 12;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		inserteCP = new JLabel("Por favor, inserte la cantidad máxima de pasajeros.");
		inserteCP.setForeground(Color.RED);
		inserteCP.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteCP.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_cantP = new GridBagConstraints();
		gbc_i_cantP.anchor = GridBagConstraints.EAST;
		gbc_i_cantP.insets = new Insets(0, 0, 5, 5);
		gbc_i_cantP.gridx = 1;
		gbc_i_cantP.gridy = 13;
		gbc_i_cantP.gridwidth=3;
		gbc_i_cantP.anchor=GridBagConstraints.WEST;
		add(inserteCP, gbc_i_cantP);
		inserteCP.setVisible(false);
		
		JLabel lblNewLabel_1_1_2_3 = new JLabel("COSTO:");
		lblNewLabel_1_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_3.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_3.gridx = 1;
		gbc_lblNewLabel_1_1_2_3.gridy = 14;
		add(lblNewLabel_1_1_2_3, gbc_lblNewLabel_1_1_2_3);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 14;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		inserteCosto = new JLabel("Por favor, inserte un costo.");
		inserteCosto.setForeground(Color.RED);
		inserteCosto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteCosto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_costo = new GridBagConstraints();
		gbc_i_costo.anchor = GridBagConstraints.EAST;
		gbc_i_costo.insets = new Insets(0, 0, 5, 5);
		gbc_i_costo.gridx = 1;
		gbc_i_costo.gridy = 15;
		gbc_i_costo.gridwidth=3;
		gbc_i_costo.anchor=GridBagConstraints.WEST;
		add(inserteCosto, gbc_i_costo);
		inserteCosto.setVisible(false);

		
		JLabel lblNewLabel_1_1_1 = new JLabel("ESTADO:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1.gridy = 16;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		rdbtnNewRadioButton = new JRadioButton("Activo");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 3;
		gbc_rdbtnNewRadioButton.gridy = 16;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton1 = new JRadioButton("No activo");
		rdbtnNewRadioButton1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton1.gridx = 4;
		gbc_rdbtnNewRadioButton1.gridy = 16;
		add(rdbtnNewRadioButton1, gbc_rdbtnNewRadioButton1);
		
		estado = new ButtonGroup();
		estado.add(rdbtnNewRadioButton);
		estado.add(rdbtnNewRadioButton1);
		
		inserteEstado = new JLabel("Por favor, seleccione un estado.");
		inserteEstado.setForeground(Color.RED);
		inserteEstado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteEstado.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_estado = new GridBagConstraints();
		gbc_i_estado.anchor = GridBagConstraints.EAST;
		gbc_i_estado.insets = new Insets(0, 0, 5, 5);
		gbc_i_estado.gridx = 1;
		gbc_i_estado.gridy = 17;
		gbc_i_estado.gridwidth=3;
		gbc_i_estado.anchor=GridBagConstraints.WEST;
		add(inserteEstado, gbc_i_estado);
		inserteEstado.setVisible(false);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(204, 204, 51));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 18;
		add(btnGuardar, gbc_btnNewButton);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(new Color(204, 204, 51));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 18;
		add(btnCancelar, gbc_btnNewButton_1);
		
		tramoAgregado = new JLabel("EL TRAMO SE HA AGREGADO CORRECTAMENTE");
		tramoAgregado.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbcTramoAgregado = new GridBagConstraints();
		gbcTramoAgregado.insets = new Insets(0, 0, 5, 5);
		gbcTramoAgregado.gridx = 1;
		gbcTramoAgregado.gridy = 19;
		gbcTramoAgregado.gridwidth=3;
		add(tramoAgregado, gbcTramoAgregado);
		tramoAgregado.setVisible(false);
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void limpiarWarnings() {
		this.inserteCosto.setVisible(false);
		this.inserteCP.setVisible(false);
		this.inserteDestino.setVisible(false);
		this.inserteDistancia.setVisible(false);
		this.inserteDuracion.setVisible(false);
		this.inserteEstado.setVisible(false);
		this.inserteLinea.setVisible(false);
		this.inserteOrigen.setVisible(false);
		this.tramoAgregado.setVisible(false);
	}
	public void limpiarDatos() {
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_1_1.setSelectedIndex(0);
		textField.setText(null);
		textField_1.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		estado.clearSelection();
	}
	
	public Tramo obtenerTramoCreado() {
		//public Tramo(Linea linea, Integer orden, Estacion origen, Estacion destino, Integer cant_pasajeros,
		//Double duracion, Double distancia, Double costo, EstadoTramoEnum estado)
		EstacionesFiltro origen= new EstacionesFiltro();
		origen.setNombre(comboBox.getSelectedItem().toString());
		EstacionesFiltro destino = new EstacionesFiltro();
		destino.setNombre(comboBox_1.getSelectedItem().toString());
		EstadoTramoEnum estado= null;
		if(this.rdbtnNewRadioButton.isSelected()) {
			estado= EstadoTramoEnum.ACTIVO;
		}else if(rdbtnNewRadioButton1.isSelected()) {
			estado= EstadoTramoEnum.INACTIVO;
		}
		
		Integer cant_pasajeros=null;
		if(!textField_4.getText().isEmpty()) cant_pasajeros= Integer.parseInt(textField_4.getText());
		Double duracion=null;
		if(!textField.getText().isEmpty()) duracion = Double.parseDouble(textField.getText());
		Double distancia=null;
		if(!textField_1.getText().isEmpty()) distancia= Double.parseDouble(textField_1.getText());
		Double costo=null;
		if(!textField_5.getText().isEmpty()) costo= Double.parseDouble(textField_5.getText());
		
		return new Tramo(LineasRepo.ObtenerLinea(1), 1, EstacionesRepo.ObtenerEstaciones(origen).get(0),EstacionesRepo.ObtenerEstaciones(destino).get(0),cant_pasajeros ,
				duracion,distancia,costo,estado);
	}
	
	public void mostrarCantPasajeros() {
		this.inserteCP.setVisible(true);
	}
	public void mostratEstado() {
		this.inserteEstado.setVisible(true);
	}
	public void mostrarCosto() {
		this.inserteCosto.setVisible(true);
	}
	public void mostrarDestino() {
		this.inserteDestino.setVisible(true);
	}
	public void mostrarDistancia() {
		this.inserteDistancia.setVisible(true);
	}
	public void mostrarDuracion() {
		this.inserteDuracion.setVisible(true);
	}
	public void mostrarLinea() {
		this.inserteLinea.setVisible(true);
	}
	public void mostrarOrigen() {
		this.inserteOrigen.setVisible(true);
	}
	public void mensajeTramoCreado() {
		this.tramoAgregado.setVisible(true);
	}
	public void deshabilitarGuardar() {
		this.btnGuardar.setEnabled(false);
	}
	public void habilitarGuardar() {
		this.btnGuardar.setEnabled(true);
	}

}