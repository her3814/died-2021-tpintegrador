package swing_tareas_mantenimiento;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import com.toedter.calendar.JDateChooser;

import bdd.EstacionesRepo;
import modelo.Estacion;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;


public class PanelAgregarTareaMantenimiento extends JPanel {
	private JButton btnNewButton_1; 

	public PanelAgregarTareaMantenimiento() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 74, 106, 158, 157, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 0, 19, 0, 0, 19, 19, 19, 21, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(600,600));
		
		JLabel lblNewLabel = new JLabel("AGREGAR TAREA DE MANTENIMIENTO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=5;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ESTACION:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		List<Estacion> estaciones = EstacionesRepo.ObtenerEstaciones();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		
		comboBox.setModel(new DefaultComboBoxModel(		
				 estaciones.stream().map(e -> e.getNombre())
				.collect(Collectors.toList())
				.toArray()));
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("FECHA INICIO:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(new Color(204, 204, 153));
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 3;
		add(dateChooser, gbc_dateChooser);
		
		JLabel lblNewLabel_3 = new JLabel("FECHA FIN:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBackground(new Color(204, 204, 102));
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.gridwidth = 3;
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser_1.gridx = 2;
		gbc_dateChooser_1.gridy = 4;
		add(dateChooser_1, gbc_dateChooser_1);
				
		JLabel lblNewLabel_4 = new JLabel("OBSERVACIONES:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(8);
		textArea.setBackground(new Color(204, 204, 255));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 3;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 5;
		add(textArea, gbc_textArea);
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(25, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(25, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 7;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
	}
	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

}
