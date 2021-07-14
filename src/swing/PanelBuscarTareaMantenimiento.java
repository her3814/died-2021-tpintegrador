package swing;


import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelBuscarTareaMantenimiento extends JPanel {
	private JButton btnNewButton_2; 
	public PanelBuscarTareaMantenimiento() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 127, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 33, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("BUSCAR TAREA DE MANTENIMIENTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=5;
		add(lblNewLabel, gbc_lblNewLabel);
		 
		 JButton btnNewButton_1 = new JButton("GUARDAR");
		 btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 
		 JLabel lblNewLabel_1 = new JLabel("CAMPO DE BUSQUEDA:");
		 lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		 GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		 gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		 gbc_lblNewLabel_1.gridx = 1;
		 gbc_lblNewLabel_1.gridy = 1;
		 add(lblNewLabel_1, gbc_lblNewLabel_1);
		 
		 JComboBox comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "FECHA INICIO", "FECHA FIN"}));
		 comboBox.setFont(new Font("Arial", Font.BOLD, 16));
		 GridBagConstraints gbc_comboBox = new GridBagConstraints();
		 gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		 gbc_comboBox.gridwidth = 5;
		 gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		 gbc_comboBox.gridx = 2;
		 gbc_comboBox.gridy = 1;
		 add(comboBox, gbc_comboBox);
		 
 		 JButton btnNewButton = new JButton("BUSCAR");
 		 btnNewButton.setBackground(new Color(204, 204, 51));
 		 btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
 		 GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
 		 gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
 		 gbc_btnNewButton.insets = new Insets(15, 5, 15, 5);
 		 gbc_btnNewButton.gridx = 5;
 		 gbc_btnNewButton.gridy = 6;
 		 add(btnNewButton, gbc_btnNewButton);
		 
		 btnNewButton_2 = new JButton("CANCELAR");
		 btnNewButton_2.setBackground(new Color(204, 204, 51));
		 btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		 GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		 gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		 gbc_btnNewButton_2.insets = new Insets(15, 0, 15, 5);
		 gbc_btnNewButton_2.gridx = 6;
		 gbc_btnNewButton_2.gridy = 6;
		 add(btnNewButton_2, gbc_btnNewButton_2);

	}
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

}
