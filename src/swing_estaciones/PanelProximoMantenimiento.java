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
	
	private JButton cancelar;
	private JTable table;
	private Object datosFila [][];
	private DefaultTableModel model;

	public PanelProximoMantenimiento() {
		
		setBackground(Color.WHITE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 154, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, -16, 298, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));

		List<Estacion> estaciones = new ArrayList<Estacion>();
		estaciones=EstacionesRepo.ObtenerEstaciones();
		
		Comparator<Estacion> comparador = (Estacion t1, Estacion t2) -> t1.getFechaUltimoMantenimiento().compareTo(t2.getFechaUltimoMantenimiento());
		PriorityQueue<Estacion> cola = new PriorityQueue<Estacion>(estaciones.size(), comparador);
		cola.addAll(estaciones);
		List<Estacion> nuevosDatos = new ArrayList<Estacion>();
		while (! cola.isEmpty()) {
			nuevosDatos.add(cola.poll());
		}
		
	
		JLabel lblNewLabel = new JLabel("PROXIMO MANTENIMIENTO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		gbc_lblNewLabel.gridwidth=4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		table = new JTable();
		model = renovarTabla(nuevosDatos);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		table.setFillsViewportHeight(true);
		autoajustarAnchoColumnas(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 11;

		JScrollPane scrollPane= new JScrollPane(table);
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 4;
		add(scrollPane, gbc_table);
		
		
		cancelar = new JButton("VOLVER");
		cancelar.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_11.insets = new Insets(0, 0, 20, 5);
		gbc_btnNewButton_11.gridx = 8;
		gbc_btnNewButton_11.gridy = 5;
		add(cancelar, gbc_btnNewButton_11);
			
	}
	
	public static Date convertToDate(LocalDate dateToConvert) {
	    return java.sql.Date.valueOf(dateToConvert);
	}

	public DefaultTableModel renovarTabla(List<Estacion> nuevosDatos) {
		String nombreColumnas[] = {"Id","Id estacion" , "Nombre estacion", "Fecha"};
		datosFila = new Object[nuevosDatos.size()] [4];
		for(int i=0; i<nuevosDatos.size();i++) {
			datosFila[i][0] = i+1;
			datosFila[i][1] = nuevosDatos.get(i).getId();
			datosFila[i][2] = nuevosDatos.get(i).getNombre();
			datosFila[i][3] = nuevosDatos.get(i).getFechaUltimoMantenimiento();
		}
		//Crear modelo de la tabla
		model = new DefaultTableModel(datosFila,nombreColumnas){
		public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;
				}
		};
		return model;
	}	
	
	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
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
