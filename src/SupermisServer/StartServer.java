package SupermisServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;

import SupermisClient.QuestionnaireSet1;


@SuppressWarnings("unused")

/*author - Hashiq Umer (UOB1821715)*/

public class StartServer {

	public static void main(String[] args) {
		System.out.println("Attempting to start the Question Server..."); 
		try {
			/*I have created a registry in order to start the server with the
			  QuestionnaireSet1 java class in the SupermisClient package. */
			RemoteQuestions questionnaire = new QuestionImplementation();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("supermis", questionnaire);

			System.out.println("Service started. Welcome to SUPERMIS Questionnaire!");

		} catch (RemoteException e) {
			System.out.println("An error occured: "+e.toString()); 
			e.printStackTrace();
		} 

	}

}
