import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class launcher extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;
	private JLabel passfalse;
	private JLabel pleaseuser;
	private JLabel Pleasepass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					launcher frame = new launcher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public launcher() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 311, 292);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLACK));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				username.setBorder(new LineBorder(new Color(51, 255, 204), 1, true));
				pass.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				passfalse.setVisible(false);
				pleaseuser.setVisible(true);
				Pleasepass.setVisible(false);
			}
		});
		username.setBorder(new LineBorder(Color.BLACK, 1, true));
		
		
		username.setBounds(70, 161, 166, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBorder(new LineBorder(Color.BLACK, 1, true));
		pass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				username.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				pass.setBorder(new LineBorder(new Color(51, 255, 204), 1, true));
				passfalse.setVisible(false);
				pleaseuser.setVisible(false);
				Pleasepass.setVisible(true);
			}
		});
		pass.setBounds(70, 192, 166, 20);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pleaseuser.setVisible(false);
				Pleasepass.setVisible(false);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/system", "root", "");
					Statement stat = con.createStatement();
					String sql = "Select * from users where username ='"+username.getText()+"' and password='"+pass.getText().toString()+"'";
					ResultSet rs= stat.executeQuery(sql);
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "success");
						dispose();
						main_system mn = new main_system();
						mn.setVisible(true);
						
						
					}
					else{
				
						passfalse.setVisible(true);
						username.setBorder(new LineBorder(new Color(255, 0, 51), 1));
						pass.setBorder(new LineBorder(new Color(255, 0, 51), 1));
						
						//JOptionPane.showMessageDialog(null, "Your username or password is incorrect!");
							
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.print(e1);
				}
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		btnNewButton.setBounds(60, 248, 85, 33);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 11));
		chckbxNewCheckBox.addActionListener(ae -> {
	         JCheckBox c = (JCheckBox) ae.getSource();
	         pass.setEchoChar(c.isSelected() ? '\u0000' : (Character)UIManager.get("PasswordField.echoChar"));
	      });
		chckbxNewCheckBox.setBounds(70, 215, 124, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 311, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\computerretail\\img\\icons8-cancel-24.png"));
		lblNewLabel_1.setBounds(287, -2, 28, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\FOR ME\\crisselle\\SYSTEM\\img\\Untitled-8.png"));
		lblNewLabel_2.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(5, -2, 28, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Speed Line Marketing");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Javanese Text", Font.BOLD, 10));
		lblNewLabel_4.setBounds(5, 4, 212, 26);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\FOR ME\\crisselle\\SYSTEM\\img\\icons8-user-male-22.png"));
		lblNewLabel.setBounds(60, 161, 44, 23);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\FOR ME\\crisselle\\SYSTEM\\img\\icons8-key-17.png"));
		label.setBounds(60, 192, 44, 23);
		contentPane.add(label);
		
		passfalse = new JLabel("Username or Password is invalid!!!");
		passfalse.setForeground(Color.RED);
		passfalse.setFont(new Font("Javanese Text", Font.PLAIN, 12));
		passfalse.setBounds(70, 138, 241, 20);
		contentPane.add(passfalse);
		
		pleaseuser = new JLabel("You must enter a Username!");
		pleaseuser.setFont(new Font("Javanese Text", Font.PLAIN, 12));
		pleaseuser.setForeground(new Color(0, 153, 255));
		pleaseuser.setBounds(83, 138, 215, 20);
		contentPane.add(pleaseuser);
		
		Pleasepass = new JLabel("You must enter a password!");
		Pleasepass.setForeground(new Color(0, 153, 255));
		Pleasepass.setFont(new Font("Javanese Text", Font.PLAIN, 12));
		Pleasepass.setBounds(83, 140, 172, 20);
		contentPane.add(Pleasepass);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\speed-removebg-preview (1).png"));
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(1, 21, 310, 112);
		contentPane.add(lblNewLabel_3);
		
		JButton button = new JButton("Cancel");
		button.setBorderPainted(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Javanese Text", Font.PLAIN, 18));
		button.setFocusable(false);
		button.setBorder(null);
		button.setBackground(Color.ORANGE);
		button.setBounds(155, 248, 85, 33);
		contentPane.add(button);
		
		Pleasepass.setVisible(false);
		passfalse.setVisible(false);
		
	}
}
