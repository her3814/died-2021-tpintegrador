package swing_estaciones;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import bdd.EstacionesRepo;
import bdd.TareaMantenimientoRepo;
import bdd.TramosRepo;
import excepciones.HoraCierreMenorHoraAperturaException;
//import excepciones.HoraCierreMenorHoraAperturaException;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class PanelBuscarEstacion extends JPanel {
	private JTextField textField;
	private JTable table;
	private SubPanelFiltros filtros;
	private JButton buscar;
	private List<Estacion> estacionesBDD;
	private Object datosFila [][];
	private JButton eliminar;
	private JButton modificar;
	private JButton btnNewButton_2;
	private JButton cancelar;
	private int seguir;
	private int row_selected;
	
	private JLabel lblNewLabel_1;
	private Estacion actual;
	private JButton aplicarFiltros;
	private String estadoFiltrado;
	private DefaultTableModel model;
	private JButton btnLimpiarFiltros;
	private JButton historial;
	
	public PanelBuscarEstacion() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 154, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, -16, 298, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("BUSCAR ESTACIÓN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=9;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(5, 5, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		filtros= new SubPanelFiltros();
		GridBagConstraints gbcFiltros = new GridBagConstraints();
		gbcFiltros.insets = new Insets(0, 0, 5, 5);
		gbcFiltros.gridx=1; 
		gbcFiltros.gridy=3;
		gbcFiltros.gridheight=4;
		add(filtros, gbcFiltros);
		
		table = new JTable();
		model = renovarTabla(EstacionesRepo.ObtenerEstaciones());
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
		gbc_table.gridx = 2;
		gbc_table.gridy = 4;
		add(scrollPane, gbc_table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
		    public void valueChanged(ListSelectionEvent e) { 
		        int cuentaFilasSeleccionadas = table.getSelectedRowCount(); 
		        if (cuentaFilasSeleccionadas == 1) { 
		        	modificar.setEnabled(true);
		        	eliminar.setEnabled(true);
		        	historial.setEnabled(true);
		        	row_selected = table.getSelectedRow();
					Integer id = (Integer) table.getValueAt(row_selected, 0);
					String nombreEstacion = (String) table.getValueAt(row_selected, 1);
					LocalTime hi = (LocalTime) table.getValueAt(row_selected, 2);
					LocalTime hf = (LocalTime) table.getValueAt(row_selected, 3);
					EstadoEstacionEnum estadoEst = (EstadoEstacionEnum) table.getValueAt(row_selected, 4);
					try {
						actual = new Estacion(id,nombreEstacion, hi, hf, estadoEst);
					} catch (HoraCierreMenorHoraAperturaException e1) {
						e1.printStackTrace();
					}	
		        }	        
		}});
		
		
		eliminar = new JButton("ELIMINAR");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				Integer id = (Integer) table.getValueAt(fila, 0);
				String nombre = (String) table.getValueAt(fila, 1);
				seguir = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la estacion: " + nombre + "?", 
				null, 2);
				//System.out.println(seguir);
				if(seguir==0) {
				LocalTime hi = (LocalTime) table.getValueAt(fila, 2);
				LocalTime hf = (LocalTime) table.getValueAt(fila, 3);
				EstadoEstacionEnum estado = (EstadoEstacionEnum) table.getValueAt(fila, 4);
				Estacion actual = null;
				try {
					actual = new Estacion(id,nombre, hi, hf, estado);
				} catch (HoraCierreMenorHoraAperturaException e1) {
					e1.printStackTrace();
				} 
				
				if(TramosRepo.estacionEstaEnUnTramo(actual)) {
					JOptionPane.showMessageDialog(null, "No puede eliminar la estacion "+ nombre + " ya que se encuentra asociada a un tramo.", "Eliminar estacion", JOptionPane.WARNING_MESSAGE);
				}else {
					model.removeRow(fila);
					TareaMantenimientoRepo.EliminarTareasMantenimiento(actual);
				}
				table.setModel(model);
				autoajustarAnchoColumnas(table);
				}
		}});
		
		buscar = new JButton("BUSCAR");	
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isBlank()) {
				table.setModel(renovarTabla(EstacionesRepo.ObtenerEstaciones()
					    .stream()
						.filter(est -> est.getNombre().toLowerCase().contains(textField.getText().toLowerCase()))
						.collect(Collectors.toList())));
				autoajustarAnchoColumnas(table);
			}else {
				table.setModel(renovarTabla(EstacionesRepo.ObtenerEstaciones()));
			}
				filtros.limpiarFiltros();
				autoajustarAnchoColumnas(table);
			}
		});
		
		buscar.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 3;
		add(buscar, gbc_btnNewButton);
		
		eliminar .setBackground(new Color(204, 204, 153));
		eliminar .setEnabled(false);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 5;
		add(eliminar , gbc_btnNewButton_3);
		
		modificar = new JButton("MODIFICAR");	
		modificar.setBackground(new Color(204, 204, 153));
		modificar.setEnabled(false);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 5;
		add(modificar, gbc_btnNewButton_4);  
	
		cancelar = new JButton("CANCELAR");
		cancelar.setBackground(new Color(204, 204, 51));
		
		aplicarFiltros = new JButton("Aplicar filtros");
		aplicarFiltros.setBackground(new Color(204, 204, 102));
		aplicarFiltros.setForeground(new Color(0, 0, 0));
		aplicarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estacionesBDD = new ArrayList<Estacion>();
				estacionesBDD = EstacionesRepo.ObtenerEstaciones();
				List<Estacion> estacionesBDDFiltradas = new ArrayList<Estacion>();
				if(!textField.getText().isBlank()) {
					estacionesBDDFiltradas= estacionesBDD.stream()
							.filter(est -> est.getNombre().toLowerCase().contains(textField.getText().toLowerCase()))
							.collect(Collectors.toList());
				}else {
				estacionesBDDFiltradas = estacionesBDD;
				}
				
				if( ! (filtros.getEstado().equals("no seleccionado"))) {
					estadoFiltrado = filtros.getEstado();
					System.out.println(estadoFiltrado.toString());
				if(estadoFiltrado.equals("En mantenimiento")) {
					estacionesBDDFiltradas = estacionesBDD.stream().filter(est -> est.getEstado().equals(EstadoEstacionEnum.MANTENIMIENTO))
					.collect(Collectors.toList());
				}
				else if (estadoFiltrado.equals("Operativa")){
					estacionesBDDFiltradas = estacionesBDD.stream().filter(est -> est.getEstado().equals(EstadoEstacionEnum.OPERATIVA))
					.collect(Collectors.toList());
				}
				}
				if( ! (filtros.getHoraCierre().equals("no seleccionado"))) {
					if(filtros.getHoraCierre().equals("00:01 a 06:00")) {	
						estacionesBDDFiltradas = estacionesBDDFiltradas
						.stream()
						.filter(est -> (est.getHorarioCierre().isBefore(LocalTime.of(06,01))) 
								&& (est.getHorarioCierre().isAfter(LocalTime.of(00, 00))))
						.collect(Collectors.toList());
					}
					else if(filtros.getHoraCierre().equals("06:01 a 12:00")) {
						estacionesBDDFiltradas = estacionesBDDFiltradas
								.stream()
								.filter(est -> (est.getHorarioCierre().isBefore(LocalTime.of(12,01))) 
										&& (est.getHorarioCierre().isAfter(LocalTime.of(06, 00))))
								.collect(Collectors.toList());
					}
					else if(filtros.getHoraCierre().equals("12:01 a 18:00")) {
						estacionesBDDFiltradas = estacionesBDDFiltradas
								.stream()
								.filter(est -> (est.getHorarioCierre().isBefore(LocalTime.of(18,01))) 
										&& (est.getHorarioCierre().isAfter(LocalTime.of(12, 00))))
								.collect(Collectors.toList());
					}
					else if(filtros.getHoraCierre().equals("18:01 a 00:00")) {
						estacionesBDDFiltradas = estacionesBDDFiltradas
								.stream()
								.filter(est -> (est.getHorarioCierre().isBefore(LocalTime.of(00,01))) 
										&& (est.getHorarioCierre().isAfter(LocalTime.of(18, 00))))
								.collect(Collectors.toList());
					}
				}
				
				if( ! (filtros.getHoraApertura().equals("no seleccionado"))){
			
					if(filtros.getHoraApertura().equals("00:01 a 06:00")) {	
						estacionesBDDFiltradas = estacionesBDDFiltradas
						.stream()
						.filter(est -> (est.getHorarioApertura().isBefore(LocalTime.of(06,01))) 
								&& (est.getHorarioApertura().isAfter(LocalTime.of(00, 00))))
						.collect(Collectors.toList());
					}
					else if(filtros.getHoraApertura().equals("06:01 a 12:00")) {
						estacionesBDDFiltradas = estacionesBDDFiltradas
								.stream()
								.filter(est -> (est.getHorarioApertura().isBefore(LocalTime.of(12,01))) 
										&& (est.getHorarioApertura().isAfter(LocalTime.of(06, 00))))
								.collect(Collectors.toList());
					}
					else if(filtros.getHoraApertura().equals("12:01 a 18:00")) {
						estacionesBDDFiltradas = estacionesBDDFiltradas
								.stream()
								.filter(est -> (est.getHorarioApertura().isBefore(LocalTime.of(18,01))) 
										&& (est.getHorarioApertura().isAfter(LocalTime.of(12, 00))))
								.collect(Collectors.toList());
					}
					else if(filtros.getHoraApertura().equals("18:01 a 00:00")) {
						estacionesBDDFiltradas = estacionesBDDFiltradas
								.stream()
								.filter(est -> (est.getHorarioApertura().isBefore(LocalTime.of(23,59))) 
										&& (est.getHorarioApertura().isAfter(LocalTime.of(18, 00))))
								.collect(Collectors.toList());
					}
				}
				table.setModel(renovarTabla(estacionesBDDFiltradas));
				autoajustarAnchoColumnas(table);
			}
		});
		
		historial = new JButton("HISTORIAL MANTENIMIENTOS");
		historial.setEnabled(false);
		historial.setBackground(new Color(204, 204, 153));
		GridBagConstraints gbc_modificar_1 = new GridBagConstraints();
		gbc_modificar_1.anchor = GridBagConstraints.EAST;
		gbc_modificar_1.gridwidth = 2;
		gbc_modificar_1.insets = new Insets(0, 0, 5, 5);
		gbc_modificar_1.gridx = 2;
		gbc_modificar_1.gridy = 6;
		add(historial, gbc_modificar_1);
		
		btnLimpiarFiltros = new JButton("Limpiar filtros");
		btnLimpiarFiltros.setBackground(new Color(204, 204, 102));
		btnLimpiarFiltros.setForeground(new Color(0, 0, 0));
		btnLimpiarFiltros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_btnLimpiarFiltros = new GridBagConstraints();
		gbc_btnLimpiarFiltros.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiarFiltros.gridx = 1;
		gbc_btnLimpiarFiltros.gridy = 7;
		add(btnLimpiarFiltros, gbc_btnLimpiarFiltros);
		

		btnLimpiarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textField.getText().isBlank()) {
					table.setModel(renovarTabla(EstacionesRepo.ObtenerEstaciones()
						    .stream()
							.filter(est -> est.getNombre().toLowerCase().contains(textField.getText().toLowerCase()))
							.collect(Collectors.toList())));
					autoajustarAnchoColumnas(table);
				}else {
					table.setModel(renovarTabla(EstacionesRepo.ObtenerEstaciones()));
				}
					filtros.limpiarFiltros();
					autoajustarAnchoColumnas(table);
				autoajustarAnchoColumnas(table);
			}
		});
		
		aplicarFiltros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 8;
		add(aplicarFiltros, gbc_btnNewButton_1);
		
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_11.insets = new Insets(10, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 6;
		gbc_btnNewButton_11.gridy = 8;
		add(cancelar, gbc_btnNewButton_11);
		
	}
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
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

	public String getTextoEscrito() {
		return this.textField.getText();
	} 
	public Estacion getActual() {
		return actual;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public DefaultTableModel renovarTabla(List<Estacion> nuevosDatos) {
		String nombreColumnas[] = {"Id","Nombre estacion", "Horario apertura", "Horario cierre", "Estado"};
		datosFila = new Object[nuevosDatos.size()] [5];
		for(int i=0; i<nuevosDatos.size();i++) {
			datosFila[i][0] = nuevosDatos.get(i).getId();
			datosFila[i][1] = nuevosDatos.get(i).getNombre();
			datosFila[i][2] = nuevosDatos.get(i).getHorarioApertura();
			datosFila[i][3] = nuevosDatos.get(i).getHorarioCierre();
			datosFila[i][4] = nuevosDatos.get(i).getEstado();
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
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public List<Estacion> getEstacionesBDD() {
		return estacionesBDD;
	}
	public void setEstacionesBDD(List<Estacion> estacionesBDD) {
		this.estacionesBDD = estacionesBDD;
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
	public JButton getHistorial() {
		return historial;
	}
	public void setHistorial(JButton historial) {
		this.historial = historial;
	}

}
