import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			arr[i] = num % 42;
		}

		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1 + i; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					break;
				}
			}
		}
		int result = 10 - count;
		if (result <= 0) {
			result = 1;
		}
		System.out.println(result);
	}
}
