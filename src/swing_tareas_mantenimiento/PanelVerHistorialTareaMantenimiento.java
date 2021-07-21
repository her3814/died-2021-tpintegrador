package swing_tareas_mantenimiento;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import bdd.EstacionesRepo;
import bdd.TareaMantenimientoRepo;
import excepciones.FechaFinMenorFechaInicioException;
import modelo.Estacion;
import modelo.TareaMantenimiento;

public class PanelVerHistorialTareaMantenimiento extends JPanel {
	private JButton btnNewButton_2; 
	private JTable table;
	private SubPanelFiltrosTareaMantenimiento filtros;
	private JButton buscar;
	private Object datosFila [][];
	private JButton eliminar;
	private JButton modificar;
	private JButton cancelar;
	private int seguir;
	private int row_selected;
	private JLabel lblNewLabel_1;
	private TareaMantenimiento actual;
	private JButton aplicarFiltros;
	private DefaultTableModel model;	
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public PanelVerHistorialTareaMantenimiento() {
		

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 154, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, -16, 298, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("HISTORIAL TAREAS DE MANTENIMIENTO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=8;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("ESTACION: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		model = renovarTabla(TareaMantenimientoRepo.Obtener());
	
		buscar = new JButton("BUSCAR");	
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(renovarTabla(TareaMantenimientoRepo.Obtener()
					    .stream()
						.filter(t -> t.getEstacion().getNombre().toString().equals(((Estacion) comboBox.getSelectedItem()).getNombre()))
						.collect(Collectors.toList())));
				autoajustarAnchoColumnas(table);
			}
		});
		
		comboBox = new JComboBox();
		ArrayList<Estacion> estaciones = (ArrayList<Estacion>) EstacionesRepo.ObtenerEstaciones();
		comboBox = new JComboBox(estaciones.toArray());
		comboBox.setSelectedIndex(-1);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		buscar.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 3;
		add(buscar, gbc_btnNewButton);
		
		table = new JTable();
		table.setModel(model);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		table.setFillsViewportHeight(true);
		autoajustarAnchoColumnas(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 9;
		
		JScrollPane scrollPane= new JScrollPane(table);
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 3;
		gbc_table.gridy = 4;
		add(scrollPane, gbc_table);
			
		cancelar = new JButton("VOLVER");
		cancelar.setBackground(new Color(204, 204, 51));
				
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_11.insets = new Insets(10, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 8;
		gbc_btnNewButton_11.gridy = 8;
		add(cancelar, gbc_btnNewButton_11);
		

	}
	
	public JButton getBuscar() {
		return buscar;
	}
	public JButton getCancelar() {
		return cancelar;
	}
	public JButton getModificar() {
		return modificar;
	}
	public void setBuscar(JButton btnNewButton) {
		this.buscar = btnNewButton;
	}

	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public DefaultTableModel renovarTabla(List<TareaMantenimiento> nuevosDatos) {
		String nombreColumnas[] = {"Id","Estacion", "Fecha inicio", "Fecha fin", "Observaciones"};
		datosFila = new Object[nuevosDatos.size()] [5];
		for(int i=0; i<nuevosDatos.size();i++) {
			datosFila[i][0] = nuevosDatos.get(i).getId();
			datosFila[i][1] = nuevosDatos.get(i).getEstacion();
			datosFila[i][2] = nuevosDatos.get(i).getFechaInicio();
			datosFila[i][3] = nuevosDatos.get(i).getFechaFin();
			datosFila[i][4] = nuevosDatos.get(i).getObservaciones();
		}
		//Crear modelo de la tabla
		model = new DefaultTableModel(datosFila,nombreColumnas){
		public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;
		}
		};
		return model;
	}	
	
	public JButton getAplicarFiltros() {
		return aplicarFiltros;
	}
	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.aplicarFiltros = btnNewButton_1;
	}
	public JButton getEliminar() {
		return eliminar ;
	}
	public void setEliminar(JButton btnNewButton_3) {
		this.eliminar  = btnNewButton_3;
	}
	
	public DefaultTableModel getModel() {
		return model;
	}
	public void setModel(DefaultTableModel model) {
		this.model = model;
		table.setModel(model);
	}
	public TareaMantenimiento getActual() {
		return actual;
	}
	public void setActual(TareaMantenimiento actual) {
		this.actual = actual;
	}

	public AbstractButton getBtnNewButton_2() {
		return btnNewButton_2;
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
	
}


