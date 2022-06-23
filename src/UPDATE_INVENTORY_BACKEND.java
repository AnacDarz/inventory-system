import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UPDATE_INVENTORY_BACKEND {
	
	UPDATE_INVENTORY_BACKEND(JTextField ITEMCODE,
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
		 
		
		 String itemcode    = ITEMCODE.getText();
		 String rim         = RIM.getText();  
		 String width       = WIDTH.getText();
		 String pattern     = (String)PATTERN.getSelectedItem();
		 String descript    = DESCRIPTION.getText();
		 String category    = (String)CATEGORY.getSelectedItem(); 
		 Float  price       = Float.parseFloat(SRP.getText());
		 int    stock       = Integer.parseInt(STOCK.getText());
		 String series      = SERIES.getText();  
		 String loadindex   = LOADINDEX.getText();  
		 String speedsymbol = SPEEDSYMBOL.getText();  
		
	
		int row = INVENTORYTABLE.getSelectedRow();
		String value = (INVENTORYTABLE.getModel().getValueAt(row,0).toString());
		String query = "update inventory set Itemcode=?,"
				       + "RIM=?,Section_Width=?,"
				       + "Pattern=?,Description=?, Category=?, SRP=?,stocks=?,series=?,Load_Index=?, Speed_Symbol=? where Itemcode="+value;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con       = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, itemcode);
			st.setString(2, rim);
			st.setString(3, width);
			st.setString(4, pattern);
			st.setString(5, descript);
			st.setString(6, category);
			st.setFloat (7, price);
			st.setInt   (8, stock);
			st.setString(9, series);
			st.setString(10, loadindex);
			st.setString(11, speedsymbol);

			int rs= st.executeUpdate();
			DefaultTableModel Model =(DefaultTableModel)INVENTORYTABLE.getModel();
			Model.setRowCount(0);
			if(rs>0){
				
				JOptionPane.showMessageDialog(null, "Success!");
				RESET RES = new RESET(  ITEMCODE,
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
			
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
			 JOptionPane.showMessageDialog(null,"INVALID!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
