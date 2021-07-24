package swing_estaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformacionEstaciones extends JPanel{
	
	private static final long serialVersionUID = -8660085662214980618L;
	
	private JLabel tituloPag;
	private JButton mantenimiento;
	private JButton pagerank;
	private JButton flujomax;
	private JButton volver;

	private GridBagConstraints gbc;
	
	public  PanelInformacionEstaciones() {
	
		
		this.gbc= new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		
		tituloPag= new JLabel("INFORMACION DE ESTACIONES");
		this.gbc.gridx=0;
		this.gbc.gridy=0;
		this.gbc.ipadx=0;
		this.gbc.ipady=20;
		this.gbc.anchor=GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbc);

		pagerank= new JButton("PAGE RANK");
		pagerank.setBackground(new Color(204,204,204));
		pagerank.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=1;
		//new Insets(top, left, botton,right)
		this.gbc.insets= new Insets(5,0,5,0);
		pagerank.setPreferredSize(new Dimension(500,20));
		this.add(pagerank, gbc);
		

		flujomax= new JButton("FLUJO MAXIMO");
		flujomax.setBackground(new Color(204,204,153));
		flujomax.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=2;
		this.gbc.insets= new Insets(5,0,5,0); // espaciado
		flujomax.setPreferredSize(new Dimension(500,20));
		this.add(flujomax, gbc);
		
		mantenimiento = new JButton("PROXIMO MANTENIMIENTO");
		mantenimiento.setBackground(new Color(204,204,102));
		mantenimiento.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=3;
		this.gbc.insets= new Insets(5,0,5,0); // espaciado
		mantenimiento.setPreferredSize(new Dimension(500,20));
		this.add(mantenimiento, gbc);
		
		
		volver = new JButton("VOLVER");
		volver.setFont(new Font("Arial", Font.BOLD, 15));
		volver.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(25, 405, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 12;
		add(volver, gbc_btnNewButton_1);
		
	}

	public JButton getMantenimiento() {
		return mantenimiento;
	}

	public JButton getPageRank() {
		return pagerank;
	}
	public JButton getVolver() {
		return volver;
	}
	public JButton getFlujoMaximo() {
		return flujomax;
	}
	
	
}