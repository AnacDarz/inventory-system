import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;

public class SORTBY {
	SORTBY(JComboBox SORT,JTable INVENTORYTABLE){
		SORT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String sorts = SORT.getSelectedItem().toString();
		try {
			
			if (sorts.equals("Item Code"))
				sorts= "Itemcode";
			if (sorts.equals("Brand Name"))
				sorts= "Brand_name";
			if (sorts.equals("Product Name"))
				sorts= "Product_name";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
			String sql     = "select * from inventory order by "+sorts+"";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rss        = ps.executeQuery();
			INVENTORYTABLE.setModel(DbUtils.resultSetToTableModel(rss));
			
			TableColumnModel columnModel = INVENTORYTABLE.getColumnModel();
			columnModel.getColumn(0).setHeaderValue("Item Code");
			columnModel.getColumn(1).setHeaderValue("Brand Name");
			columnModel.getColumn(2).setHeaderValue("Product Name");
			columnModel.getColumn(3).setHeaderValue("Supplier");
			columnModel.getColumn(4).setHeaderValue("Capacity/ Version / etc");
			columnModel.getColumn(5).setHeaderValue("Category / Type");
			columnModel.getColumn(6).setHeaderValue("Price");
			columnModel.getColumn(7).setHeaderValue("Stock/s");
			
			}catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.print(e1);
			}
	}
		
		
	});
	}
}
