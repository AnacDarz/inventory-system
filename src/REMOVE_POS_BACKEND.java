		import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
		import javax.swing.JOptionPane;
		import javax.swing.JTable;
		import javax.swing.JTextField;
		import javax.swing.table.DefaultTableModel;
		
		
public class REMOVE_POS_BACKEND {
	
	REMOVE_POS_BACKEND(JButton REMOVEPOS,
			    JTable postable,
			    JTable itemstable){
		
		REMOVEPOS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
try {
			
			int result = JOptionPane.showConfirmDialog(null, "Do you want to REMOVE this Item?");
		      switch (result) {
		         case JOptionPane.YES_OPTION:
		         break;
		         case JOptionPane.NO_OPTION:
		         break; 
		      }
		      if(result==JOptionPane.YES_OPTION) {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con        = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
		
			int row = postable.getSelectedRow();
			String value          = (postable.getModel().getValueAt(row, 0).toString());
			
			//
			try {
			String med = "select * from pos where Itemcode="+value;
			PreparedStatement ps = con.prepareStatement(med);
			ResultSet rss        = ps.executeQuery();
			
			
			String meds = "select * from inventory where Itemcode="+value;
			PreparedStatement pss = con.prepareStatement(meds);
			ResultSet rsss        = pss.executeQuery();
			
			String quntities = null;
			String stock = null;
			int quanty = 0;
			int stocks = 0;
			int totals = 0;
			while (rss.next()) {
				quanty = rss.getInt("Quantity");
				
				 while (rsss.next()) {
						stock = rsss.getString("stocks");
						stocks = Integer.parseInt(stock);
						 totals = quanty + stocks;

				
				 try {
					 
				 String medss = "update inventory set stocks='"+totals+"' where Itemcode="+value;
					PreparedStatement psss = con.prepareStatement(medss);
					int rssss= psss.executeUpdate();
				 }catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "failed");
					}
				 }
			}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "failed");
			}
			
			
			
			
			//
			
			String sql= "delete from pos where Itemcode="+value;
			PreparedStatement pst = con.prepareStatement(sql);
			int rs= pst.executeUpdate();
			DefaultTableModel Model =(DefaultTableModel)postable.getModel();
			Model.setRowCount(0);
			
			if(rs>0){
				JOptionPane.showMessageDialog(null, "Success!");
				
			}
			else{
				JOptionPane.showMessageDialog(null, "failed");
			}
			
			
			
			//VIEW_STORAGE viewbbuy= new VIEW_STORAGE(tableviewforpurchase);
			//VIEW_FOR_THE_CART_TABLE S= new VIEW_FOR_THE_CART_TABLE(CART);
			VIEW_POS_BACKEND AD = new VIEW_POS_BACKEND(postable);
			VIEW_INVENTORY_BACKEND nsd = new VIEW_INVENTORY_BACKEND(itemstable);
			
			//hanggang dtoy
		      }
		      
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "failed");
		}
	}
		
		
	});
	}
}
