package SupermisClient;

import java.sql.*;

import javax.swing.*;

/*author - Hashiq Umer (UOB1821715)*/

public class mysqlconnection {
	/*This is the class file of the database connection at which the database is connected
	 * with the application.*/
	Connection con=null;
	public static Connection dbConnector(){
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermis?useSSL=false","root","123456");
		//JOptionPane.showMessageDialog(null, "Connection Successful");
		return con;
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null, e);
		return null;
	}
	}
}
