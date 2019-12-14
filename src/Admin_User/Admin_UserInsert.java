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

import javax.swing.JTextField;

@SuppressWarnings({ "serial", "unused" })

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin_UserInsert extends JFrame {
	
	Vector<Admin_UserInsert> aui = new Vector<Admin_UserInsert>();
	
	Connection conn = null;
	JLabel lblUserInsert;
	private JPanel contentPane;
	private JLabel label;
	private JLabel lblFullname;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtFullname;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnInsert;
	private JTextField txtUsertype;
	private JLabel lblUsertype;

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
            Logger.getLogger(Admin_UserInsert.class.getName()).log(Level.SEVERE, null, ex);
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
					Admin_UserInsert frame = new Admin_UserInsert();
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
	public Admin_UserInsert() {
		
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
				
            	Admin_User user = new Admin_User();
            	user.setVisible(true);
            	user.lblUser.setText(""+lblUserInsert.getText()+"");
				
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setBounds(10, 11, 67, 23);
		contentPane.add(btnBack);
		
		lblUserInsert = new JLabel("");
		lblUserInsert.setBounds(87, 15, 48, 14);
		contentPane.add(lblUserInsert);
		
		label = new JLabel("User");
		label.setBounds(300, 20, 48, 14);
		contentPane.add(label);
		
		lblFullname = new JLabel("Full Name");
		lblFullname.setBounds(150, 91, 67, 14);
		contentPane.add(lblFullname);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(150, 118, 67, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(150, 143, 67, 14);
		contentPane.add(lblPassword);
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(230, 87, 200, 20);
		contentPane.add(txtFullname);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(230, 115, 200, 20);
		contentPane.add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(230, 140, 200, 20);
		contentPane.add(txtPassword);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String U_Fullname = txtFullname.getText();
				String U_Username = txtUsername.getText();
				String U_Password = txtPassword.getText();
				String U_Usertype = txtUsertype.getText();
				
				if ((U_Fullname.equals("")) && (U_Username.equals("")) && (U_Password.equals(""))) {
					JOptionPane.showMessageDialog(null, "Please insert data to all the Textfields");
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
			            Logger.getLogger(Admin_UserInsert.class.getName()).log(Level.SEVERE, null, ex);
			        }
		        }
				
			}
		});
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setBackground(new Color(0, 204, 255));
		btnInsert.setBounds(340, 171, 89, 23);
		contentPane.add(btnInsert);
		
		txtUsertype = new JTextField();
		txtUsertype.setText("user");
		txtUsertype.setColumns(10);
		txtUsertype.setBounds(121, 205, 200, 20);
		contentPane.add(txtUsertype);
		
		lblUsertype = new JLabel("Usertype");
		lblUsertype.setBounds(52, 208, 67, 14);
		contentPane.add(lblUsertype);
		
		txtUsertype.setVisible(false);
		lblUsertype.setVisible(false);
		lblUserInsert.setVisible(false);
	}
	
	
}
