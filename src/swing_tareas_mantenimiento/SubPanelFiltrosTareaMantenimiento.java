package swing_tareas_mantenimiento;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import bdd.EstacionesRepo;
import modelo.Estacion;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SubPanelFiltrosTareaMantenimiento extends JPanel{
	
	private ButtonGroup mesInicio;
	private ButtonGroup mesFin;
	private String nombreEstacion;
	
	public ButtonGroup getMesFin() {
		return mesFin;
	}

	public void setMesFin(ButtonGroup mesFin) {
		this.mesFin = mesFin;
	}

	public ButtonGroup getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(ButtonGroup mes) {
		this.mesInicio = mes;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	private JComboBox comboBox;
	
	public SubPanelFiltrosTareaMantenimiento() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Fecha inicio:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		gbc_lblNewLabel_1.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ENERO-MARZO");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 3;
		gbc_rdbtnNewRadioButton.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ABRIL-JUNIO");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 4;
		gbc_rdbtnNewRadioButton_1.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("JULIO-SEPTIEMBRE");
		rdbtnNewRadioButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 1;
		gbc_rdbtnNewRadioButton_3.gridy = 5;
		gbc_rdbtnNewRadioButton_3.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("OCTUBRE-DICIEMBRE");
		rdbtnNewRadioButton_4.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0,10, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 1;
		gbc_rdbtnNewRadioButton_4.gridy = 6;
		gbc_rdbtnNewRadioButton_4.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		mesInicio = new ButtonGroup();
		mesInicio.add(rdbtnNewRadioButton);
		mesInicio.add(rdbtnNewRadioButton_1);
		mesInicio.add(rdbtnNewRadioButton_3);
		mesInicio.add(rdbtnNewRadioButton_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha fin:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 7;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("ENERO-MARZO");
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 1;
		gbc_rdbtnNewRadioButton_2.gridy = 8;
		add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("ABRIL-JUNIO");
		rdbtnNewRadioButton_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_1_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1_1.gridy = 9;
		add(rdbtnNewRadioButton_1_1, gbc_rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_3_1 = new JRadioButton("JULIO-SEPTIEMBRE");
		rdbtnNewRadioButton_3_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_3_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3_1.gridx = 1;
		gbc_rdbtnNewRadioButton_3_1.gridy = 10;
		add(rdbtnNewRadioButton_3_1, gbc_rdbtnNewRadioButton_3_1);
		
		JRadioButton rdbtnNewRadioButton_4_1 = new JRadioButton("OCTUBRE-DICIEMBRE");
		rdbtnNewRadioButton_4_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_4_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_4_1.gridx = 1;
		gbc_rdbtnNewRadioButton_4_1.gridy = 11;
		add(rdbtnNewRadioButton_4_1, gbc_rdbtnNewRadioButton_4_1);
		
		mesFin = new ButtonGroup();
		mesFin.add(rdbtnNewRadioButton_2);
		mesFin.add(rdbtnNewRadioButton_1_1);
		mesFin.add(rdbtnNewRadioButton_3_1);
		mesFin.add(rdbtnNewRadioButton_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estacion");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 13;
		gbc_lblNewLabel_2.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		List<Estacion> estaciones = EstacionesRepo.ObtenerEstaciones();
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		comboBox.setSelectedIndex(-1);
		comboBox.setFont(new Font("Arial", Font.BOLD, 11));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 14;
		add(comboBox, gbc_comboBox);
		
		
	}

	public void limpiarFiltros() {
		comboBox.setSelectedIndex(-1);
		mesInicio.clearSelection();	
		mesFin.clearSelection();
	}
	
	public String getNombreEstacion() {
		if(comboBox.getSelectedIndex() == (-1)) {
			return "no seleccionado";
		}
		else return comboBox.getSelectedItem().toString();
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
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
