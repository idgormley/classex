import java.util.Scanner;

public class methodpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input=new Scanner(System.in);
System.out.print("enter x: ");
int x=input.nextInt();
System.out.print("enter y: ");
int y=input.nextInt();
int k=mult(x,y);
System.out.println(k);
input.close();
}
public static int mult(int a,int b){
	int product=a*b;
	return product;}

}
