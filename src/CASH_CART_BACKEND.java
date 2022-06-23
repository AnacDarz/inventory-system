import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class CASH_CART_BACKEND {
	CASH_CART_BACKEND(JTextField CASH,JTextField AMOUNT_DUE,JTextField CHANGE){
		
				
		CASH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
						try {
							
						
						String cash = CASH.getText();
						String amounts = AMOUNT_DUE.getText();
						
						float amount = Float.parseFloat(amounts);
						float cashcash = Float.parseFloat(cash);
						
						float SUPPLI = 0;
						SUPPLI =  cashcash - amount ;
						
						DecimalFormat df = new DecimalFormat("#.00");
						
						CHANGE.setText(df.format(SUPPLI));
					}catch (Exception e1) {
						// TODO Auto-generated catch block

					}
			}
				});
				
				
		
	}
}
