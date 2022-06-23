import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

public class VIEW_POS_BACKEND {
		VIEW_POS_BACKEND(JTable postable){	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
				String sql     = "select * from pos";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rss        = ps.executeQuery();
				postable.setModel(DbUtils.resultSetToTableModel(rss));
				
				TableColumnModel columnModel = postable.getColumnModel();
				//columnModel.getColumn(0).setHeaderValue("#");
			//	columnModel.getColumn(0).setHeaderValue("Item Code");
			//	columnModel.getColumn(1).setHeaderValue("Item");
			//	columnModel.getColumn(2).setHeaderValue("Price");
			//	columnModel.getColumn(3).setHeaderValue("Quantity");
			//	columnModel.getColumn(4).setHeaderValue("Total");
			
				
				//columnModel.getColumn(7).setPreferredWidth(20);
				
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.print(e1);
				}
		}
}
