package swing_tareas_mantenimiento;

import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.TimePicker;

import modelo.Estacion;
import modelo.TareaMantenimiento;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import bdd.EstacionesRepo;
import excepciones.FechaFinMenorFechaInicioException;
import filtros.EstacionesFiltro;

import javax.swing.JTextArea;


public class PanelAgregarTareaMantenimiento extends JPanel {
	
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel seleccioneEstacion;
	private JLabel seleccioneFechaInicio;
	private JLabel seleccioneFechaFin;
	private JDateChooser dateChooser_1 ;
	private JDateChooser dateChooser;
	private JLabel tareaAgregada;
	private JComboBox comboBox ;
	private JTextArea textArea;
	private JLabel fechaFinMayor;
	
	public PanelAgregarTareaMantenimiento() {
		setBackground(Color.WHITE);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 90, 141, 211, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 21, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("AGREGAR TAREA DE MANTENIMIENTO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("ESTACION:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		ArrayList<Estacion> estaciones = (ArrayList<Estacion>) EstacionesRepo.ObtenerEstaciones();
		
		comboBox = new JComboBox(estaciones.toArray());

		comboBox.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();

		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		seleccioneEstacion = new JLabel("Por favor, seleccione una estación.");
		seleccioneEstacion.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		seleccioneEstacion.setForeground(Color.RED);
		GridBagConstraints estacionGbc = new GridBagConstraints();
		estacionGbc.gridy = 3;
		estacionGbc.insets = new Insets(0, 0, 5, 0);
		estacionGbc.gridx = 1;
		estacionGbc.gridwidth=4;
		estacionGbc.anchor=GridBagConstraints.WEST;
		add(seleccioneEstacion, estacionGbc);
		seleccioneEstacion.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("FECHA INICIO:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 4;
		add(dateChooser, gbc_dateChooser);
		
		seleccioneFechaInicio = new JLabel("Por favor, seleccione una fecha de inicio.");
		seleccioneFechaInicio.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		seleccioneFechaInicio.setForeground(Color.RED);
		GridBagConstraints fehcaInicioGbc = new GridBagConstraints();
		fehcaInicioGbc.gridy = 5;
		fehcaInicioGbc.insets = new Insets(0, 0, 5, 0);
		fehcaInicioGbc.gridx = 1;
		fehcaInicioGbc.gridwidth=4;
		fehcaInicioGbc.anchor=GridBagConstraints.WEST;
		add(seleccioneFechaInicio, fehcaInicioGbc);
		seleccioneFechaInicio.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("FECHA FIN:");  
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		dateChooser_1 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.gridwidth = 2;
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 6;
		add(dateChooser_1, gbc_dateChooser_1);
	
		seleccioneFechaFin = new JLabel("Por favor, seleccione una fecha de fin.");
		seleccioneFechaFin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		seleccioneFechaFin.setForeground(Color.RED);
		GridBagConstraints fechaFinGbc = new GridBagConstraints();
		fechaFinGbc.gridy = 7;
		fechaFinGbc.insets = new Insets(0, 0, 5, 0);
		fechaFinGbc.gridx = 1;
		fechaFinGbc.gridwidth=4;
		fechaFinGbc.anchor=GridBagConstraints.WEST;
		add(seleccioneFechaFin, fechaFinGbc);
		seleccioneFechaFin.setVisible(false);
		
		fechaFinMayor = new JLabel("Por favor, seleccione una fecha de fin mayor a la de inicio.");
		fechaFinMayor.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		fechaFinMayor.setForeground(Color.RED);
		GridBagConstraints fechaMayorGbc = new GridBagConstraints();
		fechaMayorGbc.gridy = 7;
		fechaMayorGbc.insets = new Insets(0, 0, 5, 0);
		fechaMayorGbc.gridx = 1;
		fechaMayorGbc.gridwidth=4;
		fechaMayorGbc.anchor=GridBagConstraints.WEST;
		add(fechaFinMayor, fechaMayorGbc);
		fechaFinMayor.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("OBSERVACIONES:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 8;
		add(textArea, gbc_textArea);
		
		btnNewButton = new JButton("GUARDAR");
		btnNewButton.setBackground(new Color(204, 204, 51));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setBackground(new Color(204, 204, 51));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 10;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		tareaAgregada = new JLabel("LA TAREA DE MANTENIMIENTO SE HA AGREGADO CORRECTAMENTE");
		tareaAgregada.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbcTareaAgregada = new GridBagConstraints();
		gbcTareaAgregada.insets = new Insets(0, 0, 5, 5);
		gbcTareaAgregada.gridx = 1;
		gbcTareaAgregada.gridy = 11;
		gbcTareaAgregada.gridwidth=3;
		add(tareaAgregada, gbcTareaAgregada);
		tareaAgregada.setVisible(false);
		
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}
	
	public void limpiarWarnings() {
		this.seleccioneEstacion.setVisible(false);
		this.seleccioneFechaFin.setVisible(false);
		this.seleccioneFechaInicio.setVisible(false);
		fechaFinMayor.setVisible(false);
		this.tareaAgregada.setVisible(false);
	}
	
	public void seleccioneEstacion() {
		this.seleccioneEstacion.setVisible(true);
	}
	public void seleccioneFechaFin() {
		this.seleccioneFechaFin.setVisible(true);
	}
	public void seleccioneFechaInicio() {
		this.seleccioneFechaInicio.setVisible(true);
	}
	public TareaMantenimiento getTareaCreada() throws FechaFinMenorFechaInicioException {
		//public TareaMantenimiento(Estacion estacion, LocalDate fi, LocalDate ff, String obs)
		//EstacionesFiltro e= new EstacionesFiltro();
		//e.setNombre(this.comboBox.getSelectedItem().toString());
		
		Estacion e = (Estacion)this.comboBox.getSelectedItem();
		
		
		if(this.dateChooser.getDate()==null && this.dateChooser_1.getDate()==null) {
			return new TareaMantenimiento(e,null,null, this.textArea.getText());
		}else if(this.dateChooser.getDate()==null) {
			return new TareaMantenimiento(e,null,
					this.dateChooser_1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), this.textArea.getText());
		}else if(this.dateChooser_1.getDate()==null) {
			return new TareaMantenimiento(e,this.dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
					null, this.textArea.getText());
		}else {
			return new TareaMantenimiento(e,this.dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
					this.dateChooser_1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), this.textArea.getText());
		}

	}
	
	public void mensajeTareaCreada() {
		this.tareaAgregada.setVisible(true);
	}
	public void deshabilitarGuardado() {
		btnNewButton.setEnabled(false);
	}
	public void limpiarDatos() {
		comboBox.setSelectedIndex(0);
		dateChooser.setCalendar(null);
		this.dateChooser_1.setCalendar(null);
		this.textArea.setText(null);
	}
	public void habilitarBotones() {
		this.btnNewButton.setEnabled(true);
	}
	public void mensajeFechaErronea() {
		fechaFinMayor.setVisible(true);
	}
	

}
