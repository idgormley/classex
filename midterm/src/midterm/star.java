package midterm;

public class star {
	public static void stars(int number){
		if (number>0){
			System.out.print('*');
			stars(number-1);
			System.out.print('!');
			}else{
				System.out.println();
			}
		}
	

	
public static void main(String[] args){
	stars(10);
}

}
			
	

