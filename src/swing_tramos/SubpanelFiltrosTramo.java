package swing_tramos;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bdd.EstacionesRepo;
import bdd.LineasRepo;
import modelo.Estacion;
import modelo.Linea;


public class SubpanelFiltrosTramo extends JPanel {
	
	private JComboBox estacionOrigen;
	private JComboBox estacionDestino;
	private JComboBox linea;
	public SubpanelFiltrosTramo() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{75, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		

		JLabel lblNewLabel = new JLabel("FILTROS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.BASELINE;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.anchor=GridBagConstraints.WEST;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estacion origen:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		gbc_lblNewLabel_1.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		List<Estacion> estaciones = EstacionesRepo.ObtenerEstaciones();
		
		estacionOrigen = new JComboBox();
		estacionOrigen.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		estacionOrigen.setSelectedIndex(-1);
		estacionOrigen.setFont(new Font("Arial", Font.BOLD, 11));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		add(estacionOrigen, gbc_comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Estacion destino:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		gbc_lblNewLabel_2.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		estacionDestino = new JComboBox();
		estacionDestino.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		estacionDestino.setSelectedIndex(-1);
		estacionDestino.setFont(new Font("Arial", Font.BOLD, 11));
		GridBagConstraints gbc_destino = new GridBagConstraints();
		gbc_destino.insets = new Insets(0, 0, 5, 5);
		gbc_destino.fill = GridBagConstraints.HORIZONTAL;
		gbc_destino.gridx = 1;
		gbc_destino.gridy = 5;
		add(estacionDestino, gbc_destino);
		
		JLabel lblNewLabel_3 = new JLabel("Linea:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		gbc_lblNewLabel_3.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		List<Linea> lineas = LineasRepo.ObtenerLineas();
		linea = new JComboBox();
		linea.setModel(new DefaultComboBoxModel(		
				 lineas.stream().map(l -> l.get_nombre())
				.collect(Collectors.toList())
				.toArray()));
		linea.setSelectedIndex(-1);
		linea.setFont(new Font("Arial", Font.BOLD, 11));
		GridBagConstraints gbc_linea = new GridBagConstraints();
		gbc_linea.insets = new Insets(0, 0, 5, 5);
		gbc_linea.fill = GridBagConstraints.HORIZONTAL;
		gbc_linea.gridx = 1;
		gbc_linea.gridy = 7;
		add(linea, gbc_linea);
		
}
	public Estacion getEstacionOrigen() {
		return (Estacion)estacionOrigen.getSelectedItem();
	}
	public Estacion getEstacionDestino() {
		return (Estacion)estacionDestino.getSelectedItem();
	}
	public Linea getLinea() {
		return (Linea)linea.getSelectedItem();
	}
	public String getNombreOrigen() {
		if(estacionOrigen.getSelectedIndex() == (-1)) {
			return "no seleccionado";
		}
		else return estacionOrigen.getSelectedItem().toString();
	}
	
	public String getNombreDestino() {
		if(estacionDestino.getSelectedIndex() == (-1)) {
			return "no seleccionado";
		}
		else return estacionDestino.getSelectedItem().toString();
	}
	public String getNombreLinea() {
		if(estacionDestino.getSelectedIndex() == (-1)) {
			return "no seleccionado";
		}
		else return linea.getSelectedItem().toString();
	}
}