import java.util.Scanner;
public class ProgrammingAssignment_2{
static double tax=0;
double income=0;
int status=0;


	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Choose filing status. Enter 0 for single filers, 1 for married filing jointly, or 2 for head of household: ");
		int status=input.nextInt();
		System.out.print("Enter taxable income: ");
		double income=input.nextDouble();
		
		if (status==0){
			Tax(income);
			}
		else if(status==1){
			Tax1(income);
			}
		else if (status==2){
			Tax2(income);
			}
		
		System.out.printf("Tax is: " +tax);
		input.close();
	}
		
	public static double Tax(double income){
		int[] mylist = {9075,36900,89350,186350,405100,406750};
		
		if (income <=mylist[0] )
			tax = income * 0.10;
		else if (income <=mylist[1] )
			tax = mylist[0] * 0.10 + (income - mylist[0]) * 0.15;
		else if (income <= mylist[2])
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(income - mylist[1]) * 0.25;
		else if (income <= mylist[3] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (income - mylist[2]) * 0.28;
		else if (income <= mylist[4] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (income - mylist[3]) * 0.33;
		else if (income <= mylist[5] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (mylist[4] - mylist[3]) * 0.33 + (income - mylist[4]) * 0.35;
		else 
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (mylist[4] - mylist[3]) * 0.33 + (mylist[5] - mylist[4]) * 0.35 + (income - mylist[5]) * 0.396;
		return tax;
		}
	
	public static double Tax1(double income){
		int[] mylist = {18150,73800,148850,226850,405100,457600};
		
		if (income <=mylist[0] )
			tax = income * 0.10;
		else if (income <=mylist[1] )
			tax = mylist[0] * 0.10 + (income - mylist[0]) * 0.15;
		else if (income <= mylist[2])
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(income - mylist[1]) * 0.25;
		else if (income <= mylist[3] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (income - mylist[2]) * 0.28;
		else if (income <= mylist[4] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (income - mylist[3]) * 0.33;
		else if (income <= mylist[5] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (mylist[4] - mylist[3]) * 0.33 + (income - mylist[4]) * 0.35;
		else 
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (mylist[4] - mylist[3]) * 0.33 + (mylist[5] - mylist[4]) * 0.35 + (income - mylist[5]) * 0.396;
		return tax;
		}
	
	public static double Tax2(double income){
		int[] mylist = {12950,49400,127550,206601,405100,432200};
		
		if (income <=mylist[0] )
			tax = income * 0.10;
		else if (income <=mylist[1] )
			tax = mylist[0] * 0.10 + (income - mylist[0]) * 0.15;
		else if (income <= mylist[2])
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(income - mylist[1]) * 0.25;
		else if (income <= mylist[3] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (income - mylist[2]) * 0.28;
		else if (income <= mylist[4] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (income - mylist[3]) * 0.33;
		else if (income <= mylist[5] )
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (mylist[4] - mylist[3]) * 0.33 + (income - mylist[4]) * 0.35;
		else 
			tax = mylist[0] * 0.10 + (mylist[1] - mylist[0]) * 0.15 +(mylist[2] - mylist[1]) * 0.25 + (mylist[3] - mylist[2]) * 0.28 + (mylist[4] - mylist[3]) * 0.33 + (mylist[5] - mylist[4]) * 0.35 + (income - mylist[5]) * 0.396;
		return tax;
	}
}

	