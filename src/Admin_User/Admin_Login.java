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

import javax.swing.JTextField;
import javax.swing.JButton;

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
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

@SuppressWarnings("unused")

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin_Login extends JFrame {
	
	private static final long serialVersionUID = -1077856539035586635L;
	
	// The GUI only interacts with the QuestionnairePanel class. 
	Vector<Admin_Login> al = new Vector<Admin_Login>();
	
	Connection conn = null;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login frame = new Admin_Login();
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
	public Admin_Login() {
		
		conn = mysqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(250, 111, 204, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0, 204, 255));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement ps;
		        ResultSet rs;
		        
		        String U_Username = txtUsername.getText();
		        String U_Password = txtPassword.getText();
		        
		        if ((U_Username.equals("")) && (U_Password.equals("")) ) {
		        	JOptionPane.showMessageDialog(null,"Please insert data to all the Text Fields");
				}else if(U_Username.equals("")){
		            JOptionPane.showMessageDialog(null, "Please insert your Username");
		        }
				else if(U_Password.equals("")){
		            JOptionPane.showMessageDialog(null, "Please insert your Password");
				}
		        else{
			        
			        String query = "SELECT * FROM `user` WHERE `U_Username` =? AND `U_Password` =? AND U_Usertype = 'admin'";
			        
			        try {
			        	
			            ps = conn.prepareStatement(query);
			            ps.setString(1, U_Username);
			            ps.setString(2, U_Password);			            
			            rs = ps.executeQuery();
			            
			            if(rs.next())
			            {
			            	//Hide the frame 
			            	dispose();
			            	
			            	//Open new frame
			            	Admin_Dashboard dashboard = new Admin_Dashboard();
			            	dashboard.setVisible(true);
			            	dashboard.lblDashboard.setText(""+U_Username+""); 
			            	
			            }
			            else{
			            	
			            	JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
			            
			            }
			            
			        } catch (SQLException ex) {
			            
			        	Logger.getLogger(Admin_Login.class.getName()).log(Level.SEVERE, null, ex);
			        
			        }
		        }
		        
			}
		});
		btnLogin.setBounds(360, 183, 89, 23);
		contentPane.add(btnLogin);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(180, 114, 69, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(180, 145, 69, 14);
		contentPane.add(lblPassword);
		
		lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setBounds(300, 36, 79, 14);
		contentPane.add(lblNewLabel);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(250, 142, 204, 20);
		contentPane.add(txtPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	LoginSelection selection = new LoginSelection();
            	selection.setVisible(true);
				
            	
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(220, 220, 220));
		btnBack.setBounds(10, 7, 89, 23);
		contentPane.add(btnBack);
		
		
	}

	
}
