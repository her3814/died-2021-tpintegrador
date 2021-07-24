package swing_boletos;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelGestionarBoletos extends JPanel{

	private static final long serialVersionUID = -6907894395878047714L;
	
	private JLabel tituloPag;
	private JButton crear;
	private JButton buscar;
	private GridBagConstraints gbc;
	private JButton volver; 

	public  PanelGestionarBoletos() {
		
		this.gbc= new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		tituloPag= new JLabel("GESTIONAR BOLETOS");
		this.gbc.gridx=0;
		this.gbc.gridy=0;
		this.gbc.ipadx=0;
		this.gbc.ipady=20;
		this.gbc.anchor=GridBagConstraints.CENTER;
		tituloPag.setFont(new Font("Arial", Font.BOLD, 22));
		this.add(tituloPag, gbc);

		crear = new JButton("AGREGAR BOLETO");
		crear.setBackground(new Color(204,204,204));
		crear.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=1;
		this.gbc.insets= new Insets(5,0,5,0);
		crear.setPreferredSize(new Dimension(500,20));
		this.add(crear , gbc);

		buscar = new JButton("BUSCAR BOLETO");
		buscar.setBackground(new Color(204,204,102));
		buscar.setFont(new Font("Arial", Font.BOLD,18));
		this.gbc.gridx=0;
		this.gbc.gridy=3;
		this.gbc.insets= new Insets(5,0,5,0);
		buscar.setPreferredSize(new Dimension(500,20));
		this.add(buscar , gbc);
		
		volver = new JButton("VOLVER");
		volver.setFont(new Font("Arial", Font.BOLD, 15));
		volver.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		//gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
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