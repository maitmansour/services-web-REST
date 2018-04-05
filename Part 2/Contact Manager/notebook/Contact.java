package notebook;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Contact{
	
	String name;
	String number;
	
	public Contact(String  _name,String _number){
		name=_name;
		number=_number;
	}
		
	public Contact(){
		name="Undefined";
		number="Undefined";
	}
	
	String getNumber(){
		return number;
	}
	
	
	String getName(){
		return name;
	}
	
	
	void setNumber(String _number){
		number=_number;
	}
	
	
}
