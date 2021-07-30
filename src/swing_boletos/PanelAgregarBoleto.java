package swing_boletos;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import bdd.BoletosRepo;
import bdd.EstacionesRepo;
import bdd.LineasRepo;
import bdd.TramosRepo;
import modelo.Boleto;
import modelo.Estacion;
import modelo.Linea;
import modelo.Tramo;
import servicios.VenderBoletoServicio;
import swing_frame_grafo.TramoMostrarEnum;
import swing_frame_grafo.grafo;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class PanelAgregarBoleto extends JPanel {

	private static final long serialVersionUID = 5456988688369991566L;

	private JTextField textField_1;
	private JButton guardar;
	private JButton cancelar;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox_Origen;
	private JComboBox comboBox_Destino;
	private JLabel lblNewLabel_5;
	private JComboBox comboBox_tipoCalculo;
	private JLabel inserteCliente;
	private JLabel inserteEmail;
	private List<Estacion> estaciones;
	private JLabel boletoAgregado;
	private JLabel noExisteRecorrido;
	private JPanel panel;
	private List<Tramo> recorrido = null;

	public PanelAgregarBoleto() {

		GridBagLayout gridBagLayout = new GridBagLayout();

		gridBagLayout.columnWidths = new int[] { 54, 90, 141, 211, 67, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 26, 19, 0, 19, 0, 19, 19, 21, 0, 0, 0, 155, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(1000, 1000));
		setMinimumSize(new Dimension(300, 300));
		setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("AGREGAR BOLETO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth = 4;
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
		gbc_i_cli.gridwidth = 3;
		gbc_i_cli.anchor = GridBagConstraints.WEST;
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
		gbc_i_email.gridwidth = 3;
		gbc_i_email.anchor = GridBagConstraints.WEST;
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

		estaciones = EstacionesRepo.ObtenerEstaciones();

		comboBox_Origen = new JComboBox(estaciones.toArray());
		comboBox_Origen.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 6;
		add(comboBox_Origen, gbc_comboBox);

		comboBox_Origen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_tipoCalculo.setSelectedIndex(-1);
				cambiarEstacionDestino();
			}
		});

		lblNewLabel_4 = new JLabel("ESTACION DESTINO:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		comboBox_Destino = new JComboBox();
		// comboBox_Destino.setModel(null);
		comboBox_Destino.setEnabled(false);

		comboBox_Destino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				comboBox_tipoCalculo.setSelectedIndex(-1);
				comboBox_tipoCalculo.setEnabled(true);
			}
		});

		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 7;
		add(comboBox_Destino, gbc_comboBox_1);

		lblNewLabel_5 = new JLabel("MEJOR CAMINO:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		comboBox_tipoCalculo = new JComboBox();
		comboBox_tipoCalculo.setEnabled(false);
		comboBox_tipoCalculo.setFont(new Font("Arial", Font.BOLD, 13));
		comboBox_tipoCalculo
				.setModel(new DefaultComboBoxModel(new String[] { "MÁS BARATO", "MENOR DISTANCIA", "MÁS RÁPIDO" }));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 8;
		add(comboBox_tipoCalculo, gbc_comboBox_2);

		noExisteRecorrido = new JLabel("No existe un recorrido para las estaciones seleccionadas.");
		noExisteRecorrido.setForeground(Color.RED);
		noExisteRecorrido.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		noExisteRecorrido.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_i_recorrido = new GridBagConstraints();
		gbc_i_recorrido.anchor = GridBagConstraints.EAST;
		gbc_i_recorrido.insets = new Insets(0, 0, 5, 5);
		gbc_i_recorrido.gridx = 1;
		gbc_i_recorrido.gridy = 9;
		gbc_i_recorrido.gridwidth = 3;
		gbc_i_recorrido.anchor = GridBagConstraints.WEST;
		add(noExisteRecorrido, gbc_i_recorrido);
		noExisteRecorrido.setVisible(false);

		boletoAgregado = new JLabel("EL BOLETO SE HA AGREGADO CORRECTAMENTE");
		boletoAgregado.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbcBoletoAgregado = new GridBagConstraints();
		gbcBoletoAgregado.insets = new Insets(0, 0, 5, 5);
		gbcBoletoAgregado.gridx = 1;
		gbcBoletoAgregado.gridy = 9;
		gbcBoletoAgregado.gridwidth = 3;
		add(boletoAgregado, gbcBoletoAgregado);
		boletoAgregado.setVisible(false);

		guardar = new JButton("GUARDAR");
		guardar.setBackground(new Color(204, 204, 51));
		guardar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(10, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(guardar, gbc_btnNewButton);
		guardar.setEnabled(false);

		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarWarnings();
				agregarBoleto();
			}
		});

		cancelar = new JButton("CANCELAR");
		cancelar.setBackground(new Color(204, 204, 51));
		cancelar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(10, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 10;
		add(cancelar, gbc_btnNewButton_1);

		panel = new JPanel();
		comboBox_tipoCalculo.setSelectedIndex(-1);

		this.comboBox_tipoCalculo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Estacion origen = obtenerEstacionOrigen();
				Estacion destino = obtenerEstacionDestino();

				TramoMostrarEnum mostrar;
				if (comboBox_tipoCalculo.getSelectedItem() == null) {
					recorrido = null;
					panel = null;
					return;
				}

				switch ((String) comboBox_tipoCalculo.getSelectedItem()) {
				case "MÁS BARATO":
					recorrido = VenderBoletoServicio.CalcularCaminoMasBarato(origen, destino);
					mostrar = TramoMostrarEnum.COSTO;
					break;
				case "MENOR DISTANCIA":
					recorrido = VenderBoletoServicio.CalcularCaminoMenorDistancia(origen, destino);
					mostrar = TramoMostrarEnum.COSTO;
					break;
				case "MÁS RÁPIDO":
					recorrido = VenderBoletoServicio.CalcularCaminoMasRapido(origen, destino);
					mostrar = TramoMostrarEnum.COSTO;
					break;
				default:
					recorrido = null;
					panel = null;
					return;
				}

				if (recorrido != null) {
					noExisteRecorrido.setVisible(false);
					panel = new swing_frame_grafo.panel(grafo.ObtenerGrafoDesdeRecorrido(recorrido), mostrar);
					guardar.setEnabled(true);
				} else {
					// TODO: Agregar
					noExisteRecorrido.setVisible(true);
					guardar.setEnabled(false);
				}

			}
		});

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 11;
		add(panel, gbc_panel);

	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void limpiarWarnings() {
		this.inserteCliente.setVisible(false);
		this.inserteEmail.setVisible(false);
		noExisteRecorrido.setVisible(false);
	}

	public void limpiarDatos() {
		this.textField_1.setText(null);
		this.textField.setText(null);
		this.comboBox_Origen.setSelectedIndex(0);
		this.comboBox_Destino.setSelectedIndex(0);
		this.comboBox_tipoCalculo.setSelectedIndex(0);
		this.boletoAgregado.setVisible(false);
	}

	public Boleto obtenerBoletoCreado() {
		
		Double costo = recorrido.stream().mapToDouble(t -> t.getCosto()).sum();
		return new Boleto(textField.getText(), textField_1.getText(), LocalDate.now(), costo,
				(Estacion) this.comboBox_Origen.getSelectedItem(), (Estacion) this.comboBox_Destino.getSelectedItem(),
				recorrido);

	}

	public void agregarBoleto() {
		Boleto nuevo = this.obtenerBoletoCreado();
		if (nuevo.get_nombreCliente().isEmpty()) {
			this.inserteCliente.setVisible(true);
		}
		if (nuevo.get_correoCliente().isEmpty()) {
			this.inserteEmail.setVisible(true);
		}
		if (nuevo.get_tramos() == null || nuevo.get_tramos().size() == 0) {
			noExisteRecorrido.setVisible(true);
		}
		if (!nuevo.get_correoCliente().isEmpty() && !nuevo.get_nombreCliente().isEmpty()
				&& !(nuevo.get_tramos() == null || nuevo.get_tramos().size() == 0)) {
			BoletosRepo.GuardarBoleto(nuevo);
			System.out.println("Cliente: " + nuevo.get_nombreCliente() + ", costo: " + nuevo.getCosto() + ", recorrido"
					+ nuevo.get_tramos());
			this.boletoAgregado.setVisible(true);
			guardar.setEnabled(false);
		}
	}

	public Estacion obtenerEstacionOrigen() {
		return (Estacion) comboBox_Origen.getSelectedItem();
	}

	public Estacion obtenerEstacionDestino() {
		return (Estacion) comboBox_Destino.getSelectedItem();
	}

	public void cambiarEstacionDestino() {
		Estacion origen = (Estacion) comboBox_Origen.getSelectedItem();
		comboBox_Destino.setModel(new javax.swing.DefaultComboBoxModel<>(
				estaciones.stream().filter(e -> e.getId() != origen.getId()).collect(Collectors.toList()).toArray()));
		comboBox_Destino.setEnabled(true);
		comboBox_Destino.setSelectedIndex(-1);
		comboBox_tipoCalculo.setSelectedIndex(-1);
		comboBox_tipoCalculo.setEnabled(false);
	}
}
