package swing_tramos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
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
import bdd.TramosRepo;
import excepciones.HoraCierreMenorHoraAperturaException;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.Tramo;
import swing_estaciones.SubPanelFiltros;

public class PanelBuscarTramo extends JPanel {
	private JTable table;
	private SubpanelFiltrosTramo filtros;
	private List<Tramo> tramosBDD;
	private Object datosFila [][];
	private JButton eliminar;
	private JButton modificar;
	private JButton btnNewButton_2;
	private JButton cancelar;
	private int seguir;
	private int row_selected;
	private Tramo actual;
	private JButton aplicarFiltros;
	private String estadoFiltrado;
	private DefaultTableModel model;
	private JButton btnLimpiarFiltros;
	
	public PanelBuscarTramo() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 154, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, -16, 298, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("BUSCAR TRAMO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=8;
		add(lblNewLabel, gbc_lblNewLabel);
		
		filtros= new SubpanelFiltrosTramo();
		GridBagConstraints gbcFiltros = new GridBagConstraints();
		gbcFiltros.insets = new Insets(0, 0, 5, 5);
		gbcFiltros.gridx=1; 
		gbcFiltros.gridy=2;
		gbcFiltros.gridheight=4;
		add(filtros, gbcFiltros);
		
		table = new JTable();
		model = renovarTabla(TramosRepo.obtenerTramos());
		table.setModel(model);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		table.setFillsViewportHeight(true);
		autoajustarAnchoColumnas(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 8;
		
		JScrollPane scrollPane= new JScrollPane(table);
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 3;
		add(scrollPane, gbc_table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
		    public void valueChanged(ListSelectionEvent e) { 
		        int cuentaFilasSeleccionadas = table.getSelectedRowCount(); 
		        if (cuentaFilasSeleccionadas == 1) { 
		        	modificar.setEnabled(true);
		        	eliminar .setEnabled(true);
		        	row_selected = table.getSelectedRow();
					Integer id_linea = (Integer) table.getValueAt(row_selected, 2);
					Integer orden = (Integer) table.getValueAt(row_selected, 3);
					actual = TramosRepo.obtenerTramo(orden,id_linea);
		        }	        
		}});
		
		
		eliminar = new JButton("ELIMINAR");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				//Integer id = (Integer) table.getValueAt(fila, 0);
				//String nombre = (String) table.getValueAt(fila, 1);
				seguir = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el tramo con origen: " + actual.getOrigen().getNombre() + "?", 
				null, 2);
				System.out.println(seguir);
				if(seguir==0) {
				TramosRepo.EliminarTramo(actual);
				model.removeRow(fila);
				table.setModel(model);
				autoajustarAnchoColumnas(table);
				}
		}});
		
		eliminar .setBackground(new Color(204, 204, 153));
		eliminar .setEnabled(false);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 4;
		add(eliminar , gbc_btnNewButton_3);
		
		modificar = new JButton("MODIFICAR");	
		modificar.setBackground(new Color(204, 204, 153));
		modificar.setEnabled(false);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 4;
		add(modificar, gbc_btnNewButton_4);  
	
	
		cancelar = new JButton("CANCELAR");
		cancelar.setBackground(new Color(204, 204, 51));
		
		aplicarFiltros = new JButton("Aplicar filtros");
		aplicarFiltros.setBackground(new Color(204, 204, 102));
		aplicarFiltros.setForeground(new Color(0, 0, 0));
		aplicarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tramosBDD = new ArrayList<Tramo>();
				tramosBDD = TramosRepo.obtenerTramos();
				List<Tramo> tramosBDDFiltrados = new ArrayList<Tramo>();
				tramosBDDFiltrados = tramosBDD;
				
				if(! (filtros.getEstacionOrigen().equals("no seleccionado"))) {
					tramosBDDFiltrados = tramosBDDFiltrados.stream()
										.filter(t -> t.getOrigen().getNombre().equals(filtros.getEstacionOrigen()))
										.collect(Collectors.toList());
			};
			if(! (filtros.getEstacionDestino().equals("no seleccionado"))) {
				tramosBDDFiltrados = tramosBDDFiltrados.stream()
									.filter(t -> t.getDestino().getNombre().equals(filtros.getEstacionDestino()))
									.collect(Collectors.toList());
		};
		if(! (filtros.getLinea().equals("no seleccionado"))) {
			tramosBDDFiltrados = tramosBDDFiltrados.stream()
								.filter(t -> t.getLinea().get_nombre().equals(filtros.getLinea()))
								.collect(Collectors.toList());
	};
				table.setModel(renovarTabla(tramosBDDFiltrados));
				autoajustarAnchoColumnas(table);
			}
		});
		
		btnLimpiarFiltros = new JButton("Limpiar filtros");
		btnLimpiarFiltros.setBackground(new Color(204, 204, 102));
		btnLimpiarFiltros.setForeground(new Color(0, 0, 0));
		btnLimpiarFiltros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_btnLimpiarFiltros = new GridBagConstraints();
		gbc_btnLimpiarFiltros.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiarFiltros.gridx = 1;
		gbc_btnLimpiarFiltros.gridy = 6;
		add(btnLimpiarFiltros, gbc_btnLimpiarFiltros);
		

		btnLimpiarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//filtros.limpiarFiltros();
				table.setModel(renovarTabla(TramosRepo.obtenerTramos()));
				autoajustarAnchoColumnas(table);
			}
		});
		
		aplicarFiltros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 7;
		add(aplicarFiltros, gbc_btnNewButton_1);
		
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_11.insets = new Insets(10, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 5;
		gbc_btnNewButton_11.gridy = 7;
		add(cancelar, gbc_btnNewButton_11);
		
	}
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}
	
	public JButton getCancelar() {
		return cancelar;
	}
	public JButton getModificar() {
		return modificar;
	}

	public Tramo getActual() {
		return actual;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public DefaultTableModel renovarTabla(List<Tramo> nuevosDatos) {
		String nombreColumnas[] = {"Origen","Destino", "Linea","Orden", "Estado", "Costo"};
		datosFila = new Object[nuevosDatos.size()] [6];
		JTable new_table = new JTable();
		for(int i=0; i<nuevosDatos.size();i++) {
			datosFila[i][0] = nuevosDatos.get(i).getOrigen().getNombre();
			datosFila[i][1] = nuevosDatos.get(i).getDestino().getNombre();
			//datosFila[i][2] = nuevosDatos.get(i).getLinea().get_nombre();
			datosFila[i][3] = nuevosDatos.get(i).getOrden();
			datosFila[i][4] = nuevosDatos.get(i).get_estadoTramo();
			datosFila[i][5] = nuevosDatos.get(i).getCosto();
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
