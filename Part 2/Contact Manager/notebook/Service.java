package notebook;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.DefaultValue;
import java.net.*;
import java.lang.StringBuffer.*;
import javax.ws.rs.core.*;
import javax.servlet.http.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

@Path("/carnet")
public class Service {
    static Book currentBook = new Book();

    @GET
    public String getAction() {
        String tmp = "";
        if (currentBook.contacts.isEmpty()) {
            tmp = "Liste Vide !";
        } else {
            int i = 0;
            for (Contact item: currentBook.contacts) {
                tmp += "Contact " + i + " :   " + item.getName() + " ---> "+item.getNumber()+"<br/>";
                i++;
            }
        }

        return tmp;

    }



    @GET
    @Path("/getByName/{name}")
    public String getByNameAction(@PathParam("name") String name) {
        String tmp = "";
        Boolean found = false;
        if (currentBook.contacts.isEmpty()) {
            tmp = "Liste Vide !";
        } else {
            for (Contact item: currentBook.contacts) {
                if (item.getName().equals(name)) {
                    tmp += name + " : " + item.getNumber();
                    found = true;
                }
            }
        }
        if (!found) tmp = "Inconnu !";

        return tmp;

    }




    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/plain")
    public Response addnewContact(@FormParam("name") String name, @FormParam("number") String number) {

        if (name == null || number == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Please add name and number !").build();
        }
        for (Contact item: currentBook.contacts) {
            if (item.getName().equals(name)) {
                return Response.status(Response.Status.NOT_FOUND).entity("Already exist !").build();
            }
            
		}
			currentBook.contacts.add(new Contact(name,number));
            URI uri = UriBuilder.fromUri("http://localhost/notebook/rest").scheme("carnet").path("getByName").path(name).build();
            return Response.status(201).entity("Added Succssfully  ! URL : "+uri).build();



        


    }


    @POST
    @Path("/addxml")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes
    public Response addnewContactXML(Contact contact) {

        for (Contact item: currentBook.contacts) {
            if (item.getName().equals(contact.getName())) {
                return Response.status(Response.Status.NOT_FOUND).entity("Already exist !").build();
            }
            
		}
			currentBook.contacts.add(contact);
            URI uri = UriBuilder.fromUri("http://localhost/notebook/rest").scheme("carnet").path("getByName").path(contact.getName()).build();
			System.out.println(uri);

            return Response.status(201).entity("Added Succssfully  ! URL : "+uri).build();



        


    }

    @PUT
    @Path("/update")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes
    public Response putAction(Contact contact) {

		if(currentBook.contacts.size()==0)return Response.status(204).entity("").build();
        for (Contact item: currentBook.contacts) {
            if (item.getName().equals(contact.getName())) {
				item.setNumber(contact.getNumber());
				currentBook.contacts.set(currentBook.contacts.indexOf(item),contact);
                return Response.status(204).entity("").build();
            }
            
		}
	
	return Response.status(204).entity("").build();

    }
    
    @DELETE
    @Path("/delete/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes
    public Response deleteAction(@PathParam("name") String name) {

		if(currentBook.contacts.size()==0)return Response.status(204).entity("").build();
        for (Contact item: currentBook.contacts) {
            if (item.getName().equals(name)) {
				currentBook.contacts.remove(currentBook.contacts.indexOf(item));
                return Response.status(204).entity("").build();
            }
            
		}
	
	return Response.status(204).entity("").build();

    }
}
