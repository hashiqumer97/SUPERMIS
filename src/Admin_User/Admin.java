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

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin extends JFrame {
	
	private static final long serialVersionUID = -1077856539035586635L;
	
	// The GUI only interacts with the QuestionnairePanel class. 
	Vector<Admin> a = new Vector<Admin>();
	
	Connection conn = null;
	JLabel lblAdmin;
	private JPanel contentPane;
	private JTextField txtFullname;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtUsertype;
	private JButton btnInsert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;
         
	}


	/**
	 * Create the frame.
	 */
	public Admin() {
		
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
            	dashboard.lblDashboard.setText(""+lblAdmin.getText()+""); 
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(204, 204, 204));
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblHead = new JLabel("Admin");
		lblHead.setBounds(300, 15, 50, 14);
		contentPane.add(lblHead);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setBounds(180, 100, 62, 14);
		contentPane.add(lblFullName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(180, 130, 62, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(180, 160, 62, 14);
		contentPane.add(lblPassword);
		
		txtFullname = new JTextField();
		txtFullname.setBounds(250, 100, 166, 20);
		contentPane.add(txtFullname);
		txtFullname.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(250, 130, 166, 20);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(250, 160, 166, 20);
		contentPane.add(txtPassword);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBackground(new Color(0, 204, 255));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String U_Fullname = txtFullname.getText();
				String U_Username = txtUsername.getText();
				String U_Password = txtPassword.getText();
				String U_Usertype = txtUsertype.getText();
				
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
		            JOptionPane.showMessageDialog(null, "This Username is already exist");
		        }
		        else{
		            
			        PreparedStatement ps;
			        String query = "INSERT INTO `user`(`U_Fullname`, `U_Username`, `U_Password`, `U_Usertype`) VALUES (?,?,?,?)";
			        
			        try {
			            ps = conn.prepareStatement(query);
			            
			            ps.setString(1, U_Fullname);
			            ps.setString(2, U_Username);
			            ps.setString(3, U_Password);
			            ps.setString(4, U_Usertype);
			            
			            if(ps.executeUpdate() > 0)
			            {
			                JOptionPane.showMessageDialog(null, "Your Account is created Successfully");
			                
			                txtFullname.setText(null);
							txtUsername.setText(null);
							txtPassword.setText(null);
							txtUsertype.setText(null);
			            }
			            
			        } catch (SQLException ex) {
			            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
			        }
		        }
				
			}
		});
		btnInsert.setBounds(325, 190, 89, 23);
		contentPane.add(btnInsert);
		
		txtUsertype = new JTextField();
		txtUsertype.setText("admin");
		txtUsertype.setBounds(141, 186, 166, 20);
		contentPane.add(txtUsertype);
		txtUsertype.setColumns(10);
		
		JLabel lblUsertype = new JLabel("Usertype");
		lblUsertype.setBounds(72, 189, 62, 14);
		contentPane.add(lblUsertype);
		
		lblAdmin = new JLabel("");
		lblAdmin.setBounds(20, 45, 48, 14);
		contentPane.add(lblAdmin);
		
		txtUsertype.setVisible(false);
		lblUsertype.setVisible(false);
		lblAdmin.setVisible(false);
		
	}
	
	
	
}
