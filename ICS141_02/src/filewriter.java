import java.io.*;

public class filewriter {

	public static void main(String[] args) throws IOException {
		
			
	try(

		PrintWriter x = new PrintWriter("ICS.txt");
		){
		x.println("1.College Name: Metrostate");
		x.println("2.Class: ICS 141");
		x.println("3.Name:Your Name");
		}
	FileReader fr = new FileReader("ICS.txt");
	char[] b =new char[100];
	fr.read(b);
	for (char c:b)
		System.out.print(c);
	fr.close();
	
	}
}
