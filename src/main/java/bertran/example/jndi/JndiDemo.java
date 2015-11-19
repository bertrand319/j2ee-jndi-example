package bertran.example.jndi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiDemo {
	
	private static final int PORT = 8319;

	public static void init() throws NamingException, RemoteException {
		LocateRegistry.createRegistry(PORT);
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
				"com.sun.jndi.rmi.registry.RegistryContextFactory");
		System.setProperty(Context.PROVIDER_URL, "rmi://localhost:"+PORT);
		InitialContext context = new InitialContext();
		RemoteObject object = new RemoteObject();
		object.setName("I'm a remote object");
		context.bind("abc",object);
	}
	
	public static void find() throws NamingException, RemoteException {
		InitialContext context = new InitialContext();
		RemoteObject object = (RemoteObject) context
				.lookup("abc");
		System.out.println("Name: " + object.getName());
	}
	
	public static void main(String[] args) throws RemoteException, NamingException {
		init();
		find();
	}
}
