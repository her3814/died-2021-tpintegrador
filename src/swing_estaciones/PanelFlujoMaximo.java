package swing_estaciones;

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
import javax.swing.SwingConstants;
import modelo.Estacion;
import bdd.EstacionesRepo;
import bdd.TramosRepo;
import grafo1.Graph;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;

public class PanelFlujoMaximo extends JPanel {

	private JTextField textField_1;
	private JButton buscar;
	private JButton cancelar;
	private  JComboBox comboBox_estOrigen;
	private List<Estacion> estaciones;
	private  JComboBox comboBox_estDestino;
	private  JLabel lblNewLabel_3;
	private  Graph<Estacion> grafo;
	
	public PanelFlujoMaximo() {
		
		setBackground(Color.WHITE);
		estaciones = new ArrayList<Estacion> ();
		estaciones= EstacionesRepo.ObtenerEstaciones();
		
		grafo = new Graph<Estacion>();
		grafo.setVertexs(estaciones);
		grafo.setEdges(TramosRepo.obtenerTramos());	
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 90, 141, 211, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 21, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("FLUJO MÁXIMO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=4;
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
		
		comboBox_estOrigen = new JComboBox(estaciones.toArray());
		comboBox_estOrigen.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox_estOrigen, gbc_comboBox);
	
		JLabel lblNewLabel_2 = new JLabel("ESTACION DESTINO:");
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox_estDestino = new JComboBox(estaciones.toArray());
		comboBox_estDestino.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_comboBox1 = new GridBagConstraints();
		gbc_comboBox1.gridwidth = 2;
		gbc_comboBox1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox1.gridx = 2;
		gbc_comboBox1.gridy = 3;
		add(comboBox_estDestino, gbc_comboBox1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.CENTER;
		gbc_lblNewLabel_3.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		gbc_lblNewLabel_3.gridwidth = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		cancelar = new JButton("VOLVER");
		cancelar.setBackground(new Color(204, 204, 51));
		cancelar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 10;
		add(cancelar, gbc_btnNewButton_1);
		
		buscar = new JButton("CALCULAR");
	
		buscar.setBackground(new Color(204, 204, 51));
		buscar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(buscar, gbc_btnNewButton);
				
		
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JButton getBuscar() {
		return buscar;
	}
	public JButton getCancelar() {
		return cancelar;
	}
	
	public void calcularFM() {
		Estacion origen = (Estacion)this.comboBox_estOrigen.getSelectedItem();
		Estacion destino = (Estacion)this.comboBox_estDestino.getSelectedItem();

		lblNewLabel_3.setText("El flujo máximo entre la estacion "+ origen.getNombre() +" y "
				+ destino.getNombre()+" es de: "+grafo.flujoMaximo1(origen, destino)+".");
		lblNewLabel_3.setVisible(true);
	}
	public void deshabilitar() {
		this.comboBox_estDestino.setEnabled(false);
		this.comboBox_estOrigen.setEnabled(false);
		this.buscar.setEnabled(false);
	}
	
	public void habilitar() {
		comboBox_estOrigen.setEnabled(true);
		comboBox_estDestino.setEnabled(true);
		buscar.setEnabled(true);
		
	}


}
