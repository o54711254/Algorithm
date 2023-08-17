import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			String num = sc.next();
			if(num.equals("0")) {
				break;
			}

			char[] arr = num.toCharArray();

			int count = 0;
			for (int i = 0; i < arr.length / 2; i++) {
				if (arr[i] == arr[arr.length - 1 - i]) {
					count++;
				}
			}
			if (count == arr.length / 2) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
		}
	}
}
