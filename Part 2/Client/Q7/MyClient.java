import java.lang.*; 
import javax.ws.rs.client.*;
import org.glassfish.jersey.client.*;

import javax.ws.rs.core.Form;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
public class MyClient {

	public static void main(String[] args) {

			ClientConfig conf = new ClientConfig();
			Client client = ClientBuilder.newClient(conf);
			WebTarget target = client.target("http://localhost:8080/notebook/rest");
			
			notebook.Contact contact = new notebook.Contact("aaa","11111111111");
			
			Response response = target.path("carnet")
			.path("update")
			.request()
			.put(Entity.entity(contact, MediaType.APPLICATION_XML), Response.class) ;
			
         String value = response.readEntity(String.class);
			System.out.println(" Updated   : "+value);

	}

}
