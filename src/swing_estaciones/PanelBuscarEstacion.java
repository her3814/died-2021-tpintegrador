package swing_estaciones;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import bdd.EstacionesRepo;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;

public class PanelBuscarEstacion extends JPanel {
	private JTextField textField;
	private JTable table;
	private SubPanelFiltros filtros;
	private JButton btnNewButton;
	private List<Estacion> estacionesBDD;
	private List<String> nombresEstaciones;
	private List<LocalTime> horariosApertura;
	private List<LocalTime> horariosCierre ;
	private List<EstadoEstacionEnum> estado ;
	
	private Object datosFila [][];
	private String nombreColumnas[];
	private JButton btnNewButton_3;
	private JButton modificar;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	private Estacion actual;
	  
	public PanelBuscarEstacion() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 154, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, -16, 298, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setPreferredSize(new Dimension(500,500));
		setMinimumSize(new Dimension(300,300));
		
		JLabel lblNewLabel = new JLabel("BUSCAR ESTACI\u00D3N");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 5, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.gridwidth=8;
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
		gbc_textField.gridwidth = 4;
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
			
		btnNewButton = new JButton("BUSCAR");
		btnNewButton.setBackground(new Color(204, 204, 204));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);
		
		estacionesBDD = EstacionesRepo.ObtenerEstaciones();
		nombresEstaciones = new ArrayList<String>();
		horariosApertura = new ArrayList<LocalTime>();
		horariosCierre = new ArrayList<LocalTime>();
		estado = new ArrayList<EstadoEstacionEnum>();
		
		for(Estacion e: estacionesBDD) {
			nombresEstaciones.add(e.getNombre());
			horariosApertura.add(e.getHorarioApertura());
			horariosCierre.add(e.getHorarioCierre());
			estado.add(e.getEstado());
		}
		
		String nombreColumnas[] = {"Nombre estacion", "Horario apertura", "Horario cierre", "Estado"};
		datosFila = new Object[nombresEstaciones.size()] [4];
		
		
		for(int i=0; i<nombresEstaciones.size();i++) {
			datosFila[i][0] = nombresEstaciones.get(i);
			datosFila[i][1] = horariosApertura.get(i);
			datosFila[i][2] = horariosCierre.get(i);
			datosFila[i][3] = estado.get(i);
		}
		
		//Crear modelo de la tabla
				DefaultTableModel model = new DefaultTableModel(datosFila,nombreColumnas){
				    public boolean isCellEditable(int rowIndex,int columnIndex){
				    	return false;
				    	}
				};
				
		table = new JTable();
		table.setModel(model);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		table.setFillsViewportHeight(true);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 8;
		
		btnNewButton_3 = new JButton("ELIMINAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				String nombre = (String) table.getValueAt(fila, 0);
				int seguir = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la estacion: " + nombre + "?", 
				null, 2);
				if(seguir==0) {
				LocalTime hi = (LocalTime) table.getValueAt(fila, 1);
				LocalTime hf = (LocalTime) table.getValueAt(fila, 2);
				EstadoEstacionEnum estado = (EstadoEstacionEnum) table.getValueAt(fila, 3);
				Estacion actual = new Estacion(nombre, hi, hf, estado); 
				EstacionesRepo.EliminarEstacion(actual);
				estacionesBDD = EstacionesRepo.ObtenerEstaciones();
					renovarTabla(estacionesBDD);
				}
		}});
		
		btnNewButton_3.setBackground(new Color(204, 204, 153));
		btnNewButton_3.setEnabled(false);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 5;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		modificar = new JButton("MODIFICAR");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fila = table.getSelectedRow();
				String nombreEstacion = (String) table.getValueAt(fila, 0);
				LocalTime hi = (LocalTime) table.getValueAt(fila, 1);
				LocalTime hf = (LocalTime) table.getValueAt(fila, 2);
				EstadoEstacionEnum estadoEst = (EstadoEstacionEnum) table.getValueAt(fila, 3);
				actual = new Estacion(nombreEstacion, hi, hf, estadoEst);
			}});
		
		modificar.setBackground(new Color(204, 204, 153));
		modificar.setEnabled(false);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 5;
		add(modificar, gbc_btnNewButton_4);  
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
			    public void valueChanged(ListSelectionEvent e) { 
			        int cuentaFilasSeleccionadas = table.getSelectedRowCount(); 
			        if (cuentaFilasSeleccionadas == 1) { 
			        	modificar.setEnabled(true);
			        	btnNewButton_3.setEnabled(true);
			        } 
			}});
		
		JScrollPane scrollPane= new JScrollPane(table);
		gbc_table.insets = new Insets(5, 5, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 4;
		add(scrollPane, gbc_table);
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.setBackground(new Color(204, 204, 51));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_2 = new JButton("GUARDAR");
		btnNewButton_2.setBackground(new Color(204, 204, 51));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 7;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnNewButton_1.insets = new Insets(10, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 7;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
	}
	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JButton getModificar() {
		return modificar;
	}
	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public String getTextoEscrito() {
		return this.textField.getText();
	} 
	public Estacion getActual() {
		return actual;
	}
	
	public JTable renovarTabla(List<Estacion> nuevosDatos) {
		nombresEstaciones = new ArrayList<String>();
		horariosApertura = new ArrayList<LocalTime>();
		horariosCierre = new ArrayList<LocalTime>();
		
		for(Estacion e: nuevosDatos) {
			nombresEstaciones.add(e.getNombre());
			horariosApertura.add(e.getHorarioApertura());
			horariosCierre.add(e.getHorarioCierre());
		}
		for(int i=0; i<nombresEstaciones.size();i++) {
			datosFila[i][0]= nombresEstaciones.get(i);
			datosFila[i][1]= horariosApertura.get(i);
			datosFila[i][2]= horariosCierre.get(i);
		}
		JTable nueva = new JTable (datosFila, nombreColumnas);
		DefaultTableModel model = new DefaultTableModel(datosFila,nombreColumnas){
		    public boolean isCellEditable(int rowIndex,int columnIndex){
		    	return false;
		    	}
		};
		nueva.setModel(model); 
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		table.setFillsViewportHeight(true);
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 8;
		
		return nueva;
		
	}

	
}
