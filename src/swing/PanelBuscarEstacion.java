package swing;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBuscarEstacion extends JPanel {
	private JTextField textField;
	private JTextField txtNoTendriaQ;
	private JButton btnNewButton_2; 
	public PanelBuscarEstacion() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, -16, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("BUSCAR ESTACI\u00D3N");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(5, 5, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(5, 5, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
		
		JButton btnNewButton = new JButton("BUSCAR");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		gbc_btnNewButton.gridwidth=4;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GUARDAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		 btnNewButton_2 = new JButton("CANCELAR");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 4;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		txtNoTendriaQ = new JTextField();
		txtNoTendriaQ.setText(" NO TENDRIA Q SER VOLVER EL BOTON??");
		GridBagConstraints gbc_txtNoTendriaQ = new GridBagConstraints();
		gbc_txtNoTendriaQ.insets = new Insets(0, 0, 0, 5);
		gbc_txtNoTendriaQ.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNoTendriaQ.gridx = 2;
		gbc_txtNoTendriaQ.gridy = 6;
		add(txtNoTendriaQ, gbc_txtNoTendriaQ);
		txtNoTendriaQ.setColumns(10);
	}
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

}
