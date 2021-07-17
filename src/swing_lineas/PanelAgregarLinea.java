package swing_lineas;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modelo.EstadoLineaEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;

import java.awt.Color;

public class PanelAgregarLinea extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private ButtonGroup estado;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel inserteNombre;
	private JLabel inserteColor;
	private JLabel inserteEstado;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton1;
	private JLabel lineaAgregada;
	
	/**
	 * @wbp.nonvisual location=543,504
	 */
	private final JLabel label = new JLabel("New label");
	public PanelAgregarLinea() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 90, 141, 211, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 21, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
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
		
		JLabel lblNewLabel_5 = new JLabel("ESTADO:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		rdbtnNewRadioButton = new JRadioButton("Activa");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 6;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton1 = new JRadioButton("No activa");
		GridBagConstraints gbc_rdbtnNewRadioButton1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton1.gridx = 3;
		gbc_rdbtnNewRadioButton1.gridy = 6;
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
		gbc_i_est.gridy = 7;
		gbc_i_est.gridwidth=3;
		gbc_i_est.anchor=GridBagConstraints.WEST;
		add(inserteEstado, gbc_i_est);
		inserteEstado.setVisible(false);
		
		btnGuardar = new JButton("GUARDAR");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 8;
		add(btnGuardar, gbc_btnNewButton);
		
		btnCancelar = new JButton("CANCELAR");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 8;
		add(btnCancelar, gbc_btnNewButton_1);
		
		lineaAgregada = new JLabel("LA LINEA SE HA AGREGADO CORRECTAMENTE");
		lineaAgregada.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbcLineaAgregada = new GridBagConstraints();
		gbcLineaAgregada.insets = new Insets(0, 0, 5, 5);
		gbcLineaAgregada.gridx = 1;
		gbcLineaAgregada.gridy = 9;
		gbcLineaAgregada.gridwidth=3;
		add(lineaAgregada, gbcLineaAgregada);
		lineaAgregada.setVisible(false);
		
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void limpiarDatos() {
		textField.setText(null);
		textField_1.setText(null);
		estado.clearSelection();
		this.lineaAgregada.setVisible(false);
	}
	public void limpiarWarnings() {
		this.inserteNombre.setVisible(false);
		this.inserteColor.setVisible(false);
		this.inserteEstado.setVisible(false);
	}
	public void inserteNombre() {
		this.inserteNombre.setVisible(true);
	}
	public void inserteColor() {
		this.inserteColor.setVisible(true);
	}
	public void inserteEstado() {
		this.inserteEstado.setVisible(true);
	}
	
	public void habilitarGuardar() {
		this.btnGuardar.setEnabled(true);
	}
	public void deshabilitarGuardar() {
		this.btnGuardar.setEnabled(false);
	}
	
	public Linea obtenerLineaCreada() {
		//public Linea(String nombre, String color, EstadoLineaEnum estado, LineaTipoTransporteEnum tipoTransporte)
		EstadoLineaEnum e = null;
		if(this.rdbtnNewRadioButton.isSelected()) {
			e=EstadoLineaEnum.ACTIVA;
		}else if(this.rdbtnNewRadioButton1.isSelected()) {
			e=EstadoLineaEnum.NO_ACTIVA;
		}
		return new Linea(this.textField.getText(), this.textField_1.getText(), e, LineaTipoTransporteEnum.COLECTIVO);
	}
	
	public void mensajeLineaCreada() {
		this.lineaAgregada.setVisible(true);
	}

}