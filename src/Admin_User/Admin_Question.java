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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

@SuppressWarnings({ "serial", "unused" })

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin_Question extends JFrame {
	Vector<Admin_Question> aq = new Vector<Admin_Question>();
	Connection conn = null;
	JLabel lblQuestion;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblSearch;
	private JButton btnRefresh;
	private JTextField txtSearch;
	private JButton btnUpdate;
	private JTextField txtId;
	
	
	public void refreshTable() {
		
		try {
			
			String query ="SELECT Q_Id as ID, Q_Questions as Question FROM question";
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
					Admin_Question frame = new Admin_Question();
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
	public Admin_Question() {
		
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
				
				Admin_Dashboard dashboard = new Admin_Dashboard();
            	dashboard.setVisible(true);
            	dashboard.lblDashboard.setText(""+lblQuestion.getText()+"");
            	
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		lblQuestion = new JLabel("");
		lblQuestion.setBounds(109, 15, 48, 14);
		contentPane.add(lblQuestion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 600, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table.getSelectedRow();
					String Id_ = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "SELECT * FROM question WHERE Q_Id = '"+Id_+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while( rs.next()) 
					{
						txtId.setText(rs.getString("Q_Id"));
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		lblSearch = new JLabel("Search");
		lblSearch.setBounds(10, 47, 48, 14);
		contentPane.add(lblSearch);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(new Color(255, 255, 255));
		btnRefresh.setBackground(new Color(0, 204, 255));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "SELECT * FROM question";
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
		btnRefresh.setBounds(520, 45, 89, 23);
		contentPane.add(btnRefresh);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					String query = "SELECT Q_Id as ID, Q_Questions as Question FROM question WHERE Q_Id = ? ";
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
		txtSearch.setBounds(61, 46, 450, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0, 204, 255));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				Admin_QuestionUpdate questionUpdate = new Admin_QuestionUpdate();
				questionUpdate.setVisible(true);
				questionUpdate.lblUpdateQuestion.setText(""+lblQuestion.getText()+"");
				
			}
		});
		btnUpdate.setBounds(250, 390, 100, 23);
		contentPane.add(btnUpdate);
		
		txtId = new JTextField();
		txtId.setBounds(10, 228, 96, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		//ID TextBox invisible
		txtId.setVisible(false);
		
		//ID TextBox invisible
		lblQuestion.setVisible(false);
				
		//Load the data to the table
		refreshTable();
				
	}
	

}
