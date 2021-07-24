package swing_lineas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import bdd.LineasRepo;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SubPanelFiltrosLineas extends JPanel{
	
	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	private JComboBox comboBox;
	private ButtonGroup estado;
	private ButtonGroup tipotransporte;
	public SubPanelFiltrosLineas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
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
		
		List<String> colores = LineasRepo.ObtenerLineas().stream().map(l -> l.get_color())
				.collect(Collectors.toList());
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(		
				colores.toArray()));
		comboBox.setSelectedIndex(-1);
		comboBox.setFont(new Font("Arial", Font.BOLD, 11));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 4;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Activa");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 5;
		gbc_rdbtnNewRadioButton.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No activa");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 6;
		gbc_rdbtnNewRadioButton_1.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		estado = new ButtonGroup();
		estado.add(rdbtnNewRadioButton);
		estado.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de transporte:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		gbc_lblNewLabel_2.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton2 = new JRadioButton("Subte");
		rdbtnNewRadioButton2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton2.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton2.gridx = 1;
		gbc_rdbtnNewRadioButton2.gridy = 8;
		gbc_rdbtnNewRadioButton2.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton2, gbc_rdbtnNewRadioButton2);
		
		JRadioButton rdbtnNewRadioButton3 = new JRadioButton("Colectivo");
		rdbtnNewRadioButton3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton3.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton3.gridx = 1;
		gbc_rdbtnNewRadioButton3.gridy = 9;
		gbc_rdbtnNewRadioButton3.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton3, gbc_rdbtnNewRadioButton3);
		
		JRadioButton rdbtnNewRadioButton4 = new JRadioButton("Tren");
		rdbtnNewRadioButton4.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton4.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton4.gridx = 1;
		gbc_rdbtnNewRadioButton4.gridy = 10;
		gbc_rdbtnNewRadioButton4.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton4, gbc_rdbtnNewRadioButton4);
		
		tipotransporte = new ButtonGroup();
		tipotransporte.add(rdbtnNewRadioButton2);
		tipotransporte.add(rdbtnNewRadioButton3);
		tipotransporte.add(rdbtnNewRadioButton4);
	
	}

	public void limpiarFiltros() {
		comboBox.setSelectedIndex(-1);
		estado.clearSelection();	
		tipotransporte.clearSelection();
	}
	
	public ButtonGroup getEstado() {
		return estado;
	}

	public void setEstado(ButtonGroup estado) {
		this.estado = estado;
	}

	public ButtonGroup getTipotransporte() {
		return tipotransporte;
	}

	public void setTipotransporte(ButtonGroup tipotransporte) {
		this.tipotransporte = tipotransporte;
	}

	public String getColorLinea() {
		if(comboBox.getSelectedIndex() == (-1)) {
			return "no seleccionado";
		}
		else return comboBox.getSelectedItem().toString();
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

}
