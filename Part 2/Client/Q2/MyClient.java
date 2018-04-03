import java.lang.*; 
import javax.ws.rs.client.*;
import org.glassfish.jersey.client.*;

public class MyClient {

	public static void main(String[] args) {

			ClientConfig conf = new ClientConfig();
			Client client = ClientBuilder.newClient(conf);
			WebTarget target = client.target("http://e-mc137-110:8080/notebook");
			String result = target.path("carnet").path("getByName").path("Mido").request().get(String.class) ;
			
			
			System.out.println("Existing one   : "+result);
			
			
			 result = target.path("carnet").path("getByName").path("BlaBla").request().get(String.class) ;
			
			System.out.println("NON Existing one   : "+result);

	}

}
