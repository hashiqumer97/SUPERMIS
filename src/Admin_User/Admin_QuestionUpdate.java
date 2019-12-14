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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

@SuppressWarnings({ "serial", "unused" })

/*author - Riflan Ahmed (UOB1822257), Niroshan Sathasivam (UOB1822705)*/

public class Admin_QuestionUpdate extends JFrame {
	
	Vector<Admin_QuestionUpdate> aqu = new Vector<Admin_QuestionUpdate>();
	
	Connection conn = null;
	JLabel lblUpdateQuestion;
	private JPanel contentPane;
	private JLabel label;
	private JTextField txtSearch;
	private JButton button;
	private JTextField txtId;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtQuestion;
	private JButton button_1;
	private JTable table;
	private JScrollPane scrollPane;
	
	
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
	
	public boolean checkQuestion(String Question){
        PreparedStatement ps;
        ResultSet rs;
        boolean checkQuestion = false;
        String query = "SELECT * FROM question WHERE Q_Questions = ?";
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, Question);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
            	checkQuestion = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_QuestionUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkQuestion;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_QuestionUpdate frame = new Admin_QuestionUpdate();
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
	public Admin_QuestionUpdate() {
		
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
				
				Admin_Question question = new Admin_Question();
            	question.setVisible(true);
            	question.lblQuestion.setText(""+lblUpdateQuestion.getText()+"");
				
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		lblUpdateQuestion = new JLabel("");
		lblUpdateQuestion.setBounds(109, 15, 48, 14);
		contentPane.add(lblUpdateQuestion);
		
		label = new JLabel("Search");
		label.setBounds(10, 49, 48, 14);
		contentPane.add(label);
		
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
		txtSearch.setColumns(10);
		txtSearch.setBounds(60, 46, 450, 20);
		contentPane.add(txtSearch);
		
		button = new JButton("Refresh");
		button.addActionListener(new ActionListener() {
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
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 204, 255));
		button.setBounds(520, 45, 89, 23);
		contentPane.add(button);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(81, 340, 133, 20);
		contentPane.add(txtId);
	
		label_2 = new JLabel("Question");
		label_2.setBounds(10, 370, 62, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Id");
		label_3.setBounds(10, 340, 48, 14);
		contentPane.add(label_3);
		
		txtQuestion = new JTextField();
		txtQuestion.setColumns(10);
		txtQuestion.setBounds(80, 370, 529, 20);
		contentPane.add(txtQuestion);
		
		button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				
				String Q_Questions = txtQuestion.getText();
				
				
				if(Q_Questions.equals("")){
		            JOptionPane.showMessageDialog(null, "Please insert your Question");
		        }
				else if(checkQuestion(Q_Questions))
		        {
		            JOptionPane.showMessageDialog(null, "This Question is already exists");
		        }
		        else{
		        	
					try {
						
						String query ="Update question set Q_Id = '"+txtId.getText()+"', Q_Questions= '"+txtQuestion.getText()+"' WHERE Q_Id = '"+txtId.getText()+"' ";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.execute();
						pst.close();
						
						dispose();
						
						Admin_Question question = new Admin_Question();
		            	question.setVisible(true);
		            	question.lblQuestion.setText(""+lblUpdateQuestion.getText()+"");
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				refreshTable();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 204, 255));
		button_1.setBounds(520, 397, 89, 23);
		contentPane.add(button_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 600, 250);
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
						txtQuestion.setText(rs.getString("Q_Questions"));
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		lblUpdateQuestion.hide();
		txtId.disable();
		refreshTable();
	}


}
