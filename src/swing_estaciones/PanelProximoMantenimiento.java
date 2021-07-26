package swing_estaciones;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import bdd.EstacionesRepo;
import modelo.Estacion;
import modelo.TareaMantenimiento;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

public class PanelProximoMantenimiento extends JPanel {
	
	private static final long serialVersionUID = -2644494736548175597L;

	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton cancelar;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JDateChooser dateChooser;
	private JTable table;
	private Object datosFila [][];
	private DefaultTableModel model;

	public PanelProximoMantenimiento() {
		
		setBackground(Color.WHITE);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{54, 90, 141, 211, 67, 0};
		gridBagLayout.rowHeights = new int[]{0, 26, 19, 0, 19, 0, 19, 0, 19, 21, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("PROXIMO MANTENIMIENTO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);

		List<Estacion> estaciones = new ArrayList<Estacion>();
		estaciones=EstacionesRepo.ObtenerEstaciones();
		
		Comparator<Estacion> comparador = (Estacion t1, Estacion t2) -> t1.getFechaUltimoMantenimiento().compareTo(t2.getFechaUltimoMantenimiento());
		PriorityQueue<Estacion> cola = new PriorityQueue<Estacion>(estaciones.size(), comparador);
		cola.addAll(estaciones);
		List<Estacion> nuevosDatos = new ArrayList<Estacion>();
		while (! cola.isEmpty()) {
			nuevosDatos.add(cola.poll());
		}
		
		table = new JTable();
		model = renovarTabla(nuevosDatos);
		table.setModel(model);
		autoajustarAnchoColumnas(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowSelectionAllowed(false);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 12;
		gbc_table.gridwidth = 10;
		
		JScrollPane scrollPane= new JScrollPane(table);
		gbc_table.insets = new Insets(5, 5, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 5;
		add(scrollPane, gbc_table);
		
		cancelar = new JButton("VOLVER");
		cancelar.setBackground(new Color(204, 204, 51));
		cancelar.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 12;
		add(cancelar, gbc_btnNewButton_1);
			
	}
	public JTextField getTextField_1() {
		return textField_1;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JButton getCancelar() {
		return cancelar;
	}
	public static Date convertToDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}

	public DefaultTableModel renovarTabla(List<Estacion> nuevosDatos) {
		String nombreColumnas[] = {"Id","Nombre estacion", "Fecha FIN ultimo mantenimiento"};
		datosFila = new Object[nuevosDatos.size()] [3];
	
		for(int i=0; i<nuevosDatos.size();i++) {
			datosFila[i][0] = nuevosDatos.get(i).getId();
			datosFila[i][1] = nuevosDatos.get(i).getNombre();
			datosFila[i][2] = nuevosDatos.get(i).getFechaUltimoMantenimiento();
		}
		//Crear modelo de la tabla
		model = new DefaultTableModel(datosFila,nombreColumnas){
		public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;
				}
		};
		return model;
	}	
	public void autoajustarAnchoColumnas(JTable table) {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 15; // Min width
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width +1 , width);
	        }
	        if(width > 300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
		table.setModel(model);
	}
}
