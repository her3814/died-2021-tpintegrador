package swing_menu_principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenuPrincipal extends JPanel {

	private static final long serialVersionUID = -2737296536348984651L;

	private JLabel tituloPag;
	private JButton tareas_mantenimiento;
	private JButton lineas;
	private JButton tramos;
	private JButton boletos;
	private JButton estaciones;
	private GridBagConstraints gbc;

	public PanelMenuPrincipal() {

		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);

		tituloPag = new JLabel("MENU PRINCIPAL");
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		this.gbc.ipadx = 0;
		this.gbc.ipady = 20;
		this.gbc.anchor = GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbc);

		estaciones = new JButton("GESTIONAR ESTACIONES");
		estaciones.setBackground(new Color(204, 204, 204));
		estaciones.setFont(new Font("Arial", Font.BOLD, 18));
		this.gbc.gridx = 0;
		this.gbc.gridy = 1;
		this.gbc.insets = new Insets(5, 0, 5, 0);
		estaciones.setPreferredSize(new Dimension(500, 20));
		this.add(estaciones, gbc);

		tareas_mantenimiento = new JButton("GESTIONAR TAREAS DE MANTENIMIENTO");
		tareas_mantenimiento.setBackground(new Color(204, 204, 153));
		tareas_mantenimiento.setFont(new Font("Arial", Font.BOLD, 18));
		this.gbc.gridx = 0;
		this.gbc.gridy = 2;
		this.gbc.insets = new Insets(5, 0, 5, 0);
		tareas_mantenimiento.setPreferredSize(new Dimension(500, 20));
		this.add(tareas_mantenimiento, gbc);

		lineas = new JButton("GESTIONAR LINEAS");
		lineas.setBackground(new Color(204, 204, 102));
		lineas.setFont(new Font("Arial", Font.BOLD, 18));
		this.gbc.gridx = 0;
		this.gbc.gridy = 3;
		this.gbc.insets = new Insets(5, 0, 5, 0);
		lineas.setPreferredSize(new Dimension(500, 20));
		this.add(lineas, gbc);

		tramos = new JButton("GESTIONAR TRAMOS");
		tramos.setBackground(new Color(204, 204, 0));
		tramos.setFont(new Font("Arial", Font.BOLD, 18));
		this.gbc.gridx = 0;
		this.gbc.gridy = 4;
		this.gbc.insets = new Insets(5, 0, 5, 0);
		tramos.setPreferredSize(new Dimension(500, 20));
		this.add(tramos, gbc);

		boletos = new JButton("GESTIONAR BOLETOS");
		boletos.setBackground(new Color(204, 204, 51));
		boletos.setFont(new Font("Arial", Font.BOLD, 18));
		this.gbc.gridx = 0;
		this.gbc.gridy = 5;
		this.gbc.insets = new Insets(5, 0, 5, 0);
		boletos.setPreferredSize(new Dimension(500, 20));
		this.add(boletos, gbc);
	}

	public JButton getBoletos() {
		return boletos;
	}

	public JButton getTareas_mantenimiento() {
		return tareas_mantenimiento;
	}

	public JButton getEstaciones() {
		return estaciones;
	}

	public JButton getLineas() {
		return lineas;
	}

	public JButton getTramos() {
		return tramos;
	}

}