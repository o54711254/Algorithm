import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int total = sc.nextInt();
		int total2 = 0;
		
		int num = sc.nextInt();
		for(int i =0; i<num; i++) {
			int price = sc.nextInt();
			int ea = sc.nextInt();
			total2 += price*ea;
		}
		if(total == total2) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}