package swing_tramos;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import bdd.EstacionesRepo;
import bdd.LineasRepo;
import bdd.TramosRepo;
import modelo.ColoresLineasEnum;
import modelo.Estacion;
import modelo.EstadoLineaEnum;
import modelo.EstadoTramoEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;
import modelo.Tramo;

import java.awt.Color;
import javax.swing.JComboBox;

public class PanelModificarTramo extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private ButtonGroup estado;
	private ButtonGroup tipoTransporte;
	private JButton guardar;
	private JButton cancelar;
	private JButton btnRecorrido;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton1;
	private JLabel lblNewLabel_1;
	private JLabel inserteColor;
	private JLabel inserteTipoTransporte;
	private JLabel seleccioneEstado;
	private JLabel tramoModificado;

	private Tramo a_modificar;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;

	private List<Estacion> estaciones;
	private JLabel inserteDuracion;
	private JLabel inserteDistancia;
	private JTextField textField_4;
	private JLabel inserteCP;
	private JTextField textField_5;
	private JLabel inserteCosto;
	private JLabel inserteEstado;

	public void modificarTramo(){
			Tramo nueva =  this.getTramoModificado();
				TramosRepo.ModificarTramo(nueva);
				tramoModificado.setVisible(true);
				guardar.setEnabled(false);
	}
	
	public Tramo getTramoModificado()  {
		EstadoTramoEnum e = null;
		if(rdbtnNewRadioButton.isSelected()) {
			e= EstadoTramoEnum.ACTIVO;
		}else if(rdbtnNewRadioButton1.isSelected()){
			e= EstadoTramoEnum.INACTIVO;
		}
		
		return new Tramo(a_modificar.getLinea(), (Integer) a_modificar.getOrden(),
				a_modificar.getOrigen(), a_modificar.getDestino(), 
				Integer.valueOf(textField_4.getText()),
				Double.valueOf(textField.getText()), 
				Double.valueOf(textField_1.getText()), 
				Double.valueOf(textField_5.getText()),  e);
		
	}
	
	public PanelModificarTramo(Tramo actual) {		
		GridBagLayout gridBagLayout = new GridBagLayout();
		a_modificar = actual;
		gridBagLayout.columnWidths = new int[] { 54, 135, 13, 85, 67, 0, 0, 0, 0, 67, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 26, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 21, 0, 0, 0,
				0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500, 500));

		JLabel lblNewLabel = new JLabel("MODIFICAR TRAMO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth = 9;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ESTACION ORIGEN:");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		estaciones = EstacionesRepo.ObtenerEstaciones();
		comboBox = new JComboBox(estaciones.toArray());
		comboBox.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		comboBox.setEnabled(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("ESTACION DESTINO:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 4;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		// comboBox_1 = new JComboBox(estaciones.stream().filter(e->
		// e.getId()!=((Estacion)this.comboBox.getSelectedItem()).getId()).collect(Collectors.toList()).toArray());
		// comboBox_1= new JComboBox(estaciones.toArray());

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new javax.swing.DefaultComboBoxModel<>(
				estaciones.stream().filter(e -> e.getId() != ((Estacion) comboBox.getSelectedItem()).getId())
						.collect(Collectors.toList()).toArray()));

		comboBox_1.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 4;
		add(comboBox_1, gbc_comboBox_1);
		comboBox_1.setEnabled(false);

		JLabel lblNewLabel_1_1_3 = new JLabel("LINEA:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_3.gridx = 1;
		gbc_lblNewLabel_1_1_3.gridy = 6;
		add(lblNewLabel_1_1_3, gbc_lblNewLabel_1_1_3);

		List<Linea> lineas = LineasRepo.ObtenerLineas();

		comboBox_1_1 = new JComboBox(lineas.toArray());

		comboBox_1_1.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox_1_1 = new GridBagConstraints();
		gbc_comboBox_1_1.gridwidth = 2;
		gbc_comboBox_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1_1.gridx = 3;
		gbc_comboBox_1_1.gridy = 6;
		add(comboBox_1_1, gbc_comboBox_1_1);
		comboBox_1_1.setEnabled(false);

		btnRecorrido = new JButton("VER RECORRIDO");
		btnRecorrido.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecorrido.setBackground(new Color(204, 204, 51));
		btnRecorrido.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnRecorrido = new GridBagConstraints();
		gbc_btnRecorrido.gridwidth = 2;
		gbc_btnRecorrido.fill = GridBagConstraints.BOTH;
		gbc_btnRecorrido.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecorrido.gridx = 5;
		gbc_btnRecorrido.gridy = 6;
		add(btnRecorrido, gbc_btnRecorrido);
		btnRecorrido.setEnabled(false);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("DURACION:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2.gridx = 1;
		gbc_lblNewLabel_1_1_2.gridy = 9;
		add(lblNewLabel_1_1_2, gbc_lblNewLabel_1_1_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 9;
		add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setText(actual.getDuracion().toString());

		JLabel lblNewLabel_2_1 = new JLabel("(minutos)");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 6;
		gbc_lblNewLabel_2_1.gridy = 9;
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.WEST;
		add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);

		inserteDuracion = new JLabel("Por favor, inserte una duraci�n.");
		inserteDuracion.setForeground(Color.RED);
		inserteDuracion.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_duracion = new GridBagConstraints();
		gbc_i_duracion.anchor = GridBagConstraints.EAST;
		gbc_i_duracion.insets = new Insets(0, 0, 5, 5);
		gbc_i_duracion.gridx = 1;
		gbc_i_duracion.gridy = 10;
		gbc_i_duracion.gridwidth = 3;
		gbc_i_duracion.anchor = GridBagConstraints.WEST;
		add(inserteDuracion, gbc_i_duracion);
		inserteDuracion.setVisible(false);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("DISTANCIA:");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_1.gridx = 1;
		gbc_lblNewLabel_1_1_2_1.gridy = 11;
		add(lblNewLabel_1_1_2_1, gbc_lblNewLabel_1_1_2_1);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 11;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		textField_1.setText(actual.getDistancia().toString());
		
		JLabel lblNewLabel_2 = new JLabel("(km)");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 11;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		inserteDistancia = new JLabel("Por favor, inserte una distancia.");
		inserteDistancia.setForeground(Color.RED);
		inserteDistancia.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteDistancia.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_distancia = new GridBagConstraints();
		gbc_i_distancia.anchor = GridBagConstraints.EAST;
		gbc_i_distancia.insets = new Insets(0, 0, 5, 5);
		gbc_i_distancia.gridx = 1;
		gbc_i_distancia.gridy = 12;
		gbc_i_distancia.gridwidth = 3;
		gbc_i_distancia.anchor = GridBagConstraints.WEST;
		add(inserteDistancia, gbc_i_distancia);
		inserteDistancia.setVisible(false);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("CANTIDAD DE PASAJEROS:");
		lblNewLabel_1_1_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_2.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_1_1_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_2.gridx = 1;
		gbc_lblNewLabel_1_1_2_2.gridy = 13;
		add(lblNewLabel_1_1_2_2, gbc_lblNewLabel_1_1_2_2);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 13;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		textField_4.setText(actual.get_cantPasajeros().toString());
		
		inserteCP = new JLabel("Por favor, inserte la cantidad m�xima de pasajeros.");
		inserteCP.setForeground(Color.RED);
		inserteCP.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteCP.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_cantP = new GridBagConstraints();
		gbc_i_cantP.anchor = GridBagConstraints.EAST;
		gbc_i_cantP.insets = new Insets(0, 0, 5, 5);
		gbc_i_cantP.gridx = 1;
		gbc_i_cantP.gridy = 14;
		gbc_i_cantP.gridwidth = 3;
		gbc_i_cantP.anchor = GridBagConstraints.WEST;
		add(inserteCP, gbc_i_cantP);
		inserteCP.setVisible(false);

		JLabel lblNewLabel_1_1_2_3 = new JLabel("COSTO:");
		lblNewLabel_1_1_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2_3.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2_3.gridx = 1;
		gbc_lblNewLabel_1_1_2_3.gridy = 15;
		add(lblNewLabel_1_1_2_3, gbc_lblNewLabel_1_1_2_3);

		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 15;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		textField_5.setText(actual.getCosto().toString());
		
		inserteCosto = new JLabel("Por favor, inserte un costo.");
		inserteCosto.setForeground(Color.RED);
		inserteCosto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteCosto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_costo = new GridBagConstraints();
		gbc_i_costo.anchor = GridBagConstraints.EAST;
		gbc_i_costo.insets = new Insets(0, 0, 5, 5);
		gbc_i_costo.gridx = 1;
		gbc_i_costo.gridy = 16;
		gbc_i_costo.gridwidth = 3;
		gbc_i_costo.anchor = GridBagConstraints.WEST;
		add(inserteCosto, gbc_i_costo);
		inserteCosto.setVisible(false);

		JLabel lblNewLabel_1_1_1 = new JLabel("ESTADO:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1.gridy = 17;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		rdbtnNewRadioButton = new JRadioButton("Activo");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 3;
		gbc_rdbtnNewRadioButton.gridy = 17;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);

		rdbtnNewRadioButton1 = new JRadioButton("No activo");
		rdbtnNewRadioButton1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton1.gridx = 4;
		gbc_rdbtnNewRadioButton1.gridy = 17;
		add(rdbtnNewRadioButton1, gbc_rdbtnNewRadioButton1);

		estado = new ButtonGroup();
		estado.add(rdbtnNewRadioButton);
		estado.add(rdbtnNewRadioButton1);
		
		inserteEstado = new JLabel("Por favor, seleccione un estado.");
		inserteEstado.setForeground(Color.RED);
		inserteEstado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		((JLabel) inserteEstado).setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_estado = new GridBagConstraints();
		gbc_i_estado.anchor = GridBagConstraints.EAST;
		gbc_i_estado.insets = new Insets(0, 0, 5, 5);
		gbc_i_estado.gridx = 1;
		gbc_i_estado.gridy = 18;
		gbc_i_estado.gridwidth = 3;
		gbc_i_estado.anchor = GridBagConstraints.WEST;
		add(inserteEstado, gbc_i_estado);
		inserteEstado.setVisible(false);

		guardar = new JButton("GUARDAR");
		guardar.setBackground(new Color(204, 204, 51));
		guardar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 19;
		add(guardar, gbc_btnNewButton);

		cancelar = new JButton("CANCELAR");
		cancelar.setBackground(new Color(204, 204, 51));
		cancelar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.gridwidth = 4;
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 19;
		add(cancelar, gbc_btnNewButton_1);

		tramoModificado = new JLabel("EL TRAMO SE HA AGREGADO CORRECTAMENTE");
		tramoModificado.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbcTramoAgregado = new GridBagConstraints();
		gbcTramoAgregado.insets = new Insets(0, 0, 5, 5);
		gbcTramoAgregado.gridx = 1;
		gbcTramoAgregado.gridy = 20;
		gbcTramoAgregado.gridwidth = 3;
		add(tramoModificado, gbcTramoAgregado);
		tramoModificado.setVisible(false);
		if(actual.get_estadoTramo().equals(EstadoTramoEnum.ACTIVO)) {
			rdbtnNewRadioButton.setSelected(true);
		}
		else rdbtnNewRadioButton1.setSelected(true);
	}
	
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JButton getBtnNewButton() {
		return guardar;
	}
	public JButton getBtnNewButton_1() {
		return cancelar;
	}

	public void limpiarDatos() {
		this.textField_1.setText(null);
		this.estado.clearSelection();
		this.tipoTransporte.clearSelection();
	}
	
	public void limpiarWarnings() {
		this.seleccioneEstado.setVisible(false);
		this.lblNewLabel_1.setVisible(false);
		inserteTipoTransporte.setVisible(false);
		this.inserteColor.setVisible(false);
		this.inserteTipoTransporte.setVisible(false);
	}
	
	public void nombreFaltante() {
		lblNewLabel_1.setVisible(true);
	}
	
	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public void estadoFaltante() {
		seleccioneEstado.setVisible(true);
	}

	public void deshabilitarGuardado() {
		guardar.setEnabled(false);
	}

	public void habilitarBotones() {
		guardar.setEnabled(true);
	}
	
	public JButton getGuardar() {
		return guardar;
	}
	public void setGuardar(JButton guardar) {
		this.guardar = guardar;
	}

	public void deshabilitarCambios() {
		textField_1.setEditable(false);
		this.rdbtnNewRadioButton.setEnabled(false);
		this.rdbtnNewRadioButton1.setEnabled(false);
	}
	
	public void habilitar() {
		textField_1.setEditable(true);
		this.rdbtnNewRadioButton.setEnabled(true);
		this.rdbtnNewRadioButton1.setEnabled(true);
	}
	
}