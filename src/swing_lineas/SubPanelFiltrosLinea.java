package swing_lineas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SubPanelFiltrosLinea extends JPanel{
	private ButtonGroup color;
	private ButtonGroup estado;
	
	public SubPanelFiltrosLinea() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		
		JLabel lblNewLabel_1 = new JLabel("Color:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		gbc_lblNewLabel_1.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Anaranjado");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 3;
		gbc_rdbtnNewRadioButton.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Amarillo");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		gbc_rdbtnNewRadioButton_1.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Celeste");
		rdbtnNewRadioButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 1;
		gbc_rdbtnNewRadioButton_3.gridy = 5;
		gbc_rdbtnNewRadioButton_3.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Rojo");
		rdbtnNewRadioButton_4.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0,10, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 1;
		gbc_rdbtnNewRadioButton_4.gridy = 6;
		gbc_rdbtnNewRadioButton_4.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Verde claro");
		rdbtnNewRadioButton_5.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 1;
		gbc_rdbtnNewRadioButton_5.gridy = 7;
		gbc_rdbtnNewRadioButton_5.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Verde oscuro");
		rdbtnNewRadioButton_6.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_6.gridx = 1;
		gbc_rdbtnNewRadioButton_6.gridy = 8;
		gbc_rdbtnNewRadioButton_6.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_6, gbc_rdbtnNewRadioButton_6);
		
		color = new ButtonGroup();
		color.add(rdbtnNewRadioButton);
		color.add(rdbtnNewRadioButton_1);
		color.add(rdbtnNewRadioButton_3);
		color.add(rdbtnNewRadioButton_4);
		color.add(rdbtnNewRadioButton_5);
		color.add(rdbtnNewRadioButton_6);
		
		
		JLabel lblNewLabel_2 = new JLabel("Estado");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 9;
		gbc_lblNewLabel_2.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
	
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Activa");
		rdbtnNewRadioButton_7.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_7 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_7.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_7.gridx = 1;
		gbc_rdbtnNewRadioButton_7.gridy = 10;
		gbc_rdbtnNewRadioButton_7.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_7, gbc_rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("No activa");
		rdbtnNewRadioButton_8.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_8 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_8.insets = new Insets(0,10, 5, 5);
		gbc_rdbtnNewRadioButton_8.gridx = 1;
		gbc_rdbtnNewRadioButton_8.gridy = 11;
		gbc_rdbtnNewRadioButton_8.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_8, gbc_rdbtnNewRadioButton_8);
		
		estado = new ButtonGroup();
		estado.add(rdbtnNewRadioButton_7);
		estado.add(rdbtnNewRadioButton_8);
		
		
		JButton btnNewButton = new JButton("Limpiar filtros");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 10, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 12;
		add(btnNewButton, gbc_btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color.clearSelection();
				estado.clearSelection();
				// TO-DO tendria que mostrar todos los datos de la BDD
			}
		});
	}
}
