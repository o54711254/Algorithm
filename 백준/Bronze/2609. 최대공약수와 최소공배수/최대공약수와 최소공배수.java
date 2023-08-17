import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		
		
		int i = 10000;
		while(true) {
			i--;
			if(A%i==0&&B%i==0) {
				System.out.println(i);
				break;
			}
		}
		int A2 = A/i;
		int B2 = B/i;
		System.out.println(i*A2*B2);
	}
}
