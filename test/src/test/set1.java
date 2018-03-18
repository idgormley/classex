public class set1 {
	public class Set1 {
		static String st;
		static String fname, lname;
		static String Street, City, State;
		public static void main(String[] args) {
			Name nim = new Name(fname,lname);
			Address addr = new Address(Street,City, State);
			Student sadd = new Student(st);
			System.out.println("Student Address:" + sadd.Studd);
			}
		}
		class Name {
			static String name;
			Name(String nam, String nam1){
				nam = "John";
				nam1 = "Peter";
				name = nam + " " + nam1;
				}
		}
		class Student {
			String Studd;
			Student(String Stu){
				Stu = Name.name+"," + " " +Address.Addres;
				Studd = Stu;
				}
		}
		class Address{
			static String Addres;
			Address(String Street, String City, String State){
				String Str,Cit,Sta;
				Str = "105 Mounds Blvd";
				Cit = "St. Paul";
				Sta = "MN";
				Street = Str;
				City = Cit;
				State = Sta;
				Addres = Street + "," + " " + City + "," + " " + State;
				}
		}
}
