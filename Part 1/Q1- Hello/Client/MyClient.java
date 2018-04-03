import java.lang.*; 
import javax.ws.rs.client.*;
import org.glassfish.jersey.client.*;

public class MyClient {

	public static void main(String[] args) {

			ClientConfig conf = new ClientConfig();
			Client client = ClientBuilder.newClient(conf);
			WebTarget target = client.target("http://e-mc137-110:8080/sender");
			String result = target.path("hello").request().get(String.class) ;
			
			System.out.println("Le serveur a retourne  : "+result);

	}

}
