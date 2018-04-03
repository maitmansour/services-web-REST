package sender;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

@Path("/hello")
public class Sender {

    @GET()
    public String hello(@DefaultValue("Mohamed") @QueryParam("name") String name,
		@DefaultValue("Today") @QueryParam("date") String date) {

		
			        return "Hello "+name+"  : "+date;
				
    }


}
