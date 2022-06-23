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

public class TO_POS_BACKEND {
	TO_POS_BACKEND(JButton INSERPTOS,
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
				
				String name = JOptionPane.showInputDialog(null, "Input Quantity");
				int quanty = Integer.parseInt(name);
				int row = itemstable.getSelectedRow();
				
				
				
				
				
				String values = (itemstable.getModel().getValueAt(row, 0).toString());
				Connection con;
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
					String query ="select * from inventory where Itemcode="+values;
					

					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs= pst.executeQuery();
					
				
					
					String description = null ;
					String category = null ;
					String pattern = null;
					int    rim=0;
					int sectionwidth=0;
					String series = null;
					String loadindex = null;
					String speedsymbol = null;
					
					float int_price = 0 ;
					float amount = 0 ;
					int stocker=0;
					int stockers=0;
					
					while (rs.next()) {
		
						 
						description = rs.getString("Description");
						category = rs.getString("Category");
						pattern = rs.getString("Pattern");
						rim =rs.getInt("RIM");
						sectionwidth =rs.getInt("Section_Width");
						series = rs.getString("series");
						loadindex = rs.getString("Load_Index");
						speedsymbol = rs.getString("Speed_Symbol");
						
						stocker =rs.getInt("stocks");
						stockers = stocker - quanty;
						String prices =rs.getString("SRP");
						int_price = Float.parseFloat(prices);
						amount =  int_price * quanty;	
					
						String strDate= dt.getText();
						
					PreparedStatement st = con.prepareStatement("insert into pos(Itemcode,Description,Category,Pattern,RIM,Section_Width,series,Load_Index,Speed_Symbol,SRP,Quantity,Total)values"
																+ "(?,?,?,?,?,?,?,?,?,?,?,?)");
					
					st.setString(1, values);
					st.setString(2, description);

					st.setString(3, category);
					st.setString(4, pattern);
					st.setInt(5, rim);
					st.setInt(6, sectionwidth);
					st.setString(7, series);
					st.setString(8, loadindex);
					st.setString(9, speedsymbol);
					
					st.setFloat(10, int_price);
					st.setInt(11, quanty);
					st.setFloat(12, amount);
					
					if(stockers>=0) {
					int rss = st.executeUpdate();
					DefaultTableModel Model =(DefaultTableModel)postable.getModel();
					Model.setRowCount(0);
					if(rss>0){			
						JOptionPane.showMessageDialog(null, "Success!");
						String valuess = (itemstable.getModel().getValueAt(row, 0).toString());

						
						String queryss ="update inventory set stocks='"+stockers+"' where Itemcode="+values;
						PreparedStatement sts = con.prepareStatement(queryss);
						
						
						
						
						
						int rsss= sts.executeUpdate();
						
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
					
					}else {
						JOptionPane.showMessageDialog(null, "out of stock!");
					}
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
