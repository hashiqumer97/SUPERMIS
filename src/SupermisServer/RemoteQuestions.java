package SupermisServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

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

/*author - Hashiq Umer (UOB1821715), Riflan Ahmed (UOB1822257)*/

public interface RemoteQuestions extends Remote {
	
	/*These are the methods that i passed for all the class files which is included in the 
	  SupermisClient and Admin_User package. */
	
	/*Method of creating the vector for QuestionnaireSet1 java class file. */
	Vector<QuestionnaireSet1> q1 = new Vector<QuestionnaireSet1>();
	
	/*Method of returning the vector variable of the QuestionnaireSet1 java class file. */
	public Vector<QuestionnaireSet1> getDataq1() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet1 java class file. */
	QuestionnaireSet1 ansq1(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet2 java class file. */
	Vector<QuestionnaireSet2> q2 = new Vector<QuestionnaireSet2>();
	
	/*Method of returning the vector variable of the QuestionnaireSet2 java class file. */
	public Vector<QuestionnaireSet2> getDataq2() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet2 java class file. */
	QuestionnaireSet2 ansq2(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet3 java class file. */
	Vector<QuestionnaireSet3> q3 = new Vector<QuestionnaireSet3>();
	
	/*Method of returning the vector variable of the QuestionnaireSet3 java class file. */
	public Vector<QuestionnaireSet3> getDataq3() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet3 java class file. */
	QuestionnaireSet3 ansq3(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet4 java class file. */
	Vector<QuestionnaireSet4> q4 = new Vector<QuestionnaireSet4>();
	
	/*Method of returning the vector variable of the QuestionnaireSet4 java class file. */
	public Vector<QuestionnaireSet4> getDataq4() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet4 java class file. */
	QuestionnaireSet4 ansq4(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet5 java class file. */
	Vector<QuestionnaireSet5> q5 = new Vector<QuestionnaireSet5>();
	
	/*Method of returning the vector variable of the QuestionnaireSet5 java class file. */
	public Vector<QuestionnaireSet5> getDataq5() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet5 java class file. */
	QuestionnaireSet5 ansq5(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet6 java class file. */
	Vector<QuestionnaireSet6> q6 = new Vector<QuestionnaireSet6>();
	
	/*Method of returning the vector variable of the QuestionnaireSet6 java class file. */
	public Vector<QuestionnaireSet6> getDataq6() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet6 java class file. */
	QuestionnaireSet6 ansq6(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet7 java class file. */
	Vector<QuestionnaireSet7> q7 = new Vector<QuestionnaireSet7>();
	
	/*Method of returning the vector variable of the QuestionnaireSet7 java class file. */
	public Vector<QuestionnaireSet7> getDataq7() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet7 java class file. */
	QuestionnaireSet7 ansq7(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet8 java class file. */
	Vector<QuestionnaireSet8> q8 = new Vector<QuestionnaireSet8>();
	
	/*Method of returning the vector variable of the QuestionnaireSet8 java class file. */
	public Vector<QuestionnaireSet8> getDataq8() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet8 java class file. */
	QuestionnaireSet8 ansq8(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet9 java class file. */
	Vector<QuestionnaireSet9> q9 = new Vector<QuestionnaireSet9>();
	
	/*Method of returning the vector variable of the QuestionnaireSet9 java class file. */
	public Vector<QuestionnaireSet9> getDataq9() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet9 java class file. */
	QuestionnaireSet9 ansq9(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet10 java class file. */
	Vector<QuestionnaireSet10> q10 = new Vector<QuestionnaireSet10>();
	
	/*Method of returning the vector variable of the QuestionnaireSet10 java class file. */
	public Vector<QuestionnaireSet10> getDataq10() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet10 java class file. */
	QuestionnaireSet10 ansq10(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet11 java class file. */
	Vector<QuestionnaireSet11> q11 = new Vector<QuestionnaireSet11>();
	
	/*Method of returning the vector variable of the QuestionnaireSet11 java class file. */
	public Vector<QuestionnaireSet11> getDataq11() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet11 java class file. */
	QuestionnaireSet11 ansq11(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet12 java class file. */
	Vector<QuestionnaireSet12> q12 = new Vector<QuestionnaireSet12>();
	
	/*Method of returning the vector variable of the QuestionnaireSet12 java class file. */
	public Vector<QuestionnaireSet12> getDataq12() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet12 java class file. */
	QuestionnaireSet12 ansq12(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet13 java class file. */
	Vector<QuestionnaireSet13> q13 = new Vector<QuestionnaireSet13>();
	
	/*Method of returning the vector variable of the QuestionnaireSet13 java class file. */
	public Vector<QuestionnaireSet13> getDataq13() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet13 java class file. */
	QuestionnaireSet13 ansq13(int i) throws RemoteException;
	
	/*Method of creating the vector for QuestionnaireSet14 java class file. */
	Vector<QuestionnaireSet14> q14 = new Vector<QuestionnaireSet14>();
	
	/*Method of returning the vector variable of the QuestionnaireSet14 java class file. */
	public Vector<QuestionnaireSet14> getDataq14() throws RemoteException; 
	
	/*Method of returning the integer value of the QuestionnaireSet14 java class file. */
	QuestionnaireSet14 ansq14(int i) throws RemoteException;
	
	/*Method of creating the vector for Admin_Dashboard java class file. */
	Vector<Admin_Dashboard> ad = new Vector<Admin_Dashboard>();
	
	/*Method of returning the vector variable of the Admin_Dashboard java class file. */
	public Vector<Admin_Dashboard> ad() throws RemoteException;
	
	/*Method of creating the vector for Admin_Login java class file. */
	Vector<Admin_Login> al = new Vector<Admin_Login>();
	
	/*Method of returning the vector variable of the Admin_Login java class file. */
	public Vector<Admin_Login> al() throws RemoteException;
	
	/*Method of creating the vector for Admin_Profile java class file. */
	Vector<Admin_Profile> ap = new Vector<Admin_Profile>();
	
	/*Method of returning the vector variable of the Admin_Profile java class file. */
	public Vector<Admin_Profile> ap() throws RemoteException;
	
	/*Method of creating the vector for Admin_Question java class file. */
	Vector<Admin_Question> aq = new Vector<Admin_Question>();
	
	/*Method of returning the vector variable of the Admin_Question java class file. */
	public Vector<Admin_Question> aq() throws RemoteException;
	
	/*Method of creating the vector for Admin_QuestionUpdate java class file. */
	Vector<Admin_QuestionUpdate> aqu = new Vector<Admin_QuestionUpdate>();
	
	/*Method of returning the vector variable of the Admin_QuestionUpdate java class file. */
	public Vector<Admin_QuestionUpdate> aqu() throws RemoteException;
	
	/*Method of creating the vector for Admin_User java class file. */
	Vector<Admin_User> au = new Vector<Admin_User>();
	
	/*Method of returning the vector variable of the Admin_User java class file. */
	public Vector<Admin_User> au() throws RemoteException;
	
	/*Method of creating the vector for Admin_UserInsert java class file. */
	Vector<Admin_UserInsert> aui = new Vector<Admin_UserInsert>();
	
	/*Method of returning the vector variable of the Admin_UserInsert java class file. */
	public Vector<Admin_UserInsert> aui() throws RemoteException;
	
	/*Method of creating the vector for Admin_UserUpdate java class file. */
	Vector<Admin_UserUpdate> auu = new Vector<Admin_UserUpdate>();
	
	/*Method of returning the vector variable of the Admin_UserUpdate java class file. */
	public Vector<Admin_UserUpdate> auu() throws RemoteException;
	
	/*Method of creating the vector for Admin java class file. */
	Vector<Admin> a = new Vector<Admin>();
	
	/*Method of returning the vector variable of the Admin java class file. */
	public Vector<Admin> a() throws RemoteException;
	
	/*Method of creating the vector for LoginSelection java class file. */
	Vector<LoginSelection> ls = new Vector<LoginSelection>();
	
	/*Method of returning the vector variable of the LoginSelection java class file. */
	public Vector<LoginSelection> ls() throws RemoteException;
	
	/*Method of creating the vector for User_Dashboard java class file. */
	Vector<User_Dashboard> ud = new Vector<User_Dashboard>();
	
	/*Method of returning the vector variable of the User_Dashboard java class file. */
	public Vector<User_Dashboard> ud() throws RemoteException;
	
	/*Method of creating the vector for User_Login java class file. */
	Vector<User_Login> ul = new Vector<User_Login>();
	
	/*Method of returning the vector variable of the User_Login java class file. */
	public Vector<User_Login> ul() throws RemoteException;
	
	/*Method of creating the vector for User_Profile java class file. */
	Vector<User_Profile> up = new Vector<User_Profile>();
	
	/*Method of returning the vector variable of the User_Profile java class file. */
	public Vector<User_Profile> up() throws RemoteException;
	
}
