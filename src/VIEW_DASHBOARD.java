import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;

public class VIEW_DASHBOARD {

	public VIEW_DASHBOARD(JLabel PRODS, JLabel SALS,JLabel STCK) {
		// TODO Auto-generated constructor stub

		String ey = null;
		float vat = 0;
		float tax = 0;
		float amount_due=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			String sql     = "select sum(totals) from REPORTS";
			
			DecimalFormat df = new DecimalFormat("#.00");
			 
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rss        = ps.executeQuery();
			
			
			while(rss.next()) {
				 ey = rss.getString("sum(totals)");
				 float total = Float.parseFloat(ey);
				 vat = (float) (total/1.12);
				 tax = total - vat;
				 amount_due = tax + vat;
				 
				 // this is for the decimal if you want to display 2 decimal 
				
				
			
			SALS.setText("Php "+df.format(amount_due));
			
			
			
			}
			
			
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.print(e1);
			}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			String totalitem = "select sum(stocks) from INVENTORY";
			
			PreparedStatement psgetitem   = con.prepareStatement(totalitem);
			ResultSet         rsgetitem   = psgetitem.executeQuery();
			
			String count = null;
			while(rsgetitem.next()) {
				 count = rsgetitem.getString("sum(stocks)");

			STCK.setText(count);	
			}
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			String totalitem = "select COUNT(stocks) from INVENTORY";
			
			PreparedStatement psgetitem   = con.prepareStatement(totalitem);
			ResultSet         rsgetitem   = psgetitem.executeQuery();
			
			String count = null;
			while(rsgetitem.next()) {
				 count = rsgetitem.getString("COUNT(stocks)");

			PRODS.setText(count);	
			}
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
		}
	}

}
