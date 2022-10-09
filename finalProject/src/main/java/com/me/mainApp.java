package com.me;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import com.haowei.dao.CounsellorDao;
import com.haowei.pojo.Counsellor;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class mainApp {

	private JFrame frame;
	private JTable tblCounsellor;
	private JTextField txtIntroduction;
	private JTextField txtCustomerID;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtBirthday;
	private JTextField txtPrice;
	private JTextField txtYearStarted;
	private Object[][] tableData = null;
	private String[] columnName = null;
	private CounsellorDao dao = new CounsellorDao();
	private JLabel lblState;
	private int selectedRow;
	private int selectedColumn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainApp window = new mainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1280, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBounds(10, 10, 1246, 55);
		pnlTitle.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		frame.getContentPane().add(pnlTitle);
		pnlTitle.setLayout(new BorderLayout(0, 0));

		JLabel lblTitle = new JLabel("Counsellor Management System");
		pnlTitle.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));

		JPanel pnlContent = new JPanel();
		pnlContent.setBounds(10, 75, 1246, 578);
		pnlContent.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		frame.getContentPane().add(pnlContent);
		pnlContent.setLayout(null);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setBounds(10, 10, 286, 558);
		pnlLeft.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlLeft.setLayout(null);
		pnlContent.add(pnlLeft);

		// ###### Labels ##########
		JLabel lblCounsellorID = new JLabel("Counsellor ID");
		lblCounsellorID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCounsellorID.setBounds(10, 10, 129, 30);
		pnlLeft.add(lblCounsellorID);

		JLabel lblFName = new JLabel("First Name");
		lblFName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFName.setBounds(10, 50, 129, 30);
		pnlLeft.add(lblFName);

		JLabel lblLName = new JLabel("Last Name");
		lblLName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLName.setBounds(10, 90, 129, 30);
		pnlLeft.add(lblLName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 130, 129, 30);
		pnlLeft.add(lblEmail);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(10, 170, 129, 30);
		pnlLeft.add(lblPhone);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBirthday.setBounds(10, 210, 129, 30);
		pnlLeft.add(lblBirthday);

		JLabel lblPrice = new JLabel("Price / Session");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(10, 250, 139, 30);
		pnlLeft.add(lblPrice);

		JLabel lblYearStarted = new JLabel("Year Started");
		lblYearStarted.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYearStarted.setBounds(10, 290, 129, 30);
		pnlLeft.add(lblYearStarted);

		JLabel lblIntroduction = new JLabel("Introduction");
		lblIntroduction.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntroduction.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIntroduction.setBounds(10, 330, 129, 30);
		pnlLeft.add(lblIntroduction);

		// #### Text Field Start #########
		txtIntroduction = new JTextField();
		txtIntroduction.setHorizontalAlignment(SwingConstants.LEFT);
		txtIntroduction.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtIntroduction.setBounds(10, 366, 266, 102);
		pnlLeft.add(txtIntroduction);
		txtIntroduction.setColumns(20);

		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtCustomerID.setBounds(149, 10, 127, 30);
		pnlLeft.add(txtCustomerID);
		txtCustomerID.setColumns(10);

		txtFname = new JTextField();
		txtFname.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtFname.setColumns(10);
		txtFname.setBounds(149, 50, 127, 30);
		pnlLeft.add(txtFname);

		txtLname = new JTextField();
		txtLname.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtLname.setColumns(10);
		txtLname.setBounds(149, 90, 127, 30);
		pnlLeft.add(txtLname);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(149, 130, 127, 30);
		pnlLeft.add(txtEmail);

		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPhone.setColumns(10);
		txtPhone.setBounds(149, 170, 127, 30);
		pnlLeft.add(txtPhone);

		txtBirthday = new JTextField();
		txtBirthday.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(149, 210, 127, 30);
		pnlLeft.add(txtBirthday);

		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPrice.setColumns(10);
		txtPrice.setBounds(149, 250, 127, 30);
		pnlLeft.add(txtPrice);

		txtYearStarted = new JTextField();
		txtYearStarted.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtYearStarted.setColumns(10);
		txtYearStarted.setBounds(149, 290, 127, 30);
		pnlLeft.add(txtYearStarted);
		// #### Text Field ends ########

		// ##### Update Buttons ########
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				update();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(10, 518, 129, 30);
		pnlLeft.add(btnUpdate);

		// ######## Search Button, search by ID #######
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchById();
			}
		});
		btnSearch.setBounds(10, 478, 129, 30);
		pnlLeft.add(btnSearch);

		// ###### Insert Button #######
		JButton btnInsert = new JButton("Insert");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert();
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBounds(147, 478, 129, 30);
		pnlLeft.add(btnInsert);

		// ######## Delete Button, delete by id ##########
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteById();
			}
		});

		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(147, 518, 129, 30);
		pnlLeft.add(btnDelete);

		// ######### Clear Button ##########
		JButton btnClear = new JButton("Clear All");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
			}
		});

		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(147, 330, 129, 30);
		pnlLeft.add(btnClear);

		// Setting column name
		columnName = new String[] { "counsellorID", "fname", "lname", "email", "phone", "birthday", "pricePerSession",
				"yearStarted", "Introduction" };
		
		//#### Tabel start here ###########
		JScrollPane scrllPnTable = new JScrollPane();
		scrllPnTable.setBounds(306, 10, 930, 508);
		pnlContent.add(scrllPnTable);

		tblCounsellor = new JTable();
		tblCounsellor.setCellSelectionEnabled(true);
		tblCounsellor.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblCounsellor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrllPnTable.setViewportView(tblCounsellor);
		
		//#### Add a mouse listener to the table to get selected row and column
		tblCounsellor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Get click source, convert it to a JTable obj
				JTable target = (JTable) e.getSource();
				// Get the selected row index
				selectedRow = target.getSelectedRow();
			    selectedColumn = target.getSelectedColumn();
			}
		});
		
		JPanel pnlState = new JPanel();
		pnlState.setBounds(306, 528, 702, 40);
		pnlContent.add(pnlState);
		pnlState.setLayout(new BorderLayout(0, 0));
		
		lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblState.setVerticalAlignment(SwingConstants.TOP);
		pnlState.add(lblState);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		btnReset.setBounds(1132, 528, 104, 40);
		pnlContent.add(btnReset);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				load();
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLoad.setBounds(1018, 528, 104, 40);
		pnlContent.add(btnLoad);

		refreshTable();
	}

	public void refreshTable() {
		//DefaultTableModel tabelModel = new DefaultTableModel(getAllData(), columnName) {};
		tblCounsellor.setModel(new DefaultTableModel(
				getAllData(), columnName
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	public Object[][] getAllData() {
		List<Counsellor> list = new ArrayList<Counsellor>();
		try {
			// Get all rows
			list = dao.findAll();
			tableData = new Object[list.size()][columnName.length]; // row num = Counsellor Obj num
			// looping times = row num = list.size()
			for (int i = 0; i < list.size(); i++) {
				tableData[i][0] = list.get(i).getCounsellorID();
				tableData[i][1] = list.get(i).getFname();
				tableData[i][2] = list.get(i).getLname();
				tableData[i][3] = list.get(i).getEmail();
				tableData[i][4] = list.get(i).getPhone();
				tableData[i][5] = list.get(i).getDob();
				tableData[i][6] = list.get(i).getPricePerSession();
				tableData[i][7] = list.get(i).getYearStarted();
				tableData[i][8] = list.get(i).getIntroduction();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
		lblState.setText(list.size() + " column(s) get");
		return tableData;
	}

	public void clear() {
		txtCustomerID.setText(null);
		txtLname.setText(null);
		txtFname.setText(null);
		txtEmail.setText(null);
		txtPhone.setText(null);
		txtBirthday.setText(null);
		txtPrice.setText(null);
		txtYearStarted.setText(null);
		txtIntroduction.setText(null);
	}

	public void searchById() {
		// Get the id
		String id = txtCustomerID.getText();
		System.out.println(id);
		// Create a counsellor to store the result
		Counsellor c = new Counsellor();
		// Create a list to store the counsellor obj, in order to insert to the tableTable
		List<Counsellor> list = new ArrayList<Counsellor>();
		tableData = new Object[1][columnName.length]; // 1*13 array

		try {
			c = dao.findById(Integer.parseInt(id));
			list.add(c); // Add the retrieved data to the list
			// Add the list data to the table
			// Set the cells accordingly
			tableData[0][0] = list.get(0).getCounsellorID();
			tableData[0][1] = list.get(0).getFname();
			tableData[0][2] = list.get(0).getLname();
			tableData[0][3] = list.get(0).getEmail();
			tableData[0][4] = list.get(0).getPhone();
			tableData[0][5] = list.get(0).getDob();
			tableData[0][6] = list.get(0).getPricePerSession();
			tableData[0][7] = list.get(0).getYearStarted();
			tableData[0][8] = list.get(0).getIntroduction();
			// Set the table using the data
			DefaultTableModel tabelModel = new DefaultTableModel(tableData, columnName) {
			};
			tblCounsellor.setModel(tabelModel);
			lblState.setText("1 column(s) get");
		} catch (NumberFormatException e1) {
			System.out.println("NumberFormatException " + e1.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException " + e1.getMessage());
		} catch (SQLException e1) {
			System.out.println("SQLException " + e1.getMessage());
		}
		System.out.println(c);
	}

	public void insert() {
		Counsellor c = new Counsellor();
		// Get the input data
		String fname = txtFname.getText();
		String lname = txtLname.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
		String birthday = txtBirthday.getText();
		int price = Integer.parseInt(txtPrice.getText());
		int yearStarted = Integer.parseInt(txtYearStarted.getText());
		String introduction = txtIntroduction.getText();
		// Set the obj as the parameter of CounsellorDao.insert()
		c.setFname(fname);
		c.setLname(lname);
		c.setEmail(email);
		c.setPhone(phone);
		c.setDob(birthday);
		c.setPricePerSession(price);
		c.setYearStarted(yearStarted);
		c.setIntroduction(introduction);
		// Insert the obj to the database
		int i = -1;
		try {
			i = dao.insert(c);
			refreshTable();
			lblState.setText(i + " column(s) affected");
			//System.out.println(i + "column(s) affected");
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException " + e1.getMessage());
		} catch (SQLException e1) {
			System.out.println("SQLException " + e1.getMessage());
		}
	}

	public void update() {
		Counsellor c = new Counsellor();
		// Get the input data
		int id = Integer.parseInt(txtCustomerID.getText());
		String fname = txtFname.getText();
		String lname = txtLname.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
		String birthday = txtBirthday.getText();
		int price = Integer.parseInt(txtPrice.getText());
		int yearStarted = Integer.parseInt(txtYearStarted.getText());
		String introduction = txtIntroduction.getText();
		// Set the obj's fields
		c.setCounsellorID(id);
		c.setFname(fname);
		c.setLname(lname);
		c.setEmail(email);
		c.setPhone(phone);
		c.setDob(birthday);
		c.setPricePerSession(price);
		c.setYearStarted(yearStarted);
		c.setIntroduction(introduction);
		// Update the data
		int i = -1;
		try {
			i = dao.update(c);
			lblState.setText(i + " column(s) affected");
			refreshTable();
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException " + e1.getMessage());
		} catch (SQLException e1) {
			System.out.println("SQLException " + e1.getMessage());
		}
		
	}
	
	public void deleteById() {
		// Get id
		String id = txtCustomerID.getText();
		int i = -1;
		try {
			// Delete the record in the database
			i = dao.delete(Integer.parseInt(id));
			lblState.setText(i + " column(s) affected");
			refreshTable();
		} catch (NumberFormatException e1) {
			System.out.println("NumberFormatException " + e1.getMessage());
		} catch (ClassNotFoundException e1) {
			System.out.println("ClassNotFoundException " + e1.getMessage());
		} catch (SQLException e1) {
			System.out.println("SQLException " + e1.getMessage());
		}
	}
	
	public void load() {
		// Load the selected row's data to the input textField
		txtCustomerID.setText(tableData[selectedRow][0]+"");
		txtFname.setText(tableData[selectedRow][1]+"");
		txtLname.setText(tableData[selectedRow][2]+"");
		txtEmail.setText(tableData[selectedRow][3]+"");
		txtPhone.setText(tableData[selectedRow][4]+"");
		txtBirthday.setText(tableData[selectedRow][5]+"");
		txtPrice.setText(tableData[selectedRow][6]+"");
		txtYearStarted.setText(tableData[selectedRow][7]+"");
		txtIntroduction.setText(tableData[selectedRow][8]+"");
	}
}
