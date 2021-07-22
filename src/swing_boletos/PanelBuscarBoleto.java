package swing_boletos;

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
import bdd.LineasRepo;
import excepciones.HoraCierreMenorHoraAperturaException;
//import excepciones.HoraCierreMenorHoraAperturaException;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.EstadoLineaEnum;
import modelo.Linea;
import modelo.LineaTipoTransporteEnum;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class PanelBuscarBoleto extends JPanel {
	private JTextField textField;
	private JTable table;
	private SubPanelFiltrosBoletos filtros;
	private JButton buscar;
	private Object datosFila [][];
	private JButton eliminar;
	private JButton modificar;
	private JButton btnNewButton_2;
	private JButton cancelar;
	private int seguir;
	private int row_selected;
	private JLabel lblNewLabel_1;
	private Linea actual;
	private JButton aplicarFiltros;
	private DefaultTableModel model;
	private JButton btnLimpiarFiltros;
	
	public PanelBuscarBoleto() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 154, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, -16, 298, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("BUSCAR BOLETO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=9;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("NOMBRE CLIENTE:");
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
		
		filtros= new SubPanelFiltrosBoletos();
		GridBagConstraints gbcFiltros = new GridBagConstraints();
		gbcFiltros.insets = new Insets(0, 0, 5, 5);
		gbcFiltros.gridx=1; 
		gbcFiltros.gridy=3;
		gbcFiltros.gridheight=4;
		add(filtros, gbcFiltros);
		
		table = new JTable();
		model = renovarTabla(LineasRepo.ObtenerLineas());
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
		        	row_selected = table.getSelectedRow();
					Integer id = (Integer) table.getValueAt(row_selected, 0);
					String nombre = (String) table.getValueAt(row_selected, 1);
					String color = (String) table.getValueAt(row_selected, 2);
					EstadoLineaEnum estado = (EstadoLineaEnum) table.getValueAt(row_selected, 3);
					LineaTipoTransporteEnum transporte = (LineaTipoTransporteEnum) table.getValueAt(row_selected, 4);
					actual = new Linea(id,nombre,color, estado, transporte);
		        }     
		        }
		});
		
		
		eliminar = new JButton("ELIMINAR");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				Integer id = (Integer) table.getValueAt(fila, 0);
				String nombre = (String) table.getValueAt(fila, 1);
				seguir = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la linea: " + nombre + "?", 
				null, 2);
				System.out.println(seguir);
				if(seguir==0) {
				String color = (String) table.getValueAt(row_selected, 2);
				EstadoLineaEnum estado = (EstadoLineaEnum) table.getValueAt(row_selected, 3);
				LineaTipoTransporteEnum transporte = (LineaTipoTransporteEnum) table.getValueAt(row_selected, 4);
				Linea actual = null;
				actual = new Linea(id,nombre,color, estado, transporte);
				LineasRepo.EliminarLinea(actual);
				model.removeRow(fila);
				table.setModel(model);
				autoajustarAnchoColumnas(table);
				}
		}});
		
		buscar = new JButton("BUSCAR");	
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(renovarTabla(LineasRepo.ObtenerLineas()
					    .stream()
						.filter(est -> est.get_nombre().equals(textField.getText()))
						.collect(Collectors.toList())));
				autoajustarAnchoColumnas(table);
			}
		});
		
		buscar.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 3;
		add(buscar, gbc_btnNewButton);
		
		eliminar.setBackground(new Color(204, 204, 153));
		eliminar.setEnabled(false);
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
	
		cancelar = new JButton("VOLVER");
		cancelar.setBackground(new Color(204, 204, 51));
		
		aplicarFiltros = new JButton("Aplicar filtros");
		aplicarFiltros.setBackground(new Color(204, 204, 102));
		aplicarFiltros.setForeground(new Color(0, 0, 0));
		/*aplicarFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Linea> lineas  = new ArrayList<Linea>();
				lineas = LineasRepo.ObtenerLineas();
				List<Linea> lineasFiltradas = new ArrayList<Linea>();
				lineasFiltradas = lineas;
				if(filtros.getSelectedButtonText(filtros.getEstado()).equals("No activa")) {
					lineasFiltradas = lineasFiltradas.stream()
										.filter(l -> l.get_estado().equals(EstadoLineaEnum.NO_ACTIVA))
										.collect(Collectors.toList());
				}
				else if (filtros.getSelectedButtonText(filtros.getEstado()).equals("Activa")) {
					lineasFiltradas = lineasFiltradas.stream()
							.filter(l -> l.get_estado().equals(EstadoLineaEnum.ACTIVA))
							.collect(Collectors.toList());
				}
				if(filtros.getSelectedButtonText(filtros.getTipotransporte()).equals("Tren")) {
					lineasFiltradas = lineasFiltradas.stream()
							.filter(l -> l.get_tipoTransporte().equals(LineaTipoTransporteEnum.TREN))
							.collect(Collectors.toList());
				}
				else if(filtros.getSelectedButtonText(filtros.getTipotransporte()).equals("Colectivo")) {
					lineasFiltradas = lineasFiltradas.stream()
							.filter(l -> l.get_tipoTransporte().equals(LineaTipoTransporteEnum.COLECTIVO))
							.collect(Collectors.toList());
				}
				else if(filtros.getSelectedButtonText(filtros.getTipotransporte()).equals("Subte")) {
					lineasFiltradas = lineasFiltradas.stream()
							.filter(l -> l.get_tipoTransporte().equals(LineaTipoTransporteEnum.SUBTE))
							.collect(Collectors.toList());
				}
				if(! (filtros.getColorLinea().equals("no seleccionado"))) {
					lineasFiltradas = lineasFiltradas.stream()
							.filter(l -> l.get_color().equals(filtros.getColorLinea().toString()))
							.collect(Collectors.toList());
				}
				
				table.setModel(renovarTabla(lineasFiltradas));
				autoajustarAnchoColumnas(table);
			}
		});*/
	
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
				filtros.limpiarFiltros();
				table.setModel(renovarTabla(LineasRepo.ObtenerLineas()));
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
	public Linea getActual() {
		return actual;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public DefaultTableModel renovarTabla(List<Linea> nuevosDatos) {
		String nombreColumnas[] = {"Id","Nombre", "Color", "Estado", "Tipo de Transporte"};
		datosFila = new Object[nuevosDatos.size()] [5];
		JTable new_table = new JTable();
		for(int i=0; i<nuevosDatos.size();i++) {
			datosFila[i][0] = nuevosDatos.get(i).get_id();
			datosFila[i][1] = nuevosDatos.get(i).get_nombre();
			datosFila[i][2] = nuevosDatos.get(i).get_color();
			datosFila[i][3] = nuevosDatos.get(i).get_estado();
			datosFila[i][4] = nuevosDatos.get(i).get_tipoTransporte();
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
