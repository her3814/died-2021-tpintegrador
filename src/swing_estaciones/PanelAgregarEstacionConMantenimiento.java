package swing_estaciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;
import java.awt.GridBagLayout;

public class PanelAgregarEstacionConMantenimiento extends JPanel {
	
	private JLabel agregarMant;
	private JLabel fechaFin;
	private JDateChooser dateChooser_1;
	public JLabel obs;  
	private JTextArea textArea ;
	
	public PanelAgregarEstacionConMantenimiento() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{90};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		agregarMant= new JLabel("AGREGAR TAREA DE MANTENIMIENTO");
		agregarMant.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbc_agregarMant = new GridBagConstraints();
		gbc_agregarMant.anchor = GridBagConstraints.NORTH;
		gbc_agregarMant.insets = new Insets(0, 0, 5, 0);
		gbc_agregarMant.gridx = 0;
		gbc_agregarMant.gridy = 1;
		gbc_agregarMant.gridwidth=4;
		add(agregarMant,gbc_agregarMant);
		agregarMant.setVisible(false);
		

		fechaFin = new JLabel("FECHA FIN:");
		fechaFin.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_fin = new GridBagConstraints();
		gbc_fin.anchor = GridBagConstraints.WEST;
		gbc_fin.insets = new Insets(0, 10, 0, 5);
		gbc_fin.gridx = 0;
		gbc_fin.gridy = 2;
		add(fechaFin,gbc_fin);
		fechaFin.setVisible(false);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBackground(new Color(204, 204, 102));
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.anchor = GridBagConstraints.WEST;
		gbc_dateChooser_1.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser_1.gridx = 1;
		gbc_dateChooser_1.gridy = 2;
		add(dateChooser_1,gbc_dateChooser_1);
		dateChooser_1.setVisible(false);
		
		obs = new JLabel("OBSERVACIONES:");
		obs.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_obs = new GridBagConstraints();
		gbc_obs.anchor = GridBagConstraints.WEST;
		gbc_obs.insets = new Insets(0, 10, 0, 5);
		gbc_obs.gridx = 0;
		gbc_obs.gridy = 3;
		add(obs,gbc_obs);
		obs.setVisible(false);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setRows(8);
		textArea.setBackground(new Color(204, 204, 255));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.anchor = GridBagConstraints.NORTHWEST;
		gbc_textArea.insets = new Insets(10, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 3;
		add(textArea,gbc_textArea);
		textArea.setVisible(false);
	
}
}