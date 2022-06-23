import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class INVENTORY_BACKEND {

	
	INVENTORY_BACKEND(JTextField ITEMCODE,
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
			
			int result = JOptionPane.showConfirmDialog(null, "Do you want to add Item?");
		      switch (result) {
		         case JOptionPane.YES_OPTION:
		         break;
		         case JOptionPane.NO_OPTION:
		         break;
		         case JOptionPane.CANCEL_OPTION:
		         break;
		      }
		      if(result==JOptionPane.YES_OPTION) {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			PreparedStatement st = con.prepareStatement("insert into inventory"
														+ "(Itemcode,RIM,Section_Width,"
														+ "Pattern,Description,Category,SRP,stocks,series,Load_Index,Speed_Symbol)values"
														+ "(?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
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
			 
			int rs = st.executeUpdate();
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
				
			
			
		      
		      }else if(result==JOptionPane.NO_OPTION){
		    	  
		      }
		      VIEW_INVENTORY_BACKEND nd = new VIEW_INVENTORY_BACKEND(INVENTORYTABLE); 
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			 JOptionPane.showMessageDialog(null, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
			// System.out.print(e1);
		}
	}
}
