import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

public class TOTAL_AMOUNT_BACKEND {
	TOTAL_AMOUNT_BACKEND(JTextField SUBTOTAL,
			          JTextField totalnumber,
			          JTextField VATSALES,
			          JTextField TAX,
			          JTextField AMOUNT_DUE
			       ){
		
		String ey = null;
		float vat = 0;
		float tax = 0;
		float amount_due=0;
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
		String sql     = "select sum(total) from pos";
		
		DecimalFormat df = new DecimalFormat("#.00");
		 
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rss        = ps.executeQuery();
		
		
		while(rss.next()) {
			 ey = rss.getString("sum(total)");
			 float total = Float.parseFloat(ey);
			 vat = (float) (total/1.12);
			 tax = total - vat;
			 amount_due = tax + vat;
			 // this is for the decimal if you want to display 2 decimal 
			
		TAX.setText(df.format(tax));	
		VATSALES.setText(df.format(vat));
		SUBTOTAL.setText(ey);
		AMOUNT_DUE.setText(df.format(amount_due));
		
		
		
		}
		
		
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
		}
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
		String totalitem = "select sum(quantity) from pos";
		
		PreparedStatement psgetitem   = con.prepareStatement(totalitem);
		ResultSet         rsgetitem   = psgetitem.executeQuery();
		
		String count = null;
		while(rsgetitem.next()) {
			 count = rsgetitem.getString("sum(quantity)");

		totalnumber.setText(count);	
		}
		
	}catch (Exception e1) {
		// TODO Auto-generated catch block
		System.out.print(e1);
	}
	
	
	}
}
