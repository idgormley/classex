import java.util.Scanner;

public class DoubleAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n=input.nextInt();
		int[] myList=new int[n];
		
		System.out.print("Enter " + n + " values: ");
		for (int i = 0; i < myList.length; i++){
	         myList[i] = input.nextInt();}
		double total=0;
		for (int i = 0; i < myList.length; i++) {
	         total += myList[i];
		}
		double average=total/n;
		System.out.print("Average = "+average);
	
		input.close();
		
		
	}

}
