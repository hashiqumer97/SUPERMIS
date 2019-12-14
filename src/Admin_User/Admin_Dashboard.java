package Admin_User;


import java.awt.EventQueue;

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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

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

import SupermisServer.RemoteQuestions;


@SuppressWarnings("unused")

/*author - Hashiq Umer (UOB1821715), Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin_Dashboard extends JFrame {
	
	private static final long serialVersionUID = -1077856539035586635L;
	
	// The GUI only interacts with the QuestionnairePanel class. 
	Vector<Admin_Dashboard> ad = new Vector<Admin_Dashboard>();
	
	JLabel lblDashboard;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Dashboard frame = new Admin_Dashboard();
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
	public Admin_Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDashoard = new JLabel("Dashboard");
		lblDashoard.setBounds(250, 11, 69, 14);
		contentPane.add(lblDashoard);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setBackground(new Color(0, 204, 255));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 
				dispose();
				
				Admin_Login login = new Admin_Login();
				login.setVisible(true);
				
			}
		});
		btnLogout.setBounds(520, 400, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	Admin_Profile profile = new Admin_Profile();
            	profile.setVisible(true);
            	profile.lblProfile.setText(""+lblDashboard.getText()+""); 
            	
			}
		});
		btnProfile.setForeground(new Color(255, 255, 255));
		btnProfile.setBackground(new Color(0, 204, 255));
		btnProfile.setBounds(10, 46, 150, 120);
		contentPane.add(btnProfile);
		
		lblDashboard = new JLabel("");
		lblDashboard.setBounds(530, 11, 55, 20);
		contentPane.add(lblDashboard);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	Admin admin = new Admin();
            	admin.setVisible(true);
            	admin.lblAdmin.setText(""+lblDashboard.getText()+""); 
            	
			}
		});
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBackground(new Color(0, 204, 255));
		btnAdmin.setBounds(170, 46, 150, 120);
		contentPane.add(btnAdmin);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	Admin_User user = new Admin_User();
            	user.setVisible(true);
            	user.lblUser.setText(""+lblDashboard.getText()+"");
            	
			}
		});
		btnUser.setForeground(Color.WHITE);
		btnUser.setBackground(new Color(0, 204, 255));
		btnUser.setBounds(330, 46, 150, 120);
		contentPane.add(btnUser);
		
		JButton btnQuestions = new JButton("Questions");
		btnQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
            	Admin_QuestionUpdate question = new Admin_QuestionUpdate();
            	question.setVisible(true);
            	question.lblUpdateQuestion.setText(""+lblDashboard.getText()+"");
            	
			}
		});
		btnQuestions.setForeground(Color.WHITE);
		btnQuestions.setBackground(new Color(0, 204, 255));
		btnQuestions.setBounds(170, 180, 150, 120);
		contentPane.add(btnQuestions);
		
		JButton btnChart = new JButton("Chart");
		btnChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*By clicking this button, you will be able to view the overall chart which shows
				 * the overall result for each option in each question. */
				
				try{
					Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
					RemoteQuestions i = (RemoteQuestions)reg.lookup("supermis");
					String query="select Q_ID, Sum(Yes) as Yes , Sum(No) as No , Sum(Maybe) as Maybe from user_has_question group by Q_ID";	
					JDBCCategoryDataset dataset = new JDBCCategoryDataset(mysqlconnection.dbConnector(),query); 
					JFreeChart chart = ChartFactory.createBarChart("Overall Results", "Question ID", "Overall Answer", dataset, PlotOrientation.VERTICAL, false, true, true);
					
					CategoryPlot plot = null;
					BarRenderer renderer = (BarRenderer)chart.getCategoryPlot().getRenderer();
					renderer.setSeriesPaint(0, new Color(0, 204, 255));
					renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{0}={2}", NumberFormat.getInstance()));
					ChartFrame frame = new ChartFrame("Overall Results",chart);
					frame.setVisible(true);
					frame.setSize(640, 480);			
						
				}catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
            	
			}
		});
		btnChart.setForeground(Color.WHITE);
		btnChart.setBackground(new Color(0, 204, 255));
		btnChart.setBounds(10, 180, 150, 120);
		contentPane.add(btnChart);
	}
	


	
}
