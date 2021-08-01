package swing_tramos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelGestionarTramos extends JPanel {

	private static final long serialVersionUID = -27517210545030157L;

	private JLabel tituloPag;
	private JButton crear;
	private JButton buscar;

	private GridBagConstraints gbc;
	private JButton volver;

	public PanelGestionarTramos() {

		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		setSize(new Dimension(500, 500));
		setMinimumSize(new Dimension(300, 300));

		tituloPag = new JLabel("GESTIONAR TRAMOS");
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		this.gbc.ipadx = 0;
		this.gbc.ipady = 20;
		this.gbc.anchor = GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbc);

		crear = new JButton("AGREGAR TRAMO");
		crear.setBackground(new Color(204, 204, 204));
		crear.setFont(new Font("Arial", Font.BOLD, 18));
		this.gbc.gridx = 0;
		this.gbc.gridy = 1;
		// new Insets(top, left, botton,right)
		this.gbc.insets = new Insets(5, 0, 5, 0);
		crear.setPreferredSize(new Dimension(500, 20));
		this.add(crear, gbc);

		buscar = new JButton("BUSCAR TRAMO");
		buscar.setBackground(new Color(204, 204, 153));
		buscar.setFont(new Font("Arial", Font.BOLD, 18));
		this.gbc.gridx = 0;
		this.gbc.gridy = 2;
		this.gbc.insets = new Insets(5, 0, 5, 0);
		buscar.setPreferredSize(new Dimension(500, 20));
		this.add(buscar, gbc);

		volver = new JButton("VOLVER");
		volver.setFont(new Font("Arial", Font.BOLD, 15));
		volver.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(25, 405, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 12;
		add(volver, gbc_btnNewButton_1);

	}

	public JButton getCrear() {
		return crear;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public JButton getVolver() {
		return volver;
	}

}