package notebook;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

@Path("/carnet")
public class Service {

    @GET
    public String getAction() {
			Book currentBook = new Book();
			String tmp="";
			if(currentBook.contacts.isEmpty()){
				tmp="Liste Vide !";
			}else{
				int i=0;
							for(Contact item : currentBook.contacts){
				tmp+="Contact "+i+" :   "+item.getName()+"<br/>";
				i++;
			}
			}
			

		
			return tmp;
		
    }


}
