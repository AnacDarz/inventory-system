import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class POS_TO_TRANSACTION_BACKEND {
	POS_TO_TRANSACTION_BACKEND(JButton PAYMENT,
							JTextField SUBTOTAL,
							JTextField totalnumber,
							JTextField VATSALES,
							JTextField TAX,
							JTextField AMOUNT_DUE,
							JTextField dt,
							JTextField CASH,
							JTextField CHANGE,
							JTextField FULLNAME,
							JTable postable){
		PAYMENT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Do you want to Buy all this Item?");
			      switch (result) {
			         case JOptionPane.YES_OPTION:
			         break;
			         case JOptionPane.NO_OPTION:
			         break;
			         case JOptionPane.CANCEL_OPTION:
			         break;
			      }
			      if(result==JOptionPane.YES_OPTION) {	
	
		Connection con;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			String query ="select * from pos";
			

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			
			int customerid = 0; 
			
			//String customername = null; 
			
			String items = null;
			String quantity = null;
			String total = null;
			
			int total_items = 0;
			
			float totals = 0;
			String itemstring = "";
			
			
			String dates = null;
				 
				 
				 
			while (rs.next()) {
				items = rs.getString("Description");
				quantity = rs.getString("Quantity");
				total = rs.getString("Total");
				 
				JTextField temp = new JTextField();
				temp.setText(items +" "+ quantity+" " + total + "\t");
				//String arr[] = null ;
				
				//int count = 0;
				
			//	arr[count] = temp.getText();
				
				
				
				itemstring = itemstring + (temp.getText()+"\n");
				
				
				
				
				//count++;
				
				
				
				
				/*Itemcode = rs.getInt("Item_code");
				brandname = rs.getString("brand_name");
				genname = rs.getString("generic_name");
				dosages = rs.getString("Dosage");
				types = rs.getString("Type");
				prices = rs.getFloat("Price");
				quant = rs.getInt("quantity");
				total = rs.getFloat("total");
				
				*/
				//int s = Integer.parseInt(strDate);
				

			}
			
			 PreparedStatement st = con.prepareStatement("insert into reports(Customer_name,items,total_items,totals,cash,changes,date)values"
						+ "(?,?,?,?,?,?,?)");

			 String tn = totalnumber.getText();
			 String fullnames = FULLNAME.getText();


			 String subtotal = AMOUNT_DUE.getText();
			 String cash = CASH.getText();
			 String chng = CHANGE.getText();

			 int totalnum = Integer.parseInt(tn);
			 float SUBTOT = Float.parseFloat(subtotal);
			 float Cash = Float.parseFloat(cash);
			 float Change = Float.parseFloat(chng);

			 String strDate = dt.getText();
			 
			 st.setString(1, fullnames);
			 st.setString(2, itemstring);
			 st.setInt(3, totalnum);
			 st.setFloat(4, SUBTOT);
			 st.setFloat(5, Cash);
			 st.setFloat(6, Change);
			 st.setString(7, strDate);

			 int rss = st.executeUpdate();
			 

			 if(rss>0){	
				 
			 }
			 else{
				 JOptionPane.showMessageDialog(null, "failed");

			 }
			
			
			
		} catch (SQLException e) {
			System.out.print(e); JOptionPane.showMessageDialog(null, "failed"+e);
			// TODO Auto-generated catch block
		} catch (ClassNotFoundException e) {
			System.out.print(e); JOptionPane.showMessageDialog(null, "failed"+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
try {
			
			
		     
			Class.forName("com.mysql.jdbc.Driver");
			Connection cons        = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
		
	
			
			String sql= "delete from pos";
			PreparedStatement pst = cons.prepareStatement(sql);
			int rs= pst.executeUpdate();
			
			
			if(rs>0){
				JOptionPane.showMessageDialog(null, "Success!");
				VIEW_POS_BACKEND g = new VIEW_POS_BACKEND(postable);
			
			

		      }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "failed"+e1);
			System.out.print(e1);
		}
		
			
		//RECEIPT pp = new RECEIPT();
		//pp.setVisible(true);
			      }
			}
			
			
			});
		
		
	
	}
	
	
	
	}


