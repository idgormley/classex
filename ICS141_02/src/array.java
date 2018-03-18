import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] number= new int[10];
				Scanner input=new Scanner(System.in);
		for (int i:number){
			number[i]=input.nextInt();
			System.out.println("number entered for "+i+" is "+number[i]);
			input.close();
}
		
	}

}
