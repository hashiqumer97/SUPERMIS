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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class User_Profile extends JFrame {
	
	Vector<User_Profile> up = new Vector<User_Profile>();

	Connection conn = null;
	JLabel lblProfile;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtFullname;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnView;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Profile frame = new User_Profile();
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
	public User_Profile() {
		
		conn = mysqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPofile = new JLabel("Profile");
		lblPofile.setBounds(310, 11, 48, 14);
		contentPane.add(lblPofile);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(220, 130, 64, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(220, 190, 64, 14);
		contentPane.add(lblPassword);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(220, 160, 64, 14);
		contentPane.add(lblFullName);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(220, 100, 64, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(300, 100, 142, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(300, 160, 142, 20);
		contentPane.add(txtFullname);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(300, 130, 142, 20);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(300, 190, 142, 20);
		contentPane.add(txtPassword);
		
		JButton btnView = new JButton("View Details");
		btnView.setForeground(new Color(255, 255, 255));
		btnView.setBackground(new Color(0, 204, 255));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT U_Id, U_Fullname, U_Username, U_Password FROM `user` WHERE `U_Username` = '"+lblProfile.getText()+"'  ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
						
					while( rs.next()) {
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
		btnView.setBounds(220, 60, 227, 23);
		contentPane.add(btnView);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(0, 204, 255));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				User_Login login = new User_Login();
				login.setVisible(true);
				
			}
		});
		btnLogout.setBounds(520, 400, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 204, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		        else{
				
					try {
						
						String Updatequery ="Update user set U_Id = '"+txtId.getText()+"', U_Fullname= '"+txtFullname.getText()+"', U_Username= '"+txtUsername.getText()+"', U_Password= '"+txtPassword.getText()+"' WHERE U_Id = '"+txtId.getText()+"' ";
						PreparedStatement pst = conn.prepareStatement(Updatequery);
						pst.execute();
						pst.close();
						
						JOptionPane.showMessageDialog(null, "Successfully updated your Profile");
						
						try {
							String query = "SELECT U_id, U_Fullname, U_Username, U_Password FROM `user` WHERE `U_Username` = '"+lblProfile.getText()+"'  ";
							PreparedStatement ps = conn.prepareStatement(query);
							ResultSet rs = ps.executeQuery();
							
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
	
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        }
				
			}
		});
		btnUpdate.setBounds(350, 230, 89, 23);
		contentPane.add(btnUpdate);
		
		lblProfile = new JLabel("lblProfile");
		lblProfile.setBounds(10, 231, 48, 14);
		contentPane.add(lblProfile);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	User_Dashboard dashboard = new User_Dashboard();
				dashboard.setVisible(true);
				dashboard.lblDashboard.setText(""+lblProfile.getText()+"");
            	
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(220, 220, 220));
		btnBack.setBounds(10, 7, 89, 23);
		contentPane.add(btnBack);
		
		txtId.disable();
		txtUsername.disable();
		lblProfile.hide();
	}
	
	
}
