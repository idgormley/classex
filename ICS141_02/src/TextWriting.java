import java.io.*;
import java.util.Scanner;

public class TextWriting {


	public static void main(String[] args) throws FileNotFoundException {
		Scanner	input= new Scanner(System.in);
		
			System.out.println("Enter Your Name");
			String name= input.next();
			System.out.println("Enter Course Name");
			String course=input.next();
			System.out.println("Enter Semester of study");
			String sem=input.next();
			input.close();
		
		try(
				PrintWriter x = new PrintWriter("personal.txt");
				){
				x.println(name);
				x.println(course);
				x.println(sem);
				}
		}
}
