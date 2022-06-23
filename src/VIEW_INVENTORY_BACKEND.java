import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

public class VIEW_INVENTORY_BACKEND {
		VIEW_INVENTORY_BACKEND(JTable INVENTORYTABLE){	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
				String sql     = "select * from inventory";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rss        = ps.executeQuery();
				INVENTORYTABLE.setModel(DbUtils.resultSetToTableModel(rss));
				
				TableColumnModel columnModel = INVENTORYTABLE.getColumnModel();
				columnModel.getColumn(0).setHeaderValue("Code");
				columnModel.getColumn(1).setHeaderValue("RIM");
				columnModel.getColumn(2).setHeaderValue("Width");
				columnModel.getColumn(3).setHeaderValue("Pattern");
				columnModel.getColumn(4).setHeaderValue("Description");
				columnModel.getColumn(5).setHeaderValue("Category");
				columnModel.getColumn(6).setHeaderValue("SRP");
				columnModel.getColumn(7).setHeaderValue("Stocks");
				columnModel.getColumn(8).setHeaderValue("Series");
				columnModel.getColumn(9).setHeaderValue("Load Index");
				columnModel.getColumn(10).setHeaderValue("Speed Symbol");
				
				//columnModel.getColumn(7).setPreferredWidth(20);
				
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.print(e1);
				}
		}
}
