package swing_tramos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
import bdd.TramosRepo;
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
	private List<Estacion> estaciones;
	private JLabel fallaOrden;
	private JLabel fallaInicio;
	private JLabel fallaDestino;
	private static JLabel label;
	private JButton btnRecorrido;
	
	public PanelAgregarTramo() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 135, 13, 85, 67, 0, 0, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 19, 21, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		fallaInicio = new JLabel("La estación seleccionada como orgien ya pertenecea esta linea");
		fallaInicio.setForeground(Color.RED);
		fallaInicio.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		fallaInicio.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_inicio = new GridBagConstraints();
		gbc_i_inicio.anchor = GridBagConstraints.EAST;
		gbc_i_inicio.insets = new Insets(0, 0, 5, 5);
		gbc_i_inicio.gridx = 1;
		gbc_i_inicio.gridy = 3;
		gbc_i_inicio.gridwidth=5;
		gbc_i_inicio.anchor=GridBagConstraints.WEST;
		add(fallaInicio, gbc_i_inicio);
		fallaInicio.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("ESTACION DESTINO:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 4;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		//comboBox_1 = new JComboBox(estaciones.stream().filter(e-> e.getId()!=((Estacion)this.comboBox.getSelectedItem()).getId()).collect(Collectors.toList()).toArray());
		//comboBox_1= new JComboBox(estaciones.toArray());
		
		comboBox_1= new JComboBox();
		comboBox_1.setModel(new javax.swing.DefaultComboBoxModel<>(estaciones.stream().filter(e-> e.getId()!= ((Estacion) comboBox.getSelectedItem()).getId()).collect(Collectors.toList()).toArray()));
		
		comboBox_1.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 4;
		add(comboBox_1, gbc_comboBox_1);
		
		fallaDestino= new JLabel("La estación seleccionada como destino ya pertenecea esta linea");
		fallaDestino.setForeground(Color.RED);
		fallaDestino.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		fallaDestino.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_destino = new GridBagConstraints();
		gbc_i_destino.anchor = GridBagConstraints.EAST;
		gbc_i_destino.insets = new Insets(0, 0, 5, 5);
		gbc_i_destino.gridx = 1;
		gbc_i_destino.gridy = 5;
		gbc_i_destino.gridwidth=5;
		gbc_i_destino.anchor=GridBagConstraints.WEST;
		add(fallaDestino, gbc_i_destino);
		fallaDestino.setVisible(false);
		
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
		
		btnRecorrido = new JButton("VER RECORRIDO");
		btnRecorrido.setBackground(new Color(204, 204, 51));
		btnRecorrido.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnRecorrido= new GridBagConstraints();
		gbc_btnRecorrido.fill = GridBagConstraints.VERTICAL;
		gbc_btnRecorrido.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecorrido.gridx = 5;
		gbc_btnRecorrido.gridy = 6;
		add(btnRecorrido, gbc_btnRecorrido);
		
		btnRecorrido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String etiqueta = null;
			System.out.println(((Linea)comboBox_1_1.getSelectedItem()).toString())	;
				for(Tramo t: TramosRepo.ObtenerRecorrido((Linea)comboBox_1_1.getSelectedItem())) {
					etiqueta=etiqueta+t.getOrigen().getNombre();
				}
				System.out.println(etiqueta);
				label = new JLabel(etiqueta);
				label.setForeground(Color.RED);
				label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
				label.setHorizontalAlignment(SwingConstants.LEFT);
				GridBagConstraints gbc_i_label = new GridBagConstraints();
				gbc_i_label.anchor = GridBagConstraints.EAST;
				gbc_i_label.insets = new Insets(0, 0, 5, 5);
				gbc_i_label.gridx = 1;
				gbc_i_label.gridy = 8;
				gbc_i_label.gridwidth=3;
				gbc_i_label.anchor=GridBagConstraints.WEST;
				add(label, gbc_i_label);
				label.setVisible(true);
			}
		});
		
		fallaOrden = new JLabel("La estación seleccionada como origen no coincide con el final de esta linea");
		fallaOrden.setForeground(Color.RED);
		fallaOrden.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		fallaOrden.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_orden = new GridBagConstraints();
		gbc_i_orden.anchor = GridBagConstraints.EAST;
		gbc_i_orden.insets = new Insets(0, 0, 5, 5);
		gbc_i_orden.gridx = 1;
		gbc_i_orden.gridy = 7;
		gbc_i_orden.gridwidth=5;
		gbc_i_orden.anchor=GridBagConstraints.WEST;
		add(fallaOrden, gbc_i_orden);
		fallaOrden.setVisible(false);
		
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
		
		JLabel lblNewLabel_2_1 = new JLabel("(minutos)");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 5;
		gbc_lblNewLabel_2_1.gridy = 9;
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
		gbc_i_duracion.gridy = 10;
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
		
		inserteDistancia = new JLabel("Por favor, inserte una distancia.");
		inserteDistancia.setForeground(Color.RED);
		inserteDistancia.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteDistancia.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_distancia = new GridBagConstraints();
		gbc_i_distancia.anchor = GridBagConstraints.EAST;
		gbc_i_distancia.insets = new Insets(0, 0, 5, 5);
		gbc_i_distancia.gridx = 1;
		gbc_i_distancia.gridy = 12;
		gbc_i_distancia.gridwidth=3;
		gbc_i_distancia.anchor=GridBagConstraints.WEST;
		add(inserteDistancia, gbc_i_distancia);
		inserteDistancia.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("(km)");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 11;
		gbc_lblNewLabel_2.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
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
		
		inserteCP = new JLabel("Por favor, inserte la cantidad máxima de pasajeros.");
		inserteCP.setForeground(Color.RED);
		inserteCP.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteCP.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_cantP = new GridBagConstraints();
		gbc_i_cantP.anchor = GridBagConstraints.EAST;
		gbc_i_cantP.insets = new Insets(0, 0, 5, 5);
		gbc_i_cantP.gridx = 1;
		gbc_i_cantP.gridy = 14;
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
		
		inserteCosto = new JLabel("Por favor, inserte un costo.");
		inserteCosto.setForeground(Color.RED);
		inserteCosto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		inserteCosto.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_costo = new GridBagConstraints();
		gbc_i_costo.anchor = GridBagConstraints.EAST;
		gbc_i_costo.insets = new Insets(0, 0, 5, 5);
		gbc_i_costo.gridx = 1;
		gbc_i_costo.gridy = 16;
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
		inserteEstado.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_estado = new GridBagConstraints();
		gbc_i_estado.anchor = GridBagConstraints.EAST;
		gbc_i_estado.insets = new Insets(0, 0, 5, 5);
		gbc_i_estado.gridx = 1;
		gbc_i_estado.gridy = 18;
		gbc_i_estado.gridwidth=3;
		gbc_i_estado.anchor=GridBagConstraints.WEST;
		add(inserteEstado, gbc_i_estado);
		inserteEstado.setVisible(false);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(204, 204, 51));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 19;
		add(btnGuardar, gbc_btnNewButton);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(new Color(204, 204, 51));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 19;
		add(btnCancelar, gbc_btnNewButton_1);
		
		tramoAgregado = new JLabel("EL TRAMO SE HA AGREGADO CORRECTAMENTE");
		tramoAgregado.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbcTramoAgregado = new GridBagConstraints();
		gbcTramoAgregado.insets = new Insets(0, 0, 5, 5);
		gbcTramoAgregado.gridx = 1;
		gbcTramoAgregado.gridy = 20;
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
		this.inserteDistancia.setVisible(false);
		this.inserteDuracion.setVisible(false);
		this.inserteEstado.setVisible(false);
		this.tramoAgregado.setVisible(false);
		this.fallaOrden.setVisible(false);
		this.fallaDestino.setVisible(false);
		this.fallaInicio.setVisible(false);
		label.setVisible(false);
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
		
		return new Tramo((Linea)this.comboBox_1_1.getSelectedItem(), LineasRepo.siguienteOrden((Linea)this.comboBox_1_1.getSelectedItem()), (Estacion)this.comboBox.getSelectedItem(),(Estacion)this.comboBox_1.getSelectedItem(),cant_pasajeros ,
				duracion,distancia,costo,estado);
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

	public void agregarTramo() {
		Tramo nuevo = this.obtenerTramoCreado();
		if(nuevo.get_cantPasajeros()==null) {
			this.inserteCP.setVisible(true);
		}
		if(nuevo.get_estadoTramo()==null) {
			this.inserteEstado.setVisible(true);
		}
		if(nuevo.getCosto()==null) {
			this.inserteCosto.setVisible(true);
		}
		if(nuevo.getDistancia()==null) {
			this.inserteDistancia.setVisible(true);
		}
		if(nuevo.getDuracion()==null) {
			this.inserteDuracion.setVisible(true);
		}
		if(!this.ordenCorrecto(nuevo)) {
			this.fallaOrden.setVisible(true);
		}
		if(LineasRepo.pertenece(nuevo.getOrigen(), nuevo.getLinea())) {
			this.fallaInicio.setVisible(true);
		}
		if(LineasRepo.pertenece(nuevo.getDestino(), nuevo.getLinea())) {
			this.fallaDestino.setVisible(true);
		}
		if(nuevo.get_cantPasajeros()!=null && nuevo.get_estadoTramo()!=null && nuevo.getCosto()!=null && nuevo.getDistancia()!=null && nuevo.getDuracion()!=null 
		&& this.ordenCorrecto(nuevo) && !LineasRepo.pertenece(nuevo.getOrigen(), nuevo.getLinea()) && !LineasRepo.pertenece(nuevo.getDestino(), nuevo.getLinea())) {
			TramosRepo.GuardarTramo(nuevo);
			this.mensajeTramoCreado();
			this.deshabilitarGuardar();
		}
		
	}
	
	public JComboBox getComboBox() {
		return comboBox;
	}
	public void cambiarEstacionDestino() {
		 Estacion origen= (Estacion) comboBox.getSelectedItem();
		comboBox_1.setModel(new javax.swing.DefaultComboBoxModel<>(estaciones.stream().filter(e-> e.getId()!= origen.getId()).collect(Collectors.toList()).toArray()));
	}
	
	public Boolean ordenCorrecto(Tramo nuevo) {
	//Si es el primero de la linea no importa que estacion elige
		if(nuevo.getOrden()==1) {
			return true;
		}
		return ((Estacion)this.comboBox.getSelectedItem()).equals(LineasRepo.ultimaEstacion(nuevo.getLinea()));
	}
	
	    
}