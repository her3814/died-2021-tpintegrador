package swing_lineas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bdd.LineasRepo;
import modelo.ColoresLineasEnum;
import modelo.EstadoLineaEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;

import java.awt.Color;
import javax.swing.JComboBox;

public class PanelAgregarLinea extends JPanel {
	private JTextField textField;
	private ButtonGroup estado;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JLabel inserteNombre;
	private JLabel inserteColor;
	private JLabel inserteEstado;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton1;
	private JLabel lineaAgregada;
	private ButtonGroup medio;
	private JLabel inserteMedio;
	private JRadioButton rdbtnSubte;
	private JRadioButton rdbtnTren;
	private JRadioButton rdbtnColectivo;
	private JComboBox comboBox;
	
	public PanelAgregarLinea() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{40, 152, 111, 114, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 0, 21, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("AGREGAR LINEA");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22)); 
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		inserteNombre = new JLabel("Por favor, inserte un nombre.");
		inserteNombre.setForeground(Color.RED);
		inserteNombre.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_nom = new GridBagConstraints();
		gbc_i_nom.anchor = GridBagConstraints.EAST;
		gbc_i_nom.insets = new Insets(0, 0, 5, 5);
		gbc_i_nom.gridx = 1;
		gbc_i_nom.gridy = 3;
		gbc_i_nom.gridwidth=3;
		gbc_i_nom.anchor=GridBagConstraints.WEST;
		add(inserteNombre, gbc_i_nom);
		inserteNombre.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("COLOR:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox = new JComboBox();
		List<String> colores = new ArrayList<String>();
		colores = ColoresLineasEnum.valores();
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
				 colores.toArray()));
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
		
		inserteColor = new JLabel("Por favor, inserte un color.");
		inserteColor.setForeground(Color.RED);
		inserteColor.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteColor.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_col = new GridBagConstraints();
		gbc_i_col.anchor = GridBagConstraints.EAST;
		gbc_i_col.insets = new Insets(0, 0, 5, 5);
		gbc_i_col.gridx = 1;
		gbc_i_col.gridy = 5;
		gbc_i_col.gridwidth=3;
		gbc_i_col.anchor=GridBagConstraints.WEST;
		add(inserteColor, gbc_i_col);
		inserteColor.setVisible(false);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("MEDIO DE TRANSPORTE:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1_1.gridy = 6;
		add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		rdbtnSubte = new JRadioButton("Subte");
		rdbtnSubte.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnSubte = new GridBagConstraints();
		gbc_rdbtnSubte.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSubte.gridx = 2;
		gbc_rdbtnSubte.gridy = 6;
		add(rdbtnSubte, gbc_rdbtnSubte);
		
		rdbtnColectivo = new JRadioButton("Colectivo");
		rdbtnColectivo.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnColectivo = new GridBagConstraints();
		gbc_rdbtnColectivo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnColectivo.gridx = 3;
		gbc_rdbtnColectivo.gridy = 6;
		add(rdbtnColectivo, gbc_rdbtnColectivo);
		
		rdbtnTren = new JRadioButton("Tren");
		rdbtnTren.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnTren = new GridBagConstraints();
		gbc_rdbtnTren.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnTren.gridx = 4;
		gbc_rdbtnTren.gridy = 6;
		add(rdbtnTren, gbc_rdbtnTren);
		
		medio = new ButtonGroup();
		medio.add(rdbtnTren);
		medio.add(rdbtnColectivo);
		medio.add(rdbtnSubte);
		
		inserteMedio = new JLabel("Por favor, seleccione un medio de transporte.");
		inserteMedio.setForeground(Color.RED);
		inserteMedio.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteMedio.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_medio = new GridBagConstraints();
		gbc_i_medio.anchor = GridBagConstraints.EAST;
		gbc_i_medio.insets = new Insets(0, 0, 5, 5);
		gbc_i_medio.gridx = 1;
		gbc_i_medio.gridy = 7;
		gbc_i_medio.gridwidth=3;
		gbc_i_medio.anchor=GridBagConstraints.WEST;
		add(inserteMedio, gbc_i_medio);
		inserteMedio.setVisible(false);

		JLabel lblNewLabel_5 = new JLabel("ESTADO:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		rdbtnNewRadioButton = new JRadioButton("Activa");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 8;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton1 = new JRadioButton("No activa");
		rdbtnNewRadioButton1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnNewRadioButton1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton1.gridx = 3;
		gbc_rdbtnNewRadioButton1.gridy = 8;
		add(rdbtnNewRadioButton1, gbc_rdbtnNewRadioButton1);
		
		estado = new ButtonGroup();
		estado.add(rdbtnNewRadioButton);
		estado.add(rdbtnNewRadioButton1);
		
		inserteEstado = new JLabel("Por favor, seleccione un estado.");
		inserteEstado.setForeground(Color.RED);
		inserteEstado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteEstado.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_est = new GridBagConstraints();
		gbc_i_est.anchor = GridBagConstraints.EAST;
		gbc_i_est.insets = new Insets(0, 0, 5, 5);
		gbc_i_est.gridx = 1;
		gbc_i_est.gridy = 9;
		gbc_i_est.gridwidth=3;
		gbc_i_est.anchor=GridBagConstraints.WEST;
		add(inserteEstado, gbc_i_est);
		inserteEstado.setVisible(false);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(204, 204, 51));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(btnGuardar, gbc_btnNewButton);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.setBackground(new Color(204, 204, 51));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 10;
		add(btnVolver, gbc_btnNewButton_1);
		
		lineaAgregada = new JLabel("LA LINEA SE HA AGREGADO CORRECTAMENTE");
		lineaAgregada.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbcLineaAgregada = new GridBagConstraints();
		gbcLineaAgregada.insets = new Insets(0, 0, 5, 5);
		gbcLineaAgregada.gridx = 1;
		gbcLineaAgregada.gridy = 11;
		gbcLineaAgregada.gridwidth=3;
		add(lineaAgregada, gbcLineaAgregada);
		lineaAgregada.setVisible(false);
		
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnVolver;
	}
	
	public void limpiarDatos() {
		textField.setText(null);
		//textField_1.setText(null);
		comboBox.setSelectedIndex(-1);
		estado.clearSelection();
		this.lineaAgregada.setVisible(false);
		this.medio.clearSelection();
	}
	public void limpiarWarnings() {
		this.inserteNombre.setVisible(false);
		this.inserteColor.setVisible(false);
		this.inserteEstado.setVisible(false);
		this.inserteMedio.setVisible(false);
	}
	
	public void habilitarGuardar() {
		this.btnGuardar.setEnabled(true);
	}
	
	public Linea obtenerLineaCreada() {
		//public Linea(String nombre, String color, EstadoLineaEnum estado, LineaTipoTransporteEnum tipoTransporte)
		EstadoLineaEnum e = null;
		if(this.rdbtnNewRadioButton.isSelected()) {
			e=EstadoLineaEnum.ACTIVA;
		}else if(this.rdbtnNewRadioButton1.isSelected()) {
			e=EstadoLineaEnum.NO_ACTIVA;
		}
		
		LineaTipoTransporteEnum t =null;
		if(this.rdbtnColectivo.isSelected()) {
			t= LineaTipoTransporteEnum.COLECTIVO;
		}else if(this.rdbtnSubte.isSelected()) {
			t=LineaTipoTransporteEnum.SUBTE;
		}else if(this.rdbtnTren.isSelected()) {
			t=LineaTipoTransporteEnum.TREN;
		}
		return new Linea(this.textField.getText(), this.comboBox.getSelectedItem().toString(), e, t);
	}
	
	public void mensajeLineaCreada() {
		this.lineaAgregada.setVisible(true);
	}

	
	public void agregarLinea() {
		Linea nueva= this.obtenerLineaCreada();
		if(nueva.get_nombre().isEmpty()) {
			this.inserteNombre.setVisible(true);
		}
		if(nueva.get_color().isEmpty()) {
			this.inserteColor.setVisible(true);
		}
		if(nueva.get_estado()==null) {
			this.inserteEstado.setVisible(true);
		}
		if(nueva.get_tipoTransporte()==null) {
			this.inserteMedio.setVisible(true);
		}
		
		if(!nueva.get_nombre().isEmpty() && !nueva.get_color().isEmpty() && nueva.get_estado()!=null && nueva.get_tipoTransporte()!=null) {
			this.mensajeLineaCreada();
			this.btnGuardar.setEnabled(false);
			LineasRepo.AgregarLinea(nueva);
	
		}
	}
}