import java.util.Scanner;

public class B extends A {

	public static void main(String[]args){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter length: ");
		length=input.nextDouble();
		System.out.println("Enter height: ");
		height=input.nextDouble();
		System.out.println("Enter width: ");
		width=input.nextDouble();
		input.close();
		
		System.out.println(getArea(length,width));
	
		System.out.println(getVolume(length,width,height));
		
	}
}
