package swing_estaciones;

import java.awt.Component;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class MyTableCellRenderer extends JRadioButton implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       this.setSelected(isSelected);
       return this;
    }

}