package SupermisServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
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
import SupermisServer.RemoteQuestions;
import SupermisClient.QuestionnaireSet1;
import SupermisClient.QuestionnaireSet2;
import SupermisClient.QuestionnaireSet3;
import SupermisClient.QuestionnaireSet4;
import SupermisClient.QuestionnaireSet5;
import SupermisClient.QuestionnaireSet6;
import SupermisClient.QuestionnaireSet7;
import SupermisClient.QuestionnaireSet8;
import SupermisClient.QuestionnaireSet9;
import SupermisClient.QuestionnaireSet10;
import SupermisClient.QuestionnaireSet11;
import SupermisClient.QuestionnaireSet12;
import SupermisClient.QuestionnaireSet13;
import SupermisClient.QuestionnaireSet14;

@SuppressWarnings("unused")

/*author - Hashiq Umer (UOB1821715), Riflan Ahmed (UOB1822257)*/

public class QuestionImplementation extends UnicastRemoteObject implements RemoteQuestions{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector<QuestionImplementation> ques1 = new Vector<QuestionImplementation>();
	protected QuestionImplementation() throws RemoteException {
		super();
		connection=mysqlconnection.dbConnector();
		System.out.println("Supermis Question Implementation Created");
}
			
	
	/*This method returns the vector variable of the QuestionnaireSet1 java class file. */
	@Override
	public Vector<QuestionnaireSet1> getDataq1() throws RemoteException {
		// TODO Auto-generated method stub
		return q1;
	}
	
	java.sql.Connection connection=null;
	SupermisServer.RemoteQuestions remote = null;
	
	/*This method returns the integer value of the QuestionnaireSet1 java class file. */
	public QuestionnaireSet1 ansq1(int i) throws RemoteException {
		
		return RemoteQuestions.q1.elementAt(i);
	}
	
	/*This method returns the vector variable of the QuestionnaireSet2 java class file. */
	@Override
	public Vector<QuestionnaireSet2> getDataq2() throws RemoteException {
		// TODO Auto-generated method stub
		return q2;
	}

	/*This method returns the integer value of the QuestionnaireSet2 java class file. */
	@Override
	public QuestionnaireSet2 ansq2(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q2.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet3 java class file. */
	@Override
	public Vector<QuestionnaireSet3> getDataq3() throws RemoteException {
		// TODO Auto-generated method stub
		return q3;
	}

	/*This method returns the integer value of the QuestionnaireSet4 java class file. */
	@Override
	public QuestionnaireSet3 ansq3(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q3.elementAt(i);
	}
	
	/*This method returns the vector variable of the QuestionnaireSet4 java class file. */
	@Override
	public Vector<QuestionnaireSet4> getDataq4() throws RemoteException {
		// TODO Auto-generated method stub
		return q4;
	}

	/*This method returns the integer value of the QuestionnaireSet5 java class file. */
	@Override
	public QuestionnaireSet4 ansq4(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q4.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet5 java class file. */
	@Override
	public Vector<QuestionnaireSet5> getDataq5() throws RemoteException {
		// TODO Auto-generated method stub
		return q5;
	}
	
	/*This method returns the integer value of the QuestionnaireSet5 java class file. */
	@Override
	public QuestionnaireSet5 ansq5(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q5.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet6 java class file. */
	@Override
	public Vector<QuestionnaireSet6> getDataq6() throws RemoteException {
		// TODO Auto-generated method stub
		return q6;
	}

	/*This method returns the integer value of the QuestionnaireSet6 java class file. */
	@Override
	public QuestionnaireSet6 ansq6(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q6.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet7 java class file. */
	@Override
	public Vector<QuestionnaireSet7> getDataq7() throws RemoteException {
		// TODO Auto-generated method stub
		return q7;
	}

	/*This method returns the integer value of the QuestionnaireSet7 java class file. */
	@Override
	public QuestionnaireSet7 ansq7(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q7.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet8 java class file. */
	@Override
	public Vector<QuestionnaireSet8> getDataq8() throws RemoteException {
		// TODO Auto-generated method stub
		return q8;
	}

	/*This method returns the integer value of the QuestionnaireSet8 java class file. */
	@Override
	public QuestionnaireSet8 ansq8(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q8.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet9 java class file. */
	@Override
	public Vector<QuestionnaireSet9> getDataq9() throws RemoteException {
		// TODO Auto-generated method stub
		return q9;
	}

	/*This method returns the integer value of the QuestionnaireSet9 java class file. */
	@Override
	public QuestionnaireSet9 ansq9(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q9.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet10 java class file. */
	@Override
	public Vector<QuestionnaireSet10> getDataq10() throws RemoteException {
		// TODO Auto-generated method stub
		return q10;
	}
	
	/*This method returns the integer value of the QuestionnaireSet10 java class file. */
	@Override
	public QuestionnaireSet10 ansq10(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q10.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet11 java class file. */
	@Override
	public Vector<QuestionnaireSet11> getDataq11() throws RemoteException {
		// TODO Auto-generated method stub
		return q11;
	}

	/*This method returns the integer value of the QuestionnaireSet11 java class file. */
	@Override
	public QuestionnaireSet11 ansq11(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q11.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet12 java class file. */
	@Override
	public Vector<QuestionnaireSet12> getDataq12() throws RemoteException {
		// TODO Auto-generated method stub
		return q12;
	}

	/*This method returns the integer value of the QuestionnaireSet12 java class file. */
	@Override
	public QuestionnaireSet12 ansq12(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q12.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet13 java class file. */
	@Override
	public Vector<QuestionnaireSet13> getDataq13() throws RemoteException {
		// TODO Auto-generated method stub
		return q13;
	}

	/*This method returns the integer value of the QuestionnaireSet13 java class file. */
	@Override
	public QuestionnaireSet13 ansq13(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q13.elementAt(i);
	}

	/*This method returns the vector variable of the QuestionnaireSet14 java class file. */
	@Override
	public Vector<QuestionnaireSet14> getDataq14() throws RemoteException {
		// TODO Auto-generated method stub
		return q14;
	}

	/*This method returns the integer value of the QuestionnaireSet14 java class file. */
	@Override
	public QuestionnaireSet14 ansq14(int i) throws RemoteException {
		// TODO Auto-generated method stub
		return RemoteQuestions.q14.elementAt(i);
	}

	/*This method returns the vector variable of the Admin_Dashboard java class file. */
	@Override
	public Vector<Admin_Dashboard> ad() throws RemoteException {
		// TODO Auto-generated method stub
		return ad;
	}

	/*This method returns the vector variable of the Admin_Login java class file. */
	@Override
	public Vector<Admin_Login> al() throws RemoteException {
		// TODO Auto-generated method stub
		return al;
	}

	/*This method returns the vector variable of the Admin_Profile java class file. */
	@Override
	public Vector<Admin_Profile> ap() throws RemoteException {
		// TODO Auto-generated method stub
		return ap;
	}

	/*This method returns the vector variable of the Admin_Question java class file. */
	@Override
	public Vector<Admin_Question> aq() throws RemoteException {
		// TODO Auto-generated method stub
		return aq;
	}

	/*This method returns the vector variable of the Admin_QuestionUpdate java class file. */
	@Override
	public Vector<Admin_QuestionUpdate> aqu() throws RemoteException {
		// TODO Auto-generated method stub
		return aqu;
	}

	/*This method returns the vector variable of the Admin_User java class file. */
	@Override
	public Vector<Admin_User> au() throws RemoteException {
		// TODO Auto-generated method stub
		return au;
	}
	
	/*This method returns the vector variable of the Admin_UserInsert java class file. */
	@Override
	public Vector<Admin_UserInsert> aui() throws RemoteException {
		// TODO Auto-generated method stub
		return aui;
	}
	
	/*This method returns the vector variable of the Admin_UserUpdate java class file. */
	@Override
	public Vector<Admin_UserUpdate> auu() throws RemoteException {
		// TODO Auto-generated method stub
		return auu;
	}

	/*This method returns the vector variable of the Admin java class file. */
	@Override
	public Vector<Admin> a() throws RemoteException {
		// TODO Auto-generated method stub
		return a;
	}
	
	/*This method returns the vector variable of the LoginSelection java class file. */
	@Override
	public Vector<LoginSelection> ls() throws RemoteException {
		// TODO Auto-generated method stub
		return ls;
	}

	/*This method returns the vector variable of the User_Dashboard java class file. */
	@Override
	public Vector<User_Dashboard> ud() throws RemoteException {
		// TODO Auto-generated method stub
		return ud;
	}

	/*This method returns the vector variable of the User_Login java class file. */
	@Override
	public Vector<User_Login> ul() throws RemoteException {
		// TODO Auto-generated method stub
		return ul;
	}

	/*This method returns the vector variable of the User_Profile java class file. */
	@Override
	public Vector<User_Profile> up() throws RemoteException {
		// TODO Auto-generated method stub
		return up;
	}

}