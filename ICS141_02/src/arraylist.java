import java.util.ArrayList;

public class arraylist {
	public static void main (String[]args){
		ArrayList<Integer> numbers=new ArrayList<>();
		numbers.add(5);
		numbers.add(7);
		numbers.add(10);
		numbers.add(11);
		System.out.print(numbers);
		numbers.add(1,6);
		numbers.add(6,13);
		numbers.add(0,2);
		System.out.print(numbers);
		numbers.remove(1);
		System.out.print(numbers);	
		
	}
}
