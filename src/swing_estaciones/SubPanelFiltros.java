package swing_estaciones;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import modelo.EstadoEstacionEnum;

public class SubPanelFiltros extends JPanel {
	private ButtonGroup horaApertura;
	private ButtonGroup horaCierre;
	private ButtonGroup estado;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_4;

	public SubPanelFiltros() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("FILTROS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.BASELINE;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.anchor=GridBagConstraints.WEST;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Horario apertura:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		gbc_lblNewLabel_1.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("00:01 a 06:00");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 2;
		gbc_rdbtnNewRadioButton.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("06:01 a 12:00");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 3;
		gbc_rdbtnNewRadioButton_1.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_3 = new JRadioButton("12:01 a 18:00");
		rdbtnNewRadioButton_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 1;
		gbc_rdbtnNewRadioButton_3.gridy = 4;
		gbc_rdbtnNewRadioButton_3.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("18:01 a 00:00");
		rdbtnNewRadioButton_4.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0,10, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 1;
		gbc_rdbtnNewRadioButton_4.gridy = 5;
		gbc_rdbtnNewRadioButton_4.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		horaApertura = new ButtonGroup();
		horaApertura.add(rdbtnNewRadioButton);
		horaApertura.add(rdbtnNewRadioButton_1);
		horaApertura.add(rdbtnNewRadioButton_3);
		horaApertura.add(rdbtnNewRadioButton_4);
		
		
		JLabel lblNewLabel_2 = new JLabel("Horario cierre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		gbc_lblNewLabel_2.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("00:01 a 06:00");
		rdbtnNewRadioButton_5.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 1;
		gbc_rdbtnNewRadioButton_5.gridy = 7;
		gbc_rdbtnNewRadioButton_5.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("06:01 a 12:00");
		rdbtnNewRadioButton_6.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_6.gridx = 1;
		gbc_rdbtnNewRadioButton_6.gridy = 8;
		gbc_rdbtnNewRadioButton_6.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_6, gbc_rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("12:01 a 18:00");
		rdbtnNewRadioButton_7.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_7 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_7.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_7.gridx = 1;
		gbc_rdbtnNewRadioButton_7.gridy = 9;
		gbc_rdbtnNewRadioButton_7.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_7, gbc_rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("18:01 a 00:00");
		rdbtnNewRadioButton_8.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_8 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_8.insets = new Insets(0,10, 5, 5);
		gbc_rdbtnNewRadioButton_8.gridx = 1;
		gbc_rdbtnNewRadioButton_8.gridy = 10;
		gbc_rdbtnNewRadioButton_8.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_8, gbc_rdbtnNewRadioButton_8);
		
		horaCierre = new ButtonGroup();
		horaCierre.add(rdbtnNewRadioButton_5);
		horaCierre.add(rdbtnNewRadioButton_6);
		horaCierre.add(rdbtnNewRadioButton_7);
		horaCierre.add(rdbtnNewRadioButton_8);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0,10, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 11;
		gbc_lblNewLabel_3.anchor=GridBagConstraints.WEST;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Operativa");
		rdbtnNewRadioButton_9.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_9 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_9.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_9.gridx = 1;
		gbc_rdbtnNewRadioButton_9.gridy = 12;
		gbc_rdbtnNewRadioButton_9.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_9, gbc_rdbtnNewRadioButton_9);
		
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("En mantenimiento");
		rdbtnNewRadioButton_10.setFont(new Font("Arial", Font.BOLD, 10));
		GridBagConstraints gbc_rdbtnNewRadioButton_10 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_10.insets = new Insets(0, 10, 5, 5);
		gbc_rdbtnNewRadioButton_10.gridx = 1;
		gbc_rdbtnNewRadioButton_10.gridy = 13;
		gbc_rdbtnNewRadioButton_10.anchor=GridBagConstraints.WEST;
		add(rdbtnNewRadioButton_10, gbc_rdbtnNewRadioButton_10);

		estado= new ButtonGroup();
		estado.add(rdbtnNewRadioButton_9); 
		estado.add(rdbtnNewRadioButton_10);
		
	
		JButton btnNewButton = new JButton("Limpiar filtros");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 10, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 15;
		add(btnNewButton, gbc_btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				horaApertura.clearSelection();
				horaCierre.clearSelection();
				estado.clearSelection();
			}
		});
		
	}

	public String getHoraApertura() {
		return getSelectedButtonText(horaApertura);
	}
	public String getHoraCierre() {
		return getSelectedButtonText(horaCierre);
	}
	public String getEstado() {
		return getSelectedButtonText(estado);
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


	public void setHoraApertura(ButtonGroup horaApertura) {
		this.horaApertura = horaApertura;
	}

	public void setHoraCierre(ButtonGroup horaCierre) {
		this.horaCierre = horaCierre;
	}

	public void setEstado(ButtonGroup estado) {
		this.estado = estado;
	}
	
	
}
