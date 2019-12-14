package Admin_User;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class LoginSelection extends JFrame {
	
	Vector<LoginSelection> ls = new Vector<LoginSelection>();

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSelection frame = new LoginSelection();
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
	public LoginSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonAdmin = new JButton("Admin");
		buttonAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Admin_Login login = new Admin_Login();
				login.setVisible(true);
			}
		});
		buttonAdmin.setForeground(Color.WHITE);
		buttonAdmin.setBackground(new Color(0, 204, 255));
		buttonAdmin.setBounds(29, 74, 163, 133);
		contentPane.add(buttonAdmin);
		
		JButton buttonUser = new JButton("User");
		buttonUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				User_Login login = new User_Login();
				login.setVisible(true);
				
			}
		});
		buttonUser.setForeground(Color.WHITE);
		buttonUser.setBackground(new Color(0, 204, 255));
		buttonUser.setBounds(217, 73, 157, 134);
		contentPane.add(buttonUser);
		
		lblNewLabel = new JLabel("Login Selection");
		lblNewLabel.setBounds(250, 36, 100, 14);
		contentPane.add(lblNewLabel);
	}

	
}
