import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UPDATE_POS_BACKEND {
	UPDATE_POS_BACKEND(JButton INSERPTOS,
						   JTable postable,
						   JTable itemstable,
						   JTextField SUBTOTAL,
						   JTextField totalnumber,
						   JTextField VATSALES,
						   JTextField TAX,
						   JTextField AMOUNT_DUE,
						   JTextField CASH,
						   JTextField CHANGE,
						   JTextField dt){
		INSERPTOS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String name = JOptionPane.showInputDialog(null, "Update Quantity");
				int quanty = Integer.parseInt(name);
				int row = postable.getSelectedRow();
				
				
				
				
				String values = (postable.getModel().getValueAt(row, 0).toString());
				Connection con;
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
					String query ="select * from pos where Itemcode="+values;
					

					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					
				
					
					String prod = null ;
					String  types = null ;
					String brand = null;
					String cap = null;
					
					int quantity=0;
					
					float int_price = 0 ;
					float amount = 0 ;
				
					while (rs.next()) {
						
						String quant =rs.getString("quantity"); 
						quantity = Integer.parseInt(quant);
						 
						
						
						
						
						String prices =rs.getString("SRP");
						int_price = Float.parseFloat(prices);
						amount =  int_price * quanty;	
					
						String strDate= dt.getText();
						
					PreparedStatement st = con.prepareStatement("update pos set quantity=?, total=? where Itemcode="+values);
					
					
					st.setInt(1, quanty);
					st.setFloat(2, amount);
					
					
					int rss = st.executeUpdate();
					DefaultTableModel Model =(DefaultTableModel)itemstable.getModel();
					Model.setRowCount(0);
					if(rss>0){			
						JOptionPane.showMessageDialog(null, "Success!");
						//.
						Connection cons;
						Class.forName("com.mysql.jdbc.Driver");
						cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
						String querys ="select * from inventory where Itemcode="+values;
						

						PreparedStatement psts = cons.prepareStatement(querys);
						ResultSet rds= psts.executeQuery();
						
						int stocker=0;
						int stockers=0;
						
						
						
						while (rds.next()) {
							
							stocker =rds.getInt("stocks");
							stockers = stocker + quantity;
							
							if(stockers>=0) {
								PreparedStatement stsq = cons.prepareStatement("update inventory set stocks=? where Itemcode="+values);
								
								
								stsq.setInt(1, stockers);
								
								
								int rdss = stsq.executeUpdate();
								DefaultTableModel Models =(DefaultTableModel)itemstable.getModel();
								Models.setRowCount(0);
							}else {
								JOptionPane.showMessageDialog(null, "out of stock!");
							}
						}
						
						
						Connection conss;
						Class.forName("com.mysql.jdbc.Driver");
						conss = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
						String queryss ="select * from inventory where Itemcode="+values;
						
						
						PreparedStatement pstss = conss.prepareStatement(queryss);
						ResultSet rdss= pstss.executeQuery();
							int stak = 0;
							int staks = 0;
						 while (rdss.next()) {
							
							 stak =rdss.getInt("stocks");
							 staks = stockers - quanty;
							
							if(stockers>=0) {
								
								PreparedStatement stsqs = conss.prepareStatement("update inventory set stocks=? where Itemcode="+values);
								
								
								stsqs.setInt(1, staks);
								
								
								int rdsss = stsqs.executeUpdate();
								DefaultTableModel Models =(DefaultTableModel)itemstable.getModel();
								Models.setRowCount(0);
							}else {
								JOptionPane.showMessageDialog(null, "out of stock!");
							}
						}
						
						
						
						VIEW_INVENTORY_BACKEND nsd = new VIEW_INVENTORY_BACKEND(itemstable);
						VIEW_POS_BACKEND AD = new VIEW_POS_BACKEND(postable);
						TOTAL_AMOUNT_BACKEND aff = new TOTAL_AMOUNT_BACKEND( SUBTOTAL,totalnumber, VATSALES, TAX, AMOUNT_DUE);
						
						
						//VIEW_STORAGE viewbbuy= new VIEW_STORAGE(tableviewforpurchase);
						//TOTAL_AMOUNT_CART d = new TOTAL_AMOUNT_CART(SUBTOTAL,totalnumber,VATSALES,TAX,AMOUNT_DUE);
						//CASH_CART ccart = new CASH_CART(CASH,AMOUNT_DUE,CHANGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "failed");
							
					}
					///
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "The item is duplicated!"+e);
					System.out.print(e);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	}
}
