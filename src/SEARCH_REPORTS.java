import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class SEARCH_REPORTS {
	
	SEARCH_REPORTS(JTextField SEARCHREPORTS,JTable REPORTSTABLE){
		SEARCHREPORTS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
		String name = SEARCHREPORTS.getText();
		String query= "select * from REPORTS where ITEMS like '%"+name+"%'";
	try {
		Connection con       = DriverManager.getConnection("jdbc:mysql://localhost:3306/tires", "root", "");
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rs= pst.executeQuery();
		REPORTSTABLE.setModel(DbUtils.resultSetToTableModel(rs));

	} catch (Exception e1) {
		// TODO Auto-generated catch block
		System.out.print(e1);
	}     
			}  		
		});
	}
}
