import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RESET {
	RESET(JTextField ITEMCODE,
			  JTextField RIM,
			  JTextField WIDTH,
			  JComboBox  PATTERN,
			  JTextField DESCRIPTION,
			  JComboBox  CATEGORY,
			  JTextField SRP,
			  JTextField STOCK,
			  JTextField SERIES,
			  JTextField LOADINDEX,
			  JTextField SPEEDSYMBOL){
				
		ITEMCODE.setText("");
		RIM.setText("");
		WIDTH.setText("");
		DESCRIPTION.setText("");
		SRP.setText("");
		STOCK.setText("");
		SERIES.setText("");
		LOADINDEX.setText("");
		SPEEDSYMBOL.setText("");
		
		
	}
}
