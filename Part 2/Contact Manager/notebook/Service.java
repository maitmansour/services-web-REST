package notebook;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.DefaultValue;

@Path("/carnet")
public class Service {
			static Book currentBook = new Book();

    @GET
    public String getAction() {
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
    
    
    
    @GET
	@Path("/getByName/{name}")
    public String getByNameAction(@PathParam("name") String name) {
			String tmp="";
			Boolean found=false;
			if(currentBook.contacts.isEmpty()){
				tmp="Liste Vide !";
			}else{
							for(Contact item : currentBook.contacts){
								if(item.getName().equals(name)){
									tmp+=name+" : "+item.getNumber();
									found=true;
								}
			}
			}
			if(!found)tmp="Inconnu !";
			
			return tmp;
		
    }
    
    
        
    
    @POST
	@Path("/add")
    public String addnewContact(@FormParam("name") String name,@FormParam("number") String number) {
			
			if(name==null || number==null){
				return "Please add name and number !";
			}
			for(Contact item : currentBook.contacts){
								if(item.getName().equals(name)){
									return "Contact Déja existant !";
								}
							}
			currentBook.contacts.add(new Contact(name,number));
			
			return "Contact Ajouté  !";
		
    }


}
