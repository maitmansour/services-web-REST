package sender;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class Sender {

    /* Premier exemple avec un GET */
    @GET()
    public String hello() {
        return "Hello";
    }

}
