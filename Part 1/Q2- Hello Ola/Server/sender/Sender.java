package sender;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class Sender {

    @GET()
    public String hello() {
        return "Hello";
    }

}
