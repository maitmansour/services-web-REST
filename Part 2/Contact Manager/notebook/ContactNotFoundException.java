package notebook;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class ContactNotFoundException extends WebApplicationException {
     public ContactNotFoundException(String message) {
         super(Response.status(Response.Status.NOT_FOUND)
             .entity(message).type(MediaType.TEXT_PLAIN).build());
     }
}
