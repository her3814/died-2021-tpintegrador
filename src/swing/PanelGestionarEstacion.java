package swing;

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

public class PanelGestionarEstacion extends JPanel{

	private JLabel tituloPag;
	private JButton crear;
	private JButton buscar;
	
	private GridBagConstraints gbc;
	
	
	public  PanelGestionarEstacion() {
		
	
		this.gbc= new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		tituloPag= new JLabel("GESTIONAR ESTACION");
		this.gbc.gridx=0;
		this.gbc.gridy=0;
		this.gbc.ipadx=0;
		this.gbc.ipady=20;
		this.gbc.anchor=GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbc);
		
		
		
		crear= new JButton("CREAR ESTACION");
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
		
	}

	public JButton getCrear() {
		return crear;
	}


	public JButton getBuscar() {
		return buscar;
	}

	
}