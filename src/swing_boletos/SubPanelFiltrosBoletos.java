package swing_boletos;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import bdd.EstacionesRepo;
import modelo.Estacion;

import javax.swing.JComboBox;

public class SubPanelFiltrosBoletos extends JPanel {
	private ButtonGroup mes;
	

	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_4;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox_1;

	public SubPanelFiltrosBoletos() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		gbc_lblNewLabel_1.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("ENERO-MARZO");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 3;
		gbc_rdbtnNewRadioButton.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("ABRIL-JUNIO");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		gbc_rdbtnNewRadioButton_1.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_3 = new JRadioButton("JULIO-SEPTIEMBRE");
		rdbtnNewRadioButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 1;
		gbc_rdbtnNewRadioButton_3.gridy = 5;
		gbc_rdbtnNewRadioButton_3.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("OCTUBRE-DICIEMBRE");
		rdbtnNewRadioButton_4.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0,10, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 1;
		gbc_rdbtnNewRadioButton_4.gridy = 6;
		gbc_rdbtnNewRadioButton_4.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		mes = new ButtonGroup();
		mes.add(rdbtnNewRadioButton);
		mes.add(rdbtnNewRadioButton_1);
		mes.add(rdbtnNewRadioButton_3);
		mes.add(rdbtnNewRadioButton_4);
		
		lblNewLabel_2 = new JLabel("Estacion origen");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox = new JComboBox();
		List<Estacion> estaciones = EstacionesRepo.ObtenerEstaciones();
		comboBox.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		comboBox.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 8;
		add(comboBox, gbc_comboBox);
		
		lblNewLabel_3 = new JLabel("Estacion destino");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 9;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		comboBox_1.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 10;
		add(comboBox_1, gbc_comboBox_1);
		
		
		
	}


	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return "no seleccionado";
    }

	
	public void limpiarFiltros() {
		mes.clearSelection();
		this.comboBox.setSelectedIndex(-1);
		this.comboBox_1.setSelectedIndex(-1);
	}
	
}
