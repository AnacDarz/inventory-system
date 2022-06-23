import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TABLETOTXT {
	TABLETOTXT( 
			JTextField ITEMCODE,
			  JTextField RIM,
			  JTextField WIDTH,
			  JComboBox  PATTERN,
			  JTextField DESCRIPTION,
			  JComboBox  CATEGORY,
			  JTextField SRP,
			  JTextField STOCK,
			  JTextField SERIES,
			  JTextField LOADINDEX,
			  JTextField SPEEDSYMBOL,
			  JTable INVENTORYTABLE){
		
		INVENTORYTABLE.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = INVENTORYTABLE.getSelectedRow();
				DefaultTableModel Model =(DefaultTableModel)INVENTORYTABLE.getModel();
				ITEMCODE.setText(Model.getValueAt(row, 0).toString());
				RIM.setText(Model.getValueAt(row, 1).toString());
				WIDTH.setText(Model.getValueAt(row, 2).toString());
				PATTERN.setToolTipText(Model.getValueAt(row, 3).toString());
				DESCRIPTION.setText(Model.getValueAt(row, 4).toString());
				CATEGORY.setToolTipText(Model.getValueAt(row, 5).toString());
				SRP.setText(Model.getValueAt(row, 6).toString());
				STOCK.setText(Model.getValueAt(row, 7).toString());
				SERIES.setText(Model.getValueAt(row, 8).toString());
				LOADINDEX.setText(Model.getValueAt(row,9).toString());
				SPEEDSYMBOL.setText(Model.getValueAt(row,10).toString());
				
		
				
			}
		});
	}
}
