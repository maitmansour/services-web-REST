package sender;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces("text/plain")
public class Sender {

    @GET()
    public String hello() {
        return "Hello";
    }
    
    @GET()
	@Path("/xml")
    @Produces("application/xml")
    public String salut() {
        return "Hello";
    }
    @GET()
	@Path("/html")
    @Produces("text/html")
    public String ola() {
        return "Hello";
    }

}
