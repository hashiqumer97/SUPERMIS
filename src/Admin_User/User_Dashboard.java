package Admin_User;

import java.awt.EventQueue;






import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

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
import SupermisClient.mysqlconnection;
import SupermisServer.RemoteQuestions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JWindow;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })

/*author - Hashiq Umer (UOB1821715), Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class User_Dashboard extends JFrame {
	
	Vector<User_Dashboard> ud = new Vector<User_Dashboard>();
	java.sql.Connection con=null;
	JLabel lblDashboard;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Dashboard frame = new User_Dashboard();
					
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
	
	public User_Dashboard() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblDashoard = new JLabel("Dashboard");
		lblDashoard.setBounds(300, 11, 69, 14);
		contentPane.add(lblDashoard);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(0, 204, 255));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con=mysqlconnection.dbConnector();
				try{
					
					String queryyes="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst = con.prepareStatement(queryyes);
					pst.setString(1, "0");
					pst.setString(2, "0");
					pst.setString(3, "0");
					pst.setString(4, "1");
					pst.executeUpdate();
					
					String queryyes1="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst1 = con.prepareStatement(queryyes1);
					pst1.setString(1, "0");
					pst1.setString(2, "0");
					pst1.setString(3, "0");
					pst1.setString(4, "2");
					pst1.executeUpdate();
					
					String queryyes2="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst2 = con.prepareStatement(queryyes2);
					pst2.setString(1, "0");
					pst2.setString(2, "0");
					pst2.setString(3, "0");
					pst2.setString(4, "3");
					pst2.executeUpdate();
					
					String queryyes3="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst3 = con.prepareStatement(queryyes3);
					pst3.setString(1, "0");
					pst3.setString(2, "0");
					pst3.setString(3, "0");
					pst3.setString(4, "4");
					pst3.executeUpdate();
					
					String queryyes4="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst4 = con.prepareStatement(queryyes4);
					pst4.setString(1, "0");
					pst4.setString(2, "0");
					pst4.setString(3, "0");
					pst4.setString(4, "5");
					pst4.executeUpdate();
					
					String queryyes5="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst5 = con.prepareStatement(queryyes5);
					pst5.setString(1, "0");
					pst5.setString(2, "0");
					pst5.setString(3, "0");
					pst5.setString(4, "6");
					pst5.executeUpdate();
					
					String queryyes6="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst6 = con.prepareStatement(queryyes6);
					pst6.setString(1, "0");
					pst6.setString(2, "0");
					pst6.setString(3, "0");
					pst6.setString(4, "7");
					pst6.executeUpdate();
					
					String queryyes7="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst7 = con.prepareStatement(queryyes7);
					pst7.setString(1, "0");
					pst7.setString(2, "0");
					pst7.setString(3, "0");
					pst7.setString(4, "8");
					pst7.executeUpdate();
					
					String queryyes8="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst8 = con.prepareStatement(queryyes8);
					pst8.setString(1, "0");
					pst8.setString(2, "0");
					pst8.setString(3, "0");
					pst8.setString(4, "9");
					pst8.executeUpdate();
					
					String queryyes9="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst9 = con.prepareStatement(queryyes9);
					pst9.setString(1, "0");
					pst9.setString(2, "0");
					pst9.setString(3, "0");
					pst9.setString(4, "10");
					pst9.executeUpdate();
					
					String queryyes10="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst10 = con.prepareStatement(queryyes10);
					pst10.setString(1, "0");
					pst10.setString(2, "0");
					pst10.setString(3, "0");
					pst10.setString(4, "11");
					pst10.executeUpdate();
					
					String queryyes11="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst11 = con.prepareStatement(queryyes11);
					pst11.setString(1, "0");
					pst11.setString(2, "0");
					pst11.setString(3, "0");
					pst11.setString(4, "12");
					pst11.executeUpdate();
					
					String queryyes12="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst12 = con.prepareStatement(queryyes12);
					pst12.setString(1, "0");
					pst12.setString(2, "0");
					pst12.setString(3, "0");
					pst12.setString(4, "13");
					pst12.executeUpdate();
					
					String queryyes13="update question set Yes = ?, No = ?, Maybe = ? where Q_ID = ?";
					PreparedStatement pst13 = con.prepareStatement(queryyes13);
					pst13.setString(1, "0");
					pst13.setString(2, "0");
					pst13.setString(3, "0");
					pst13.setString(4, "14");
					pst13.executeUpdate();
					
					}catch (Exception eee) {
						eee.printStackTrace();
					}
			
				dispose();
				
				User_Login login = new User_Login();
				login.setVisible(true);
				
			}
		});
		btnLogout.setBounds(520, 400, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	User_Profile profile = new User_Profile();
            	profile.setVisible(true);
            	profile.lblProfile.setText(""+lblDashboard.getText()+""); 
            	
			}
		});
		btnProfile.setForeground(new Color(255, 255, 255));
		btnProfile.setBackground(new Color(0, 204, 255));
		btnProfile.setBounds(10, 46, 150, 120);
		contentPane.add(btnProfile);
		
		lblDashboard = new JLabel("");
		lblDashboard.setBounds(520, 11, 55, 20);
		contentPane.add(lblDashboard);
		
		JButton btnResult = new JButton("Result");
		btnResult.addActionListener(new ActionListener() {
			@SuppressWarnings({ })
			public void actionPerformed(ActionEvent e) {
				/*By clicking this button, you will be able to view the individual result chart which shows
				 * the individual result for each option in each question. */
				try{
					Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
					RemoteQuestions i = (RemoteQuestions)reg.lookup("supermis");
					String query="select Q_ID, Yes, No, Maybe from question";	
					final JDBCCategoryDataset dataset = new JDBCCategoryDataset(mysqlconnection.dbConnector(),query); 
					
					JFreeChart chart = ChartFactory.createBarChart("Results", "Question ID", "Answer Chosen", dataset, PlotOrientation.VERTICAL, false, true, true);
					CategoryPlot plot = new CategoryPlot();
					BarRenderer renderer = (BarRenderer)chart.getCategoryPlot().getRenderer();
					renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}", NumberFormat.getInstance()));
					ChartFrame frame = new ChartFrame("Results",chart);
					frame.setVisible(true);
					frame.setSize(640, 480);
					}catch (Exception ee) {
						JOptionPane.showMessageDialog(null, ee);
					}
            	
			}
		});
		btnResult.setForeground(Color.WHITE);
		btnResult.setBackground(new Color(0, 204, 255));
		btnResult.setBounds(330, 46, 150, 120);
		contentPane.add(btnResult);
		
		JButton btnQuestions = new JButton("Questions");
		btnQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
            	QuestionnaireSet1 question = new QuestionnaireSet1();
            	question.setVisible(true);
            	question.lbl_user.setText(""+lblDashboard.getText()+"");
            	
			}
		});
		btnQuestions.setForeground(Color.WHITE);
		btnQuestions.setBackground(new Color(0, 204, 255));
		btnQuestions.setBounds(170, 46, 150, 120);
		contentPane.add(btnQuestions);
	}
	
	
	
	
}
