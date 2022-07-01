import java.util.Scanner;

public class deiff {
	public static void main(String[]args)
	{
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter the value q");
			int q=sc.nextInt();
			System.out.println("enter the value alpha");
			int alpha=sc.nextInt();
			System.out.println("enter the secret key of a");
			int Xa=sc.nextInt();
			System.out.println("enter the secret key of b");
			int Xb=sc.nextInt();
			int Ya=(int)(Math.pow(alpha,Xa)%q);
			System.out.println("ya="+Ya);
			int Yb=(int)(Math.pow(alpha,Xb)%q);
			System.out.println("yb="+Yb);
			int ka=(int)(Math.pow(Yb,Xa)%q);
			System.out.println("ka="+ka);
			int kb=(int)(Math.pow(Ya,Xb)%q);
			System.out.println("kb="+kb);
			if(kb==ka)
				System.out.println("a and b can communicate");
			else
				System.out.println("a and b cant communicate");
		}
}
}
