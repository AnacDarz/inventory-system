import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.ComponentOrientation;

public class main_system extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel dashboard;
	private JPanel inventory;
	private JPanel menu;
	private JPanel panel_3;
	private JButton homemini;
	private JButton logoutmini;
	private JButton optionmini;
	private JButton reportsmini;
	private JButton purchasemini;
	private JButton inventorymini;
	private JButton menu_button;
	private JButton btnNewButton1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JPanel panel_1;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton button;
	private JPanel purchase;
	private JPanel reports;
	private JTextField DESCRIPTION;
	private JTextField ITEMCODE;
	private JTextField RIM;
	private JTextField WIDTH;
	private JTextField SRP;
	private JTextField STOCK;
	private JTable INVENTORYTABLE;
	private JTextField SEARCHFIELD;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JComboBox CATEGORY;
	private JComboBox PATTERN;
	private JTable itemstable;
	private JTextField SUBTOTAL;
	private JTextField totalnumber;
	private JTextField VATSALES;
	private JTextField CHANGE;
	private JTextField CASH;
	private JTextField TAX;
	private JTextField AMOUNT_DUE;
	private JTable postable;
	private JScrollPane scrollPane_2;
	private JTextField dt;
	private JButton INSERTPOS;
	private JButton editpos;
	private JButton REMOVEPOS;
	private JButton REMOVEALL;
	private JTextField FULLNAME;
	private JLabel label_18;
	private JTable REPORTSTABLE;
	private JScrollPane scrollPane_3;
	private JLabel totalsalesreports;
	private JTextField SEARCHREPORTS;
	private JButton INVENTORY;
	private JButton button_2;
	private JLabel lblNewLabel_1;
	private JPanel panel_13;
	private JPanel panel_11;
	private JLabel PRODS;
	private JLabel SALS;
	private JLabel STCK;
	private JLabel label_22;
	private JLabel label_24;
	private JLabel label_25;
	private JPanel panel_10;
	private JScrollPane scrollPane_1;
	private JButton button_6;
	private JTextField SEARCHPURCHASE;
	private JTextField SERIES;
	private JTextField LOADINDEX;
	private JLabel label_21;
	private JLabel label_26;
	private JTextField SPEEDSYMBOL;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					main_system frame = new main_system();
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
	public main_system() {
		setUndecorated(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.ORANGE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		menu = new JPanel();
		menu.setBounds(0, 0, 167, 495);
		menu.setBackground(Color.DARK_GRAY);
		contentPane.add(menu);
		menu.setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 135, 167, 302);
		menu.add(panel);
		
		INVENTORY = new JButton("   Inventory");
		INVENTORY.setActionCommand("Inventory");
		INVENTORY.setHorizontalAlignment(SwingConstants.LEFT);
		INVENTORY.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\2703076-24 (1).png"));
		INVENTORY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(inventory);
				inventory.setVisible(true);
				panel_1.setBounds(0, 71, 167, 26);
			}
		});
		INVENTORY.setForeground(Color.WHITE);
		INVENTORY.setContentAreaFilled(false);
		INVENTORY.setBorderPainted(false);
		INVENTORY.setBounds(-12, 71, 179, 26);
		panel.add(INVENTORY);
		
		button = new JButton(" Purchase");
		button.setActionCommand("Purchase");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\2703080-24 (1).png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(purchase);
				purchase.setVisible(true);
				panel_1.setBounds(0, 108, 167, 26);
			}
		});
		button.setForeground(Color.WHITE);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(-12, 108, 179, 26);
		panel.add(button);
		
		button_2 = new JButton(" Reports");
		button_2.setHorizontalAlignment(SwingConstants.LEFT);
		button_2.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\2703075-24 (1).png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(reports);
				reports.setVisible(true);
				panel_1.setBounds(0,145, 167, 26);
				VIEW_REPORTS_BACKEND asda = new VIEW_REPORTS_BACKEND(REPORTSTABLE);
				VIEW_TOTAL_REPORTS asfasasd = new VIEW_TOTAL_REPORTS(totalsalesreports);
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(-12, 145, 169, 26);
		panel.add(button_2);
		
		
		
		JButton DASHBOARD = new JButton("Dashboard");
		DASHBOARD.setHorizontalAlignment(SwingConstants.LEFT);
		DASHBOARD.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\4552610-24.png"));
		DASHBOARD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchpanel(dashboard);
				dashboard.setVisible(true);
				panel_1.setBounds(0, 34, 167, 26);
				
			}
		});
		DASHBOARD.setForeground(Color.WHITE);
		DASHBOARD.setContentAreaFilled(false);
		DASHBOARD.setBorderPainted(false);
		DASHBOARD.setBounds(-12, 34, 179, 26);
		panel.add(DASHBOARD);
		
		JButton button_4 = new JButton(" Log Out");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Do you want to Exit?");
			      switch (result) {
			         case JOptionPane.YES_OPTION:
			         break;
			         case JOptionPane.NO_OPTION:
			         break;
			      }
			      if(result==JOptionPane.YES_OPTION) {
			      dispose();
			      }
				else{
					
				}
			}
		});
		button_4.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\763291-24 (1).png"));
		button_4.setHorizontalAlignment(SwingConstants.LEFT);
		button_4.setForeground(Color.WHITE);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(-12, 182, 169, 26);
		panel.add(button_4);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 34, 167, 26);
		panel.add(panel_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 22, 167, 133);
		menu.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\speed-removebg-preview (1).png"));
		lblNewLabel_2.setBounds(0, 0, 167, 108);
		panel_8.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 1061, 23);
		header.setLayout(null);
		header.setBackground(new Color(255, 140, 0));
		contentPane.add(header);
		
		menu_button = new JButton("");
		menu_button.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\2738305-20 (1).png"));
		
		menu_button.setBackground(new Color(255, 250, 250));
		menu_button.setBounds(167, 0, 29, 23);
		header.add(menu_button);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\iconfinder_error_1646012.png"));
		lblNewLabel_1.setBounds(1037, 0, 24, 23);
		header.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Speed Line Marketing");
		lblNewLabel_3.setBounds(860, 0, 167, 23);
		header.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel footer = new JPanel();
		footer.setBounds(0, 494, 1061, 23);
		footer.setLayout(null);
		footer.setBackground(new Color(255, 140, 0));
		contentPane.add(footer);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(33, 21, 1028, 474);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		String sortby[] = {"Item Code", "Category",
				   "price" , "stock" , "supplier", "Capacity" ,"Brand Name",
				   "Product Name"};
		
		String category[] = {"SCOOTER",
		 		"STREET", 
		 		"OFF ROAD"
		 		};
		
		String supp[] = {"CM521", "C6513", "C6525","C6577" , "C6501"};
		
		menu_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				menu();
			}
		});
		javax.swing.Timer tolkak = new javax.swing.Timer(1000, new ClockListener());
	    tolkak.start();
		
		purchase = new JPanel();
		purchase.setLayout(null);
		purchase.setBackground(SystemColor.menu);
		purchase.setBounds(0, 0, 1018, 474);
		layeredPane.add(purchase);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(144, 11, 629, 452);
		purchase.add(panel_5);
		
		JLabel label_2 = new JLabel("Purchase");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		label_2.setBounds(10, 0, 301, 48);
		panel_5.add(label_2);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setBackground(new Color(255, 255, 255));
		scrollPane_1.setBounds(10, 59, 612, 165);
		panel_5.add(scrollPane_1);
		
		itemstable = new JTable();
		itemstable.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setViewportView(itemstable);
		VIEW_INVENTORY_BACKEND nsd = new VIEW_INVENTORY_BACKEND(itemstable);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_2.setBounds(10, 260, 609, 181);
		panel_5.add(scrollPane_2);
		
		postable = new JTable();
		postable.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_2.setViewportView(postable);
		panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(Color.BLACK));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(775, 11, 243, 452);
		purchase.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel label_11 = new JLabel("Sub Total");
		label_11.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		label_11.setBounds(10, 21, 127, 14);
		panel_10.add(label_11);
		
		SUBTOTAL = new JTextField();
		SUBTOTAL.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		SUBTOTAL.setEditable(false);
		SUBTOTAL.setDisabledTextColor(Color.WHITE);
		SUBTOTAL.setColumns(10);
		SUBTOTAL.setBackground(Color.WHITE);
		SUBTOTAL.setBounds(123, 11, 112, 34);
		panel_10.add(SUBTOTAL);
		
		JLabel label_12 = new JLabel("Total No. of Items");
		label_12.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		label_12.setBounds(10, 60, 112, 14);
		panel_10.add(label_12);
		
		totalnumber = new JTextField();
		totalnumber.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		totalnumber.setEditable(false);
		totalnumber.setColumns(10);
		totalnumber.setBounds(123, 54, 112, 20);
		panel_10.add(totalnumber);
		
		JLabel label_13 = new JLabel("VAT Sales");
		label_13.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		label_13.setBounds(10, 85, 83, 14);
		panel_10.add(label_13);
		
		VATSALES = new JTextField();
		VATSALES.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		VATSALES.setEditable(false);
		VATSALES.setColumns(10);
		VATSALES.setBounds(123, 82, 112, 20);
		panel_10.add(VATSALES);
		
		JLabel label_14 = new JLabel("12% VAT Amt");
		label_14.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		label_14.setBounds(10, 110, 112, 14);
		panel_10.add(label_14);
		
		JLabel label_15 = new JLabel("Amount Due");
		label_15.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		label_15.setBounds(10, 138, 112, 14);
		panel_10.add(label_15);
		
		JLabel label_16 = new JLabel("CASH");
		label_16.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		label_16.setBounds(10, 180, 83, 14);
		panel_10.add(label_16);
		
		JLabel label_17 = new JLabel("Change");
		label_17.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		label_17.setBounds(10, 205, 83, 14);
		panel_10.add(label_17);
		
		CHANGE = new JTextField();
		CHANGE.setForeground(Color.BLACK);
		CHANGE.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		CHANGE.setEditable(false);
		CHANGE.setColumns(10);
		CHANGE.setBounds(123, 202, 112, 20);
		panel_10.add(CHANGE);
		
		CASH = new JTextField();
		CASH.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		CASH.setColumns(10);
		CASH.setBounds(123, 177, 112, 20);
		panel_10.add(CASH);
		
		JButton PAYMENT = new JButton("Payment");
		PAYMENT.setBackground(Color.CYAN);
		PAYMENT.setBounds(36, 274, 184, 23);
		panel_10.add(PAYMENT);
		
		
		
		TAX = new JTextField();
		TAX.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		TAX.setEditable(false);
		TAX.setColumns(10);
		TAX.setBounds(123, 107, 112, 20);
		panel_10.add(TAX);
		
		AMOUNT_DUE = new JTextField();
		AMOUNT_DUE.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		AMOUNT_DUE.setEditable(false);
		AMOUNT_DUE.setColumns(10);
		AMOUNT_DUE.setBounds(123, 135, 112, 20);
		panel_10.add(AMOUNT_DUE);
		
		VIEW_POS_BACKEND AD = new VIEW_POS_BACKEND(postable);
		
		//Date date = new Date(); //declare this above;
		
		dt = new JTextField();
		dt.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		dt.setBorder(null);
		//dt.setText(date.toString()); //set this inside you class.
		
		dt.setBounds(483, 38, 136, 20);
		panel_5.add(dt);
		dt.setColumns(10);
		
		CASH_CART_BACKEND AsD = new CASH_CART_BACKEND( CASH, AMOUNT_DUE, CHANGE);
		TOTAL_AMOUNT_BACKEND aff = new TOTAL_AMOUNT_BACKEND( SUBTOTAL,totalnumber, VATSALES, TAX, AMOUNT_DUE);
		
		INSERTPOS = new JButton("Buy");
		INSERTPOS.setBounds(18, 336, 104, 29);
		panel_10.add(INSERTPOS);
		
				TO_POS_BACKEND sadad = new TO_POS_BACKEND( INSERTPOS,postable,itemstable, 
														   SUBTOTAL,totalnumber,VATSALES,
														   TAX,  AMOUNT_DUE, AMOUNT_DUE,
														   CHANGE, dt);
				
		
		
		editpos = new JButton("Update");
		
			
			
			
			
			editpos.setBounds(131, 336, 104, 29);
			panel_10.add(editpos);
			
			
			
			REMOVEPOS = new JButton("Remove");
			
			REMOVE_POS_BACKEND asdfda = new REMOVE_POS_BACKEND( REMOVEPOS, postable,itemstable);
			
				REMOVEPOS.setBounds(18, 379, 104, 29);
				panel_10.add(REMOVEPOS);
				
				REMOVEALL = new JButton("Remove All");
				
						REMOVEALL_POS_BACKEND asdfdada = new REMOVEALL_POS_BACKEND(  postable, REMOVEALL, itemstable);
						
								REMOVEALL.setBounds(131, 379, 104, 29);
								panel_10.add(REMOVEALL);
								
								label_18 = new JLabel("CustomerName");
								label_18.setFont(new Font("Segoe Print", Font.PLAIN, 11));
								label_18.setBounds(10, 236, 112, 14);
								panel_10.add(label_18);
								
								FULLNAME = new JTextField();
								FULLNAME.setFont(new Font("Segoe Print", Font.PLAIN, 11));
								FULLNAME.setColumns(10);
								FULLNAME.setBounds(123, 233, 112, 20);
								panel_10.add(FULLNAME);
								
								UPDATE_POS_BACKEND sadsad = new UPDATE_POS_BACKEND(editpos,
												    postable,
												    itemstable,
												    SUBTOTAL,
												    totalnumber,
												    VATSALES,
												    TAX,
												    AMOUNT_DUE,
												    CASH,
												    CHANGE,
												    dt);
								
								POS_TO_TRANSACTION_BACKEND asdasj = new POS_TO_TRANSACTION_BACKEND( PAYMENT,SUBTOTAL,totalnumber,
									    VATSALES,TAX,AMOUNT_DUE, dt,CASH, CHANGE, FULLNAME,postable);
								
								button_6 = new JButton("");
								button_6.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\iconfinder_00-ELASTOFONT-STORE-READY_search_2703065 (1).png"));
								button_6.setBorder(new LineBorder(new Color(0, 0, 0)));
								button_6.setBackground(Color.WHITE);
								button_6.setBounds(585, 235, 34, 23);
								panel_5.add(button_6);
								
								SEARCHPURCHASE = new JTextField();
								SEARCHPURCHASE.setColumns(10);
								SEARCHPURCHASE.setBorder(new LineBorder(Color.BLACK));
								SEARCHPURCHASE.setBounds(383, 235, 204, 23);
								panel_5.add(SEARCHPURCHASE);
								
								SEARCH_PURCHASE ASS=new SEARCH_PURCHASE( SEARCHPURCHASE, itemstable);
								switchpanel(purchase);
								purchase.setVisible(false);
		
		inventory = new JPanel();
		inventory.setLayout(null);
		inventory.setBackground(SystemColor.menu);
		inventory.setBounds(0, 0, 1018, 474);
		layeredPane.add(inventory);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(144, 11, 874, 452);
		inventory.add(panel_4);
		
		JLabel label_1 = new JLabel("Inventory");
		label_1.setVerifyInputWhenFocusTarget(false);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		label_1.setBounds(358, 0, 301, 52);
		panel_4.add(label_1);
		
		JLabel lblNewLabel = new JLabel("Item Code");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 84, 77, 20);
		panel_4.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("RIM");
		label_4.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_4.setBounds(10, 109, 124, 20);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("Section Width");
		label_5.setBounds(10, 134, 102, 20);
		label_5.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("Category");
		label_6.setBounds(311, 104, 102, 20);
		label_6.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("SRP");
		label_7.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_7.setBounds(311, 129, 62, 20);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("Stock");
		label_8.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_8.setBounds(311, 154, 56, 20);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("Item Description");
		label_9.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_9.setBounds(311, 79, 155, 20);
		panel_4.add(label_9);
		
		DESCRIPTION = new JTextField();
		DESCRIPTION.setBorder(new LineBorder(new Color(105, 105, 105)));
		DESCRIPTION.setHorizontalAlignment(SwingConstants.RIGHT);
		DESCRIPTION.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		DESCRIPTION.setBounds(423, 79, 184, 20);
		panel_4.add(DESCRIPTION);
		DESCRIPTION.setColumns(10);
		
		ITEMCODE = new JTextField();
		ITEMCODE.setForeground(Color.BLACK);
		ITEMCODE.setBorder(new LineBorder(new Color(105, 105, 105)));
		ITEMCODE.setHorizontalAlignment(SwingConstants.RIGHT);
		ITEMCODE.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		ITEMCODE.setColumns(10);
		ITEMCODE.setBounds(122, 81, 184, 20);
		panel_4.add(ITEMCODE);
		
		SPEEDSYMBOL = new JTextField();
		SPEEDSYMBOL.setHorizontalAlignment(SwingConstants.RIGHT);
		SPEEDSYMBOL.setForeground(SystemColor.controlDkShadow);
		SPEEDSYMBOL.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		SPEEDSYMBOL.setColumns(10);
		SPEEDSYMBOL.setBorder(new LineBorder(new Color(105, 105, 105)));
		SPEEDSYMBOL.setBounds(752, 129, 112, 20);
		panel_4.add(SPEEDSYMBOL);
		
		RIM = new JTextField();
		RIM.setBorder(new LineBorder(new Color(105, 105, 105)));
		RIM.setForeground(new Color(0, 0, 0));
		RIM.setHorizontalAlignment(SwingConstants.RIGHT);
		RIM.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		RIM.setColumns(10);
		RIM.setBounds(122, 106, 184, 20);
		panel_4.add(RIM);
		
		WIDTH = new JTextField();
		WIDTH.setBorder(new LineBorder(new Color(105, 105, 105)));
		WIDTH.setForeground(new Color(105, 105, 105));
		WIDTH.setHorizontalAlignment(SwingConstants.RIGHT);
		WIDTH.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		WIDTH.setColumns(10);
		WIDTH.setBounds(122, 131, 184, 20);
		panel_4.add(WIDTH);
		
		SRP = new JTextField();
		SRP.setBorder(new LineBorder(new Color(105, 105, 105)));
		SRP.setHorizontalAlignment(SwingConstants.RIGHT);
		SRP.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		SRP.setColumns(10);
		SRP.setBounds(423, 129, 184, 20);
		panel_4.add(SRP);
		
		STOCK = new JTextField();
		STOCK.setBorder(new LineBorder(new Color(105, 105, 105)));
		STOCK.setHorizontalAlignment(SwingConstants.RIGHT);
		STOCK.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		STOCK.setColumns(10);
		STOCK.setBounds(423, 154, 184, 20);
		panel_4.add(STOCK);
		

		SERIES = new JTextField();
		SERIES.setHorizontalAlignment(SwingConstants.RIGHT);
		SERIES.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		SERIES.setColumns(10);
		SERIES.setBorder(new LineBorder(new Color(105, 105, 105)));
		SERIES.setBounds(752, 79, 112, 20);
		panel_4.add(SERIES);
		
		LOADINDEX = new JTextField();
		LOADINDEX.setHorizontalAlignment(SwingConstants.RIGHT);
		LOADINDEX.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		LOADINDEX.setColumns(10);
		LOADINDEX.setBorder(new LineBorder(new Color(105, 105, 105)));
		LOADINDEX.setBounds(752, 104, 112, 20);
		panel_4.add(LOADINDEX);
		
		JButton INSERT = new JButton("INSERT");
		INSERT.setForeground(new Color(255, 255, 255));
		INSERT.setBackground(new Color(0, 204, 0));
		INSERT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				INVENTORY_BACKEND inventorybackend = new INVENTORY_BACKEND(  ITEMCODE,
						   RIM,WIDTH,PATTERN,DESCRIPTION,CATEGORY,SRP,STOCK,SERIES,
						   LOADINDEX,SPEEDSYMBOL,INVENTORYTABLE);
				VIEW_INVENTORY_BACKEND nsd = new VIEW_INVENTORY_BACKEND(itemstable);
			}
		});
		
		INSERT.setBounds(10, 194, 89, 23);
		panel_4.add(INSERT);
		
		JButton button_1 = new JButton("UPDATE");
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(255, 102, 0));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UPDATE_INVENTORY_BACKEND ssd = new UPDATE_INVENTORY_BACKEND(  ITEMCODE,
						   RIM,WIDTH,PATTERN,DESCRIPTION,CATEGORY,SRP,STOCK,SERIES,
						   LOADINDEX,SPEEDSYMBOL,INVENTORYTABLE);
			}
		});
		button_1.setBounds(103, 194, 89, 23);
		panel_4.add(button_1);
		
		JButton button_3 = new JButton("DELETE");
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(255, 0, 0));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DELETE_INVENTORY_BACKEND del = new DELETE_INVENTORY_BACKEND(ITEMCODE,
						   RIM,
						   WIDTH,
						    PATTERN,
						   DESCRIPTION,
						    CATEGORY,
						   SRP,
						   STOCK,
						   SERIES,
						   LOADINDEX,
						   SPEEDSYMBOL,
						   INVENTORYTABLE);
			}
		});
		button_3.setBounds(196, 194, 89, 23);
		panel_4.add(button_3);
		
		JButton button_5 = new JButton("RESET");
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBackground(new Color(0, 0, 102));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RESET RES = new RESET(  ITEMCODE,
						   RIM,
						   WIDTH,
						    PATTERN,
						   DESCRIPTION,
						    CATEGORY,
						   SRP,
						   STOCK,
						   SERIES,
						   LOADINDEX,
						   SPEEDSYMBOL);
			}
		});
		button_5.setBounds(291, 194, 89, 23);
		panel_4.add(button_5);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Javanese Text", Font.PLAIN, 12));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 224, 854, 217);
		panel_4.add(scrollPane);
		
		INVENTORYTABLE = new JTable();
		INVENTORYTABLE.setBorder(new LineBorder(new Color(0, 0, 0)));
		INVENTORYTABLE.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(INVENTORYTABLE);
		
		SEARCHFIELD = new JTextField();
		SEARCHFIELD.setBorder(new LineBorder(new Color(105, 105, 105)));
		SEARCHFIELD.setHorizontalAlignment(SwingConstants.RIGHT);
		SEARCHFIELD.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		SEARCHFIELD.setColumns(10);
		SEARCHFIELD.setBounds(477, 197, 222, 20);
		panel_4.add(SEARCHFIELD);
		
		SEARCH_INVENTORY_BACKEND f = new SEARCH_INVENTORY_BACKEND( SEARCHFIELD, INVENTORYTABLE);
		
		comboBox = new JComboBox(sortby);
		comboBox.setBorder(new LineBorder(new Color(171, 173, 179)));
		comboBox.setBackground(new Color(255, 250, 250));
		comboBox.setBounds(709, 197, 155, 20);
		panel_4.add(comboBox);
		
		SORTBY ddaad = new SORTBY( comboBox, INVENTORYTABLE);
		
		
		CATEGORY = new JComboBox(category);
		CATEGORY.setMaximumRowCount(9);
		CATEGORY.setBackground(new Color(255, 255, 255));
		CATEGORY.setBorder(new LineBorder(new Color(105, 105, 105)));
		CATEGORY.setBounds(423, 104, 184, 20);
		panel_4.add(CATEGORY);
		
		PATTERN = new JComboBox(supp);
		PATTERN.setBorder(new LineBorder(new Color(105, 105, 105)));
		PATTERN.setBackground(Color.WHITE);
		PATTERN.setBounds(122, 153, 184, 20);
		panel_4.add(PATTERN);
		
		JLabel label_10 = new JLabel("Pattern");
		label_10.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_10.setBounds(10, 156, 102, 20);
		panel_4.add(label_10);
		TABLETOTXT BB = new TABLETOTXT(  ITEMCODE,
				   RIM,
				   WIDTH,
				    PATTERN,
				   DESCRIPTION,
				    CATEGORY,
				   SRP,
				   STOCK,
				   SERIES,
				   LOADINDEX,
				   SPEEDSYMBOL,
				   INVENTORYTABLE);
		
		VIEW_INVENTORY_BACKEND nd = new VIEW_INVENTORY_BACKEND(INVENTORYTABLE);
		
		JLabel label_19 = new JLabel("Series");
		label_19.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_19.setBounds(617, 79, 102, 20);
		panel_4.add(label_19);
		
		
		label_21 = new JLabel("Load Index");
		label_21.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_21.setBounds(617, 109, 89, 20);
		panel_4.add(label_21);
		
		label_26 = new JLabel("Speed Symbol");
		label_26.setFont(new Font("Javanese Text", Font.PLAIN, 14));
		label_26.setBounds(617, 129, 118, 20);
		panel_4.add(label_26);
		
		
		
		switchpanel(inventory);
		inventory.setVisible(false);
		
		dashboard = new JPanel();
		dashboard.setBackground(UIManager.getColor("Button.background"));
		dashboard.setBounds(0, 0, 1018, 474);
		layeredPane.add(dashboard);
		dashboard.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(144, 11, 874, 452);
		dashboard.add(panel_2);
		
		JLabel label = new JLabel("Dashboard");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		label.setBounds(10, 1, 301, 48);
		panel_2.add(label);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(192, 192, 192));
		panel_7.setBounds(0, 45, 184, 2);
		panel_2.add(panel_7);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 102, 51));
		panel_12.setBounds(30, 87, 224, 84);
		panel_2.add(panel_12);
		panel_12.setLayout(null);
		
		PRODS = new JLabel("New label");
		PRODS.setForeground(new Color(255, 255, 255));
		PRODS.setHorizontalAlignment(SwingConstants.CENTER);
		PRODS.setFont(new Font("Javanese Text", Font.PLAIN, 22));
		PRODS.setBounds(-1, 1, 225, 45);
		panel_12.add(PRODS);
		
		label_25 = new JLabel("Products");
		label_25.setForeground(new Color(255, 255, 255));
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		label_25.setBounds(-1, 36, 225, 56);
		panel_12.add(label_25);
		
		panel_13 = new JPanel();
		panel_13.setBackground(new Color(0, 153, 153));
		panel_13.setBounds(617, 85, 226, 87);
		panel_2.add(panel_13);
		panel_13.setLayout(null);
		
		STCK = new JLabel("New label");
		STCK.setForeground(new Color(255, 255, 255));
		STCK.setHorizontalAlignment(SwingConstants.CENTER);
		STCK.setFont(new Font("Javanese Text", Font.PLAIN, 22));
		STCK.setBounds(-1, 1, 224, 52);
		panel_13.add(STCK);
		
		
		
		label_22 = new JLabel("Stocks");
		label_22.setForeground(new Color(255, 255, 255));
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		label_22.setBounds(1, 34, 225, 64);
		panel_13.add(label_22);
		
		panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 153, 204));
		panel_11.setBounds(323, 85, 224, 89);
		panel_2.add(panel_11);
		panel_11.setLayout(null);
		
		SALS = new JLabel("New label");
		SALS.setForeground(new Color(255, 255, 255));
		SALS.setHorizontalAlignment(SwingConstants.CENTER);
		SALS.setFont(new Font("Javanese Text", Font.PLAIN, 22));
		SALS.setBounds(0, 0, 224, 57);
		panel_11.add(SALS);
		
		label_24 = new JLabel("Total Sales");
		label_24.setForeground(new Color(255, 255, 255));
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Javanese Text", Font.PLAIN, 20));
		label_24.setBounds(-1, 34, 226, 68);
		panel_11.add(label_24);
		VIEW_DASHBOARD sdgsd = new VIEW_DASHBOARD( PRODS,  SALS, STCK);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\speed-removebg-preview (2).png"));
		lblNewLabel_4.setBounds(30, 192, 813, 249);
		panel_2.add(lblNewLabel_4);
		switchpanel(dashboard);
		
		reports = new JPanel();
		reports.setLayout(null);
		reports.setBackground(SystemColor.menu);
		
	
		reports.setBounds(0, 0, 1018, 474);
		layeredPane.add(reports);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(144, 11, 874, 452);
		reports.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_3 = new JLabel("Reports");
		label_3.setBounds(10, 11, 301, 48);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		panel_6.add(label_3);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_3.setBounds(10, 117, 854, 324);
		panel_6.add(scrollPane_3);
		
		REPORTSTABLE = new JTable();
		REPORTSTABLE.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_3.setViewportView(REPORTSTABLE);
		VIEW_REPORTS_BACKEND asda = new VIEW_REPORTS_BACKEND(REPORTSTABLE);
		
		totalsalesreports = new JLabel("Total Sales: ");
		totalsalesreports.setFont(new Font("Javanese Text", Font.PLAIN, 23));
		totalsalesreports.setBounds(568, 82, 296, 32);
		panel_6.add(totalsalesreports);
		//VIEW_REPORTS_BACKEND afa = new VIEW_REPORTS_BACKEND(JTable REPORTSTABLE);
		VIEW_TOTAL_REPORTS asfasasd = new VIEW_TOTAL_REPORTS(totalsalesreports);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\iconfinder_00-ELASTOFONT-STORE-READY_search_2703065 (1).png"));
		btnNewButton.setBounds(212, 83, 34, 23);
		panel_6.add(btnNewButton);
		
		SEARCHREPORTS = new JTextField();
		SEARCHREPORTS.setBorder(new LineBorder(Color.BLACK));
		SEARCHREPORTS.setBounds(10, 83, 204, 23);
		panel_6.add(SEARCHREPORTS);
		SEARCHREPORTS.setColumns(10);
		SEARCH_REPORTS AS=new SEARCH_REPORTS( SEARCHREPORTS, REPORTSTABLE);
		VIEW_REPORTS_BACKEND asdsa = new VIEW_REPORTS_BACKEND(REPORTSTABLE);
		switchpanel(reports);
		reports.setVisible(false);
		reports.setVisible(true);
	}
	
	private void menu() {
		menu.setBounds(0, 0, 29, 495);
		menu_button.setVisible(false);
		panel_2.setBounds(10, 11, 1008, 452);
		panel_4.setBounds(10, 11, 1008, 452);
		panel_5.setBounds(10, 11, 750, 452);
		panel_6.setBounds(10, 11, 1008, 452);
	    comboBox.setBounds(845, 197, 155, 20);
	    scrollPane.setBounds(10, 224, 990, 217);
	    scrollPane_3.setBounds(10, 117, 985, 324);
	    
	    scrollPane_1.setBounds(10, 59, 730, 165);
	    scrollPane_2.setBounds(10, 260, 730, 181);
	    dt.setBounds(483, 38, 250, 20);
	    totalsalesreports.setBounds(700, 82, 296, 32);
		
		JButton minibutton = new JButton("");
		minibutton.setIcon(new ImageIcon("C:\\Users\\Anac\\Desktop\\newprojectama\\Inventory\\img\\2738305-20 (1).png"));
		minibutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				minibutton.setVisible(false);
				menu.setBounds(0, 0, 167, 495);
				menu_button.setVisible(true);
				panel_2.setBounds(144, 11, 874, 452);
				panel_4.setBounds(144, 11, 874, 452);
				panel_5.setBounds(144, 11, 629, 452);
				panel_6.setBounds(144, 11, 874, 452);
				scrollPane_3.setBounds(10, 117, 854, 324);
				scrollPane.setBounds(10, 224, 854, 217);
				comboBox.setBounds(709, 197, 155, 20);
				scrollPane_1.setBounds(10, 59, 612, 165);
				scrollPane_2.setBounds(10, 260, 609, 181);
				dt.setBounds(483, 38, 136, 20);
				totalsalesreports.setBounds(568, 82, 296, 32);
			}
		});
		minibutton.setBackground(new Color(255, 250, 250));
		minibutton.setBounds(0, 0, 29, 23);
		menu.add(minibutton);
		
	}
	
	public void switchpanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	class ClockListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");  
    		   LocalDateTime now = LocalDateTime.now();  
    		   dt.setText(dtf.format(now)); 
    		   
    	}
    }
}
