import java.util.Scanner;

public class NumPower{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("How many times do you want to run the program?");
		int i=input.nextInt();
		int count=0;
		while(count<i){
		System.out.print("Enter a number");
		double a=input.nextDouble();
		System.out.print("Enter its power");
		double n=input.nextDouble();
		double m=Math.pow(a, n);
		System.out.println(a+"to the power of "+n+"is= "+m);
		count++;
		input.close();
		}
		
	}
}


