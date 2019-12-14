package SupermisClient;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;

import Admin_User.Admin;
import Admin_User.Admin_Dashboard;
import Admin_User.Admin_Login;
import Admin_User.Admin_Profile;
import Admin_User.Admin_Question;
import Admin_User.Admin_QuestionUpdate;
import Admin_User.Admin_User;
import Admin_User.Admin_UserInsert;
import Admin_User.Admin_UserUpdate;
import Admin_User.LoginSelection;
import Admin_User.User_Dashboard;
import Admin_User.User_Login;
import Admin_User.User_Profile;
import SupermisServer.RemoteQuestions;

@SuppressWarnings("unused")

/*author - Hashiq Umer (UOB1821715), Niroshan Sathasivam (UOB1822705)*/

public class QuestionnaireSet11 extends JFrame implements ActionListener {

	java.sql.Connection connection=null;
	private static final long serialVersionUID = -1077856539035586635L;
	
	// The GUI only interacts with the QuestionnairePanel class. 
	Vector<QuestionnaireSet11> q11 = new Vector<QuestionnaireSet11>();
	
	
	public void actionPerformed(ActionEvent ee) {
		connection=mysqlconnection.dbConnector();
		
		if(ee.getSource().equals(question)){
		try{
		/*This function gets the question which is fetched from the database along with the 3 options which are Yes,
		No and Maybe */
			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
			RemoteQuestions i = (RemoteQuestions)reg.lookup("supermis");
			String sql = "select Q_Questions from question where Q_ID = 11";
			PreparedStatement p = connection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				String s = rs.getString("Q_Questions");
				welcome.setText(s);
				
			}
			
			yesButton.setVisible(true);
			noButton.setVisible(true);
			maybeButton.setVisible(true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
try{
	/*user id will be fetched from the user table in the database which is fetched by using the username
	 * field which is "U_Username" in the user table.*/
			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
			RemoteQuestions i = (RemoteQuestions)reg.lookup("supermis");
			String sql = "select U_Id from `user` where `U_Username` = '"+lbl_user.getText()+"'";
			PreparedStatement p = connection.prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				lbl_id.setText(rs.getString("U_Id"));
				
			}
			
			yesButton.setVisible(true);
			noButton.setVisible(true);
			maybeButton.setVisible(true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		if(ee.getSource().equals(yesButton)) { 
			/*This function will work when the "Yes" button is clicked */
			try{
				boolean f = false;
				Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
				RemoteQuestions i = (RemoteQuestions)reg.lookup("supermis");
				f=ee.getSource().equals(yesButton);
				if(f==true){
					/*This query will update the question table in the database according to the given 
					 * answer which is "Yes" and will be included in the individual chart at which it can  
					 * be seen after the completion of the questionnaire. */
					String queryyes="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst = connection.prepareStatement(queryyes);
					pst.setString(1, "1");
					pst.setString(2, "0");
					pst.setString(3, "0");
					pst.setString(4, "11");
					pst.executeUpdate();
					
					/*This query will insert the answer "Yes" into user_has_question table in the database at 
					 * which the answer will be included in the overall chart at which only admin users can 
					 * be able to view it. */
					String queryyes1="insert into user_has_question (Yes, No, Maybe, Q_ID) values (?, ?, ?, ?)";
					PreparedStatement pst1 = connection.prepareStatement(queryyes1);
					pst1.setString(1, "1");
					pst1.setString(2, "0");
					pst1.setString(3, "0");
					pst1.setString(4, "11");
					pst1.execute();
					QuestionnaireSet12 q2 = new QuestionnaireSet12();
					q2.setVisible(true);
					this.setVisible(false);
				}
				
			}catch (Exception eee) {
				eee.printStackTrace();
			}
			
			
			}
		 else if(ee.getSource().equals(noButton)) { 
			 /*This function will work when the "No" button is clicked */
			 try{
				 boolean f = false;
					Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
					RemoteQuestions i = (RemoteQuestions)reg.lookup("supermis");
					f=ee.getSource().equals(noButton);
					if(f==true){
						/*This query will update the question table in the database according to the given 
						 * answer which is "No" and will be included in the individual chart at which it can  
						 * be seen after the completion of the questionnaire. */
						String queryno="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
						PreparedStatement pst = connection.prepareStatement(queryno);
						pst.setString(1, "0");
						pst.setString(2, "1");
						pst.setString(3, "0");
						pst.setString(4, "11");
						pst.executeUpdate();
						
						/*This query will insert the answer "No" into user_has_question table in the database at 
						 * which the answer will be included in the overall chart at which only admin users can 
						 * be able to view it. */
						String queryno1="insert into user_has_question (Yes, No, Maybe, Q_ID) values (?, ?, ?, ?)";
						PreparedStatement pst1 = connection.prepareStatement(queryno1);
						pst1.setString(1, "0");
						pst1.setString(2, "1");
						pst1.setString(3, "0");
						pst1.setString(4, "11");
						pst1.execute();
						QuestionnaireSet12 q2 = new QuestionnaireSet12();
						q2.setVisible(true);
						this.setVisible(false);
					}
					
				}catch (Exception eee) {
					eee.printStackTrace();
				}
			
		 }
		
		 else if(ee.getSource().equals(maybeButton)) { 
			 /*This function will work when the "Maybe" button is clicked */
			 try{
				 boolean f = false;
					Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
					RemoteQuestions i = (RemoteQuestions)reg.lookup("supermis");
					f=ee.getSource().equals(maybeButton);
					if(f==true){
						/*This query will update the question table in the database according to the given 
						 * answer which is "Maybe" and will be included in the individual chart at which it can  
						 * be seen after the completion of the questionnaire. */
						String querymaybe="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
						PreparedStatement pst = connection.prepareStatement(querymaybe);
						pst.setString(1, "0");
						pst.setString(2, "0");
						pst.setString(3, "1");
						pst.setString(4, "11");
						pst.executeUpdate();
						
						/*This query will insert the answer "Maybe" into user_has_question table in the database at 
						 * which the answer will be included in the overall chart at which only admin users can 
						 * be able to view it. */
						String querymaybe1="insert into user_has_question (Yes, No, Maybe, Q_ID) values (?, ?, ?, ?)";
						PreparedStatement pst1 = connection.prepareStatement(querymaybe1);
						pst1.setString(1, "0");
						pst1.setString(2, "0");
						pst1.setString(3, "1");
						pst1.setString(4, "11");
						pst1.execute();
						QuestionnaireSet12 q2 = new QuestionnaireSet12();
						q2.setVisible(true);
						this.setVisible(false);
						
					}
					
				}catch (Exception eee) {
					eee.printStackTrace();
				}
		 }
	}
	/*In this, I have mentioned the variables and the text that should be included in a particular variable. */
	JLabel lbl_user = new JLabel("");
	JTextField lbl_id = new JTextField("");
	JLabel welcome = new JLabel("");
	JButton yesButton = new JButton("Yes");	
	JButton noButton = new JButton("No");
	JButton maybeButton = new JButton("Maybe");
	JButton question = new JButton("Show Eleventh Question");


/**
 * Constructor	
 */
	
	public QuestionnaireSet11() {
		super();
		setSize(640,480);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		
	JPanel panel = new JPanel(new GridLayout(7,1));
	/*I have made a new panel in order to make the variables visible in JFrame.*/
	panel.add(lbl_user);
	lbl_user.setHorizontalAlignment(JLabel.CENTER);
	lbl_user.setVerticalAlignment(JLabel.CENTER);
	lbl_user.setBackground(Color.WHITE);
	lbl_user.setVisible(false);
	panel.setBackground(Color.WHITE);
	
		

		panel.add(welcome);
		welcome.setHorizontalAlignment(JLabel.CENTER);
	    welcome.setVerticalAlignment(JLabel.CENTER);
	    welcome.setBackground(Color.WHITE);
		welcome.setVisible(true);
		
		panel.add(lbl_id);
		lbl_id.setVisible(false);
		
		panel.add(yesButton); 
		yesButton.setBackground(new Color(0, 204, 255));
	    yesButton.setForeground(Color.WHITE);
		yesButton.addActionListener(this);
		yesButton.setVisible(false);
		
		panel.add(noButton); 
		noButton.setBackground(new Color(0, 204, 255));
	    noButton.setForeground(Color.WHITE);
		noButton.addActionListener(this); 
		noButton.setVisible(false);
		
		panel.add(maybeButton); 
		maybeButton.setBackground(new Color(0, 204, 255));
	    maybeButton.setForeground(Color.WHITE);
		maybeButton.addActionListener(this); 
		maybeButton.setVisible(false);
		
		panel.add(question); 
		question.setBackground(new Color(220, 220, 220));
	    question.setForeground(Color.BLACK);
		question.addActionListener(this); 
		
	
				
		getContentPane().add(panel);
		panel.repaint();
		
	
			
			
		}
		
		


	
	
	public static void main(String [] args ) { 
		QuestionnaireSet1 myGUI = new QuestionnaireSet1(); 
		myGUI.setVisible(true); 
		
	}




}