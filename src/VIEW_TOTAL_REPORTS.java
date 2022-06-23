import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;


public class VIEW_TOTAL_REPORTS {

	public VIEW_TOTAL_REPORTS(JLabel totalsalesreports) {
		// TODO Auto-generated constructor stub
		String ey = null;
		float vat = 0;
		float tax = 0;
		float amount_due=0;
		String item = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			String sql     = "select sum(totals) from reports";
			
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
				
				 totalsalesreports.setText("Total Sales: Php "+df.format(amount_due));
			
			}
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.print(e1);
			}
	}

}
