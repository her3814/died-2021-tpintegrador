package swing_boletos;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.TimePicker;

import bdd.EstacionesRepo;
import filtros.EstacionesFiltro;
import modelo.Boleto;
import modelo.Estacion;
import modelo.Tramo;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class PanelAgregarBoleto extends JPanel {

	private JTextField textField_1;
	private JButton guardar;
	private JButton cancelar;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblNewLabel_5;
	private JComboBox comboBox_2;
	private JLabel inserteCliente;
	private JLabel inserteEmail;
	private JLabel inserteEstOrigen;
	private JLabel inserteEstDestino;
	
	public PanelAgregarBoleto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 90, 141, 211, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 0, 21, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("AGREGAR BOLETO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("NOMBRE CLIENTE:");
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
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		inserteCliente = new JLabel("Por favor, inserte un nombre de cliente.");
		inserteCliente.setForeground(Color.RED);
		inserteCliente.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteCliente.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_cli = new GridBagConstraints();
		gbc_i_cli.anchor = GridBagConstraints.EAST;
		gbc_i_cli.insets = new Insets(0, 0, 5, 5);
		gbc_i_cli.gridx = 1;
		gbc_i_cli.gridy = 3;
		gbc_i_cli.gridwidth=3;
		gbc_i_cli.anchor=GridBagConstraints.WEST;
		add(inserteCliente, gbc_i_cli);
		inserteCliente.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL CLIENTE:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		inserteEmail = new JLabel("Por favor, inserte un email.");
		inserteEmail.setForeground(Color.RED);
		inserteEmail.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteEmail.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_email = new GridBagConstraints();
		gbc_i_email.anchor = GridBagConstraints.EAST;
		gbc_i_email.insets = new Insets(0, 0, 5, 5);
		gbc_i_email.gridx = 1;
		gbc_i_email.gridy = 5;
		gbc_i_email.gridwidth=3;
		gbc_i_email.anchor=GridBagConstraints.WEST;
		add(inserteEmail, gbc_i_email);
		inserteEmail.setVisible(false);
		
		lblNewLabel_1 = new JLabel("ESTACION ORIGEN:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		List<Estacion> estaciones = EstacionesRepo.ObtenerEstaciones();
		
		comboBox = new JComboBox();
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 6;
		add(comboBox, gbc_comboBox);
		
		inserteEstOrigen = new JLabel("Por favor, seleccione una estación de origen.");
		inserteEstOrigen.setForeground(Color.RED);
		inserteEstOrigen.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteEstOrigen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_origen = new GridBagConstraints();
		gbc_i_origen.anchor = GridBagConstraints.EAST;
		gbc_i_origen.insets = new Insets(0, 0, 5, 5);
		gbc_i_origen.gridx = 1;
		gbc_i_origen.gridy = 7;
		gbc_i_origen.gridwidth=3;
		gbc_i_origen.anchor=GridBagConstraints.WEST;
		add(inserteEstOrigen, gbc_i_origen);
		inserteEstOrigen.setVisible(false);
		
		lblNewLabel_4 = new JLabel("ESTACION DESTINO:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 8;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		comboBox_1 = new JComboBox();	
		comboBox_1.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 8;
		add(comboBox_1, gbc_comboBox_1);
		
		inserteEstDestino = new JLabel("Por favor, seleccione una estación de origen.");
		inserteEstDestino.setForeground(Color.RED);
		inserteEstDestino.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteEstDestino.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_destino = new GridBagConstraints();
		gbc_i_destino.anchor = GridBagConstraints.EAST;
		gbc_i_destino.insets = new Insets(0, 0, 5, 5);
		gbc_i_destino.gridx = 1;
		gbc_i_destino.gridy = 9;
		gbc_i_destino.gridwidth=3;
		gbc_i_destino.anchor=GridBagConstraints.WEST;
		add(inserteEstDestino, gbc_i_destino);
		inserteEstDestino.setVisible(false);
		
		lblNewLabel_5 = new JLabel("MEJOR CAMINO:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 10;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial", Font.BOLD, 13));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"M\u00C1S BARATO", "MENOR DISTANCIA", "M\u00C1S R\u00C1PIDO"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 10;
		add(comboBox_2, gbc_comboBox_2);

		guardar = new JButton("GUARDAR");
		guardar.setBackground(new Color(204, 204, 51));
		guardar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(10, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 11;
		add(guardar, gbc_btnNewButton);
		
		cancelar = new JButton("CANCELAR");
		cancelar.setBackground(new Color(204, 204, 51));
		cancelar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(10, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 11;
		add(cancelar, gbc_btnNewButton_1);
		
	}
	
	public JButton getCancelar() {
		return cancelar;
	}
	public JButton getGuardar() {
		return guardar;
	}
	public void limpiarWarnings() {
		this.inserteCliente.setVisible(false);
		this.inserteEmail.setVisible(false);
		this.inserteEstOrigen.setVisible(false);
		this.inserteEstDestino.setVisible(false);
	}
	public void limpiarDatos() {
		this.textField_1.setText(null);
		this.textField.setText(null);
		this.comboBox.setSelectedIndex(0);
		this.comboBox_1.setSelectedIndex(0);
		this.comboBox_2.setSelectedIndex(0);
	}
	
	public void obtenerBoletoCreado() {
		EstacionesFiltro filtroOrigen= new EstacionesFiltro();
		filtroOrigen.setNombre(this.comboBox.getSelectedItem().toString());
		EstacionesFiltro filtroDestino = new EstacionesFiltro();
		filtroDestino.setNombre(this.comboBox_1.getSelectedItem().toString());
		
	//public Boleto(String correo, String nombre, LocalDate fechaVenta, Double costo, Estacion origen, Estacion destino, LinkedHashSet<Tramo> recorrido)
	//	return new Boleto(textField.getText(), textField_1.getText(), LocalDate.now(),0.0,EstacionesRepo.ObtenerEstaciones(filtroOrigen).get(0),EstacionesRepo.ObtenerEstaciones(filtroDestino).get(0), );
		
	}
public void agregarBoleto() {
		//Boleto nuevo= panelAgregarBoleto.obtenerBoletoCreado();
	}
}
