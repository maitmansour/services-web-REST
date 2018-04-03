package notebook;

public class Contact{
	
	String name;
	String number;
	
	Contact(String  _name,String _number){
		name=_name;
		number=_number;
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
