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
		
		
public class REMOVEALL_POS_BACKEND {
	REMOVEALL_POS_BACKEND(JTable postable,JButton REMOVEALL,JTable itemstable){
		REMOVEALL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
try {
			
			int result = JOptionPane.showConfirmDialog(null, "Do you want to REMOVE ALL Item?");
		      switch (result) {
		         case JOptionPane.YES_OPTION:
		         break;
		         case JOptionPane.NO_OPTION:
		         break;
		      }
		      if(result==JOptionPane.YES_OPTION) {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con        = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "");
		
			int row = 0;
			
			
				Connection cond = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "");
				String totalitem = "select count(*) from pos";
				
				PreparedStatement psgetitem   = con.prepareStatement(totalitem);
				ResultSet         rsgetitem   = psgetitem.executeQuery();
				
				String count = null;
				int counts = 0 ;
				while(rsgetitem.next()) {
					 count = rsgetitem.getString("count(*)");
					 counts = Integer.parseInt(count);
				}
				
				while(row<=counts) {
			
			String value          = (postable.getModel().getValueAt(row, 0).toString());
			
			//
			try {
			String med = "select * from pos where item_code="+value;
			PreparedStatement ps = con.prepareStatement(med);
			ResultSet rss        = ps.executeQuery();
			
			
			String meds = "select * from inventory where item_code="+value;
			PreparedStatement pss = con.prepareStatement(meds);
			ResultSet rsss        = pss.executeQuery();
			
			
			while (rss.next()) {
				String quntities = null;
				String stock = null;
				int quanty = 0;
				int stocks = 0;
				int totals = 0;
				quanty = rss.getInt("quantity");
				
				 while (rsss.next()) {
						stock = rsss.getString("stock");
						stocks = Integer.parseInt(stock);
						 totals = quanty + stocks;

				
				 try {
					 
				 String medss = "update inventory set stock='"+totals+"' where item_code="+value;
					PreparedStatement psss = con.prepareStatement(medss);
					int rssss= psss.executeUpdate();
				 }catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "failsed");
					}
				 }
			}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "failed");
			}
			
			
			
			//
			
			String sql= "delete from pos where Item_Code="+value;
			PreparedStatement pst = con.prepareStatement(sql);
			int rs= pst.executeUpdate();
			DefaultTableModel Model =(DefaultTableModel)postable.getModel();
			Model.setRowCount(0);
		
			VIEW_POS_BACKEND AD = new VIEW_POS_BACKEND(postable);
			VIEW_INVENTORY_BACKEND nsd = new VIEW_INVENTORY_BACKEND(itemstable);
			
			
			//hanggang dtoy
		      }
				row++;
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			
		}
		
	}
		
		
	});
	
	}
	}