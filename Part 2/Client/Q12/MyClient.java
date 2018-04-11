import java.lang.*; 
import javax.ws.rs.client.*;
import org.glassfish.jersey.client.*;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MyClient {

	public static void main(String[] args) {
		
		String name="6565656";
		notebook.Contact contact = new notebook.Contact("aaa",name);

	  try {

		File file = new File(name+".xml");
		JAXBContext jaxbContext = JAXBContext.newInstance( notebook.Contact.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(contact, file);
		jaxbMarshaller.marshal(contact, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }


	}

}
