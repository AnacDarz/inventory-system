import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DELETE_INVENTORY_BACKEND {
	
	DELETE_INVENTORY_BACKEND(JTextField ITEMCODE,
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
try {
			
			int result = JOptionPane.showConfirmDialog(null, "Do you want to Delete this Item?");
		      switch (result) {
		         case JOptionPane.YES_OPTION:
		         break;
		         case JOptionPane.NO_OPTION:
		         break;
		      }
		      if(result==JOptionPane.YES_OPTION) {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con        = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
		
			int row = INVENTORYTABLE.getSelectedRow();
			String value          = (INVENTORYTABLE.getModel().getValueAt(row, 0).toString());
			
			String sql= "delete from inventory where Itemcode="+value;
			PreparedStatement pst = con.prepareStatement(sql);
			int rs= pst.executeUpdate();
			DefaultTableModel Model =(DefaultTableModel)INVENTORYTABLE.getModel();
			Model.setRowCount(0);
			if(rs>0){
				JOptionPane.showMessageDialog(null, "Success!");
				RESET RES = new RESET( ITEMCODE,
						   RIM,
						   WIDTH,
						    PATTERN,
						   DESCRIPTION,
						    CATEGORY,
						   SRP,
						   STOCK,
						   SERIES,
						   LOADINDEX,
						   SPEEDSYMBOL);
			}
			else{
				JOptionPane.showMessageDialog(null, "failed");
			}

			VIEW_INVENTORY_BACKEND nd = new VIEW_INVENTORY_BACKEND(INVENTORYTABLE);
		      }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "failed");
		}
	}
}
