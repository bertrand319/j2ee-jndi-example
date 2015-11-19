package bertran.example.jndi;

import java.io.Serializable;
import java.rmi.Remote;

public class RemoteObject implements Remote, Serializable {

	private static final long serialVersionUID = -5815250042434642106L;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
