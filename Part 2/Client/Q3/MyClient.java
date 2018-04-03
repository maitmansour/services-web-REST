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
			WebTarget target = client.target("http://e-mc137-110:8080/notebook");
			
		Form form = new Form();
		form.param("name", "Mohamed");
		form.param("number", "065656565");
       
        
			Response response = target.path("carnet").path("add").request(MediaType.APPLICATION_FORM_URLENCODED).post(Entity.form(form)) ;
			
        String value = response.readEntity(String.class);
			System.out.println("NON Existing one   : "+value);	
			

       
        
			 response = target.path("carnet").path("add").request(MediaType.APPLICATION_FORM_URLENCODED).post(Entity.form(form)) ;
			
         value = response.readEntity(String.class);
			System.out.println("NON Existing one AFTER ADD    : "+value);	
			
					
		 form = new Form();
		form.param("name", "Mido");
		form.param("number", "065656565");
       
        
			 response = target.path("carnet").path("add").request(MediaType.APPLICATION_FORM_URLENCODED).post(Entity.form(form)) ;
			
         value = response.readEntity(String.class);
			System.out.println(" Existing one   : "+value);

	}

}
