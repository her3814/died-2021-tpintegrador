package swing_lineas;


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

public class PanelGestionarLineas extends JPanel{

	private JLabel tituloPag;
	private JButton agregar;
	private JButton buscar;
	private JButton volver;
	
	private GridBagConstraints gbcTitulo;
	private GridBagConstraints gbcAgregar;
	private GridBagConstraints gbcBuscar;
	
	
	public JButton getVolver() {
		return volver;
	}

	public  PanelGestionarLineas() {
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.LIGHT_GRAY);
		
		
		gbcTitulo= new GridBagConstraints();
		tituloPag= new JLabel("GESTIONAR LINEAS");
		this.gbcTitulo.gridx=0;
		this.gbcTitulo.gridy=0;
		this.gbcTitulo.ipadx=0;
		this.gbcTitulo.ipady=20;
		this.gbcTitulo.anchor=GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbcTitulo);
		
		
		gbcAgregar= new GridBagConstraints();
		agregar= new JButton("AGREGAR LINEA");
		agregar.setBackground(Color.WHITE);
		agregar.setFont(new Font("Arial", Font.BOLD,18));
		this.gbcAgregar.gridx=0;
		this.gbcAgregar.gridy=1;
		this.gbcAgregar.ipadx=0;
		this.gbcAgregar.ipady=20;
		this.gbcAgregar.anchor=GridBagConstraints.CENTER;
		//new Insets(top, left, botton,right)
		this.gbcAgregar.insets= new Insets(5,0,5,0);
		agregar.setPreferredSize(new Dimension(300,20));
		this.add(agregar, gbcAgregar);
		
		gbcBuscar= new GridBagConstraints();
		buscar= new JButton("BUSCAR LINEA");
		buscar.setBackground(Color.WHITE);
		buscar.setFont(new Font("Arial", Font.BOLD,18));
		this.gbcBuscar.gridx=0;
		this.gbcBuscar.gridy=2;
		this.gbcBuscar.ipadx=0;
		this.gbcBuscar.ipady=20;
		this.gbcBuscar.anchor=GridBagConstraints.CENTER;
		this.gbcBuscar.insets= new Insets(5,0,5,0); // espaciado
		buscar.setPreferredSize(new Dimension(300,20));
		this.add(buscar, gbcBuscar);
		
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

	public JButton getAgregar() {
		return agregar;
	}


	public JButton getBuscar() {
		return buscar;
	}

	
}
