package swing_lineas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import bdd.LineasRepo;
import modelo.ColoresLineasEnum;
import modelo.EstadoLineaEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;
import java.awt.Color;
import javax.swing.JComboBox;

public class PanelModificarLinea extends JPanel {
	
	private JTextField textField_1;
	private ButtonGroup estado;
	private ButtonGroup tipoTransporte;
	private JButton guardar;
	private JButton cancelar;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton1;
	private JLabel lblNewLabel_1;
	private JLabel inserteColor;
	private JLabel inserteTipoTransporte;
	private JLabel seleccioneEstado;
	private JLabel lblNewLabel_6;
	private Linea a_modificar;
	private JComboBox comboBox;
	private JLabel lblNewLabel_4;
	private JRadioButton rdbtnTren;
	private JRadioButton rdbtnSubte;
	private JRadioButton rdbtnColectivo;
	
	public void modificarLinea(){
			Linea nueva =  this.getLineaModificada();
			if(nueva.get_nombre().isEmpty()) {
				guardar.setEnabled(false);	
			}
				LineasRepo.ModificarLinea(nueva);
				lblNewLabel_6.setVisible(true);
				guardar.setEnabled(false);
	}
	
	public PanelModificarLinea(Linea actual) {		
		setBackground(Color.WHITE);
		this.a_modificar=actual;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 90, 141, 0, 211, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 21, 0, 0, 85, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		setSize(new Dimension(503, 555));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("MODIFICAR LINEA");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=5;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Por favor, inserte un nombre.");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		gbc_lblNewLabel_1.gridwidth=4;
		gbc_lblNewLabel_1.anchor=GridBagConstraints.WEST;
		lblNewLabel_1.setVisible(false);

		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("COLOR:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		List<String> colores = new ArrayList<String>();
		colores.addAll(ColoresLineasEnum.valores());
		comboBox = new JComboBox(colores.toArray());
		comboBox.setSelectedItem(actual.get_color());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		add(comboBox, gbc_comboBox);
	
		inserteColor = new JLabel("Por favor, inserte un color");
		inserteColor.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteColor.setForeground(Color.RED);
		GridBagConstraints horaApgbc = new GridBagConstraints();
		horaApgbc.gridy = 5;
		horaApgbc.insets = new Insets(0, 0, 5, 5);
		horaApgbc.gridx = 1;
		horaApgbc.gridwidth=4;
		horaApgbc.anchor=GridBagConstraints.WEST;
		add(inserteColor, horaApgbc);
		inserteColor.setVisible(false);
		
		lblNewLabel_4 = new JLabel("TIPO DE TRANSPORTE:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		rdbtnTren = new JRadioButton("Tren");
		rdbtnTren.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnTren = new GridBagConstraints();
		gbc_rdbtnTren.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTren.gridx = 2;
		gbc_rdbtnTren.gridy = 6;
		add(rdbtnTren, gbc_rdbtnTren);
		
		rdbtnSubte = new JRadioButton("Subte");
		rdbtnSubte.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnSubte = new GridBagConstraints();
		gbc_rdbtnSubte.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSubte.gridx = 3;
		gbc_rdbtnSubte.gridy = 6;
		add(rdbtnSubte, gbc_rdbtnSubte);
		
		rdbtnColectivo = new JRadioButton("Colectivo");
		rdbtnColectivo.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_rdbtnColectivo = new GridBagConstraints();
		gbc_rdbtnColectivo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnColectivo.gridx = 4;
		gbc_rdbtnColectivo.gridy = 6;
		add(rdbtnColectivo, gbc_rdbtnColectivo);
				
		tipoTransporte = new ButtonGroup();
		tipoTransporte.add(rdbtnSubte);
		tipoTransporte.add(rdbtnColectivo);
		tipoTransporte.add(rdbtnTren);

		if(actual.get_tipoTransporte().equals(LineaTipoTransporteEnum.COLECTIVO)) {
			rdbtnColectivo.setSelected(true);
		}
		else if(actual.get_tipoTransporte().equals(LineaTipoTransporteEnum.TREN)) {
			rdbtnTren.setSelected(true);
		}
		else rdbtnSubte.setSelected(true);
		
		inserteTipoTransporte = new JLabel("Por favor, seleccione un tipo de transporte.");
		inserteTipoTransporte.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
		inserteTipoTransporte.setForeground(Color.RED);
		GridBagConstraints horaCgbc = new GridBagConstraints();
		horaCgbc.gridy = 7;
		horaCgbc.insets = new Insets(0, 0, 5, 5);
		horaCgbc.gridx = 1;
		horaCgbc.gridwidth=8;
		horaCgbc.anchor=GridBagConstraints.WEST;
		add(inserteTipoTransporte, horaCgbc);
		inserteTipoTransporte.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("ESTADO:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
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
		gbc_rdbtnNewRadioButton1.gridx = 4;
		gbc_rdbtnNewRadioButton1.gridy = 8;
		add(rdbtnNewRadioButton1, gbc_rdbtnNewRadioButton1);
		
		seleccioneEstado = new JLabel("Por favor, seleccione un estado.");
		seleccioneEstado.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		seleccioneEstado.setForeground(Color.RED);
		GridBagConstraints estadoGbc = new GridBagConstraints();
		estadoGbc.gridy = 9;
		estadoGbc.insets = new Insets(0, 0, 5, 0);
		estadoGbc.gridx = 1;
		estadoGbc.gridwidth=10;
		estadoGbc.anchor=GridBagConstraints.WEST;
		add(seleccioneEstado, estadoGbc);
		seleccioneEstado.setVisible(false); 
		
		estado = new ButtonGroup();
		estado.add(rdbtnNewRadioButton);
		estado.add(rdbtnNewRadioButton1);
		
		cancelar = new JButton("VOLVER");
		cancelar.setBackground(new Color(204, 204, 51));
		cancelar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 10;
		add(cancelar, gbc_btnNewButton_1);
		
		guardar = new JButton("GUARDAR");
		guardar.setBackground(new Color(204, 204, 51));
		guardar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(guardar, gbc_btnNewButton);
		
		lblNewLabel_6 = new JLabel("LA LINEA SE MODIFICÓ CORRECTAMENTE");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 11;
		gbc_lblNewLabel_6.gridwidth=4;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		textField_1.setText(actual.get_nombre());

		if(actual.get_estado().equals(EstadoLineaEnum.ACTIVA)) {
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

	public Linea getLineaModificada()  {
		EstadoLineaEnum e = null;
		if(rdbtnNewRadioButton.isSelected()) {
			e= EstadoLineaEnum.ACTIVA;
		}else if(rdbtnNewRadioButton1.isSelected()){
			e= EstadoLineaEnum.NO_ACTIVA;
		}
		LineaTipoTransporteEnum t = null;
		if (rdbtnColectivo.isSelected()) {
			t = LineaTipoTransporteEnum.COLECTIVO;
		}
		else if (rdbtnSubte.isSelected()) {
			t=LineaTipoTransporteEnum.SUBTE;
		}
		else if(rdbtnTren.isSelected()) {
			t = LineaTipoTransporteEnum.TREN;
		}
		return new Linea(a_modificar.get_id(),this.textField_1.getText(),
				ColoresLineasEnum.valueOf(comboBox.getSelectedItem().toString()).toString(),
				e,t) ;
	}

	public void limpiarDatos() {
		this.textField_1.setText(null);
		this.estado.clearSelection();
		this.tipoTransporte.clearSelection();
	}
	
	public void limpiarWarnings() {
		this.seleccioneEstado.setVisible(false);
		this.lblNewLabel_1.setVisible(false);
		lblNewLabel_6.setVisible(false);
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

	public void mensajeLineaModificada() {
		lblNewLabel_6.setVisible(true);
	}
	public void estadoFaltante() {
		seleccioneEstado.setVisible(true);
	}
	
	public void mostrarDatosMantenimiento() {
		cancelar.setEnabled(false);
		guardar.setEnabled(false);
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

	public JLabel getLblNewLabel_6() {
		return lblNewLabel_6;
	}

	public void setLblNewLabel_6(JLabel lblNewLabel_6) {
		this.lblNewLabel_6 = lblNewLabel_6;
	}
	
	public String estadoSeleccionado() {
		if(rdbtnNewRadioButton.isSelected()) {
			return "activa";
		}else if(this.rdbtnNewRadioButton1.isSelected()) {
			return "no activa";
		}else return "no seleccionado";
	}
}