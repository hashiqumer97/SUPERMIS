package Admin_User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import SupermisClient.QuestionnaireSet1;
import SupermisClient.QuestionnaireSet10;
import SupermisClient.QuestionnaireSet11;
import SupermisClient.QuestionnaireSet12;
import SupermisClient.QuestionnaireSet13;
import SupermisClient.QuestionnaireSet14;
import SupermisClient.QuestionnaireSet2;
import SupermisClient.QuestionnaireSet3;
import SupermisClient.QuestionnaireSet4;
import SupermisClient.QuestionnaireSet5;
import SupermisClient.QuestionnaireSet6;
import SupermisClient.QuestionnaireSet7;
import SupermisClient.QuestionnaireSet8;
import SupermisClient.QuestionnaireSet9;
import SupermisServer.RemoteQuestions;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

@SuppressWarnings({ "serial", "unused" })

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin_User extends JFrame {
	
	Vector<Admin_User> au = new Vector<Admin_User>();
	
	Connection conn = null;
	JLabel lblUser;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtSearch;
	private JButton btnRefresh;
	private JTable table;
	private JButton btnDelete;
	
	public void refreshTable() {
		
		try {
			
			String query ="SELECT U_Id as ID, U_Fullname as FullName, U_UserName as Username, U_Password as Password FROM user WHERE U_Usertype = 'User'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			pst.close();
			rs.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ex");
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_User frame = new Admin_User();
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
	public Admin_User() {
		
		conn = mysqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	Admin_Dashboard dashboard = new Admin_Dashboard();
            	dashboard.setVisible(true);
            	dashboard.lblDashboard.setText(""+lblUser.getText()+"");
            	
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(204, 204, 204));
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		lblUser = new JLabel("");
		lblUser.setBounds(109, 15, 48, 14);
		contentPane.add(lblUser);
		
		txtId = new JTextField();
		txtId.setBounds(10, 45, 96, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					String query = "SELECT U_Id, U_Fullname, U_Username, U_Password FROM user WHERE U_Username = ? and U_Usertype = 'User' ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, txtSearch.getText());
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}


			}
		});
		txtSearch.setColumns(10);
		txtSearch.setBounds(119, 45, 390, 20);
		contentPane.add(txtSearch);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "SELECT * FROM user";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					txtSearch.setText(null);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				refreshTable();
				
			}
		});
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBackground(new Color(0, 204, 255));
		btnRefresh.setBounds(520, 44, 89, 23);
		contentPane.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 600, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table.getSelectedRow();
					String Id_ = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "SELECT * FROM user WHERE U_Id = '"+Id_+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while( rs.next()) 
					{
						txtId.setText(rs.getString("U_Id"));
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	Admin_UserInsert userInsert = new Admin_UserInsert();
            	userInsert.setVisible(true);
            	userInsert.lblUserInsert.setText(""+lblUser.getText()+"");
				
			}
		});
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBackground(new Color(0, 204, 255));
		btnInsert.setBounds(320, 400, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Admin_UserUpdate userInsert = new Admin_UserUpdate();
            	userInsert.setVisible(true);
            	userInsert.lblUser12Update.setText(""+lblUser.getText()+"");
            	
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 204, 255));
		btnUpdate.setBounds(420, 400, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				
				int action =  JOptionPane.showConfirmDialog(null, "Do you want delete it", "Delete", JOptionPane.YES_NO_OPTION);
				
				if (action == 0) {
					try {
						
						String query ="Delete FROM user WHERE U_Id = '"+txtId.getText()+"' ";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.execute();
						pst.close();
						txtSearch.setText(null);
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					refreshTable();
				}
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 204, 255));
		btnDelete.setBounds(520, 400, 89, 23);
		contentPane.add(btnDelete);
		
		//User Label invisible
		lblUser.setVisible(false);
		
		//ID TextBox invisible
		txtId.setVisible(false);
				
		//Load the data to the table
		refreshTable();
	}
	

}
