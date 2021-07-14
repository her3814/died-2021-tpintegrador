package swing_tareas_mantenimiento;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelVerHistorialTareaMantenimiento extends JPanel {
	private JButton btnNewButton_2; 

	/**
	 * Create the panel.
	 */
	public PanelVerHistorialTareaMantenimiento() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 33, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("VER HISTORIAL");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);
		 
		 
		 btnNewButton_2 = new JButton("CANCELAR");
		 btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		 GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		 gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		 gbc_btnNewButton_2.insets = new Insets(15, 0, 0, 5);
		 gbc_btnNewButton_2.gridx = 3;
		 gbc_btnNewButton_2.gridy = 6;
		 add(btnNewButton_2, gbc_btnNewButton_2);

	}
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}
	}


