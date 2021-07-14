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

public class PanelGestionarTareaMantenimiento extends JPanel{

	private JLabel tituloPag;
	private JButton crear;
	private JButton buscar;
	private JButton historial;

	private GridBagConstraints gbc;
	
	
	public  PanelGestionarTareaMantenimiento() {
		
	
		this.gbc= new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		tituloPag= new JLabel("GESTIONAR TAREA DE MANTENIMIENTO");
		this.gbc.gridx=0;
		this.gbc.gridy=0;
		this.gbc.ipadx=0;
		this.gbc.ipady=20;
		this.gbc.anchor=GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbc);
		

		crear= new JButton("CREAR TAREA DE MANTENIMIENTO");
		crear.setBackground(Color.WHITE);
		crear.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=1;
		//new Insets(top, left, botton,right)
		this.gbc.insets= new Insets(5,0,5,0);
		crear.setPreferredSize(new Dimension(400,20));
		this.add(crear, gbc);

		buscar= new JButton("BUSCAR TAREA DE MANTENIMIENTO");
		buscar.setBackground(Color.WHITE);
		buscar.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=2;
		this.gbc.insets= new Insets(5,0,5,0); 
		buscar.setPreferredSize(new Dimension(400,20));
		this.add(buscar, gbc);

		historial= new JButton("VER HISTORIAL");
		historial.setBackground(Color.WHITE);
		historial.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=3;
		this.gbc.insets= new Insets(5,0,5,0); 
		historial.setPreferredSize(new Dimension(400,20));
		this.add(historial, gbc);
	}

	public JButton getCrear() {
		return crear;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public JButton getHistorial() {
		return historial;
	}
	
}