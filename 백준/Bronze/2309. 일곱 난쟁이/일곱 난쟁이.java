
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int num = sum - 100;
		int a = 0;
		int b = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1 + i; j < arr.length; j++) {
				if (arr[i] + arr[j] == num) {
					a = arr[i];
					b = arr[j];
				}
			}
		}
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != a && arr[i] != b) {
				result[i] = arr[i];
			}
		}

		for (int i = 0; i < result.length - 1; i++) {
			for (int j = 1 + i; j < result.length; j++) {
				if (result[i] > result[j]) {
					int tmp = result[i];
					result[i] = result[j];
					result[j] = tmp;
				}
			}
		}
		for(int i = 2; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
}