package notebook;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
public class Contact{
	@XmlElement
	String name;
	@XmlElement
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
