import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String num = sc.next();

		char [] arr = num.toCharArray();

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (arr[i]-48);
		}
		System.out.println(sum);
	}

}
