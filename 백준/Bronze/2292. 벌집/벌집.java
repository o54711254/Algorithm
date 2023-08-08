import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num =sc.nextInt();
		
		int i = 0;
		while (true) {
			int sum = (3*i*i+3*i+1);
			i++;
			if (sum>=num) {
				System.out.println(i);
				break;
			}
		}
	}
}