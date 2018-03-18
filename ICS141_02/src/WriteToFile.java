import java.io.*;

public class WriteToFile {

	public static void main(String[] args) throws IOException {
		File filename=new File("test.txt");
		File file=new File("test2.txt");
		PrintWriter x= new PrintWriter(filename);
		FileWriter y= new FileWriter(file);
		x.print("My name is");
		y.write("OK");
		x.close();
		y.close();
		
		FileReader fr = new FileReader(filename);
		char[] array = new char[50];
		fr.read(array);
		
		for (char c:array)
			System.out.print(c);
		fr.close();
		

	}

}
