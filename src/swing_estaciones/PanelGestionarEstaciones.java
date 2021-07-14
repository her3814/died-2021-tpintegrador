package swing_estaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelGestionarEstaciones extends JPanel{

	private JLabel tituloPag;
	private JButton crear;
	private JButton buscar;
	private JButton volver;

	private GridBagConstraints gbc;
	
	public  PanelGestionarEstaciones() {
	
		this.gbc= new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		tituloPag= new JLabel("GESTIONAR ESTACIONES");
		this.gbc.gridx=0;
		this.gbc.gridy=0;
		this.gbc.ipadx=0;
		this.gbc.ipady=20;
		this.gbc.anchor=GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbc);

		crear= new JButton("AGREGAR ESTACION");
		crear.setBackground(Color.WHITE);
		crear.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=1;
		//new Insets(top, left, botton,right)
		this.gbc.insets= new Insets(5,0,5,0);
		crear.setPreferredSize(new Dimension(300,20));
		this.add(crear, gbc);
		

		buscar= new JButton("BUSCAR ESTACIONES");
		buscar.setBackground(Color.WHITE);
		buscar.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=2;
		this.gbc.insets= new Insets(5,0,5,0); // espaciado
		buscar.setPreferredSize(new Dimension(300,20));
		this.add(buscar, gbc);
		
		volver = new JButton("VOLVER");
		volver.setFont(new Font("Arial", Font.BOLD, 15));
		volver.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(25, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
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