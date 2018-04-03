package sender;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class Sender {

    /* Premier exemple avec un GET */
    @GET()
    public String hello() {
        return "Hello";
    }
    
    /* Premier exemple avec un GET */
    @GET()
	@Path("/{name}")
    public String helloSomeOne(@PathParam("name") String name){
        return "Hello : "+name;
    }

}
