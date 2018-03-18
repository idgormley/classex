

import java.util.InputMismatchException;
import java.util.Scanner;

public class testexception {
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		
		try {
			System.out.println("Enter a number");
			int x= input.nextInt();
			System.out.print(x);
		}catch (InputMismatchException et){
			System.out.println("You entered a wrong value");
		}
		finally{
			System.out.println("thank you for using the system");
			input.close();
		}
		
	}
}
