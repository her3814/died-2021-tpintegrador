package swing_estaciones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.TimePicker;

public class PanelErrorEnTodo extends JPanel {

		private JTextField textField_1;
		private ButtonGroup estado;
		private JButton btnNewButton;
		private JButton btnNewButton_1;
		private TimePicker timePicker;
		private TimePicker timePicker_1;
		private JRadioButton rdbtnNewRadioButton;
		private JRadioButton rdbtnNewRadioButton1;
		private final JLabel label = new JLabel("New label");
		private JLabel lblNewLabel_1;
		private JLabel lblNewLabel_6;
		private JLabel lblNewLabel_7;
		private JLabel lblNewLabel_8;
		public PanelErrorEnTodo() {
			setBackground(Color.WHITE);
			
			
			GridBagLayout gridBagLayout = new GridBagLayout();
			
			gridBagLayout.columnWidths = new int[]{54, 90, 141, 211, 67, 0};
			gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 21, 0, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			setSize(new Dimension(500, 502));
			setMinimumSize(new Dimension(300,300));
			
			JLabel lblNewLabel = new JLabel("AGREGAR ESTACION");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			gbc_lblNewLabel.gridwidth=4;
			add(lblNewLabel, gbc_lblNewLabel);
			
			
			JLabel lblNewLabel_2 = new JLabel("NOMBRE:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.gridwidth = 2;
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 2;
			add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
			
			lblNewLabel_6 = new JLabel("Por favor, ingrese un nombre.");
			lblNewLabel_6.setForeground(new Color(204, 0, 0));
			lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 11));
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_6.gridx = 2;
			gbc_lblNewLabel_6.gridy = 3;
			gbc_lblNewLabel_6.gridwidth=3;
			gbc_lblNewLabel_6.anchor=GridBagConstraints.WEST;
			add(lblNewLabel_6, gbc_lblNewLabel_6);
			
			JLabel lblNewLabel_3 = new JLabel("HORA APERTURA:");
			lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 4;
			add(lblNewLabel_3, gbc_lblNewLabel_3);
			
			timePicker = new TimePicker();
			timePicker.getComponentToggleTimeMenuButton().setFont(new Font("Arial", Font.PLAIN, 10));
			timePicker.getComponentToggleTimeMenuButton().setBackground(new Color(204, 204, 153));
			GridBagConstraints gbc_timePicker = new GridBagConstraints();
			gbc_timePicker.insets = new Insets(0, 0, 5, 5);
			gbc_timePicker.fill = GridBagConstraints.BOTH;
			gbc_timePicker.gridx = 2;
			gbc_timePicker.gridy = 4;
			gbc_timePicker.gridwidth=2;
			add(timePicker, gbc_timePicker);
			
			lblNewLabel_7 = new JLabel("Por favor, ingrese una hora de apertura.");
			lblNewLabel_7.setForeground(new Color(204, 0, 0));
			lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 11));
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_7.gridx = 2;
			gbc_lblNewLabel_7.gridy = 5;
			gbc_lblNewLabel_7.gridwidth=3;
			gbc_lblNewLabel_7.anchor=GridBagConstraints.WEST;
			add(lblNewLabel_7, gbc_lblNewLabel_7);
			
			JLabel lblNewLabel_4 = new JLabel("HORA CIERRE:");
			lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 6;
			add(lblNewLabel_4, gbc_lblNewLabel_4);
			
			timePicker_1 = new TimePicker();
			timePicker_1.getComponentToggleTimeMenuButton().setFont(new Font("Arial", Font.PLAIN, 10));
			timePicker_1.getComponentToggleTimeMenuButton().setBackground(new Color(204, 204, 153));
			GridBagConstraints gbc_timePicker_1 = new GridBagConstraints();
			gbc_timePicker_1.insets = new Insets(0, 0, 5, 5);
			gbc_timePicker_1.fill = GridBagConstraints.BOTH;
			gbc_timePicker_1.gridx = 2;
			gbc_timePicker_1.gridy = 6;
			gbc_timePicker_1.gridwidth=2;
			add(timePicker_1, gbc_timePicker_1);
			
			lblNewLabel_8 = new JLabel("Por favor, ingrese una hora de cierre.");
			lblNewLabel_8.setForeground(new Color(204, 0, 0));
			lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 11));
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 2;
			gbc_lblNewLabel_8.gridy = 7;
			gbc_lblNewLabel_8.gridwidth=3;
			gbc_lblNewLabel_8.anchor=GridBagConstraints.WEST;
			add(lblNewLabel_8, gbc_lblNewLabel_8);
			
			JLabel lblNewLabel_5 = new JLabel("ESTADO:");
			lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 8;
			add(lblNewLabel_5, gbc_lblNewLabel_5);
			
			rdbtnNewRadioButton = new JRadioButton("Operativa");
			rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 13));
			GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
			gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnNewRadioButton.gridx = 2;
			gbc_rdbtnNewRadioButton.gridy = 8;
			add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
			
			rdbtnNewRadioButton1 = new JRadioButton("En mantenimiento");
			rdbtnNewRadioButton1.setFont(new Font("Arial", Font.BOLD, 13));
			GridBagConstraints gbc_rdbtnNewRadioButton1 = new GridBagConstraints();
			gbc_rdbtnNewRadioButton1.insets = new Insets(0, 0, 5, 5);
			gbc_rdbtnNewRadioButton1.gridx = 3;
			gbc_rdbtnNewRadioButton1.gridy = 8;
			add(rdbtnNewRadioButton1, gbc_rdbtnNewRadioButton1);
			
			estado = new ButtonGroup();
			estado.add(rdbtnNewRadioButton);
			estado.add(rdbtnNewRadioButton1);
			
			btnNewButton = new JButton("GUARDAR");
			btnNewButton.setBackground(new Color(204, 204, 51));
			btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 10;
			add(btnNewButton, gbc_btnNewButton);
			
			btnNewButton_1 = new JButton("CANCELAR");
			btnNewButton_1.setBackground(new Color(204, 204, 51));
			btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
			gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton_1.gridx = 3;
			gbc_btnNewButton_1.gridy = 10;
			add(btnNewButton_1, gbc_btnNewButton_1);
			
			
		}
		public JButton getBtnNewButton() {
			return btnNewButton;
		}
		public JButton getBtnNewButton_1() {
			return btnNewButton_1;
		}
		
	}

