
public class Student {
	static String FirstName;
	static String LastName;
	static String getName(String FName,String LName){
		FName=FirstName;
		LName=LastName;
		String Name;
		Name=FName +" "+ LName;
		return Name;
	}
}
