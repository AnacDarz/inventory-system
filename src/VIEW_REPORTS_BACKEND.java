import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

public class VIEW_REPORTS_BACKEND {
		VIEW_REPORTS_BACKEND(JTable REPORTSTABLE){	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
				String sql     = "select * from reports";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rss        = ps.executeQuery();
				REPORTSTABLE.setModel(DbUtils.resultSetToTableModel(rss));
				
				TableColumnModel columnModel = REPORTSTABLE.getColumnModel();
				columnModel.getColumn(0).setHeaderValue("I.D.");
				columnModel.getColumn(1).setHeaderValue("Customer Name");
				columnModel.getColumn(2).setHeaderValue("Items");
				columnModel.getColumn(3).setHeaderValue("Total Items");
				columnModel.getColumn(4).setHeaderValue("Total Price");
				columnModel.getColumn(5).setHeaderValue("Cash");
				columnModel.getColumn(6).setHeaderValue("Change");
				columnModel.getColumn(7).setHeaderValue("Date");
				
				columnModel.getColumn(0).setPreferredWidth(2);
				columnModel.getColumn(1).setPreferredWidth(5);
				columnModel.getColumn(2).setPreferredWidth(80);
				columnModel.getColumn(3).setPreferredWidth(2);
				columnModel.getColumn(4).setPreferredWidth(4);
				columnModel.getColumn(5).setPreferredWidth(4);
				columnModel.getColumn(6).setPreferredWidth(4);
				columnModel.getColumn(7).setPreferredWidth(4);
				
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.print(e1);
				}
		}
}
