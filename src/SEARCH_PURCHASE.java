import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class SEARCH_PURCHASE {
	
	SEARCH_PURCHASE(JTextField SEARCHFIELD,JTable INVENTORYTABLE){
		SEARCHFIELD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
		String name = SEARCHFIELD.getText();
		String query= "select * from inventory where Itemcode like '%"+name+"%'";
	try {
		Connection con       = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rs= pst.executeQuery();
		INVENTORYTABLE.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception e1) {
		// TODO Auto-generated catch block
		System.out.print(e1);
	}     
			}  		
		});
	}
}
