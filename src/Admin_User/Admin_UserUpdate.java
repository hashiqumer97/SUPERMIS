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

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

@SuppressWarnings({ "serial", "unused" })

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin_UserUpdate extends JFrame {
	
	Vector<Admin_UserUpdate> auu = new Vector<Admin_UserUpdate>();
	
	Connection conn = null;
	private JPanel contentPane;
	JLabel lblUser12Update;
	private JLabel label;
	private JTextField txtSearch;
	private JLabel lblSearch;
	private JButton btnRefresh;
	private JTextField txtId;
	private JTextField txtFullname;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button;
	
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
	
	public boolean checkUsername(String Username){
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM user WHERE U_Username = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, Username);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_UserUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_UserUpdate frame = new Admin_UserUpdate();
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
	@SuppressWarnings("deprecation")
	public Admin_UserUpdate() {
		
		conn = mysqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(204, 204, 204));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Admin_User user = new Admin_User();
            	user.setVisible(true);
            	user.lblUser.setText(""+lblUser12Update.getText()+"");
            	
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		lblUser12Update = new JLabel("");
		lblUser12Update.setBounds(109, 15, 48, 14);
		contentPane.add(lblUser12Update);
		
		label = new JLabel("Update");
		label.setBounds(300, 15, 48, 14);
		contentPane.add(label);
		
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
		txtSearch.setBounds(60, 52, 450, 20);
		contentPane.add(txtSearch);
		
		lblSearch = new JLabel("Search");
		lblSearch.setBounds(10, 52, 48, 14);
		contentPane.add(lblSearch);
		
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
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(new Color(0, 204, 255));
		btnRefresh.setBounds(520, 50, 89, 23);
		contentPane.add(btnRefresh);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				
				String U_Fullname = txtFullname.getText();
				String U_Username = txtUsername.getText();
				String U_Password = txtPassword.getText();
				
				if ((U_Fullname.equals("")) && (U_Username.equals("")) && (U_Password.equals(""))) {
					JOptionPane.showMessageDialog(null, "Please insert data to all the Text Fields");
				}else if(U_Fullname.equals("")){
		            JOptionPane.showMessageDialog(null, "Please insert your Full Name");
		        }
				else if(U_Username.equals("")){
		            JOptionPane.showMessageDialog(null, "Please insert your Username");
		        }
				else if(U_Password.equals("")){
		            JOptionPane.showMessageDialog(null, "Please insert your Password");
		        }
		        else if(checkUsername(U_Username))
		        {
		            JOptionPane.showMessageDialog(null, "This Username is already exists");
		        }
		        else{
				
					try {
						
						String query ="Update user set U_Id = '"+txtId.getText()+"', U_Fullname= '"+txtFullname.getText()+"', U_Username= '"+txtUsername.getText()+"', U_Password= '"+txtPassword.getText()+"' WHERE U_Id = '"+txtId.getText()+"' ";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.execute();
						pst.close();
						
						dispose();
						
						Admin_User user = new Admin_User();
		            	user.setVisible(true);
		            	user.lblUser.setText(""+lblUser12Update.getText()+"");
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				refreshTable();
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 204, 255));
		button.setBounds(520, 400, 89, 23);
		contentPane.add(button);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(81, 240, 133, 20);
		contentPane.add(txtId);
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(80, 270, 134, 20);
		contentPane.add(txtFullname);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(80, 300, 134, 20);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(80, 330, 134, 20);
		contentPane.add(txtPassword);
		
		label_1 = new JLabel("Password");
		label_1.setBounds(10, 330, 62, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("Username");
		label_2.setBounds(10, 300, 62, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Full Name");
		label_3.setBounds(10, 270, 62, 14);
		contentPane.add(label_3);
		
		label_4 = new JLabel("Id");
		label_4.setBounds(10, 240, 48, 14);
		contentPane.add(label_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 600, 130);
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
						txtFullname.setText(rs.getString("U_Fullname"));
						txtUsername.setText(rs.getString("U_Username"));
						txtPassword.setText(rs.getString("U_Password"));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		txtId.disable();
		lblUser12Update.setVisible(false);
		refreshTable();
		
	}
	

}
