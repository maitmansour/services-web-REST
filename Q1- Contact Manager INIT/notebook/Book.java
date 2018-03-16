package notebook;

import java.util.*;
public class Book{
	
        List<Contact> contacts;
        
	
	Book(){
		contacts = new ArrayList<Contact>();
		contacts.add(new Contact("Mido","0666666"));
		contacts.add(new Contact("Simo","8888888"));
	}	
	
}
